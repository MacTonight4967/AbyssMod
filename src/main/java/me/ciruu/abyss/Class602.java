package me.ciruu.abyss;

import me.ciruu.abyss.Globals;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class Class602 {
    private static BlockPos Field2730 = null;
    private static boolean Field2731 = false;

    public static void Method3024(BlockPos blockPos) {
        Field2730 = blockPos;
        Field2731 = false;
    }

    public static BlockPos Method3025() {
        return Field2730;
    }

    public static boolean Method3027() {
        if (Field2730 != null) {
            return Class602.Method3338(Globals.mc.world.getBlockState(Field2730));
        }
        return false;
    }

    private static boolean Method3338(IBlockState iBlockState) {
        return iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.AIR || iBlockState.getBlock() instanceof BlockLiquid;
    }

    public static boolean Method3026(float f, boolean bl) {
        RayTraceResult rayTraceResult;
        if (Field2730 == null) {
            return false;
        }
        IBlockState iBlockState = Globals.mc.world.getBlockState(Field2730);
        if (Class602.Method3338(iBlockState) || Globals.mc.player.getDistanceSq(Field2730) > Math.pow(f, f)) {
            Field2730 = null;
            return false;
        }
        Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
        EnumFacing enumFacing = EnumFacing.UP;
        if (bl && (rayTraceResult = Globals.mc.world.rayTraceBlocks(new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ), new Vec3d((double)Field2730.getX() + 0.5, (double)Field2730.getY() - 0.5, (double)Field2730.getZ() + 0.5))) != null && rayTraceResult.sideHit != null) {
            enumFacing = rayTraceResult.sideHit;
        }
        if (!Field2731) {
            Field2731 = true;
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, Field2730, enumFacing));
        } else {
            Globals.mc.playerController.onPlayerDamageBlock(Field2730, enumFacing);
        }
        return true;
    }
}
