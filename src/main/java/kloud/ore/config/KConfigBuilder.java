package kloud.ore.config;

import java.util.ArrayList;
import java.util.List;

import kloud.ore.objs.Vein;
import net.minecraftforge.common.config.Configuration;
/**Class for building a configuration that allows for vein size and weights to be modified independently*/
public class KConfigBuilder implements IKConfig {
	/**Holds the Configuration instance for this KConfigBuilder*/
	private Configuration config;
	/**Holds a List of KConfigEntry's to be iterated through*/
	private List<KConfigEntry> entries = new ArrayList<KConfigEntry>();
	
	/**
	 * @param configuration
	 * configuration is the instance of Configuration to be used in this ConfigBuilder.
	 */
	public KConfigBuilder(Configuration configuration) {
		this.config = configuration;
	}
	/**
	 * @param vein the vein to create the entry for.
	 * Creates a ConfigEntry for the vein passed in and adds it to the list of entries
	 */
	public void createConfigEntry(Vein vein) {
		String weight = vein.getVeinName()+"_weight";
		String size = vein.getVeinName()+"_size";
		String catName = vein.getVeinName();
		
		entries.add(new KConfigEntry(weight, size, catName, vein.getVeinSize(), vein.getVeinWeight(), vein.MAXWEIGHT, vein.MAXSIZE));
		
	}
	/**
	 * Syncs the values read from the configuration
	 * call after reading this config;
	 */
	public void syncConfig() {
		config.load();
		for(KConfigEntry kce : entries) {
//			kce.veinSize = config.getInt(kce.size, kce.catName, kce.defaultSize, 1, kce.maxSize, Ores.oreConfig.comment);
//			kce.veinWeight = config.getInt(kce.weight, kce.catName, kce.defaultWeight, 1, kce.maxWeight, Ores.oreConfig.desc + kce.catName);
			kce.updateVein();
			
		}
		config.save();
	}

}
