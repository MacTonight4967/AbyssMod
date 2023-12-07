package me.ciruu.abyss;

import java.util.function.Predicate;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class377;
import me.ciruu.abyss.Class85;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;

public class Class376
extends Module {
    private static BlockPos Field1229;
    private Setting Field1230 = new Setting("Toggle", "Toggles the features after being used", this, true);
    private Setting Field1231 = new Setting("DoubleMode", "Toggles the features after being used", this, false);
    private Setting Field1232 = new Setting("CheckHole", "Toggles the features after being used", this, true);
    private int Field1233;
    private static boolean Field1234;
    private static double Field1235;
    private static double Field1236;
    @EventHandler
    private Listener Field1237;
    @EventHandler
    private Listener Field1238 = new Listener<Class26>(this::Method1576, new Predicate[0]);

    public Class376() {
        super("SelfWeb", "Puts a cobweb in your feet", Class11.COMBAT);
        this.Method1577(this.Field1230);
        this.Method1577(this.Field1232);
        this.Method1577(this.Field1231);
        this.Field1237 = new Listener<EventNetworkPostPacketEvent>(Class376::Method1578, new Predicate[0]);
    }

    public void Method1579() {
        super.Method13();
        if (Globals.mc.world != null) {
            int n = this.Field1233 = Globals.mc.player.getHeldItemMainhand().getItem() == Item.getItemFromBlock((Block)Blocks.WEB) ? Globals.mc.player.inventory.currentItem : -1;
        }
        if (this.Field1233 == -1) {
            for (int i = 0; i < 9; ++i) {
                if (Globals.mc.player.inventory.getStackInSlot(i).getItem() != Item.getItemFromBlock((Block)Blocks.WEB)) continue;
                this.Field1233 = i;
                break;
            }
        }
        if (this.Field1233 == -1) {
            return;
        }
    }

    public void Method1580() {
        super.Method15();
        Class376.Method1581();
    }

    private static void Method1582(float f, float f2) {
        Field1235 = f;
        Field1236 = f2;
        Field1234 = true;
    }

    private static void Method1581() {
        if (Field1234) {
            Field1235 = Globals.mc.player.rotationYaw;
            Field1236 = Globals.mc.player.rotationPitch;
            Field1234 = false;
        }
    }

    public boolean Method1583() {
        BlockPos blockPos = new BlockPos(Globals.mc.player.posX, Globals.mc.player.posY, Globals.mc.player.posZ);
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        return Class376.Method1584(iBlockState, blockPos);
    }

    private static boolean Method1584(IBlockState iBlockState, BlockPos blockPos) {
        return Class85.Method206(blockPos) || Class85.Method1585(blockPos) || Class85.Method208(blockPos) || Class85.Method1586(blockPos);
    }

    private void Method1576(Class26 class26) {
        int n;
        if (((Boolean)this.Field1232.getValue()).booleanValue() && !this.Method1583()) {
            return;
        }
        int n2 = this.Field1233 = Globals.mc.player.getHeldItemMainhand().getItem() == Item.getItemFromBlock((Block)Blocks.WEB) ? Globals.mc.player.inventory.currentItem : -1;
        if (this.Field1233 == -1) {
            for (n = 0; n < 9; ++n) {
                if (Globals.mc.player.inventory.getStackInSlot(n).getItem() != Item.getItemFromBlock((Block)Blocks.WEB)) continue;
                this.Field1233 = n;
                break;
            }
        }
        if (this.Field1233 == -1) {
            return;
        }
        n = Globals.mc.player.inventory.currentItem;
        BlockPos blockPos = new BlockPos(Globals.mc.player.posX, Globals.mc.player.posY, Globals.mc.player.posZ);
        Block block = Globals.mc.world.getBlockState(blockPos).getBlock();
        if (block instanceof BlockAir || block instanceof BlockLiquid) {
            Globals.mc.player.inventory.currentItem = this.Field1233;
            Class376.Method1582(0.0f, 0.0f);
            Class377.Method1587(blockPos, false);
            if (((Boolean)this.Field1231.getValue()).booleanValue()) {
                blockPos = new BlockPos(Globals.mc.player.posX, Globals.mc.player.posY + 1.0, Globals.mc.player.posZ);
                Class377.Method1587(blockPos, false);
            }
            Class376.Method1581();
            Globals.mc.player.inventory.currentItem = n;
        }
        if (((Boolean)this.Field1230.getValue()).booleanValue()) {
            this.Method1588();
        }
    }

    private static void Method1578(EventNetworkPostPacketEvent eventNetworkPostPacketEvent) {
        Packet packet = eventNetworkPostPacketEvent.Method16();
        if (packet instanceof CPacketPlayer && Field1234) {
            ((CPacketPlayer)packet).yaw = (float)Field1235;
            ((CPacketPlayer)packet).pitch = (float)Field1236;
        }
    }
}
