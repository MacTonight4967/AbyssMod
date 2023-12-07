package me.ciruu.abyss;

import me.ciruu.abyss.Globals;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class Class377 {
    public static boolean Method1587(BlockPos blockPos, boolean bl) {
        new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            if (!Class377.Method2941(blockPos2)) continue;
            Vec3d vec3d = new Vec3d((Vec3i)blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
            if (bl) {
                Class377.Method2942(vec3d);
            }
            Globals.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Globals.mc.player, CPacketEntityAction.Action.START_SNEAKING));
            Class377.Method2943(blockPos2, enumFacing2, vec3d);
            Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
            Globals.mc.rightClickDelayTimer = 0;
            Globals.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Globals.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
            return true;
        }
        return false;
    }

    private static PlayerControllerMP Method2944() {
        return Globals.mc.playerController;
    }

    public static void Method2943(BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d) {
        Class377.Method2944().processRightClickBlock(Globals.mc.player, Globals.mc.world, blockPos, enumFacing, vec3d, EnumHand.MAIN_HAND);
    }

    public static IBlockState Method2945(BlockPos blockPos) {
        return Globals.mc.world.getBlockState(blockPos);
    }

    public static Block Method2946(BlockPos blockPos) {
        return Class377.Method2945(blockPos).getBlock();
    }

    public static boolean Method2941(BlockPos blockPos) {
        return Class377.Method2946(blockPos).canCollideCheck(Class377.Method2945(blockPos), false);
    }

    public static void Method2942(Vec3d vec3d) {
        float[] fArray = Class377.Method2947(vec3d);
        Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(fArray[0], fArray[1], Globals.mc.player.onGround));
    }

    private static float[] Method2947(Vec3d vec3d) {
        Vec3d vec3d2 = Class377.Method2948();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{Globals.mc.player.rotationYaw + MathHelper.wrapDegrees((float)(f - Globals.mc.player.rotationYaw)), Globals.mc.player.rotationPitch + MathHelper.wrapDegrees((float)(f2 - Globals.mc.player.rotationPitch))};
    }

    public static Vec3d Method2948() {
        return new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ);
    }
}
