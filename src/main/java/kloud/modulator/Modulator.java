package kloud.modulator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import kloud.ore.Ores;
import kloud.proxy.IProxy;
import kloud.rouge.RogueLike;
import kloud.tile.Tiles;
import net.kloudspace.util.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/**Main class for the Controlling the IModule instances*/
@Mod(modid = Reference.MODID, name = "Modulate", version = "x.y.z")
public class Modulator {
	
	/**static instance of the Ores Module*/
	static Ores oresMain;
	/**static instance of the RogueLike Module*/
	static RogueLike rogueMain;
	/**static instance of the Tiles Module*/
	static Tiles tileMain;
	/**Holds a static instance of the Main configuration directory for this modification in the MinecraftForge
	 * configuration directory*/
	static File mainConfigDirectory;
	
	/**
	 * Modulator constructor, remember to initiate static module objects 
	 */
	public Modulator() {
		oresMain = new Ores();
		rogueMain = new RogueLike();
		tileMain = new Tiles();
	}
	/**Holds the Modulators ConfigBuilder reference*/
	private ConfigBuilder config;
	/**List of modules. registered from the Class<? extends IModule>'s constructor*/
	private static List<IModule> modules = new ArrayList<IModule>();
	/**Parsed modules list based on the {@link IModule#isActive()}*/
	private static List<IModule> activeModules = new ArrayList<IModule>();
	
	@SidedProxy(clientSide = Reference.MODCLIENTPROXY, serverSide = Reference.MODSERVERPROXY)
	public static IProxy proxy;
	/**
	 * @param module the module to register.
	 * 
	 */
	public static void addModule(IModule module) {
		modules.add(module);
	}
	/**
	 * 
	 * @return the module list 
	 * --Is not filtered to tell if the module is active--
	 */
	public static List<IModule> getModules() {
		return Modulator.modules;
	}
	/**cycles through the modules list and adds active IModules to {@link Modulator#activeModules}*/
	public static void getActive() {
		for(IModule module : modules) {
			if(module.isActive()) { 
				System.out.println("=======================================================\n " + module.getModuleName()
				+ "\n Added to active.\n ===============================================================");
				activeModules.add(module);
			}
		}
	}
	/** Handles loading in the preinitialization phase
	 * 
	 * @param e  the PreInitializationEvent
	 * 
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		mainConfigDirectory = new File(e.getSuggestedConfigurationFile().getParentFile(), "KloudModules");
		mainConfigDirectory.mkdirs();
		config = new ConfigBuilder(new Configuration(new File(mainConfigDirectory, "Modules" + Reference.SELFBUILDINGCONFIGSUFFIX)));
		config.moduleLoader();
		getActive();
		for(IModule module : activeModules) {
			module.preInit(e);
		}
	}
	/** Handles loading in the initialization phase
	 * 
	 * @param e  the InitializationEvent
	 * 
	 */
	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		for(IModule module : activeModules) {
			module.init(e);
		}
	}
	/** Handles loading in postinitialization phase
	 * 
	 * @param e  the PostInitializationEvent
	 * 
	 */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		for(IModule module : activeModules) {
			module.postInit(e);
		}
	}
	

}
