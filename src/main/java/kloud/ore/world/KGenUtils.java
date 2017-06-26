package kloud.ore.world;

import kloud.ore.Ores;
import kloud.ore.objs.Vein;
import net.minecraft.world.gen.feature.WorldGenerator;

public class KGenUtils {
	
	/**
	 * @param vein
	 * @return A WorldGenerator object for the given Vein object
	 * Creates the World Generator and registers it as an active WorldGenerator
	 * currently the easiest way to inject World Generator due to blocking KGenMinable
	 */
	public static WorldGenerator createGenerator(Vein vein) {
		WorldGenerator temp = new KGenMinable(vein);
		((KOreGenerator)Ores.kOreGenerator).add(temp);
		return temp;
	}
	
	/**
	 * @param vein
	 * @return A WorldGenerator object for the given Vein object
	 * Returns a WorldGenerator object that has not been registed as active
	 */
	public static WorldGenerator createUnRegisteredGenerator(Vein vein) {
		WorldGenerator temp = new KGenMinable(vein);
		return temp;
	}

}
