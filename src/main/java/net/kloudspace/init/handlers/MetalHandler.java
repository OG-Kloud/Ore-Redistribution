package net.kloudspace.init.handlers;

import net.kloudspace.init.materials.MetalType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class MetalHandler {
	
	public static MetalType gold;
	public static MetalType iron;
	public static MetalType copper;
	public static MetalType tin;
	public static MetalType aluminium;
	public static MetalType lead;
	public static MetalType silver;
	public static MetalType chromium;
	public static MetalType cobalt;
	public static MetalType nickel;
	public static MetalType titanium;
	public static MetalType tungsten;
	public static MetalType zinc;
	public static MetalType mercury;
	public static MetalType platinum;
	public static MetalType iridium;
	public static MetalType osmium;
	public static MetalType palladium;
	
	public static void init() {
		gold = new MetalType("gold");
		iron = new MetalType("iron");
		copper = new MetalType("copper");
		tin = new MetalType("tin");
		aluminium = new MetalType("aluminium");
		lead = new MetalType("lead");
		silver = new MetalType("silver");
		chromium = new MetalType("chromium");
		cobalt = new MetalType("cobalt");
		nickel = new MetalType("nickel");
		titanium = new MetalType("titanium");
		tungsten = new MetalType("tungsten");
		zinc = new MetalType("zinc");
		mercury = new MetalType("mercury");
		platinum = new MetalType("platinum");
		iridium = new MetalType("iridium");
		osmium = new MetalType("osmium");
		palladium = new MetalType("palladium");
		initMetalVariables();
	}
	
	public static void initMetalVariables() {
		gold.setHardness(2.0F);
		gold.setResistance(3.0F);
		gold.setMetalIngot(Items.GOLD_INGOT);
		gold.setMetalNugget(Items.GOLD_NUGGET);
		gold.setMetalOre(BlockOreHandler.goldOre);
		gold.setMetalStorage(Blocks.GOLD_BLOCK);
		gold.setBlockDrop(BlockOreHandler.goldOre);
		iron.setHardness(5.0F);
		iron.setResistance(10.0F);
		iron.setMetalIngot(Items.IRON_INGOT);
		iron.setMetalNugget(Items.field_191525_da);
		iron.setMetalOre(BlockOreHandler.ironOre);
		iron.setMetalStorage(Blocks.IRON_BLOCK);
		iron.setBlockDrop(BlockOreHandler.ironOre);
		copper.setHardness(3.0F);
		copper.setResistance(5.0F);
		copper.setBlockDrop(BlockOreHandler.copperOre);
	}
	
	
	
	//Blocks

}
