package net.kloudspace.init.handlers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabHandler {
	
	public static CreativeTabs ORES;
	public static CreativeTabs TOOLS;
	public static CreativeTabs ITEMS;
	
	public static void init() {
		ORES = tabCreater("Ores & Ingots", Items.IRON_INGOT);
		TOOLS = tabCreater("Tools", ToolHandler.flint_pickaxe);
		ITEMS = tabCreater("Misc.", ItemHandler.copperIngot);
	}
	
	
	public static CreativeTabs tabCreater(String name, final Item display) {
		return new CreativeTabs(name){
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(display);
			}
		};
	}
	

}
