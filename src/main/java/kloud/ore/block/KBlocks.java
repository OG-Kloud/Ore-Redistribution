package kloud.ore.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
/**
 * Base class for {@literal Ores module} blocks
 * @author kloud
 *
 */
public class KBlocks extends Block {
	/**
	 * holds the drop for this KBlocks instance
	 */
	public Item drop;
	/**
	 * 
	 * @param mat - the material
	 * @param name - block name to register
	 * @param tab - CreativeTab
	 * @param hardness - block hardness
	 * @param resistance - block resistance
	 * @param harvest - harvest level
	 * @param tool - the harvest tool class string
	 */
	public KBlocks(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		this(mat, name, tab, hardness, resistance);
		setHarvestLevel(tool, harvest);
	}
	/**
	 * Call the {@link KBlocks#KBlocks(Material, String, CreativeTabs, float, float, int, String)} to set Harvest level and tool class
	 * 
	 * @param mat - the material
	 * @param name - block name to register
	 * @param tab - CreativeTab
	 * @param hardness - block hardness
	 * @param resistance - block resistance
	 */
	public KBlocks(Material mat, String name, CreativeTabs tab, float hardness, float resistance) {
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setHardness(hardness);
		setResistance(resistance);
	}

}
