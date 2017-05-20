package net.kloudspace.init.materials;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MetalType {
		
	public final String name;
	public Item metalIngot;
	public Block metalOre;
	public Block metalStorage;
	public Item metalNugget;
	public float meltingPoint;
	
	public Item blockDrop;
	
	public float hardness = 0;
	public float resistance = 0;
	
	public int harvestLevel = 0;
	
	public MetalType(String name) {
		this.name = name;
	}
	
	public void setHardness(float hardness) {
		this.hardness = hardness;
	}

	public float getResistance() {
		return resistance;
	}

	public void setResistance(float resistance) {
		this.resistance = resistance;
	}

	public float getHardness() {
		return hardness;
	}

	public int getHarvestLevel() {
		return harvestLevel;
	}

	public void setHarvestLevel(int harvestLevel) {
		this.harvestLevel = harvestLevel;
	}

	public String getName() {
		return name;
	}

	public Item getMetalIngot() {
		return metalIngot;
	}

	public void setMetalIngot(Item metalIngot) {
		this.metalIngot = metalIngot;
	}

	public Block getMetalOre() {
		return metalOre;
	}

	public void setMetalOre(Block metalOre) {
		this.metalOre = metalOre;
	}

	public Block getMetalStorage() {
		return metalStorage;
	}

	public void setMetalStorage(Block metalStorage) {
		this.metalStorage = metalStorage;
	}

	public Item getMetalNugget() {
		return metalNugget;
	}

	public void setMetalNugget(Item metalNugget) {
		this.metalNugget = metalNugget;
	}

	public Item getBlockDrop() {
		return blockDrop;
	}

	public void setBlockDrop(Item blockDrop) {
		this.blockDrop = blockDrop;
	}
	
	public void setBlockDrop(Block block) {
		this.blockDrop = Item.getItemFromBlock(block);
	}

	public float getMeltingPoint() {
		return meltingPoint;
	}

	public void setMeltingPoint(float meltingPoint) {
		this.meltingPoint = meltingPoint;
	}
	
	

}
