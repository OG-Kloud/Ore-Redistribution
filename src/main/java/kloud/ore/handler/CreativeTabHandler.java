package kloud.ore.handler;

import net.kloudspace.util.IKHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabHandler implements IKHandler{
	
	public static CreativeTabs ORES;
	public static CreativeTabs TOOLS;
	public static CreativeTabs ITEMS;
	
	public void init() {
		ORES = tabCreater("Ores & Ingots", Items.IRON_INGOT);
		TOOLS = tabCreater("Tools", ToolHandler.flint_pickaxe);
		ITEMS = tabCreater("Misc.", ItemHandler.copperIngot);
	}
	
	/** Creates a CreativeTab
	 * 
	 * @param name of the new creative tab to create
	 * @param display - Item to display on the tab
	 * @return the newly created {@link CreativeTab}
	 */
	public CreativeTabs tabCreater(String name, final Item display) {
		return new CreativeTabs(name){
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(display);
			}
		};
	}


	@Override
	public void register() {
		
	}

}
