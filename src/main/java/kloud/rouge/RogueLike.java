package kloud.rouge;

import kloud.modulator.IModule;
import kloud.proxy.IProxy;
import kloud.rouge.cap.IStat;
import kloud.rouge.cap.Strength;
import kloud.rouge.cap.StrengthStorage;
import kloud.rouge.messages.StatReply;
import net.kloudspace.util.Reference;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
/**Main class for the RougeLike module*/
public class RogueLike implements IModule{
	
	private boolean active = Reference.ENABLED;
	private String moduleName = Reference.rogueModule;
	
	private final String desc = "";
	
	public static SimpleNetworkWrapper network;
	
	@SidedProxy(clientSide = Reference.ROGUECLIENTPROXY, serverSide = Reference.ROGUESERVERPROXY)
	public static IProxy proxy;
	
	public RogueLike() {
		this.addModule(this);
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
	public void preInit(FMLPreInitializationEvent e) {
		System.out.println("RogueLike preInit called ========================================");
		network = NetworkRegistry.INSTANCE.newSimpleChannel("RogueModule");
		network.registerMessage(StatReply.Handler.class, StatReply.class, 0, Side.CLIENT);
		CapabilityManager.INSTANCE.register(IStat.class, new StrengthStorage(), Strength.class);
		proxy.preInit();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		proxy.init();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit();
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
