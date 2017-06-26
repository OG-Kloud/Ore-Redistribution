package kloud.ore.config;

import net.minecraftforge.common.config.Configuration;

public class KOreConfig implements IKConfig{
	//Corresponding
	public final String desc = "The weight of a generator : ";
	/**
	public int coalSize;
	public int coalGeneratorWeight;
	public int gold1Size;
	public int gold1;
	public int redstoneSize;
	public int redstone;
	public int lapisSize;
	public int lapis;
	public int coal1Size;
	public int coal1;
	public int gold2Size;
	public int gold2;
	public int coal2Size;
	public int coal2;
	public int copper1Size;
	public int copper1;
	public int lead1Size;
	public int lead1;
	public int silver1Size;
	public int silver1;
	public int cobaltSize;
	public int cobalt;
	public int iridium1Size;
	public int iridium1;
	public int platinum1Size;
	public int platinum1;
	public int osmiumSize;
	public int osmium;
	public int palladiumSize;
	public int palladium;
	public int titaniumSize;
	public int titanium;
	public int zincSize;
	public int zinc;
	public int zinc1Size;
	public int zinc1;
	public int copperSize;
	public int copper;
	public int iron1Size;
	public int iron1;
	public int iron2Size;
	public int iron2;
	*/
	public String comment = "Controls size of ore veins.\n"
			+ "Variables are capped at 50 as amounts above 50 will create a concurrent generation lag issue.\n";
	public int minValue = 1;
	public int maxValue = 50;
	
