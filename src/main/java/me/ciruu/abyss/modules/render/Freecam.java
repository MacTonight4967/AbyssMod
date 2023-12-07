package me.ciruu.abyss.modules.render;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.function.Predicate;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class326;
import me.ciruu.abyss.Class522;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class3;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.events.render.EventRenderCullCavesEvent;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Freecam
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    public final Setting mode = new Setting("Mode", "Mode of freecam to use, camera allows you to watch baritone, etc", this, (Object)Class3.Normal);
    public final Setting speed = new Setting("Speed", "Speed of freecam flight, higher number equals quicker motion.", (Module)this, (Object)Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(10.0f));
    public final Setting cancel = new Setting("Cancel Packets", "Cancels the packets, you won't be able to freely move without this.", (Module)this, (Object)true, this.mainwindow, this::Method4149);
    private Entity Field3436;
    private EntityOtherPlayerMP Field3437;
    private Vec3d Field3438;
    private float Field3439;
    private float Field3440;
    @EventHandler
    private Listener Field3441 = new Listener<Class522>(this::Method4150, new Predicate[0]);
    @EventHandler
    private Listener Field3442 = new Listener<Class26>(this::Method4151, new Predicate[0]);
    @EventHandler
    private Listener Field3443 = new Listener<EventPlayerMove>(this::Method4152, new Predicate[0]);
    @EventHandler
    private Listener Field3444 = new Listener<EventRenderCullCavesEvent>(Freecam::Method4153, new Predicate[0]);
    @EventHandler
    private Listener Field3445 = new Listener<EventPlayerUpdate>(this::Method4154, new Predicate[0]);
    @EventHandler
    private Listener Field3446 = new Listener<EventNetworkPrePacketEvent>(this::Method4155, new Predicate[0]);
    @EventHandler
    private Listener Field3447 = new Listener<EventNetworkPostPacketEvent>(this::Method4156, new Predicate[0]);

    public Freecam() {
        super("Freecam", "Allows you to move your camera away from you.", Class11.RENDER);
        this.Method4157(this.mode);
        this.Method4157(this.speed);
        this.Method4157(this.cancel);
    }

    public void Method4158(boolean bl) {
        if (this.Method4159()) {
            this.Method4160(false);
            this.Method4161();
        }
    }

    public void Method4162() {
        super.Method13();
        if (Globals.mc.world == null) {
            return;
        }
        if (this.mode.getValue() == Class3.Normal) {
            this.Field3436 = null;
            if (Globals.mc.player.getRidingEntity() != null) {
                this.Field3436 = Globals.mc.player.getRidingEntity();
                Globals.mc.player.dismountRidingEntity();
            }
            this.Field3437 = new EntityOtherPlayerMP((World)Globals.mc.world, Globals.mc.getSession().getProfile());
            this.Field3437.copyLocationAndAnglesFrom((Entity)Globals.mc.player);
            this.Field3437.prevRotationYaw = Globals.mc.player.rotationYaw;
            this.Field3437.rotationYawHead = Globals.mc.player.rotationYawHead;
            this.Field3437.inventory.copyInventory(Globals.mc.player.inventory);
            Globals.mc.world.addEntityToWorld(-69, (Entity)this.Field3437);
            if (this.Field3436 != null) {
                this.Field3437.startRiding(this.Field3436);
            }
            this.Field3438 = Globals.mc.player.getPositionVector();
            this.Field3439 = Globals.mc.player.rotationYaw;
            this.Field3440 = Globals.mc.player.rotationPitch;
            Globals.mc.player.noClip = true;
        } else {
            Class326.setCameraState(true);
        }
    }

    public void Method4161() {
        super.Method15();
        if (Globals.mc.world == null) {
            return;
        }
        if (this.mode.getValue() == Class3.Normal) {
            if (this.Field3436 != null) {
                if (this.Field3437 != null) {
                    this.Field3437.dismountRidingEntity();
                }
                Globals.mc.player.startRiding(this.Field3436, true);
                this.Field3436 = null;
            }
            if (this.Field3437 != null) {
                Globals.mc.world.removeEntity((Entity)this.Field3437);
            }
            if (this.Field3438 != null) {
                Globals.mc.player.setPosition(this.Field3438.x, this.Field3438.y, this.Field3438.z);
            }
            Globals.mc.player.rotationYaw = this.Field3439;
            Globals.mc.player.rotationPitch = this.Field3440;
            Globals.mc.player.noClip = false;
            Globals.mc.player.setVelocity(0.0, 0.0, 0.0);
        } else {
            Class326.setCameraState(false);
        }
    }

    public String Method4163() {
        return ChatFormatting.WHITE + ((Class3)((Object)this.mode.getValue())).name();
    }

    private void Method4156(EventNetworkPostPacketEvent eventNetworkPostPacketEvent) {
        CPacketUseEntity cPacketUseEntity;
        if (eventNetworkPostPacketEvent.Method1536() != Class53.PRE) {
            return;
        }
        if (this.mode.getValue() == Class3.Normal) {
            if (((Boolean)this.cancel.getValue()).booleanValue() && (eventNetworkPostPacketEvent.Method16() instanceof CPacketUseEntity || eventNetworkPostPacketEvent.Method16() instanceof CPacketPlayerTryUseItem || eventNetworkPostPacketEvent.Method16() instanceof CPacketPlayerTryUseItemOnBlock || eventNetworkPostPacketEvent.Method16() instanceof CPacketPlayer || eventNetworkPostPacketEvent.Method16() instanceof CPacketVehicleMove || eventNetworkPostPacketEvent.Method16() instanceof CPacketChatMessage)) {
                eventNetworkPostPacketEvent.cancel();
            }
        } else if (this.mode.getValue() == Class3.Camera && eventNetworkPostPacketEvent.Method16() instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity)eventNetworkPostPacketEvent.Method16()).getEntityFromWorld((World)Globals.mc.world) == Globals.mc.player) {
            eventNetworkPostPacketEvent.cancel();
        }
    }

    private void Method4155(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        SPacketSetPassengers sPacketSetPassengers;
        Entity entity;
        if (eventNetworkPrePacketEvent.Method1822() != Class53.PRE) {
            return;
        }
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketRespawn) {
            this.Method4164();
            return;
        }
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketSetPassengers && this.mode.getValue() == Class3.Normal && (entity = Globals.mc.world.getEntityByID((sPacketSetPassengers = (SPacketSetPassengers)eventNetworkPrePacketEvent.Method49()).getEntityId())) != null) {
            for (int n : sPacketSetPassengers.getPassengerIds()) {
                if (n != Globals.mc.player.getEntityId()) continue;
                this.Field3436 = entity;
                break;
            }
        }
    }

    private void Method4154(EventPlayerUpdate eventPlayerUpdate) {
        if (this.mode.getValue() == Class3.Normal) {
            Globals.mc.player.noClip = true;
            Globals.mc.player.setVelocity(0.0, 0.0, 0.0);
            double[] dArray = Class29.Method1330(((Float)this.speed.getValue()).floatValue());
            if (Globals.mc.player.movementInput.moveStrafe != 0.0f || Globals.mc.player.movementInput.moveForward != 0.0f) {
                Globals.mc.player.motionX = dArray[0];
                Globals.mc.player.motionZ = dArray[1];
            } else {
                Globals.mc.player.motionX = 0.0;
                Globals.mc.player.motionZ = 0.0;
            }
            Globals.mc.player.setSprinting(false);
            if (Globals.mc.gameSettings.keyBindJump.isKeyDown()) {
                Globals.mc.player.motionY += (double)((Float)this.speed.getValue()).floatValue();
            }
            if (Globals.mc.gameSettings.keyBindSneak.isKeyDown()) {
                Globals.mc.player.motionY -= (double)((Float)this.speed.getValue()).floatValue();
            }
            if (Globals.mc.player.isRiding()) {
                Globals.mc.player.dismountRidingEntity();
            }
        }
    }

    private static void Method4153(EventRenderCullCavesEvent eventRenderCullCavesEvent) {
        eventRenderCullCavesEvent.cancel();
    }

    private void Method4152(EventPlayerMove eventPlayerMove) {
        if (this.mode.getValue() == Class3.Normal) {
            Globals.mc.player.noClip = true;
        }
    }

    private void Method4151(Class26 class26) {
        if (this.mode.getValue() == Class3.Camera) {
            Class326.movementTick(Globals.mc.player.movementInput.sneak, Globals.mc.player.movementInput.jump);
        }
    }

    private void Method4150(Class522 class522) {
        this.Method4164();
    }

    private boolean Method4149() {
        return this.mode.getValue() == Class3.Normal;
    }
}
