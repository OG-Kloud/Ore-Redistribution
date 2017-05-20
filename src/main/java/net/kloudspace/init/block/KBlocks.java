package net.kloudspace.init.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class KBlocks extends Block {
	
	public Item drop;
	
	public KBlocks(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		this(mat, name, tab, hardness, resistance);
		setHarvestLevel(tool, harvest);
	}
	
	public KBlocks(Material mat, String name, CreativeTabs tab, float hardness, float resistance) {
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setHardness(hardness);
		setResistance(resistance);
	}

}
