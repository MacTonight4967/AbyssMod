package me.ciruu.abyss;

import java.util.function.Predicate;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class Class677
extends Module {
    private final Setting Field3540 = new Setting("Timer", "", (Module)this, (Object)Float.valueOf(1.0f), Float.valueOf(0.01f), Float.valueOf(1.0f));
    private final Setting Field3541 = new Setting("Disable", "", this, false);
    private final Setting Field3542 = new Setting("OnGroundAll", "", this, false);
    private Minecraft Field3543 = Globals.mc;
    @EventHandler
    private Listener Field3544 = new Listener<EventPlayerUpdateWalking>(this::Method4296, new Predicate[0]);

    public Class677() {
        super("Step2b", "", Class11.MOVEMENT);
        this.Method4297(this.Field3540);
        this.Method4297(this.Field3541);
        this.Method4297(this.Field3542);
    }

    public void Method4298() {
        super.Method15();
        Manager.Field298.Method337(1.0f);
    }

    private void Method4296(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (this.Field3543.player.collidedHorizontally && this.Field3543.player.onGround && this.Field3543.player.fallDistance == 0.0f && !this.Field3543.player.isInWeb && !this.Field3543.player.isOnLadder() && !this.Field3543.player.movementInput.jump) {
            eventPlayerUpdateWalking.Method479();
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 0.41999998688698, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 0.7531999805212, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 1.00133597911214, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 1.16610926093821, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 1.24918707874468, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 1.17675927506424, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 1.02442408821369, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 1.0, this.Field3543.player.posZ, true));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 1.41999998688698, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 1.7531999805212, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 2.00133597911214, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 2.16610926093821, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 2.24918707874468, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 2.17675927506424, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 2.02442408821369, this.Field3543.player.posZ, ((Boolean)this.Field3542.getValue()).booleanValue()));
            this.Field3543.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field3543.player.posX, this.Field3543.player.posY + 2.0, this.Field3543.player.posZ, true));
            this.Field3543.player.setPosition(this.Field3543.player.posX, this.Field3543.player.posY + 2.0, this.Field3543.player.posZ);
            if (((Boolean)this.Field3541.getValue()).booleanValue()) {
                this.Method4299();
            }
        }
    }
}
