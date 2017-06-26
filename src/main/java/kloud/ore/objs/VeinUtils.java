package kloud.ore.objs;

import net.minecraft.block.Block;

public class VeinUtils {
	
	public static Vein createVein(Block b1, Block b2, Block b3, String name, int size, int weight) {
		Vein temp = new Vein(b1, b2, b3, name, size, weight);
		return temp;
	}

}
