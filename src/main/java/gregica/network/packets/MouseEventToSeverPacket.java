package gregica.network.packets;

import gregica.api.item.IExtendedItemBehavior;
import gregica.network.GCPacket;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class MouseEventToSeverPacket implements GCPacket {
    
    private final boolean isUp;
    
    @SuppressWarnings("unused")
    public MouseEventToSeverPacket(ByteBuf byteBuf){
        this.isUp = byteBuf.readBoolean();
    }
    
    public MouseEventToSeverPacket(boolean b){
        this.isUp = b;
    }
    
    @Override
    public void onServer(EntityPlayer player) {
        World world = player.getEntityWorld();
        ItemStack itemStack = player.getHeldItem(EnumHand.MAIN_HAND);
        IExtendedItemBehavior behavior = IExtendedItemBehavior.getFirstOnItemsStack(itemStack);
        if(behavior != null){
            behavior.onWheelChanged(this.isUp,world,player,itemStack);
        }
    }
    
    @Override
    public void writeData(ByteBuf out) {
        out.writeBoolean(isUp);
    }
    
//    @Override
//    public void readData(ByteBuf in) throws IOException {
//
//    }
}
