package kloud.proxy;

import kloud.rouge.event.RougeEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class RougeServerProxy implements IProxy{

	@Override
	public void preInit() {
		
		System.out.println("\n=============================================\n RogueLike server proxy preinit");
//		MinecraftForge.EVENT_BUS.register(new RougeEventHandler());
	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		
	}
	
	public EntityPlayer getPlayer(MessageContext ctx) {
		if(ctx.side == Side.CLIENT) return Minecraft.getMinecraft().player;
		else return ctx.getServerHandler().playerEntity;
	}

}
