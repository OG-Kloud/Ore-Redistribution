package net.kloudspace.init.handlers;

import net.kloudspace.init.block.KBlockOre;
import net.kloudspace.init.block.MercuryOre;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockOreHandler {
	
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
	public static Block ironOre;
	public static ItemBlock ibIronOre;
	
	public static Block goldOre;
	public static ItemBlock ibGoldOre;
	
	public static Block diamondOre;
	public static ItemBlock ibDiamondOre;
	
	public static Block coalOre;
	public static ItemBlock ibCoalOre;
	
	public static Block redstoneOre;
	public static ItemBlock ibRedstoneOre;
	
	public static Block lapisOre;
	public static ItemBlock ibLapisOre;
	
	
	
	public static void init() {
		//KBlockOre(String name, float resistance, int harvestLevel)
		copperOre = new KBlockOre("copper_ore", MetalHandler.copper).canOxidize(true);
		ibCopperOre = (ItemBlock) new ItemBlock(copperOre);
		
		tinOre = new KBlockOre("tin_ore", MetalHandler.tin).canOxidize(false);
		ibTinOre = (ItemBlock) new ItemBlock(tinOre);
		
		aluminiumOre = new KBlockOre("aluminium_ore", MetalHandler.aluminium);
		ibAluminiumOre = (ItemBlock) new ItemBlock(aluminiumOre);
		
		leadOre = new KBlockOre("lead_ore", MetalHandler.lead);
		ibLeadOre = (ItemBlock) new ItemBlock(leadOre);
		
		silverOre = new KBlockOre("silver_ore", MetalHandler.silver);
		ibSilverOre = (ItemBlock) new ItemBlock(silverOre);
		
		chromiumOre = new KBlockOre("chromium_ore", MetalHandler.chromium);
		ibChromiumOre = (ItemBlock) new ItemBlock(chromiumOre);
		
		cobaltOre = new KBlockOre("cobalt_ore", MetalHandler.cobalt);
		ibCobaltOre = (ItemBlock) new ItemBlock(cobaltOre);
		
		nickelOre = new KBlockOre("nickel_ore", MetalHandler.nickel).canOxidize(false);
		ibNickelOre = (ItemBlock) new ItemBlock(nickelOre);
		
		titaniumOre = new KBlockOre("titanium_ore", MetalHandler.titanium);
		ibTitaniumOre = (ItemBlock) new ItemBlock(titaniumOre);
		
		tungstenOre = new KBlockOre("tungsten_ore", MetalHandler.tungsten);
		ibTungstenOre = (ItemBlock) new ItemBlock(tungstenOre);
		
		zincOre = new KBlockOre("zinc_ore", MetalHandler.zinc);
		ibZincOre = (ItemBlock) new ItemBlock(zincOre);
		
		mercuryOre = new MercuryOre("mercury_ore", MetalHandler.mercury);
		ibMercuryOre = (ItemBlock) new ItemBlock(mercuryOre);
		
		platinumOre = new KBlockOre("platinum_ore", MetalHandler.platinum);
		ibPlatinumOre = (ItemBlock) new ItemBlock(platinumOre);
		
		iridiumOre = new KBlockOre("iridium_ore", MetalHandler.iridium);
		ibIridiumOre = (ItemBlock) new ItemBlock(iridiumOre);
		
		osmiumOre = new KBlockOre("osmium_ore", MetalHandler.osmium);
		ibOsmiumOre = (ItemBlock) new ItemBlock(osmiumOre);
		
		palladiumOre = new KBlockOre("palladium_ore", MetalHandler.palladium);
		ibPalladiumOre = (ItemBlock) new ItemBlock(palladiumOre);
		
		ironOre = new KBlockOre("iron_ore", MetalHandler.iron).canOxidize(true).canOxidize(true);
		ibIronOre = (ItemBlock) new ItemBlock(ironOre);
	}
	
	public static void register() {
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
		
		register(ibIronOre, ironOre);
	}
	
	public static void register(ItemBlock item, Block block) {
		GameRegistry.register(block);
		GameRegistry.register(item, block.getRegistryName());
	}
	
	public static void registerRenders() {
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
		registerRender(ironOre);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
