package net.kloudspace.util;
/**
 * Binding contract to be a handler
 * @author kloud
 *
 */
public interface IKHandler {
	/**
	 * Initialization call from common/server proxy during preinitialization
	 */
	public void init();
	/**
	 * Register shorthand call from common/server proxy during preintialization
	 */
	public void register();
	
	
}
