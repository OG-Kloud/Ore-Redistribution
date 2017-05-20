package net.kloudspace.init.block;

import net.kloudspace.init.handlers.CreativeTabHandler;
import net.kloudspace.init.materials.MetalType;
import net.minecraft.block.material.Material;

public class KAlloyOre extends KBlocks{
	
	public MetalType type;

	public KAlloyOre(Material mat, String name, float resistance) {
		super(mat, name, CreativeTabHandler.ORES, 15F, resistance);
	}
	
	
	

}
