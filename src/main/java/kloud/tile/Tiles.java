package kloud.tile;

import kloud.modulator.IModule;
import net.kloudspace.util.Reference;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Tiles implements IModule{
	
	private boolean active = Reference.DISABLED;
	private String moduleName = Reference.TILES_MODULE;
	private final String desc = "";
	
	public Tiles() {
		this.addModule(this);
	}
	

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		
	}

	@Override
	public void init(FMLInitializationEvent e) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		
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
