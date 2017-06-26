package kloud.modulator;

import java.io.File;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/**Binding contract required for a class to be registered as a module in the Modulator.class*/
public interface IModule {
	/**
	 * 
	 * @return weather this IModule should be active by default. 
	 * <p>
	 * {@literal @return} value changes once the configurations have been read
	 */
	public abstract boolean isActive();
	/**
	 *  Sets weather this IModule should be active or not;
	 * @param isActive
	 */
	public abstract void setActive(boolean isActive);
	/**
	 * Sets the module name for this IModule
	 * @param name
	 */
	public abstract void setModuleName(String name);
	/**
	 * 
	 * @return the module name for this IModule
	 */
	public abstract String getModuleName();
	
	/**call from class constructor */
	default void addModule(IModule module) {
		Modulator.addModule(module);
	}
	/** Handles FMLPreInitializationEvent
	 * 
	 * @param e
	 */
	public abstract void preInit(FMLPreInitializationEvent e);
	/** Handles FMLInitializationEvent
	 * 
	 * @param e
	 */
	public abstract void init(FMLInitializationEvent e);
	/** Handles FMLPostInitializationEvent
	 * 
	 * @param e
	 */
	public abstract void postInit(FMLPostInitializationEvent e);
	/**
	 * Gets default state
	 * @return modification's default state
	 */
	public abstract boolean getDefaultState();
	/**
	 * 
	 * @return the main configuration directory held by {@link Modulator#mainConfigDirectory}
	 */
	default File getMainConfigurationDirectory() {
		return Modulator.mainConfigDirectory;
	}
	/**
	 * 
	 * @return a description of the active IModule
	 */
	public abstract String getDesc();

}
