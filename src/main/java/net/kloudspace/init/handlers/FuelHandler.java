package net.kloudspace.init.handlers;

import java.util.ArrayList;
import java.util.List;

import net.kloudspace.block.tile.furance.Fuel;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelHandler {
	
	public static Fuel coal;
	public static Fuel charcoal;
	
	private static List<Fuel> fuels = new ArrayList<Fuel>();
	
	public static void init() {
		coal = new Fuel(Items.COAL, 200, 200, 5, 20);
	}
	
	public static void register() {
		register(coal);
	}
	
	public static void register(Fuel fuel) {
		fuels.add(fuel);
	}

	public static Fuel getFuel(Item item) {
		Fuel fuelTemp = null;
		for(Fuel f : fuels) {
			if(f.getFuel() == item) {
				fuelTemp = f;
				break;
			}
		}
		return fuelTemp;
	}

	public static boolean isItemFuel(ItemStack stack) {
		Item item = stack.getItem();
		boolean flag = false;
		for(Fuel f : fuels) {
			if(f.getFuel() == item) {
				flag = true;
				break;
			}
		}
		return flag;
	}

}
