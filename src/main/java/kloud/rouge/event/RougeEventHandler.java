package kloud.rouge.event;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class RougeEventHandler {
	
	public RougeEventHandler() {
		System.out.println("EventHandler registered");
	}
	
	@SubscribeEvent
	public static void onDeaths(LivingDropsEvent e) {
		System.out.println("LivingDropsEvent");
		if(!e.getEntity().world.isRemote) {
		//	MinecraftForge.EVENT_BUS.post(new MobDeathEvent(e.getEntity(), (EntityPlayer)source.getSourceOfDamage()));
		//		onMobDeath(e.getEntity(), (EntityPlayer)source.getSourceOfDamage());
			ItemSword sword = new ItemSword(ToolMaterial.DIAMOND);
			ItemStack stack = new ItemStack(sword);
			stack.addEnchantment(Enchantment.getEnchantmentByID(0), 1);
			EntityItem item = new EntityItem(e.getEntity().world, e.getEntity().posX, e.getEntity().posY, e.getEntity().posZ, stack);
			e.getDrops().add(item);
//			e.getEntity().world.spawnEntity(item);
		}
	}
	
	
	public static void onMobDeath(Entity ent, EntityPlayer p) {//Item
		System.out.println("Custome Event called");
		ItemSword sword = new ItemSword(ToolMaterial.DIAMOND);
		ContainerEnchantment con = new ContainerEnchantment(p.inventory, ent.world, ent.getPosition());
		con.tableInventory.setInventorySlotContents(0, new ItemStack(sword));
		con.tableInventory.setInventorySlotContents(1, new ItemStack(Items.DYE, 64, EnumDyeColor.BLUE.getMetadata()));
		con.enchantItem(p, 3);
		World worldObj =  ent.world;
		worldObj.spawnEntity(new EntityItem(worldObj, ent.posZ, ent.posY, ent.posZ, new ItemStack(sword)));
	}

}
