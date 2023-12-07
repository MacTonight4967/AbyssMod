package me.ciruu.abyss;

import java.util.function.Predicate;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.modules.combat.AutoCrystal;
import me.ciruu.abyss.modules.combat.Predict;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.network.play.server.SPacketCollectItem;
import net.minecraft.network.play.server.SPacketCombatEvent;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketEntity;
import net.minecraft.network.play.server.SPacketEntityMetadata;
import net.minecraft.network.play.server.SPacketEntityProperties;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketSpawnExperienceOrb;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.SPacketSpawnMob;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.network.play.server.SPacketSpawnPainting;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraft.world.World;

/*
 * Exception performing whole class analysis ignored.
 */
public static class Class19 {
    private final AutoCrystal Field3505 = (AutoCrystal)Manager.moduleManager.getModuleByClass(AutoCrystal.class);
    public int Field65;
    @EventHandler
    public Listener Field64 = new Listener<EventNetworkPrePacketEvent>(this::Method4254, 400, new Predicate[0]);

    private void Method4254(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        if (Globals.mc.player == null || Globals.mc.world == null || Manager.moduleManager.getModuleByClass(AutoCrystal.class) == null || Manager.moduleManager.getModuleByClass(Predict.class) == null) {
            return;
        }
        if (!Manager.moduleManager.isModuleEnabled(AutoCrystal.class) || !Manager.moduleManager.isModuleEnabled(Predict.class)) {
            return;
        }
        Packet packet = eventNetworkPrePacketEvent.Method49();
        String string = packet.getClass().getSimpleName();
        if (string.startsWith("C")) {
            return;
        }
        try {
            SPacketSpawnObject sPacketSpawnObject;
            int n;
            if (packet instanceof SPacketCollectItem) {
                n = ((SPacketCollectItem)packet).getEntityID();
                this.Field65 = Math.max(n, this.Field65);
            }
            if (packet instanceof SPacketCombatEvent) {
                n = ((SPacketCombatEvent)packet).entityId;
                this.Field65 = Math.max(n, this.Field65);
            }
            if (packet instanceof SPacketEntity) {
                n = ((SPacketEntity)packet).entityId;
                this.Field65 = Math.max(n, this.Field65);
            }
            if (packet instanceof SPacketEntityMetadata) {
                n = ((SPacketEntityMetadata)packet).getEntityId();
                this.Field65 = Math.max(n, this.Field65);
            }
            if (packet instanceof SPacketEntityProperties) {
                n = ((SPacketEntityProperties)packet).getEntityId();
                this.Field65 = Math.max(n, this.Field65);
            }
            if (packet instanceof SPacketEntityStatus) {
                n = ((SPacketEntityStatus)packet).entityId;
                Entity object = ((SPacketEntityStatus)packet).getEntity((World)Globals.mc.world);
                this.Field65 = Math.max(n, this.Field65);
                if (((AutoCrystal)Manager.moduleManager.getModuleByClass(AutoCrystal.class)).Field70 != null && object == ((AutoCrystal)Manager.moduleManager.getModuleByClass(AutoCrystal.class)).Field70 && object.isDead) {
                    Predict.Method53().Method47();
                }
            }
            if (packet instanceof SPacketEntityVelocity) {
                n = ((SPacketEntityVelocity)packet).getEntityID();
                this.Field65 = Math.max(n, this.Field65);
            }
            if (packet instanceof SPacketSpawnExperienceOrb) {
                SPacketSpawnExperienceOrb sPacketSpawnExperienceOrb = (SPacketSpawnExperienceOrb)packet;
                int n2 = sPacketSpawnExperienceOrb.getEntityID();
                this.Field65 = Math.max(n2, this.Field65);
                if (Globals.mc.player.getDistance(sPacketSpawnExperienceOrb.getX(), sPacketSpawnExperienceOrb.getY(), sPacketSpawnExperienceOrb.getZ()) >= 6.0) {
                    Predict.Method53().Method47();
                }
            }
            if (packet instanceof SPacketSpawnGlobalEntity) {
                int n3 = ((SPacketSpawnGlobalEntity)packet).getEntityId();
                this.Field65 = Math.max(n3, this.Field65);
            }
            if (packet instanceof SPacketSpawnPainting) {
                int n4 = ((SPacketSpawnPainting)packet).getEntityID();
                this.Field65 = Math.max(n4, this.Field65);
            }
            if (packet instanceof SPacketSpawnPlayer) {
                int n5 = ((SPacketSpawnPlayer)packet).getEntityID();
                this.Field65 = Math.max(n5, this.Field65);
            }
            if (packet instanceof SPacketSpawnMob) {
                int n6 = ((SPacketSpawnMob)packet).getEntityID();
                this.Field65 = Math.max(n6, this.Field65);
            }
            if (packet instanceof SPacketEntityTeleport) {
                int n7 = ((SPacketEntityTeleport)packet).getEntityId();
                this.Field65 = Math.max(n7, this.Field65);
            }
            if (packet instanceof SPacketSpawnObject && (sPacketSpawnObject = (SPacketSpawnObject)packet).getType() != 51) {
                this.Field65 = sPacketSpawnObject.getEntityID();
                if (Globals.mc.player.getDistance(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ()) >= 6.0 && sPacketSpawnObject.getType() == 60 || sPacketSpawnObject.getType() == 91 || sPacketSpawnObject.getType() == 75 || sPacketSpawnObject.getType() == 2) {
                    Predict.Method53().Method47();
                }
            }
            if (packet instanceof SPacketDestroyEntities) {
                int[] nArray;
                for (int n2 : nArray = ((SPacketDestroyEntities)packet).getEntityIDs()) {
                    this.Field65 = Math.max(n2, this.Field65);
                    if (((AutoCrystal)Manager.moduleManager.getModuleByClass(AutoCrystal.class)).Field70 == null || ((AutoCrystal)Manager.moduleManager.getModuleByClass(AutoCrystal.class)).Field70.getEntityId() != n2) continue;
                    Predict.Method53().Method47();
                }
            }
            if (packet instanceof SPacketAnimation) {
                int n8 = ((SPacketAnimation)packet).getEntityID();
                this.Field65 = Math.max(n8, this.Field65);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
