package kloud.rouge.cap;

import net.minecraft.nbt.NBTTagCompound;

public class Strength implements IStat {
	
	private int points = 0;
	
	private int lvl = 0;

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public void incrPoints(int amount) {
		this.points += amount;
	}

	@Override
	public void decrPoints(int amount) {
		this.points -= amount;
	}

	@Override
	public void setPoints(int amount) {
		this.points = amount;
	}

	@Override
	public int getLvl() {
		return this.lvl;
	}

	@Override
	public void incrLvl() {
		this.lvl += 1;
	}

	@Override
	public void decrLvl() {
		this.lvl -= 1;
	}

	@Override
	public void setLvl(int amount) {
		this.lvl = amount;
	}

	@Override
	public NBTTagCompound saveNBT(NBTTagCompound tag) {
		tag.setInteger("points", this.points);
		tag.setInteger("level", this.lvl);
		return tag;
	}

	@Override
	public void readNBT() {
		
	}

}
