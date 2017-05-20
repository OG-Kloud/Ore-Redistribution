package net.kloudspace.init.handlers;

import net.kloudspace.init.items.KItemIngot;
import net.kloudspace.init.items.KItemNugget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {
	
	public static Item copperIngot;
	public static Item copperNugget;
	public static Item tinIngot;
	public static Item tinNugget;
	public static Item aluminiumIngot;
	public static Item aluminiumNugget;
	public static Item leadIngot;
	public static Item leadNugget;
	public static Item silverIngot;
	public static Item silverNugget;
	public static Item chromiumIngot;
	public static Item chromiumNugget;
	public static Item cobaltIngot;
	public static Item cobaltNugget;
	public static Item nickelIngot;
	public static Item nickelNugget;
	public static Item titaniumIngot;
	public static Item titaniumNugget;
	public static Item tungstenIngot;
	public static Item tungstenNugget;
	public static Item zincIngot;
	public static Item zincNugget;
	public static Item mercuryIngot;
	public static Item mercuryNugget;
	public static Item platinumIngot;
	public static Item platinumNugget;
	public static Item iridiumIngot;
	public static Item iridiumNugget;
	public static Item osmiumIngot;
	public static Item osmiumNugget;
	public static Item palladiumIngot;
	public static Item palladiumNugget;
	
	//Item
	public static void init() {
		copperIngot = new KItemIngot("copper_ingot");
		copperNugget = new KItemNugget("copper_nugget");
		tinIngot = new KItemIngot("tin_ingot");
		tinNugget = new KItemNugget("tin_nugget");
		aluminiumIngot = new KItemIngot("aluminium_ingot");
		aluminiumNugget = new KItemNugget("aluminium_nugget");
		leadIngot = new KItemIngot("lead_ingot");
		leadNugget = new KItemNugget("lead_nugget");
		silverIngot = new KItemIngot("silver_ingot");
		silverNugget = new KItemNugget("silver_nugget");
		chromiumIngot = new KItemIngot("chromium_Ingot");
		chromiumNugget = new KItemNugget("chromium_nugget");
		cobaltIngot = new KItemIngot("cobalt_ingot");
		cobaltNugget = new KItemNugget("cobalt_nugget");
		nickelIngot = new KItemIngot("nickle_ingot");
		nickelNugget = new KItemNugget("nickel_nugget");
		titaniumIngot = new KItemIngot("titanium_ingot");
		titaniumNugget = new KItemNugget("titanium_nugget");
		tungstenIngot = new KItemIngot("tungsten_ingot");
		tungstenNugget = new KItemNugget("tungsten_nugget");
		zincIngot = new KItemIngot("zinc_ingot");
		zincNugget = new KItemNugget("zinc_nugget");
		mercuryIngot = new KItemIngot("mercury_ingot");
		mercuryNugget = new KItemNugget("mercury_nugget");
		platinumIngot = new KItemIngot("platinum_ingot");
		platinumNugget = new KItemNugget("platinum_nugget");
		iridiumIngot = new KItemIngot("iridium_ingot");
		iridiumNugget = new KItemNugget("iridium_nugget");
		osmiumIngot = new KItemIngot("osmium_ingot");
		osmiumNugget = new KItemNugget("osmium_nugget");
		palladiumIngot = new KItemIngot("palladium_ingot");
		palladiumNugget = new KItemNugget("palladium_nugget");
	}
	
	public static void register() {
		register(copperIngot);
		register(copperNugget);
		register(tinIngot);
		register(tinNugget);
		register(aluminiumIngot);
		register(aluminiumNugget);
		register(leadIngot);
		register(leadNugget);
		register(silverIngot);
		register(silverNugget);
		register(chromiumIngot);
		register(chromiumNugget);
		register(cobaltIngot);
		register(cobaltNugget);
		register(nickelIngot);
		register(nickelNugget);
		register(titaniumIngot);
		register(titaniumNugget);
		register(tungstenIngot);
		register(tungstenNugget);
		register(zincIngot);
		register(zincNugget);
		register(mercuryIngot);
		register(mercuryNugget);
		register(platinumIngot);
		register(platinumNugget);
		register(iridiumIngot);
		register(iridiumNugget);
		register(osmiumIngot);
		register(osmiumNugget);
		register(palladiumIngot);
		register(palladiumNugget);
	}
	
	public static void registerRenders() {
		registerRenders(copperIngot);
		registerRenders(copperNugget);
		registerRenders(tinIngot);
		registerRenders(tinNugget);
		registerRenders(aluminiumIngot);
		registerRenders(aluminiumNugget);
		registerRenders(leadIngot);
		registerRenders(leadNugget);
		registerRenders(silverIngot);
		registerRenders(silverNugget);
		registerRenders(chromiumIngot);
		registerRenders(chromiumNugget);
		registerRenders(cobaltIngot);
		registerRenders(cobaltNugget);
		registerRenders(nickelIngot);
		registerRenders(nickelNugget);
		registerRenders(titaniumIngot);
		registerRenders(titaniumNugget);
		registerRenders(tungstenIngot);
		registerRenders(tungstenNugget);
		registerRenders(zincIngot);
		registerRenders(zincNugget);
		registerRenders(mercuryIngot);
		registerRenders(mercuryNugget);
		registerRenders(platinumIngot);
		registerRenders(platinumNugget);
		registerRenders(iridiumIngot);
		registerRenders(iridiumNugget);
		registerRenders(osmiumIngot);
		registerRenders(osmiumNugget);
		registerRenders(palladiumIngot);
		registerRenders(palladiumNugget);
	}
	
	public static void registerRenders(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void register(Item item) {
		GameRegistry.register(item);
	}

}
