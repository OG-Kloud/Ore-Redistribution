package net.kloudspace.util;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reference {
	
	public static final String MODID = "orekloud";
	public static final String NAME = "Ores";
	public static final String VERSION = "x.y.z";
	
	public static final String CLIENTPROXY = "net.kloudspace.proxy.ClientProxy";
	public static final String SERVERPROXY = "net.kloudspace.proxy.CommonProxy";
	
	public static final String RESOURCE = MODID.toLowerCase(Locale.US);
	
	public static Logger getLogger(String type) {
		String log = MODID;
		return LogManager.getLogger(log + "-" + type);
	}
	  
}
