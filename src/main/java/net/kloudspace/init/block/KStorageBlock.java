package net.kloudspace.init.block;

import net.kloudspace.init.handlers.CreativeTabHandler;
import net.kloudspace.init.materials.MetalType;
import net.minecraft.block.material.Material;

public class KStorageBlock extends KBlocks {

	public KStorageBlock(String name, MetalType type) {
		super(Material.IRON, name, CreativeTabHandler.ORES, type.getHardness() , type.getResistance());
	}

}
