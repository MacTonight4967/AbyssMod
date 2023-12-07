package me.ciruu.abyss;

import me.ciruu.abyss.Globals;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;

public class Class467 {
    private int Field2801 = -1;

    public void Method3383() {
        if (this.Field2801 != -1) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field2801 == 8 ? 7 : this.Field2801 + 1));
            Globals.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field2801));
            Globals.mc.player.inventory.currentItem = this.Field2801;
            Globals.mc.playerController.syncCurrentPlayItem();
            this.Field2801 = -1;
        }
    }

    public void Method3008(int n) {
        this.Field2801 = n;
    }
}
