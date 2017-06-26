package net.kloudspace.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
/**
 * 
 * @author kloud
 *
 */
public interface IKHandlerRenders extends IKHandler{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void register();
	/**
	 * Register Renders call from client proxy during preinitialization
	 */
	public void registerRenders();
	
	/**
	 * Register renders call from {@link IKHandlerRenders#registerRenders()} for block
	 */
	default public void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	/**
	 * Register renders call from {@link IKHandlerRenders#registerRenders()} for block
	 */
	default public void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}


}
