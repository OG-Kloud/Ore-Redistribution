package net.kloudspace.init.handlers;

import net.kloudspace.init.items.KPickaxe;
import net.minecraft.item.Item;

public class ToolHandler {
	
	public static Item flint_pickaxe;
	
	
	public static void init() {
		flint_pickaxe = new KPickaxe("flint_pickaxe", MaterialHandler.FLINT);
	}
	
	public static void register() {
		
	}
	
	public static void registerRenders() {
		
	}
	
	public static void registerRenders(Item item) {
		
	}

}
