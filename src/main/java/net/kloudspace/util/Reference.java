package net.kloudspace.util;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kloud.modulator.IModule;

/**Holds constants used in this Minecraft modification*/
public class Reference {
	
	public static final String MODID = "orekloud";
	public static final String NAME = "Modulation";
	public static final String VERSION = "x.y.z";
	
	public static final String oreModule = "Ore Module";
	public static final String rogueModule = "Rouge Module";
	public static final String TILES_MODULE = "Tiles Module";
	
	public static final String strCap = "Strength";
	
	public static final boolean ENABLED = true;
	public static final boolean DISABLED = false;
	
	public static final String ORE_CLIENTPROXY = "kloud.proxy.OreClientProxy";
	public static final String ORE_SERVERPROXY = "kloud.proxy.OreCommonProxy";
	
	public static final String MODCLIENTPROXY = "kloud.proxy.ModClientProxy";
	public static final String MODSERVERPROXY = "kloud.proxy.ModCommonProxy";
	
	public static final String ROGUECLIENTPROXY = "kloud.proxy.RougeClientProxy";
	public static final String ROGUESERVERPROXY = "kloud.proxy.RougeServerProxy";
	
	public static final String SELFBUILDINGCONFIGSUFFIX = ".ksbcfg";
	
	public static final boolean debug = true;
	
	public static final Logger logger = LogManager.getLogger(MODID);
	
	public static final String RESOURCE = MODID.toLowerCase(Locale.US);
	
	public static void log(IModule module, String msg) {
		if(debug) {
			logger.info("===================" + module.getModuleName() + "=======================");
			logger.info(msg);
		}
	}
	
	public static void log(String msg) {
		if(debug) {
			logger.info("===================" + MODID + "=======================");
			logger.info(msg);
		}
	}
	  
}
