package net.kloudspace.init.handlers;

import java.util.HashMap;
import java.util.Map;

import net.kloudspace.block.tile.furance.OreRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class OreRecipeHandler {
	
	public static final Map<Integer, OreRecipe> recipeIdMap = new HashMap<Integer, OreRecipe>();
	private static int idCounter;
	
	private static OreRecipe coalRecipe;
	
	/*OreRecipe#(Item Input, Item Output, int Required temp, int Required time at temp, int Amount of input needed*/
	public static void init(){
		coalRecipe = new OreRecipe(Item.getItemFromBlock(BlockOreHandler.coalOre), Items.COAL, 100, 5, 1);
	}
	
	public static void register() {
		register(coalRecipe);
	}
	
	public static void register(OreRecipe recipe) {
		if(OreRecipeHandler.recipeIdMap.get(0) == null) {
			OreRecipeHandler.recipeIdMap.put(0, recipe);
		} else if(OreRecipeHandler.recipeIdMap.get(recipe.getID()) == null) {
			OreRecipeHandler.recipeIdMap.put(recipe.setID(getFreshId()), recipe);
		} else {
			throw new IllegalArgumentException("Tried to register an OreRecipe with an exsiting id");
		}
	}
	
	public static int getFreshId() {
		return idCounter + 1;
	}

	public static OreRecipe matchRecipe(Item item) {
		OreRecipe recipe = null;
		for(int i = 0; i <= OreRecipeHandler.idCounter; i++) {
			if(OreRecipeHandler.recipeIdMap.get(i).input == item) {
				recipe = OreRecipeHandler.recipeIdMap.get(i);
			}
		}
		return recipe;
	}

}
