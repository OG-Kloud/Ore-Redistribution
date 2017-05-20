package net.kloudspace.gui.slot;

import net.kloudspace.init.handlers.FuelHandler;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class KOvenFuelSlot extends Slot{

	public KOvenFuelSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return FuelHandler.isItemFuel(stack);
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
	}
	
	public static boolean isBucket(ItemStack stack) {
		return stack.getItem() == Items.BUCKET;
    }
	
	

}
