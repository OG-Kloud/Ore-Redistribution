package kloud.ore.world;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class KGenEvents {
	@SubscribeEvent
	public static void oreGen(GenerateMinable e){
//		if(Ores.genConfig.disableVanillaGen) {
			if(e.getGenerator() instanceof WorldGenMinable) {
				e.setResult(Result.DENY);
			}
//		}
	}

}