	public void onLoad(Configuration config) {
		/**
		config.load();
		config.addCustomCategoryComment(COAL, "Blocks : coal_ore");
		coalSize = config.getInt("VeinSize", COAL, 50, minValue, maxValue, comment);
		coalGeneratorWeight = config.getInt("Coal Generator", COAL, 50, 1, 100, desc + "coal");
		config.addCustomCategoryComment(GOLD1, "Blocks: gold_ore + silver_ore");
		gold1Size = config.getInt("VeinSize", GOLD1, 50, minValue, maxValue, comment);
		gold1 = config.getInt("Gold1 Generator", GOLD1, 50, 1, 100, desc + "gold1");
		config.addCustomCategoryComment(REDSTONE, "Blocks: redstone_ore");
		redstoneSize = config.getInt("redstone", REDSTONE, 50, minValue, maxValue, comment);
		redstone = config.getInt("Redstone Generator", REDSTONE, 50, 1, 100, desc + "redstone");
		config.addCustomCategoryComment(LAPIS, "Blocks: lapis_ore");
		lapisSize = config.getInt("lapisSize", LAPIS, 50, minValue, maxValue, comment);
		lapis = config.getInt("Lapis Generator", LAPIS, 50, 1, 100, desc + "lapis");
		config.addCustomCategoryComment(COAL1, "Blocks: coal_ore + tungsten_ore");
		coal1Size = config.getInt("coal1Size", COAL1, 50, minValue, maxValue, comment);
		coal1 = config.getInt("Coal1 Generator", COAL1, 50, 1, 100, desc + "coal1");
		config.addCustomCategoryComment(GOLD2, "Blocks: gold_ore + platinum_ore");
		gold2Size = config.getInt("gold2Size", GOLD2, 50, minValue, maxValue, comment);
		gold2 = config.getInt("Gold2 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "gold2");
		config.addCustomCategoryComment(COAL2, "Blocks: coal_ore + diamond_ore");
		coal2Size = config.getInt("coal2Size", COAL2, 50, minValue, maxValue, comment);
		coal2 = config.getInt("Coal2 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "coal2");
		config.addCustomCategoryComment(COPPER1, "Blocks: copper_ore + tin_ore + aluminium_ore");
		copper1Size = config.getInt("copper1Size", COPPER1, 50, minValue, maxValue, comment);
		copper1 = config.getInt("copper1 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "copper1");
		config.addCustomCategoryComment(LEAD1, "Blocks: lead_ore + aluminium_ore");
		lead1Size = config.getInt("lead1Size", LEAD1, 50, minValue, maxValue, comment);
		lead1 = config.getInt("Lead1 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "lead1");
		config.addCustomCategoryComment(SILVER1, "Blocks: silver_ore + chromium_ore + nickle_ore");
		silver1Size = config.getInt("silver1Size", SILVER1, 50, minValue, maxValue, comment);
		silver1 = config.getInt("Silver1 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "silver1");
		config.addCustomCategoryComment(COBALT, "Blocks: cobalt_ore + nickle_ore");
		cobaltSize = config.getInt("cobaltSize", COBALT, 50, minValue, maxValue, comment);
		cobalt = config.getInt("Cobalt Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "cobalt");
		config.addCustomCategoryComment(IRIDIUM1, "Blocks: iridium_ore + titanium_ore");
		iridium1Size = config.getInt("iridium1Size", IRIDIUM1, 50, minValue, maxValue, comment);
		iridium1 = config.getInt("Iridium1 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "iridium1");
		config.addCustomCategoryComment(PLATINUM1, "Blocks: platinum_ore + iridium_ore");
		platinum1Size = config.getInt("platinum1Size", PLATINUM1, 50, minValue, maxValue, comment);
		platinum1 = config.getInt("Platinum1 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "platinum1");
		config.addCustomCategoryComment(OSMIUM, "Blocks: osmium_ore + tin_ore");
		osmiumSize = config.getInt("osmiumSize", OSMIUM, 50, minValue, maxValue, comment);
		osmium = config.getInt("Osmium Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "osmium");
		config.addCustomCategoryComment(PALLADIUM, "Blocks: palladium_ore + silver_ore");
		palladiumSize = config.getInt("palladiumSize", PALLADIUM, 50, minValue, maxValue, comment);
		palladium = config.getInt("Palladium Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "palladium");
		config.addCustomCategoryComment(TITANIUM, "Blocks: titanium_ore + silver_ ore");
		titaniumSize = config.getInt("titaniumSize", TITANIUM, 50, minValue, maxValue, comment);
		titanium = config.getInt("Titanium Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "titanium");
		config.addCustomCategoryComment(ZINC, "Blocks: zinc_ore");
		zincSize = config.getInt("zincSize", ZINC, 50, minValue, maxValue, comment);
		zinc = config.getInt("Zinc Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "Zinc");
		config.addCustomCategoryComment(ZINC1, "Blocks: zinc_ore + aluminium_ore + nickle_ore");
		zinc1Size = config.getInt("zinc1Size", ZINC1, 50, minValue, maxValue, comment);
		zinc1 = config.getInt("Zinc1 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "zinc1");
		config.addCustomCategoryComment(IRON1, "Blocks: iron_ore + copper_ore");
		iron1Size = config.getInt("iron1Size", IRON1, 50, minValue, maxValue, comment);
		iron1 = config.getInt("iron1 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "iron1");
		config.addCustomCategoryComment(IRON2, "Blocks: iron_ore + coal_ore");
		iron2Size = config.getInt("iron2Size", IRON2, 50, minValue, maxValue, comment);
		iron2 = config.getInt("Gold1 Generator", Configuration.CATEGORY_GENERAL, 50, 1, 100, desc + "iron2");

		config.save();
		*/
	}
	/**
	public final static String COAL = "coal_vein";
	public final static String GOLD1 = "gold1_vein";
	public final static String REDSTONE = "redstone_vein";
	public final static String LAPIS = "lapis_vein";
	public final static String COAL1 = "coal1_vein";
	public final static String GOLD2 = "gold2_vein";
	public final static String COAL2 = "coal2_vein";
	public final static String COPPER1 = "copper1_vein";
	public final static String LEAD1 = "lead1_vein";
	public final static String SILVER1 = "silver1_vein";
	public final static String COBALT = "cobalt_vein";
	public final static String IRIDIUM1 = "iridium1_vein";
	public final static String PLATINUM1 = "platinum_vein";
	public final static String OSMIUM = "osmium_vein";
	public final static String PALLADIUM = "palladium_vein";
	public final static String TITANIUM = "titanium_vein";
	public final static String ZINC = "zinc_vein";
	public final static String ZINC1 = "zinc1_vein";
	public final static String IRON1 = "iron1_vein";
	public final static String IRON2 = "iron2_vein";
	*/

	@Override
	public void syncConfig() {
		// TODO Auto-generated method stub
		
	}
}
