package kloud.ore.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import kloud.ore.objs.Vein;
import kloud.ore.objs.VeinUtils;
import net.kloudspace.util.IKHandler;
import net.minecraft.init.Blocks;

public class VeinHandler implements IKHandler{
	
	public static boolean isPreviousOreGenerated = true;
	
	public static Vein coal;
	public static Vein goldSilver;
	public static Vein redstone;
	public static Vein lapis;
	public static Vein coalTungsten;
	public static Vein goldPlatinum;
	public static Vein coalDiamond;
	public static Vein copperTinAluminium;
	public static Vein leadAluminium;
	public static Vein silverChromiumNickle;
	public static Vein cobaltNickle;
	public static Vein iridiumTitanium;
	public static Vein platinumIridium;
	public static Vein osmiumTin;
	public static Vein palladiumSilver;
	public static Vein titaniumSilver;
	public static Vein zinc;
	public static Vein zincAluminiumNickle;
	public static Vein nativeCopper;
	public static Vein ironCopper;
	public static Vein ironCoal;


	public static int veinSize = 50;
	public static int veinWeight = 100;
	
	public static Map<Vein, String> veinToName = new HashMap<Vein, String>();
	public static Map<String, Vein> nameToVein = new HashMap<String, Vein>();
	public static Map<Vein, Integer> veinToWeight = new HashMap<Vein, Integer>();
	public static Map<String, Integer> nameToWeight = new HashMap<String, Integer>();
	public static int totalVeinWeight = 0;
	
