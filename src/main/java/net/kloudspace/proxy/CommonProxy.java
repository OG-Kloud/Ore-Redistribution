package net.kloudspace.proxy;

import net.kloudspace.init.handlers.BlockOreHandler;
import net.kloudspace.init.handlers.BlockStorageHandler;
import net.kloudspace.init.handlers.BlockTileHandler;
import net.kloudspace.init.handlers.CreativeTabHandler;
import net.kloudspace.init.handlers.FuelHandler;
import net.kloudspace.init.handlers.ItemHandler;
import net.kloudspace.init.handlers.MetalHandler;
import net.kloudspace.init.handlers.OreRecipeHandler;
import net.kloudspace.init.handlers.TileEntityHandler;
import net.kloudspace.init.handlers.ToolHandler;
import net.kloudspace.init.handlers.VeinHandler;
import net.kloudspace.world.KOreGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy {

	@Override
	public void preInit() {
		MetalHandler.init();
		CreativeTabHandler.init();
		
		ItemHandler.init();
		ItemHandler.register();
		
		BlockOreHandler.init();
		BlockOreHandler.register();
		
		BlockStorageHandler.init();
		BlockStorageHandler.register();
		
		BlockTileHandler.init();
		BlockTileHandler.register();
		TileEntityHandler.init();
		TileEntityHandler.register();
		
		FuelHandler.init();
		FuelHandler.register();
		OreRecipeHandler.init();
		OreRecipeHandler.register();
		
		VeinHandler.init();
		VeinHandler.register();
		ToolHandler.init();
		ToolHandler.register();
		
		GameRegistry.registerWorldGenerator(new KOreGenerator(), 0);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		
	}

}
