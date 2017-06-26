package kloud.ore.handler;

import kloud.ore.block.KStorageBlock;
import net.kloudspace.util.IKHandlerRenders;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BlockStorageHandler implements IKHandlerRenders{
	
	public static Block copperStorage;
	public static Item ibCopperStorage;
	public static Block tinStorage;
	/**
	 * {@inheritDoc}
	 */
	public void init() {
		copperStorage = new KStorageBlock("copper_storage", MetalHandler.copper);
		tinStorage = new KStorageBlock("tin_storage", MetalHandler.tin);
	}
	
	public void register() {
		
	}
	
	public void registerRenders() {
		
	}
	

}
