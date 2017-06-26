package kloud.ore.handler;

import java.io.File;

import kloud.ore.block.KBlockOre;
import kloud.ore.block.MercuryOre;
import net.kloudspace.util.IKHandlerRenders;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
/** Handles Ores
 * 
 * @author kloud
 *
 */
public class BlockOreHandler implements IKHandlerRenders{
	
	public static Block copperOre;
	public static ItemBlock ibCopperOre;
	
	public static Block tinOre;
	public static ItemBlock ibTinOre;
	
	public static Block aluminiumOre;
	public static ItemBlock ibAluminiumOre;
	
	public static Block leadOre;
	public static ItemBlock ibLeadOre;
	
	public static Block silverOre;
	public static ItemBlock ibSilverOre;
	
	public static Block chromiumOre;
	public static ItemBlock ibChromiumOre;
	
	public static Block cobaltOre;
	public static ItemBlock ibCobaltOre;
	
	public static Block nickelOre;
	public static ItemBlock ibNickelOre;
	
	public static Block titaniumOre;
	public static ItemBlock ibTitaniumOre;
	
	public static Block tungstenOre;
	public static ItemBlock ibTungstenOre;
	
	public static Block zincOre;
	public static ItemBlock ibZincOre;
	
	public static Block mercuryOre;
	public static ItemBlock ibMercuryOre;
	
	public static Block platinumOre;
	public static ItemBlock ibPlatinumOre;
	
	public static Block iridiumOre;
	public static ItemBlock ibIridiumOre;
	
	public static Block osmiumOre;
	public static ItemBlock ibOsmiumOre;
	
	public static Block palladiumOre;
	public static ItemBlock ibPalladiumOre;
	
	/*-------------------------------------------------Natural Alloys-------------------------------------------------------------------*/
	
	public static Block brassOre;
	public static ItemBlock ibBrassOre;
	
	public static Block bronzeOre;
	public static ItemBlock ibBronzeOre;
	
	public static Block pewterOre;
	public static ItemBlock ibPewterOre;
	
	public static Block osmiridiumOre;
	public static ItemBlock ibOsmiridiumOre;
	
	public static Block electrumOre;
	public static ItemBlock ibElectrumOre;
	
	public static Block whiteGoldOre;
	public static ItemBlock ibWhiteGoldOre;
	
