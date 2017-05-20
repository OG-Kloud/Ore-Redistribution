package net.kloudspace.block.tile.furance;

import net.minecraft.item.Item;

public class Fuel {
	
	private final Item fuel;
	private final int maxTemp;
	private final int rampTime;
	private int usedTemp;
	/**Amount of temperature transfered per tick (Basic furnace looses 5*heat/Tick)*/
	private final int tempTransfer;
	private final int maxBurnTime;
	
	public Fuel(Item item, int max, int ramp, int trans, int burnTime) {
		this.fuel = item;
		this.maxTemp = max;
		this.rampTime = ramp;
		this.tempTransfer = trans;
		this.maxBurnTime = burnTime;
	}

	public Item getFuel() {
		return fuel;
	}

	public int getMaxTemp() {
		return maxTemp;
	}

	public int getRampTime() {
		return rampTime;
	}

	public void incrUsedTemp() {
		this.usedTemp += this.tempTransfer;
	}

	public int getUsedTemp() {
		return usedTemp;
	}

	public void setUsedTemp(int usedTemp) {
		this.usedTemp = usedTemp;
	}

	public int getTempTransfer() {
		return tempTransfer;
	}

	public int getMaxBurnTime() {
		return maxBurnTime;
	}
}