	public static List<Vein> veins = new ArrayList<Vein>();
//	private static KOreConfig config = Ores.oreConfig;
	/**Vein#(Block primaryOre, Block secondaryOre, Block trisiaryOre, String name, int sizeOfVein, int weightOfVein)
	 *<p>
	 * Size above 50 causes concurrent generation lag.
	 * weight is relative to the total weight of all veins
	 * <p>
	 * !!You need to register the veins!!
	 * 
	 *    ##UNUSED##
	 * Standard class total weights
	 *     common - 250
	 *     uncommon - 150
	 *     rare - 100
	*/
	@Override
	public void init() {
		coal = VeinUtils.createVein(Blocks.COAL_ORE, Blocks.COAL_ORE, Blocks.COAL_ORE, "coal_vein", veinSize, veinWeight);
		goldSilver = VeinUtils.createVein(BlockOreHandler.silverOre, Blocks.GOLD_ORE, BlockOreHandler.silverOre, "gold_vein", veinSize, veinWeight);
		redstone = VeinUtils.createVein(Blocks.REDSTONE_ORE, Blocks.REDSTONE_ORE, Blocks.REDSTONE_ORE, "redstone_vein", veinSize, veinWeight);
		lapis = VeinUtils.createVein(Blocks.LAPIS_ORE, Blocks.LAPIS_ORE, Blocks.LAPIS_ORE, "lapis_vein", veinSize, veinWeight);
		coalTungsten = VeinUtils.createVein(Blocks.COAL_ORE, BlockOreHandler.tungstenOre, Blocks.COAL_ORE, "coal_tungsten_vein", veinSize, veinWeight);
		goldPlatinum = VeinUtils.createVein(Blocks.GOLD_ORE, BlockOreHandler.platinumOre, Blocks.GOLD_ORE, "gold_platinum_vein", veinSize, veinWeight);
		coalDiamond = VeinUtils.createVein(Blocks.COAL_ORE, Blocks.DIAMOND_ORE, Blocks.COAL_ORE, "coal_diamond_vein", veinSize, veinWeight);
		copperTinAluminium = VeinUtils.createVein(BlockOreHandler.copperOre, BlockOreHandler.tinOre, BlockOreHandler.aluminiumOre, "copper_tin_aluminium_vein", veinSize, veinWeight);
		leadAluminium = VeinUtils.createVein(BlockOreHandler.leadOre, BlockOreHandler.aluminiumOre, BlockOreHandler.leadOre, "lead_aluminium_vein", veinSize, veinWeight);
		silverChromiumNickle = VeinUtils.createVein(BlockOreHandler.silverOre, BlockOreHandler.chromiumOre, BlockOreHandler.nickelOre, "silver_chromium_nickle_vein", veinSize, veinWeight);
		cobaltNickle = VeinUtils.createVein(BlockOreHandler.nickelOre, BlockOreHandler.cobaltOre, BlockOreHandler.nickelOre, "cobalt_nickle_vein", veinSize, veinWeight);
		iridiumTitanium = VeinUtils.createVein(BlockOreHandler.iridiumOre, BlockOreHandler.titaniumOre, BlockOreHandler.iridiumOre, "iridium_titanium_vein", veinSize, veinWeight);
		platinumIridium = VeinUtils.createVein(BlockOreHandler.platinumOre, BlockOreHandler.iridiumOre, BlockOreHandler.platinumOre, "platinum_iridium_vein", veinSize, veinWeight);
		osmiumTin = VeinUtils.createVein(BlockOreHandler.osmiumOre, BlockOreHandler.tinOre, BlockOreHandler.tinOre, "osmium_tin_vein", veinSize, veinWeight);
		palladiumSilver = VeinUtils.createVein(BlockOreHandler.palladiumOre, BlockOreHandler.silverOre, BlockOreHandler.silverOre, "palladium_silver_vein", veinSize, veinWeight);
		titaniumSilver = VeinUtils.createVein(BlockOreHandler.titaniumOre, BlockOreHandler.silverOre, BlockOreHandler.silverOre, "titanium_silver_vein", veinSize, veinWeight);
		zinc = VeinUtils.createVein(BlockOreHandler.zincOre, BlockOreHandler.zincOre, BlockOreHandler.zincOre, "zinc_vein", veinSize, veinWeight);
		zincAluminiumNickle = VeinUtils.createVein(BlockOreHandler.zincOre, BlockOreHandler.aluminiumOre, BlockOreHandler.nickelOre, "zinc_aluminium_nickle_vein", veinSize, veinWeight);
		nativeCopper = VeinUtils.createVein(BlockOreHandler.copperOre, BlockOreHandler.copperOre, BlockOreHandler.copperOre, "copper_vein", veinSize, veinWeight);
		ironCopper = VeinUtils.createVein(Blocks.IRON_ORE, BlockOreHandler.copperOre, BlockOreHandler.copperOre, "iron_copper_vein", veinSize, veinWeight);
		ironCoal = VeinUtils.createVein(Blocks.IRON_ORE, Blocks.COAL_ORE, Blocks.IRON_ORE, "iron_copper_vein", veinSize, veinWeight);
	}
	@Override
	public void register() {
		addToMappings(coal);
		addToMappings(goldSilver);
		addToMappings(redstone);
		addToMappings(lapis);
		addToMappings(coalTungsten);
		addToMappings(goldPlatinum);
		addToMappings(coalDiamond);
		addToMappings(copperTinAluminium);
		addToMappings(leadAluminium);
		addToMappings(silverChromiumNickle);
		addToMappings(cobaltNickle);
		addToMappings(iridiumTitanium);
		addToMappings(platinumIridium);
		addToMappings(osmiumTin);
		addToMappings(palladiumSilver);
		addToMappings(titaniumSilver);
		addToMappings(zinc);
		addToMappings(zincAluminiumNickle);
		addToMappings(nativeCopper);
		addToMappings(ironCopper);
		addToMappings(ironCoal);
	}
	/**Gets a random {@link Vein} skud by weight 
	 * 
	 * @return random {@link Vein}
	 */
	public static Vein getVeinByWeight() {
		Random rand = new Random();
		int index = rand.nextInt(totalVeinWeight);
		int sum = 0;
		int i = 0;
		while(sum < index) {
			sum = sum + ((Vein)veins.get(i++)).getVeinWeight();
		}
//		System.out.println("Chosen vein is: " + veins.get(Math.max(0, i-1)).getVeinName());
		return veins.get(Math.max(0, i-1));
	}
	/** Adds {@link Vein} to the Registrys
	 * 
	 * @param vein
	 */
	public static void addToMappings(Vein vein) {
		String name = vein.getVeinName();
		int weight = vein.getVeinWeight();
		System.out.println("Total vein weight befor registering " + name + " was " + totalVeinWeight);
		totalVeinWeight += weight;
		System.out.println("New total vein weights is: " + totalVeinWeight);
		veinToName.put(vein, name);
		nameToVein.put(name, vein);
		veinToWeight.put(vein, weight);
		nameToWeight.put(name, weight);
		veins.add(vein);
	}
	/** Gets a {@link Vein} from the {@link Vein#getVeinName()} variable
	 * 
	 * @param name
	 * @return the {@link Vein} with the name requested
	 */
	public static Vein getVeinFromName(String name) {
		return VeinHandler.nameToVein.get(name);
	}

}

