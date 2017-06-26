package kloud.ore.handler;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler {
	
	public static ToolMaterial FLINT = EnumHelper.addToolMaterial("FLINT", 1, 50, 5F, 3F, 22);
	public static ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", 1, 99, 5.5F, 4F, 13);
	public static ToolMaterial IRON = EnumHelper.addToolMaterial("IRON", 2, 251, 5F, 5F, 10);
	public static ToolMaterial GOLD = EnumHelper.addToolMaterial("GOLD", 0, 22, 10F, 1F, 99);

}
