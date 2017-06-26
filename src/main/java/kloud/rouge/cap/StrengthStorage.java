package kloud.rouge.cap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class StrengthStorage implements IStorage<IStat> {

	@Override
	public NBTBase writeNBT(Capability<IStat> capability, IStat instance, EnumFacing side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readNBT(Capability<IStat> capability, IStat instance, EnumFacing side, NBTBase nbt) {
		// TODO Auto-generated method stub
		
	}

}
