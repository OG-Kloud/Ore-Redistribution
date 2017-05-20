package net.kloudspace.init.items;

import net.kloudspace.init.handlers.CreativeTabHandler;
import net.minecraft.item.ItemPickaxe;

public class KPickaxe extends ItemPickaxe {

	public KPickaxe(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.TOOLS);
	}

}
