package kloud.rouge.messages;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class StatInquiry implements IMessage{
	
	
	
	public StatInquiry() {}
	
	public StatInquiry(EntityPlayer player) {
		
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}
	
	public static class InquiryHandler implements IMessageHandler<StatInquiry, IMessage> {

		@Override
		public IMessage onMessage(StatInquiry message, MessageContext ctx) {
			return new StatReply();
		}

		
		
	}

}
