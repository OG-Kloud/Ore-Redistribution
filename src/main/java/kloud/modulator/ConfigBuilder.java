package kloud.modulator;

import java.util.ArrayList;
import java.util.List;

import net.kloudspace.util.Reference;
import net.minecraftforge.common.config.Configuration;
/**
 * Builds a Configuration for deactivating different modules in this mod
 **/
public class ConfigBuilder {
	
	Configuration configuration;
	
	public ConfigBuilder(Configuration config) {
		this.configuration = config;
	}
	/**Holds a list of modules(A copy from Modulator.class)*/
	public List<IModule> modules = new ArrayList<IModule>();
	/**Cycles through the {@link Modulator#getModules()} list and adds them to the configuration*/
	public void moduleLoader() {
		Reference.log("Called ConfigBuilder#moduleLoader()");
		modules = Modulator.getModules();
		configuration.load();
		for(IModule module : modules) {
			System.out.println(module.getModuleName());
			if(module.isActive()) {
				
				module.setActive(configuration.getBoolean(module.getModuleName(), "Module" + module.getModuleName(), module.getDefaultState(), module.getDesc()));
			}
		}
		
		configuration.save();
	}

}
