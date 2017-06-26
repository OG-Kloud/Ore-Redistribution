package kloud.rouge.cap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class StrengthProvider implements ICapabilitySerializable<NBTBase>{
	
	@CapabilityInject(IStat.class)
	public static final Capability<IStat> STRENGTH_CAP = null;
	
	private IStat instance = STRENGTH_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == STRENGTH_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == STRENGTH_CAP ? STRENGTH_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return STRENGTH_CAP.getStorage().writeNBT(STRENGTH_CAP, instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		STRENGTH_CAP.getStorage().readNBT(STRENGTH_CAP, instance, null, nbt);
	}

}
