package net.kloudspace.proxy;

import net.kloudspace.init.handlers.BlockOreHandler;
import net.kloudspace.init.handlers.ItemHandler;

public class ClientProxy extends CommonProxy {
	
	public void init() {
		ItemHandler.registerRenders();
		BlockOreHandler.registerRenders();
	}

}
