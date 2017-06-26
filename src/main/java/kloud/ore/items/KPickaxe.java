package kloud.ore.items;

import kloud.ore.handler.CreativeTabHandler;
import net.minecraft.item.ItemPickaxe;

public class KPickaxe extends ItemPickaxe {

	public KPickaxe(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabHandler.TOOLS);
	}

}
