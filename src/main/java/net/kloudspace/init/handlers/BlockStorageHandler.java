package net.kloudspace.init.handlers;

import net.kloudspace.init.block.KStorageBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BlockStorageHandler {
	
	public static Block copperStorage;
	public static Item ibCopperStorage;
	public static Block tinStorage;
	
	public static void init() {
		copperStorage = new KStorageBlock("copper_storage", MetalHandler.copper);
		tinStorage = new KStorageBlock("tin_storage", MetalHandler.tin);
	}
	
	public static void register() {
		
	}
	
	public static void registerRenders() {
		
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
