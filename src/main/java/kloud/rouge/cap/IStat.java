package kloud.rouge.cap;

import net.minecraft.nbt.NBTTagCompound;

public interface IStat {
	
	public int getPoints();
	
	public void incrPoints(int amount);
	
	public void decrPoints(int amount);
	
	public void setPoints(int amount);
	
	public int getLvl();
	
	public void incrLvl();
	
	public void decrLvl();
	
	public void setLvl(int amount);
	
	default void resetLvl() {
		this.setLvl(0);
	}
	
	public NBTTagCompound saveNBT(NBTTagCompound tag);
	
	public void readNBT();
	
	
	
	
	

}
