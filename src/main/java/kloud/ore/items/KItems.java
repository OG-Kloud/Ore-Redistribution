package kloud.ore.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class KItems extends Item {
	
	public KItems(String name, CreativeTabs tab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
	}
	
	public KItems(String name, CreativeTabs tab, int stackSize) {
		this(name, tab);
		setMaxStackSize(stackSize);
	}

}
