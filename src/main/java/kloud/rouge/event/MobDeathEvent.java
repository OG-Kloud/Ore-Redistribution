package kloud.rouge.event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.Event;

public class MobDeathEvent extends Event {
	
	private Entity entity;
	private BlockPos position;
	private Entity thePlayer;
	/**MobType holds random level range and EntityClass*/
	private MobType mobType;
	
	private static List<MobType> types = new ArrayList<MobType>();

	/**This event sould post only when the entity was killed by a player (in theory) */
	public MobDeathEvent(Entity entity, EntityPlayer player) {
		this.entity = entity;
		this.position = entity.getPosition();
		this.mobType = getMobType(entity);
		this.thePlayer = player;
		System.out.println("MobDeathEvent");
	}
	
	public Entity getEntity() {return this.entity;}
	
	public BlockPos getBlockPos() {return this.position;}
	
	public MobType getMobType() {return this.mobType;}
	
	public Entity getPlayer() {return this.thePlayer;}
	
	private MobType getMobType(Entity entity) {
		for(MobType t : types) {
			if(t.entity == entity.getClass())return t;
		}
		return MobType.BASIC;
	}
	
	
	public static enum MobType {
		WITHER(1, 50, EntityWither.class),
		ZOMBIE(1, 50, EntityZombie.class),
		SKELETON(1, 50, EntitySkeleton.class),
		CREEPER(1, 50, EntityCreeper.class),
		ENDERMAN(1, 50, EntityEnderman.class),
		ENDDRAGON(1, 50, EntityDragon.class),
		BASIC(1, 50, EntityZombie.class);
		
		public int min = 0, max = 0;
		public Class<?extends Entity> entity;
		
		MobType(int lvlMin, int lvlMax, Class<? extends Entity> clazz) {
		this.min = lvlMin;
		this.max = lvlMax;
		this.entity = clazz;
		addType(this);
		}
		
		public void addType(MobType t) {
			MobDeathEvent.types.add(t);
		}
		
	}

}
