package kloud.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public interface IProxy {
	
	public void preInit();
	public void init();
	public void postInit();
	
	default EntityPlayer getPlayer(MessageContext ctx) {
		if(ctx.side == Side.CLIENT) return Minecraft.getMinecraft().player;
		else return ctx.getServerHandler().playerEntity;
	}

}
