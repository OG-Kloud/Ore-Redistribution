package net.kloudspace.block.tile.entity;

import net.kloudspace.gui.slot.KOvenFuelSlot;
import net.kloudspace.gui.slot.KSlotOvenOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KContainerFurnace extends Container {

	private final IInventory tileFurnace;
	/**The current temp of the furnace*/
	private int currentTemp;
	/**The amount of time this furnace has been at the appropriate temperature*/
	private int currentTimeAtTemp;
	/**The amount of time that the current fuel has been burning*/
	private int fuelBurnTime= 0;

	public KContainerFurnace(InventoryPlayer playerInventory, IInventory furnaceInventory) {
		this.tileFurnace = furnaceInventory;
		this.addSlotToContainer(new Slot(furnaceInventory, 0, 56, 17));
		this.addSlotToContainer(new KOvenFuelSlot(furnaceInventory, 1, 56, 53));
		this.addSlotToContainer(new KSlotOvenOutput(playerInventory.player, furnaceInventory, 2, 116, 35));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}

	public void addListener(IContainerListener listener){
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileFurnace);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i) {
			IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);

			if (this.currentTimeAtTemp != this.tileFurnace.getField(2)) {
				icontainerlistener.sendProgressBarUpdate(this, 2, this.tileFurnace.getField(2));
			}

			if (this.currentTemp != this.tileFurnace.getField(0)) {
				icontainerlistener.sendProgressBarUpdate(this, 0, this.tileFurnace.getField(0));
			}

			if (this.fuelBurnTime != this.tileFurnace.getField(1)) {
				icontainerlistener.sendProgressBarUpdate(this, 1, this.tileFurnace.getField(1));
			}
		}
		this.currentTimeAtTemp = this.tileFurnace.getField(2);
		this.currentTemp = this.tileFurnace.getField(0);
		this.fuelBurnTime = this.tileFurnace.getField(1);
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		this.tileFurnace.setField(id, data);
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tileFurnace.isUsableByPlayer(playerIn);
	}

	/**
	 * Take a stack from the specified inventory slot.
	 */
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot)this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index == 2) {
				if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
					return ItemStack.EMPTY;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if(index != 1 && index != 0) {
				if(!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty()) {
					if(!this.mergeItemStack(itemstack1, 0, 1, false)) {
						return ItemStack.EMPTY;
					}
				} else if(TileEntityFurnace.isItemFuel(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
						return ItemStack.EMPTY;
					}
				} else if(index >= 3 && index < 30) {
					if(!this.mergeItemStack(itemstack1, 30, 39, false)) {
						return ItemStack.EMPTY;
					}
				} else if(index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
					return ItemStack.EMPTY;
				}
			} else if(!this.mergeItemStack(itemstack1, 3, 39, false)) {
				return ItemStack.EMPTY;
			}

			if(itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}

}
