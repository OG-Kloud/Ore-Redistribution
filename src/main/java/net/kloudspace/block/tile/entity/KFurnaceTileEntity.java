package net.kloudspace.block.tile.entity;

import net.kloudspace.block.tile.furance.Fuel;
import net.kloudspace.block.tile.furance.OreRecipe;
import net.kloudspace.gui.slot.KOvenFuelSlot;
import net.kloudspace.init.handlers.FuelHandler;
import net.kloudspace.init.handlers.OreRecipeHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KFurnaceTileEntity extends TileEntityLockable implements ITickable, ISidedInventory{

	private static final int[] SLOTS_TOP = new int[] {0};
	private static final int[] SLOTS_BOTTOM = new int[] {2, 1};
	private static final int[] SLOTS_SIDES = new int[] {1};
	/** The ItemStacks that hold the items currently being used in the furnace */
	private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
	/**Holds the currently active recipe*/
	private OreRecipe recipe;
	/**Holds the current fuel item*/
	private Fuel fuel;
	/**The current temp of the furnace*/
	private int currentTemp;
	/**The amount of time this furnace has been at the appropriate temperature*/
	private int currentTimeAtTemp;
	/**The amount of time that the current fuel has been burning*/
	private int fuelBurnTime= 0;

	private String customName;
	@Override
	public int getSizeInventory() {
		return this.furnaceItemStacks.size();
	}
	
	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.furnaceItemStacks) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/** Returns the stack in the given slot. */
	@Override
	public ItemStack getStackInSlot(int index) {
		return (ItemStack)this.furnaceItemStacks.get(index);
	}

	/** Removes up to a specified number of items from an inventory slot and returns them in a new stack. */
	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
	}

	/** Removes a stack from the given slot and returns it. */
	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
	}

	/** Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections). */
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack itemstack = (ItemStack)this.furnaceItemStacks.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.furnaceItemStacks.set(index, stack);
		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}
		if (index == 0 && !flag) {
			this.markDirty();
		}
	}

	/** Get the name of this object. For players this returns their username */
	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.furnace";
	}

	/** Returns true if this thing is named */
	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomInventoryName(String p_145951_1_) {
		this.customName = p_145951_1_;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.furnaceItemStacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
		this.fuelBurnTime = compound.getInteger("BurnTime");

		if (compound.hasKey("CustomName", 8))
		{
			this.customName = compound.getString("CustomName");
		}
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", (short)this.fuelBurnTime);
		ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}

		return compound;
	}

	/** Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	/** Furnace isBurning */
	public boolean isBurning() {
		return fuel != null;
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean isBurning(IInventory inventory) {
		return inventory.getField(0) > 0;
	}

	/** Like the old updateEntity(), except more generic. */
	@Override
	public void update() {
		if(recipe != null) tickProcessRecipe();
		if(recipe == null) tickProcessRecipe(true);
		tickProcessFuel();
		this.markDirty();
	}

	private void useFuel() {
		fuel = null;
		this.furnaceItemStacks.get(1).shrink(1);
		fuel = FuelHandler.getFuel(this.furnaceItemStacks.get(1).getItem());
		this.fuelBurnTime = 0;
	}
	/***/
	private void tickProcessRecipe(boolean b) {
		OreRecipe recipeTemp = OreRecipeHandler.matchRecipe(this.furnaceItemStacks.get(0).getItem());
		if(recipeTemp != null) recipe = recipeTemp;
	}
	/**Handles Recipe process every tick*/
	private void tickProcessRecipe() {
		if(this.currentTemp >= recipe.requiredTemp) {
			if(this.currentTimeAtTemp >= recipe.requiredTime) {
				if(ItemStack.areItemsEqual(this.furnaceItemStacks.get(2), new ItemStack(recipe.output)));
				this.furnaceItemStacks.get(2).setCount(this.furnaceItemStacks.get(2).getCount() + 1);
				this.furnaceItemStacks.get(0).setCount(this.furnaceItemStacks.get(0).getCount() - 1);
				this.recipe = null;
				this.currentTimeAtTemp = 0;
			} else {
				++this.currentTimeAtTemp;
			}
		}
	}
	/**Handles fuel process every tick*/
	private void tickProcessFuel() {
		if(fuel.getUsedTemp() >= fuel.getMaxTemp() || this.fuelBurnTime >= fuel.getMaxBurnTime()) {
			useFuel();
		} else {
			if(this.currentTemp != recipe.requiredTemp) {
				this.currentTemp += fuel.getTempTransfer();
				fuel.incrUsedTemp();
			} else {
				this.currentTemp -= 5;
			}
		}
		++this.fuelBurnTime;
	}

	/**Don't rename this method to canInteractWith due to conflicts with Container*/
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	public void openInventory(EntityPlayer player) {}

	public void closeInventory(EntityPlayer player){}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For
	 * guis use Slot.isItemValid
	 */
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 2) {
			return false;
		} else if (index != 1) {
			return true;
		} else {
			ItemStack itemstack = (ItemStack)this.furnaceItemStacks.get(1);
			return FuelHandler.isItemFuel(stack) || KOvenFuelSlot.isBucket(stack) && itemstack.getItem() != Items.BUCKET;
		}
	}
	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
	}

	/** Returns true if automation can insert the given item in the given slot from the given side. */	
	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	/** Returns true if automation can extract the given item in the given slot from the given side.*/
	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if (direction == EnumFacing.DOWN && index == 1) {
			Item item = stack.getItem();

			if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
				return false;
			}
		}

		return true;
	}
	@Override
	public String getGuiID() {
		return "minecraft:furnace";
	}
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new KContainerFurnace(playerInventory, this);
	}
	@Override
	public void clear() {
		this.furnaceItemStacks.clear();
	}
	
	@Override
	public int getField(int id) {
		switch(id) {
		case 0:
			return this.currentTemp;
		case 1:
			return this.currentTimeAtTemp;
		case 2:
			return this.fuelBurnTime;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
        switch (id) {
        	case 0:
        		this.currentTemp = value;
                break;
            case 1:
                this.currentTimeAtTemp = value;
                break;
            case 2:
                this.fuelBurnTime = value;
        }
    }

	@Override
	public int getFieldCount() {
		return 3;
	}

	net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
	net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (T) handlerTop;
			else
				return (T) handlerSide;
		return super.getCapability(capability, facing);
	}

}
//TileEntityFurnace