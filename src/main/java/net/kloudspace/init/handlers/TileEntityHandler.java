package net.kloudspace.init.handlers;

import net.kloudspace.block.tile.entity.KFurnaceTileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	
	public static void init() {
		
	}
	
	public static void register() {
		GameRegistry.registerTileEntity(KFurnaceTileEntity.class, "kfurnace.tileentity");;
	}

}
