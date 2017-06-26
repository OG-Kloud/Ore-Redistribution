package kloud.proxy;

import kloud.ore.Ores;
import kloud.ore.world.KGenEvents;
import kloud.rouge.event.RougeEventHandler;
import net.minecraftforge.common.MinecraftForge;

public class OreCommonProxy implements IProxy {

	@Override
	public void preInit() {
		Ores.metalHandler.init();
		Ores.tabHandler.init();
		
		Ores.itemHandler.init();
		Ores.itemHandler.register();
		
		Ores.oreHandler.init();
		Ores.oreHandler.register();
		
		Ores.storageBlockHandler.init();
		Ores.storageBlockHandler.register();
		
		
		Ores.veinHandler.init();
		Ores.veinHandler.register();
		
		Ores.toolHandler.init();
		Ores.toolHandler.register();
		
		MinecraftForge.ORE_GEN_BUS.register(new KGenEvents());
		MinecraftForge.EVENT_BUS.register(new RougeEventHandler());

	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		
	}

}
