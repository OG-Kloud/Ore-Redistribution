package kloud.ore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import kloud.modulator.IModule;
import kloud.ore.config.IKConfig;
import kloud.ore.config.KConfigBuilder;
import kloud.ore.handler.BlockOreHandler;
import kloud.ore.handler.BlockStorageHandler;
import kloud.ore.handler.CreativeTabHandler;
import kloud.ore.handler.ItemHandler;
import kloud.ore.handler.MaterialHandler;
import kloud.ore.handler.MetalHandler;
import kloud.ore.handler.ToolHandler;
import kloud.ore.handler.VeinHandler;
import kloud.ore.world.KOreGenerator;
import kloud.proxy.IProxy;
import net.kloudspace.util.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
/** Controlling class for the Ores Module
 * 
 * @author kloud
 *
 */
public class Ores implements IModule{ 
	/**Module name to be returned by {@link Ores#getModuleName()}*/
	private String moduleName = "Ores";
	/**Holds the state of the module enabled or disabled.  
	 *Disabled modules will be deleted from/not add to the configuration file.
	 *<p>
	 *returned by {@link Ores#isActive()}
	 */
	private boolean active = true;
	/**Holds the description of this module. 
	 *<p>
	 * returned by {@link Ores#getDesc()}
	 */
	private final String desc = "Controls ore generation by canceling any generation attempts by Minecrafts "
			+ "WorldGenMinable#generate method. If this module is enabled vanilla ore generation will be disabled"
			+ "and generation will be created by  KGenMinable#generate method. KloudGenMinable handles ore generation"
			+ "in multi block veins and thus the ore veins are further apart but will provide many more ores in total.";
	/**holds a list of class's implementing IKConfig --!must be registered!--*/
	private List<IKConfig> configs = new ArrayList<IKConfig>();
	/**private instance of {@link IModule#getMainConfigurationDirectory()}*/
	private File configDirectory;
	/**Holds an instance of the configuration directory for this IModule*/
	private File moduleDirectory;
	/**Holds instance of KConfigBuilder*/
	public static KConfigBuilder kcb;
	/**Holds instance of KOreGenerator*/
	public static IWorldGenerator kOreGenerator = new KOreGenerator();
	
	public static BlockOreHandler oreHandler = new BlockOreHandler();
	public static BlockStorageHandler storageBlockHandler = new BlockStorageHandler();
	public static CreativeTabHandler tabHandler = new CreativeTabHandler();
	public static ItemHandler itemHandler = new ItemHandler();
	public static MaterialHandler materialHandler = new MaterialHandler();
	public static MetalHandler metalHandler = new MetalHandler();
	public static ToolHandler toolHandler = new ToolHandler();
	public static VeinHandler veinHandler = new VeinHandler();
	/**
	 * Constructor
	 *<p>
	 *!! Remember to register this module with {@link IModule#addModule(IModule)}
	 */
	public Ores() {
		this.addModule(this);
	}
	
	@SidedProxy(clientSide = Reference.ORE_CLIENTPROXY, serverSide = Reference.ORE_SERVERPROXY)
	public static IProxy proxy;
	
	/**static instance of this Module*/
//	public static Ores ores;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		configDirectory = this.getMainConfigurationDirectory();
		moduleDirectory = new File(configDirectory, "OReDistribution");
		kcb = new KConfigBuilder(new Configuration(new File(moduleDirectory, "Vein Variables" + Reference.SELFBUILDINGCONFIGSUFFIX)));
		configs.add(kcb);
		proxy.preInit();
		kcb.syncConfig();
		((KOreGenerator)Ores.kOreGenerator).init();
		GameRegistry.registerWorldGenerator(Ores.kOreGenerator, 0);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(FMLInitializationEvent e) {
		proxy.init();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit();
	}
	@Override
	public boolean isActive() {
		return active;
	}
	@Override
	public void setActive(boolean isActive) {
		this.active = isActive;
	}
	@Override
	public void setModuleName(String name) {
		this.moduleName = name;
	}
	@Override
	public String getModuleName() {
		return this.moduleName;
	}
	@Override
	public boolean getDefaultState() {
		return this.active;
	}
	@Override
	public String getDesc() {
		return this.desc;
	}

}
