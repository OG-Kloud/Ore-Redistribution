package kloud.ore.handler;

import kloud.ore.items.KPickaxe;
import net.kloudspace.util.IKHandlerRenders;
import net.minecraft.item.Item;

public class ToolHandler implements IKHandlerRenders{
	
	public static Item flint_pickaxe;
	
	@Override
	public void init() {
		flint_pickaxe = new KPickaxe("flint_pickaxe", MaterialHandler.FLINT);
	}
	@Override
	public void register() {
		
	}
	@Override
	public void registerRenders() {
		
	}

}
