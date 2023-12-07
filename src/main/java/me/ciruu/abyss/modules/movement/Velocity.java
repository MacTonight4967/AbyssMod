package me.ciruu.abyss.modules.movement;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.function.Predicate;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.events.player.EventPlayerApplyCollision;
import me.ciruu.abyss.events.player.EventPlayerPushOutOfBlocks;
import me.ciruu.abyss.events.player.EventPlayerPushedByWater;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.world.World;

public class Velocity
extends Module {
    public final Setting horizontal = new Setting("Horizontal", "The horizontal velocity you will take.", (Module)this, (Object)0, 0, 100);
    public final Setting vertical = new Setting("Veritcal", "The vertical velocity you will take.", (Module)this, (Object)0, 0, 100);
    public final Setting explosions = new Setting("Explosions", "Apply velocity modifier on explosion velocity.", this, true);
    public final Setting bobbers = new Setting("Bobbers", "Apply velocity modifier on fishing bobber velocity.", this, true);
    public final Setting nopush = new Setting("NoPush", "Disable collision with entities, blocks and water", this, true);
    @EventHandler
    private Listener Field687 = new Listener<EventPlayerPushOutOfBlocks>(this::Method971, new Predicate[0]);
    @EventHandler
    private Listener Field688 = new Listener<EventPlayerPushedByWater>(this::Method972, new Predicate[0]);
    @EventHandler
    private Listener Field689 = new Listener<EventPlayerApplyCollision>(this::Method973, new Predicate[0]);
    @EventHandler
    private Listener Field690 = new Listener<EventNetworkPrePacketEvent>(this::Method974, new Predicate[0]);

    public Velocity() {
        super("Velocity", "Modify the velocity you take.", Class11.MOVEMENT);
        this.Method975(this.horizontal);
        this.Method975(this.vertical);
        this.Method975(this.explosions);
        this.Method975(this.bobbers);
        this.Method975(this.nopush);
    }

    public String Method976() {
        return ChatFormatting.WHITE + String.format("H:%s%%|V:%s%%", this.horizontal.getValue(), this.vertical.getValue());
    }

    private void Method974(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        Entity entity;
        SPacketEntityVelocity sPacketEntityVelocity;
        if (Globals.mc.player == null) {
            return;
        }
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketEntityStatus && ((Boolean)this.bobbers.getValue()).booleanValue() && (sPacketEntityVelocity = (SPacketEntityStatus)eventNetworkPrePacketEvent.Method49()).getOpCode() == 31 && (entity = sPacketEntityVelocity.getEntity((World)Minecraft.getMinecraft().world)) != null && entity instanceof EntityFishHook) {
            EntityFishHook entityFishHook = (EntityFishHook)entity;
            if (entityFishHook.caughtEntity == Minecraft.getMinecraft().player) {
                eventNetworkPrePacketEvent.cancel();
            }
        }
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketEntityVelocity && (sPacketEntityVelocity = (SPacketEntityVelocity)eventNetworkPrePacketEvent.Method49()).getEntityID() == Globals.mc.player.getEntityId()) {
            if ((Integer)this.horizontal.getValue() == 0 && (Integer)this.vertical.getValue() == 0) {
                eventNetworkPrePacketEvent.cancel();
                return;
            }
            if ((Integer)this.horizontal.getValue() != 100) {
                sPacketEntityVelocity.motionX = sPacketEntityVelocity.motionX / 100 * (Integer)this.horizontal.getValue();
                sPacketEntityVelocity.motionZ = sPacketEntityVelocity.motionZ / 100 * (Integer)this.horizontal.getValue();
            }
            if ((Integer)this.vertical.getValue() != 100) {
                sPacketEntityVelocity.motionY = sPacketEntityVelocity.motionY / 100 * (Integer)this.vertical.getValue();
            }
        }
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketExplosion && ((Boolean)this.explosions.getValue()).booleanValue()) {
            sPacketEntityVelocity = (SPacketExplosion)eventNetworkPrePacketEvent.Method49();
            sPacketEntityVelocity.motionX *= (float)((Integer)this.horizontal.getValue()).intValue();
            sPacketEntityVelocity.motionY *= (float)((Integer)this.vertical.getValue()).intValue();
            sPacketEntityVelocity.motionZ *= (float)((Integer)this.horizontal.getValue()).intValue();
        }
    }

    private void Method973(EventPlayerApplyCollision eventPlayerApplyCollision) {
        if (!((Boolean)this.nopush.getValue()).booleanValue()) {
            return;
        }
        eventPlayerApplyCollision.cancel();
    }

    private void Method972(EventPlayerPushedByWater eventPlayerPushedByWater) {
        if (!((Boolean)this.nopush.getValue()).booleanValue()) {
            return;
        }
        eventPlayerPushedByWater.cancel();
    }

    private void Method971(EventPlayerPushOutOfBlocks eventPlayerPushOutOfBlocks) {
        if (!((Boolean)this.nopush.getValue()).booleanValue()) {
            return;
        }
        eventPlayerPushOutOfBlocks.cancel();
    }
}
