package kloud.rouge.messages;

import io.netty.buffer.ByteBuf;
import kloud.rouge.RogueLike;
import kloud.rouge.cap.IStat;
import kloud.rouge.cap.StrengthProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class StatReply implements IMessage {
	
	private static IStat stat;

	
	public StatReply(){}
	
	public StatReply(EntityPlayer player) {
		stat = player.getCapability(StrengthProvider.STRENGTH_CAP, null);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		buf.writeInt(stat.getPoints());
		buf.writeInt(stat.getLvl());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		stat.setPoints(buf.readInt());
		stat.setLvl(buf.readInt());
	}
	
	public static class Handler implements IMessageHandler<StatReply, IMessage> {

		@Override
		public IMessage onMessage(StatReply message, MessageContext ctx) {
			IThreadListener mainThread = Minecraft.getMinecraft();
			mainThread.addScheduledTask(new Runnable() {

				@Override
				public void run() {
					EntityPlayer player = RogueLike.proxy.getPlayer(ctx);
					IStat statS = player.getCapability(StrengthProvider.STRENGTH_CAP, null);
					statS.setPoints(stat.getPoints());
					statS.setLvl(stat.getLvl());
				}
			
			});
			return null;
		}
		
	}

}
