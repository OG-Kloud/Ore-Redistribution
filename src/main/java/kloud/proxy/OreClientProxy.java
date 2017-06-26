package kloud.proxy;

import kloud.ore.Ores;

public class OreClientProxy extends OreCommonProxy {
	
	public void init() {
		Ores.itemHandler.registerRenders();
		Ores.oreHandler.registerRenders();
	}

}
