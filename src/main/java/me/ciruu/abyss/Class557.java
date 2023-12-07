package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.function.Predicate;
import me.ciruu.abyss.Class155;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class558;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class Class557
extends Module {
    private final Setting Field2158 = new Setting("Mode", "", this, (Object)Class558.Jump);
    private final Setting Field2159 = new Setting("Rotate", "Rotate", this, false);
    private final Setting Field2160 = new Setting("AutoDisable", "", this, true);
    private final Setting Field2161 = new Setting("Offset", "", (Module)this, (Object)Float.valueOf(7.0f), Float.valueOf(-20.0f), Float.valueOf(20.0f));
    private BlockPos Field2162;
    private boolean Field2163 = false;
    private boolean Field2164 = false;
    private int Field2165 = -1;
    private int Field2166 = 0;
    @EventHandler
    private Listener Field2167 = new Listener<Class26>(this::Method2637, new Predicate[0]);

    public Class557() {
        super("Burrow", "Glitch a player into a block at its feet.", Class11.COMBAT);
        this.Method2638(this.Field2158);
        this.Method2638(this.Field2159);
        this.Method2638(this.Field2160);
        this.Method2638(this.Field2161);
    }

    public String Method2639() {
        return ChatFormatting.WHITE + ((Class558)((Object)this.Field2158.getValue())).name();
    }

    public void Method2640(boolean bl) {
        if (this.Method2641()) {
            this.Method2642(false);
            this.Method2643();
        }
    }

    public void Method2644() {
        super.Method13();
        this.Field2162 = new BlockPos(Globals.mc.player.posX, Globals.mc.player.posY, Globals.mc.player.posZ);
        if (Globals.mc.world.getBlockState(new BlockPos(Globals.mc.player.posX, Globals.mc.player.posY, Globals.mc.player.posZ)).getBlock().equals(Blocks.OBSIDIAN) || Class557.Method2645(this.Field2162) || Class155.Method544(BlockObsidian.class) == -1) {
            this.Method2646();
            return;
        }
        this.Field2165 = Globals.mc.player.inventory.currentItem;
    }

    public void Method2643() {
        super.Method15();
        this.Field2163 = false;
        this.Field2164 = false;
        this.Field2166 = 0;
    }

    public static boolean Method2645(BlockPos blockPos) {
        for (Entity entity : Globals.mc.world.loadedEntityList) {
            if (entity.equals((Object)Globals.mc.player) || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox())) continue;
            return true;
        }
        return false;
    }

    private void Method2637(Class26 class26) {
        if (Class155.Method544(BlockObsidian.class) == -1) {
            Globals.printChatMessage("Can't find obsidian in hotbar!");
            this.Method2646();
            return;
        }
        Globals.mc.player.inventory.currentItem = Class155.Method544(BlockObsidian.class);
        if (this.Field2158.getValue() == Class558.Jump) {
            if (!this.Field2163) {
                Globals.mc.player.jump();
                this.Field2163 = true;
            }
            if (!this.Field2164 && (this.Field2158.getValue() == Class558.Jump && Globals.mc.player.posY - (double)this.Field2162.getY() >= 1.0 || this.Field2158.getValue() == Class558.Instant)) {
                Class31.Method536(this.Field2162, EnumHand.MAIN_HAND, (Boolean)this.Field2159.getValue(), true, Globals.mc.player.isSneaking());
                Globals.mc.player.setPosition(Globals.mc.player.posX, Globals.mc.player.posY + (double)((Float)this.Field2161.getValue()).floatValue(), Globals.mc.player.posZ);
                Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Globals.mc.player.posX, Globals.mc.player.posY + (double)((Float)this.Field2161.getValue()).floatValue(), Globals.mc.player.posZ, false));
                this.Field2164 = true;
            }
            if (this.Field2164) {
                Globals.mc.player.setPositionAndUpdate(Globals.mc.player.posX, (double)this.Field2162.getY(), Globals.mc.player.posZ);
                Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Globals.mc.player.posX, (double)this.Field2162.getY(), Globals.mc.player.posZ, true));
                Globals.mc.player.inventory.currentItem = this.Field2165;
                if (((Boolean)this.Field2160.getValue()).booleanValue()) {
                    this.Method2646();
                }
            }
        } else if (this.Field2158.getValue() == Class558.Instant && this.Field2166 >= 3) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Globals.mc.player.posX, Globals.mc.player.posY + 0.41999998688698, Globals.mc.player.posZ, true));
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Globals.mc.player.posX, Globals.mc.player.posY + 0.7531999805211997, Globals.mc.player.posZ, true));
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Globals.mc.player.posX, Globals.mc.player.posY + 1.00133597911214, Globals.mc.player.posZ, true));
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Globals.mc.player.posX, Globals.mc.player.posY + 1.16610926093821, Globals.mc.player.posZ, true));
            Class31.Method536(this.Field2162, EnumHand.MAIN_HAND, (Boolean)this.Field2159.getValue(), true, false);
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Globals.mc.player.posX, Globals.mc.player.posY + (double)((Float)this.Field2161.getValue()).floatValue(), Globals.mc.player.posZ, false));
            Globals.mc.player.connection.sendPacket((Packet)new CPacketConfirmTeleport());
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Globals.mc.player.posX, (double)this.Field2162.getY(), Globals.mc.player.posZ, true));
            Globals.mc.player.inventory.currentItem = this.Field2165;
            if (((Boolean)this.Field2160.getValue()).booleanValue()) {
                this.Method2646();
            }
        }
        ++this.Field2166;
    }
}
