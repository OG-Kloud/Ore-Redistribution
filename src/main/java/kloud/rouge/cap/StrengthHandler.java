package kloud.rouge.cap;

import net.kloudspace.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class StrengthHandler {
	
	public static final ResourceLocation STRENGTH_CAP = new ResourceLocation(Reference.MODID, "strength");
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent.Entity e) {
		if(!(e.getEntity() instanceof EntityPlayer)) return;
		e.addCapability(STRENGTH_CAP, new StrengthProvider());
	}

}
