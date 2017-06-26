package kloud.ore.handler;

import kloud.ore.materials.MetalType;
import kloud.ore.materials.MetalTypeUtils;
import net.kloudspace.util.IKHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class MetalHandler implements IKHandler{
	
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
	
	@Override
	public void init() {
		gold = MetalTypeUtils.createMetalType("gold");
		iron = MetalTypeUtils.createMetalType("iron");
		copper = MetalTypeUtils.createMetalType("copper");
		tin = MetalTypeUtils.createMetalType("tin");
		aluminium = MetalTypeUtils.createMetalType("aluminium");
		lead = MetalTypeUtils.createMetalType("lead");
		silver = MetalTypeUtils.createMetalType("silver");
		chromium = MetalTypeUtils.createMetalType("chromium");
		cobalt = MetalTypeUtils.createMetalType("cobalt");
		nickel = MetalTypeUtils.createMetalType("nickel");
		titanium = MetalTypeUtils.createMetalType("titanium");
		tungsten = MetalTypeUtils.createMetalType("tungsten");
		zinc = MetalTypeUtils.createMetalType("zinc");
		mercury = MetalTypeUtils.createMetalType("mercury");
		platinum = MetalTypeUtils.createMetalType("platinum");
		iridium = MetalTypeUtils.createMetalType("iridium");
		osmium = MetalTypeUtils.createMetalType("osmium");
		palladium = MetalTypeUtils.createMetalType("palladium");
		initMetalVariables();
	}
	/**
	 * Initiates {@link MetalType} variables
	 */
	private static void initMetalVariables() {
		gold.setHardness(2.0F);
		gold.setResistance(3.0F);
		gold.setMetalIngot(Items.GOLD_INGOT);
		gold.setMetalNugget(Items.GOLD_NUGGET);
		gold.setMetalOre(Blocks.GOLD_ORE);
		gold.setMetalStorage(Blocks.GOLD_BLOCK);
		gold.setBlockDrop(Blocks.GOLD_ORE);
		iron.setHardness(5.0F);
		iron.setResistance(10.0F);
		iron.setMetalIngot(Items.IRON_INGOT);
		iron.setMetalNugget(Items.field_191525_da);
		iron.setMetalOre(Blocks.IRON_ORE);
		iron.setMetalStorage(Blocks.IRON_BLOCK);
		iron.setBlockDrop(Blocks.IRON_ORE);
		copper.setHardness(3.0F);
		copper.setResistance(5.0F);
		copper.setBlockDrop(BlockOreHandler.copperOre);
	}
	
	/**Currently unused*/
	@Override
	public void register() {
		
	}
	
	
	
	//Blocks

}
