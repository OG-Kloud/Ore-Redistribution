package net.kloudspace.init.handlers;

import net.kloudspace.init.block.KBlockOven;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockTileHandler {
	
	public static Block kOven;
	public static Block kOven_lit;
	public static Item ibKOven;
	public static Item ibKOven_lit;
	
	public static void init() {
		kOven = new KBlockOven(false);
		kOven.setRegistryName("koven");
		kOven_lit = new KBlockOven(true);
		kOven_lit.setRegistryName("kovenlit");
		ibKOven = (ItemBlock) new ItemBlock(kOven);
		ibKOven_lit = (ItemBlock) new ItemBlock(kOven_lit);
	}
	
	public static void register() {
		register(ibKOven, kOven);
		register(ibKOven_lit, kOven_lit);
	}
	
	private static void register(Item item, Block block) {
		GameRegistry.register(block);
		GameRegistry.register(item, block.getRegistryName());
	}

}
