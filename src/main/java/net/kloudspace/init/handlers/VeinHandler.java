package net.kloudspace.init.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.kloudspace.ore.Vein;
import net.minecraft.init.Blocks;

public class VeinHandler {
	
	public static boolean isPreviousOreGenerated = true;
	
	public static Vein ironVein;
	public static Vein goldVein;
	public static Vein coalVein;
	
	public static Map<Vein, String> veinToName = new HashMap<Vein, String>();
	public static Map<String, Vein> nameToVein = new HashMap<String, Vein>();
	public static Map<Vein, Integer> veinToWeight = new HashMap<Vein, Integer>();
	public static Map<String, Integer> nameToWeight = new HashMap<String, Integer>();
	public static int totalVeinWeight = 0;
	
	public static List<Vein> veins = new ArrayList<Vein>();
	/**Vein#(Block primaryOre, Block secondaryOre, Block trisiaryOre, String name, int sizeOfVein, int weightOfVein)
	 * Size above 50 causes concurrent generation lag
	 * weight is relative to the total weight of all veins
	 * 
	 * !!You need to register the veins!!
	*/
	public static void init() {
		ironVein = new Vein(BlockOreHandler.ironOre, BlockOreHandler.copperOre, BlockOreHandler.ironOre, "iron_vein", 50, 100);
		goldVein = new Vein(BlockOreHandler.silverOre, BlockOreHandler.goldOre, BlockOreHandler.whiteGoldOre, "gold_vein", 50, 25);
		coalVein = new Vein(BlockOreHandler.coalOre, BlockOreHandler.coalOre, BlockOreHandler.diamondOre, "coalVein", 40, 35);
	}
	
	public static void register() {
		addToMappings(ironVein);
		addToMappings(goldVein);
		addToMappings(coalVein);
	}

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

}
