package kloud.ore.block;

import java.util.Random;

import kloud.ore.handler.CreativeTabHandler;
import kloud.ore.materials.MetalType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
/**
 * Basic ore class
 * <p>
 * provides no special functionality
 * @author kloud
 *
 */
public class KBlockOre extends KBlocks {
	/**
	 * weather this ore can oxidize
	 */
	private boolean canOxidize = false;
	/**
	 * the {@link MetalType} for this ore
	 */
	public MetalType type;
	/** Constructs ore
	 *
	 * @param name to register the block with the registries
	 * @param type the  {@link MetalType}
	 */
	public KBlockOre(String name, MetalType type) {
		super(Material.ROCK, name, CreativeTabHandler.ORES, type.getHardness(), type.getResistance(), type.getHarvestLevel(), "pickaxe");
		this.type = type;
	}
	/** sets if the block can oxidize
	 * <p>
	 * currently not used
	 * 
	 * @param flag weather this block can oxidize
	 * @return the block instance
	 */
	public KBlockOre canOxidize(boolean flag) {
		this.setCanOxidize(flag);
		return this;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
			
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return super.quantityDropped(state, fortune, random);
	}
	/**
	 * 
	 * @return the {@link MetalType} for this block
	 */
	public MetalType getMetalType() {
		return type;
	}
	/**
	 * 
	 * @return weather this block can oxidize
	 */
	public boolean canOxidize() {
		return canOxidize;
	}
	/**set weather this block can oxidize*/
	private void setCanOxidize(boolean canOxidize) {
		this.canOxidize = canOxidize;
	}

}
