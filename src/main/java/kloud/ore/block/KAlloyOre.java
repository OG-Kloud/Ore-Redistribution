package kloud.ore.block;

import kloud.ore.handler.CreativeTabHandler;
import kloud.ore.materials.MetalType;
import net.minecraft.block.material.Material;
/**
 * Unused at the moment 06-25-2017 16:05pst
 * @author kloud
 *
 */
public class KAlloyOre extends KBlocks{
	
	public MetalType type;

	public KAlloyOre(Material mat, String name, float resistance) {
		super(mat, name, CreativeTabHandler.ORES, 15F, resistance);
	}
	
	
	

}
