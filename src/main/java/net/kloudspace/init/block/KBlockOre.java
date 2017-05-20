package net.kloudspace.init.block;

import java.util.Random;

import net.kloudspace.init.handlers.CreativeTabHandler;
import net.kloudspace.init.materials.MetalType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class KBlockOre extends KBlocks {
	
	public boolean canOxidize;
	public MetalType type;

	public KBlockOre(String name, MetalType type) {
		super(Material.ROCK, name, CreativeTabHandler.ORES, type.getHardness(), type.getResistance(), type.getHarvestLevel(), "pickaxe");
		this.type = type;
	}
	
	public KBlockOre canOxidize(boolean flag) {
		this.canOxidize = flag;
		return this;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
			
	}
	
	
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return super.quantityDropped(state, fortune, random);
	}

	public MetalType getMetalType() {
		return type;
	}

}
