package net.kloudspace.block.tile.furance;

import net.minecraft.item.Item;

public class OreRecipe {
	
	
	private int ID;
	public Item input;
	public Item output;
	public int requiredTemp;
	/**Amount of time for this recipe to process at temperature(in ticks)*/
	public int requiredTime;
	public int requiredNumberOfInput;
	
	public OreRecipe(Item inputItem, Item outputItem, int temp, int time, int numberRequired) {
		this.input = inputItem;
		this.output = outputItem;
		this.requiredTemp = temp;
		this.requiredTime = time;
		this.requiredNumberOfInput = numberRequired;
	}

	public int getID() {
		return ID;
	}

	public int setID(int iD) {
		return ID = iD;
	}

}