	/*-----------------------------------------------Vanilla Ore Overrides--------------------------------------------------------------*/
//	public static Block ironOre;
//	public static ItemBlock ibIronOre;
	
//	public static Block goldOre;
//	public static ItemBlock ibGoldOre;
	
//	public static Block diamondOre;
//	public static ItemBlock ibDiamondOre;
	
//	public static Block coalOre;
//	public static ItemBlock ibCoalOre;
	
//	public static Block redstoneOre;
//	public static ItemBlock ibRedstoneOre;
	
//	public static Block lapisOre;
//	public static ItemBlock ibLapisOre;
	
	
	/**
	 *{@inheritDoc}
	 */
	public void init() {
		//KBlockOre(String name, float resistance, int harvestLevel)
		copperOre = new KBlockOre("copper", MetalHandler.copper).canOxidize(true);
		ibCopperOre = (ItemBlock) new ItemBlock(copperOre);
		
		tinOre = new KBlockOre("tin", MetalHandler.tin).canOxidize(false);
		ibTinOre = (ItemBlock) new ItemBlock(tinOre);
		
		aluminiumOre = new KBlockOre("aluminium", MetalHandler.aluminium);
		ibAluminiumOre = (ItemBlock) new ItemBlock(aluminiumOre);
		
		leadOre = new KBlockOre("lead", MetalHandler.lead);
		ibLeadOre = (ItemBlock) new ItemBlock(leadOre);
		
		silverOre = new KBlockOre("silver", MetalHandler.silver);
		ibSilverOre = (ItemBlock) new ItemBlock(silverOre);
		
		chromiumOre = new KBlockOre("chromium", MetalHandler.chromium);
		ibChromiumOre = (ItemBlock) new ItemBlock(chromiumOre);
		
		cobaltOre = new KBlockOre("cobalt", MetalHandler.cobalt);
		ibCobaltOre = (ItemBlock) new ItemBlock(cobaltOre);
		
		nickelOre = new KBlockOre("nickel", MetalHandler.nickel).canOxidize(false);
		ibNickelOre = (ItemBlock) new ItemBlock(nickelOre);
		
		titaniumOre = new KBlockOre("titanium", MetalHandler.titanium);
		ibTitaniumOre = (ItemBlock) new ItemBlock(titaniumOre);
		
		tungstenOre = new KBlockOre("tungsten", MetalHandler.tungsten);
		ibTungstenOre = (ItemBlock) new ItemBlock(tungstenOre);
		
		zincOre = new KBlockOre("zinc", MetalHandler.zinc);
		ibZincOre = (ItemBlock) new ItemBlock(zincOre);
		
		mercuryOre = new MercuryOre("mercury", MetalHandler.mercury);
		ibMercuryOre = (ItemBlock) new ItemBlock(mercuryOre);
		
		platinumOre = new KBlockOre("platinum", MetalHandler.platinum);
		ibPlatinumOre = (ItemBlock) new ItemBlock(platinumOre);
		
		iridiumOre = new KBlockOre("iridium", MetalHandler.iridium);
		ibIridiumOre = (ItemBlock) new ItemBlock(iridiumOre);
		
		osmiumOre = new KBlockOre("osmium", MetalHandler.osmium);
		ibOsmiumOre = (ItemBlock) new ItemBlock(osmiumOre);
		
		palladiumOre = new KBlockOre("palladium", MetalHandler.palladium);
		ibPalladiumOre = (ItemBlock) new ItemBlock(palladiumOre);
		
	//	ironOre = new KBlockOre("iron_ore", MetalHandler.iron).canOxidize(true);
	//	ibIronOre = (ItemBlock) new ItemBlock(ironOre);
		
	//	goldOre = new KBlockOre("gold_ore", MetalHandler.gold);
	}
	/**
	 * {@inheritDoc}
	 */
	public void register() {
		register(ibCopperOre, copperOre);
		register(ibTinOre, tinOre);
		register(ibAluminiumOre, aluminiumOre);
		register(ibLeadOre, leadOre);
		register(ibSilverOre, silverOre);
		register(ibChromiumOre, chromiumOre);
		register(ibCobaltOre, cobaltOre);
		register(ibNickelOre, nickelOre);
		register(ibTitaniumOre, titaniumOre);
		register(ibTungstenOre, tungstenOre);
		register(ibZincOre, zincOre);
		register(ibMercuryOre, mercuryOre);
		register(ibPlatinumOre, platinumOre);
		register(ibIridiumOre, iridiumOre);
		register(ibOsmiumOre, osmiumOre);
		register(ibPalladiumOre, palladiumOre);
		
	//	register(ibIronOre, ironOre);
	}
	/** Shorthand register method for Block and ItemBlock at the same time
	 * 
	 * @param item
	 * @param block
	 */
	public static void register(ItemBlock item, Block block) {
		new File(block.getRegistryName().getResourceDomain()).mkdirs();
		GameRegistry.register(block);
		GameRegistry.register(item, block.getRegistryName());
		Character s1 = block.getRegistryName().getResourcePath().charAt(0);
		String s = s1.toString().toUpperCase();
		String temp1 = block.getRegistryName().getResourcePath().substring(1);
		String finalS = "ore" + s + temp1;
		System.out.println(finalS);
		OreDictionary.registerOre(finalS, block);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registerRenders() {
		registerRender(copperOre);
		registerRender(tinOre);
		registerRender(aluminiumOre);
		registerRender(leadOre);
		registerRender(silverOre);
		registerRender(chromiumOre);
		registerRender(cobaltOre);
		registerRender(nickelOre);
		registerRender(titaniumOre);
		registerRender(tungstenOre);
		registerRender(zincOre);
		registerRender(mercuryOre);
		registerRender(platinumOre);
		registerRender(iridiumOre);
		registerRender(osmiumOre);
		registerRender(palladiumOre);
	}
}
