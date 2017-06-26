package kloud.ore.block;

import kloud.ore.handler.CreativeTabHandler;
import kloud.ore.materials.MetalType;
import net.minecraft.block.material.Material;
/**
 * Not used
 * <p>
 * Base class for storage blocks e.g. Block of Iron
 * @author kloud
 *
 */
public class KStorageBlock extends KBlocks {

	public KStorageBlock(String name, MetalType type) {
		super(Material.IRON, name, CreativeTabHandler.ORES, type.getHardness() , type.getResistance());
	}

}
