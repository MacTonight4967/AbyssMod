package me.ciruu.abyss;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class426;
import me.ciruu.abyss.enums.Class428;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.network.EventNetworkExceptionCaught;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketCloseWindow;
import net.minecraft.network.play.server.SPacketPlayerPosLook;

public class Class427
extends Module {
    private final Setting Field3189 = new Setting("AntiKick", "", this, true);
    private final Setting Field3190 = new Setting("Mode", "", this, (Object)Class426.Fast);
    private final Setting Field3191 = new Setting("Type", "", this, (Object)Class428.Down);
    private final Setting Field3192 = new Setting("Speed", "", (Module)this, (Object)Float.valueOf(0.25f), Float.valueOf(0.1f), Float.valueOf(1.0f));
    private final Setting Field3193 = new Setting("UpSpeed", "", (Module)this, (Object)Float.valueOf(0.05f), Float.valueOf(0.01f), Float.valueOf(0.2f));
    private final Setting Field3194 = new Setting("PhaseSpeed", "", (Module)this, (Object)Float.valueOf(0.031f), Float.valueOf(0.01f), Float.valueOf(0.25f));
    private final Setting Field3195 = new Setting("ExtraPackets", "", this, true);
    private final Random Field3196 = new Random();
    public static int Field3197 = -1;
    private int Field3198 = 0;
    private int Field3199 = 0;
    private boolean Field3200 = true;
    private final List Field3201 = new ArrayList();
    @EventHandler
    private Listener Field3202 = new Listener<EventPlayerUpdateWalking>(this::Method3868, new Predicate[0]);
    @EventHandler
    private Listener Field3203 = new Listener<EventPlayerUpdateWalking>(this::Method3869, new Predicate[0]);
    @EventHandler
    private Listener Field3204 = new Listener<EventNetworkPrePacketEvent>(this::Method3870, new Predicate[0]);
    @EventHandler
    public Listener Field3205 = new Listener<EventPlayerMove>(Class427::Method3871, new Predicate[0]);
    @EventHandler
    public Listener Field3206 = new Listener<EventNetworkExceptionCaught>(this::Method3872, new Predicate[0]);
    @EventHandler
    public Listener Field3207 = new Listener<EventNetworkPostPacketEvent>(this::Method3873, new Predicate[0]);

    public Class427() {
        super("PacketFly", "", Class11.EXPLOIT);
        this.Method3874(this.Field3189);
        this.Method3874(this.Field3190);
        this.Method3874(this.Field3191);
        this.Method3874(this.Field3192);
        this.Method3874(this.Field3193);
        this.Method3874(this.Field3194);
        this.Method3874(this.Field3195);
    }

    public void Method3875() {
        super.Method13();
        Field3197 = -1;
        this.Field3200 = true;
    }

    private double Method3876() {
        return this.Field3190.getValue() == Class426.Setback ? 0.003 : 0.04;
    }

    private boolean Method3877() {
        return !Globals.mc.world.getCollisionBoxes((Entity)Globals.mc.player, Globals.mc.player.getEntityBoundingBox().expand(-0.0625, -0.0625, -0.0625)).isEmpty();
    }

    private CPacketPlayer Method3878(CPacketPlayer cPacketPlayer) {
        this.Field3201.add(cPacketPlayer);
        return cPacketPlayer;
    }

    private void Method3879(double d, double d2, double d3) {
        Globals.mc.player.connection.sendPacket((Packet)this.Method3878((CPacketPlayer)new CPacketPlayer.Position(Globals.mc.player.posX + Globals.mc.player.motionX, Globals.mc.player.posY + Globals.mc.player.motionY, Globals.mc.player.posZ + Globals.mc.player.motionZ, Globals.mc.player.onGround)));
        Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(++Field3197));
        Globals.mc.player.connection.sendPacket((Packet)this.Method3878((CPacketPlayer)new CPacketPlayer.Position(d, d2, d3, Globals.mc.player.onGround)));
        Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(++Field3197));
        Globals.mc.player.connection.sendPacket((Packet)this.Method3878((CPacketPlayer)new CPacketPlayer.Position(Globals.mc.player.posX + Globals.mc.player.motionX, Globals.mc.player.posY + Globals.mc.player.motionY, Globals.mc.player.posZ + Globals.mc.player.motionZ, Globals.mc.player.onGround)));
        if (((Boolean)this.Field3195.getValue()).booleanValue()) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(Field3197 - 1));
        }
        Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(Field3197));
        if (((Boolean)this.Field3195.getValue()).booleanValue()) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(Field3197 + 1));
        }
    }

    private void Method3880(double d, double d2, double d3) {
        Globals.mc.player.connection.sendPacket((Packet)this.Method3878((CPacketPlayer)new CPacketPlayer.Position(d, d2, d3, Globals.mc.player.onGround)));
        Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(++Field3197));
        Globals.mc.player.connection.sendPacket((Packet)this.Method3878((CPacketPlayer)new CPacketPlayer.Position(Globals.mc.player.posX + Globals.mc.player.motionX, Globals.mc.player.posY + Globals.mc.player.motionY, Globals.mc.player.posZ + Globals.mc.player.motionZ, Globals.mc.player.onGround)));
        if (((Boolean)this.Field3195.getValue()).booleanValue()) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(Field3197 - 1));
        }
        Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(Field3197));
        if (((Boolean)this.Field3195.getValue()).booleanValue()) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport(Field3197 + 1));
        }
    }

    private void Method3873(EventNetworkPostPacketEvent eventNetworkPostPacketEvent) {
        if (eventNetworkPostPacketEvent.Method16() instanceof CPacketPlayer) {
            if (this.Field3201.contains((CPacketPlayer)eventNetworkPostPacketEvent.Method16())) {
                this.Field3201.remove((CPacketPlayer)eventNetworkPostPacketEvent.Method16());
            } else {
                eventNetworkPostPacketEvent.cancel();
            }
        }
    }

    private void Method3872(EventNetworkExceptionCaught eventNetworkExceptionCaught) {
        if (((Boolean)this.Field3189.getValue()).booleanValue()) {
            eventNetworkExceptionCaught.cancel();
        }
    }

    private static void Method3871(EventPlayerMove eventPlayerMove) {
        eventPlayerMove.cancel();
        eventPlayerMove.Method107(0.0);
        eventPlayerMove.Method105(0.0);
        eventPlayerMove.Method108(0.0);
    }

    private void Method3870(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketPlayerPosLook && Globals.mc.player != null && Globals.mc.world != null) {
            SPacketPlayerPosLook sPacketPlayerPosLook = (SPacketPlayerPosLook)eventNetworkPrePacketEvent.Method49();
            sPacketPlayerPosLook.yaw = Globals.mc.player.rotationYaw;
            sPacketPlayerPosLook.pitch = Globals.mc.player.rotationPitch;
            Field3197 = sPacketPlayerPosLook.getTeleportId();
        }
        if (((Boolean)this.Field3189.getValue()).booleanValue() && eventNetworkPrePacketEvent.Method49() instanceof SPacketCloseWindow) {
            eventNetworkPrePacketEvent.cancel();
        }
    }

    private void Method3869(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() == Class53.PRE && this.Field3200) {
            eventPlayerUpdateWalking.cancel();
        }
    }

    private void Method3868(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        boolean bl;
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE) {
            return;
        }
        Globals.mc.player.setVelocity(0.0, 0.0, 0.0);
        if (!Globals.mc.player.onGround && ++this.Field3198 >= 4) {
            this.Field3198 = 0;
            bl = Globals.mc.player.movementInput.moveStrafe != 0.0f || Globals.mc.player.movementInput.moveForward != 0.0f;
            Globals.mc.player.motionY = Globals.mc.gameSettings.keyBindJump.isKeyDown() ? (double)((Float)this.Field3193.getValue()).floatValue() : -this.Method3876();
            this.Field3200 = false;
        }
        bl = this.Method3877();
        if (Globals.mc.player.movementInput.moveStrafe != 0.0f || Globals.mc.player.movementInput.moveForward != 0.0f) {
            double[] dArray = Class29.Method1330(bl ? (double)((Float)this.Field3194.getValue()).floatValue() : 0.26);
            Globals.mc.player.motionX = dArray[0] * (double)((Float)this.Field3192.getValue()).floatValue();
            Globals.mc.player.motionZ = dArray[1] * (double)((Float)this.Field3192.getValue()).floatValue();
            this.Field3200 = false;
        } else if (Globals.mc.player.movementInput.jump) {
            Globals.mc.player.motionY = ((Float)this.Field3193.getValue()).floatValue();
            if (!Globals.mc.player.onGround && ++this.Field3199 >= 20) {
                this.Field3199 = 0;
                Globals.mc.player.motionY = -0.032;
            }
            this.Field3200 = false;
        }
        double d = Globals.mc.player.posX + Globals.mc.player.motionX;
        double d2 = Globals.mc.player.posY + Globals.mc.player.motionY;
        double d3 = Globals.mc.player.posZ + Globals.mc.player.motionZ;
        switch ((Class428)((Object)this.Field3191.getValue())) {
            case Down: {
                d2 -= 1337.69;
                break;
            }
            case Up: {
                d2 += 1337.69;
                break;
            }
            case Preserve: {
                d += (double)this.Field3196.nextInt(100000);
                d3 += (double)this.Field3196.nextInt(100000);
            }
        }
        switch ((Class426)((Object)this.Field3190.getValue())) {
            case Fast: {
                this.Method3879(d, d2, d3);
                break;
            }
            case Setback: {
                this.Method3880(d, d2, d3);
                break;
            }
        }
    }
}