/**
 * public static void init() {
		coal = VeinUtils.createVein(Blocks.COAL_ORE, Blocks.COAL_ORE, Blocks.COAL_ORE, "coal_vein", config.coal1Size, config.coalGeneratorWeight);
		goldSilver = VeinUtils.createVein(BlockOreHandler.silverOre, Blocks.GOLD_ORE, BlockOreHandler.silverOre, "gold_vein", config.gold1Size, config.gold1);
		redstone = VeinUtils.createVein(Blocks.REDSTONE_ORE, Blocks.REDSTONE_ORE, Blocks.REDSTONE_ORE, "redstone_vein", config.redstoneSize, config.redstone);
		lapis = VeinUtils.createVein(Blocks.LAPIS_ORE, Blocks.LAPIS_ORE, Blocks.LAPIS_ORE, "lapis_vein", config.lapisSize, config.lapis);
		coalTungsten = VeinUtils.createVein(Blocks.COAL_ORE, BlockOreHandler.tungstenOre, Blocks.COAL_ORE, "coal_tungsten_vein", config.coal1Size, config.coal1);
		goldPlatinum = VeinUtils.createVein(Blocks.GOLD_ORE, BlockOreHandler.platinumOre, Blocks.GOLD_ORE, "gold_platinum_vein", config.gold2Size, config.gold2);
		coalDiamond = VeinUtils.createVein(Blocks.COAL_ORE, Blocks.DIAMOND_ORE, Blocks.COAL_ORE, "coal_diamond_vein", config.coal2Size, config.coal2);
		copperTinAluminium = VeinUtils.createVein(BlockOreHandler.copperOre, BlockOreHandler.tinOre, BlockOreHandler.aluminiumOre, "copper_tin_aluminium_vein", config.copper1Size, config.copper1);
		leadAluminium = VeinUtils.createVein(BlockOreHandler.leadOre, BlockOreHandler.aluminiumOre, BlockOreHandler.leadOre, "lead_aluminium_vein", config.lead1Size, config.lead1);
		silverChromiumNickle = VeinUtils.createVein(BlockOreHandler.silverOre, BlockOreHandler.chromiumOre, BlockOreHandler.nickelOre, "silver_chromium_nickle_vein", config.silver1Size, config.silver1);
		cobaltNickle = VeinUtils.createVein(BlockOreHandler.nickelOre, BlockOreHandler.cobaltOre, BlockOreHandler.nickelOre, "cobalt_nickle_vein", config.cobaltSize, config.cobalt);
		iridiumTitanium = VeinUtils.createVein(BlockOreHandler.iridiumOre, BlockOreHandler.titaniumOre, BlockOreHandler.iridiumOre, "iridium_titanium_vein", config.iridium1Size, config.iridium1);
		platinumIridium = VeinUtils.createVein(BlockOreHandler.platinumOre, BlockOreHandler.iridiumOre, BlockOreHandler.platinumOre, "platinum_iridium_vein", config.platinum1Size, config.platinum1);
		osmiumTin = VeinUtils.createVein(BlockOreHandler.osmiumOre, BlockOreHandler.tinOre, BlockOreHandler.tinOre, "osmium_tin_vein", config.osmiumSize, config.osmium);
		palladiumSilver = VeinUtils.createVein(BlockOreHandler.palladiumOre, BlockOreHandler.silverOre, BlockOreHandler.silverOre, "palladium_silver_vein", config.palladiumSize, config.palladium);
		titaniumSilver = VeinUtils.createVein(BlockOreHandler.titaniumOre, BlockOreHandler.silverOre, BlockOreHandler.silverOre, "titanium_silver_vein", config.titaniumSize, config.titanium);
		zinc = VeinUtils.createVein(BlockOreHandler.zincOre, BlockOreHandler.zincOre, BlockOreHandler.zincOre, "zinc_vein", config.zincSize, config.zinc);
		zincAluminiumNickle = VeinUtils.createVein(BlockOreHandler.zincOre, BlockOreHandler.aluminiumOre, BlockOreHandler.nickelOre, "zinc_aluminium_nickle_vein", config.zinc1Size, config.zinc1);
		nativeCopper = VeinUtils.createVein(BlockOreHandler.copperOre, BlockOreHandler.copperOre, BlockOreHandler.copperOre, "copper_vein", config.copperSize, config.copper);
		ironCopper = VeinUtils.createVein(Blocks.IRON_ORE, BlockOreHandler.copperOre, BlockOreHandler.copperOre, "iron_copper_vein", config.iron1Size, config.iron1);
		ironCoal = VeinUtils.createVein(Blocks.IRON_ORE, Blocks.COAL_ORE, Blocks.IRON_ORE, "iron_copper_vein", config.iron2Size, config.iron2);
	}*/
