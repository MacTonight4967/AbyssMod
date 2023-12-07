package me.ciruu.abyss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.ciruu.abyss.enums.Class109;
import me.ciruu.abyss.enums.Class285;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class Class110 {
    public static final List Field938 = Arrays.asList(Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR, Blocks.ENCHANTING_TABLE);
    public static final List Field939 = Arrays.asList(Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX);
    private static final Minecraft Field1795 = Minecraft.getMinecraft();

    public static void Method2173(BlockPos blockPos) {
        Class110.Method1088(blockPos, EnumHand.MAIN_HAND);
    }

    public static void Method1088(BlockPos blockPos, EnumHand enumHand) {
        Vec3d vec3d = new Vec3d(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY + (double)Minecraft.getMinecraft().player.getEyeHeight(), Minecraft.getMinecraft().player.posZ);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            Vec3d vec3d2;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            if (!Class110.Method2174(blockPos2) || vec3d.squareDistanceTo(vec3d2 = new Vec3d((Vec3i)blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5))) > 18.0625) continue;
            Class110.Method1263(vec3d2);
            Class110.Method2175(blockPos2, enumFacing2, vec3d2, enumHand);
            Minecraft.getMinecraft().player.swingArm(enumHand);
            Class110.Field1795.rightClickDelayTimer = 4;
            return;
        }
    }

    public static float[] Method1045(Vec3d vec3d) {
        Vec3d vec3d2 = Class110.Method2176();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{Minecraft.getMinecraft().player.rotationYaw + MathHelper.wrapDegrees((float)(f - Minecraft.getMinecraft().player.rotationYaw)), Minecraft.getMinecraft().player.rotationPitch + MathHelper.wrapDegrees((float)(f2 - Minecraft.getMinecraft().player.rotationPitch))};
    }

    private static Vec3d Method2176() {
        return new Vec3d(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY + (double)Minecraft.getMinecraft().player.getEyeHeight(), Minecraft.getMinecraft().player.posZ);
    }

    public static void Method1263(Vec3d vec3d) {
        float[] fArray = Class110.Method1045(vec3d);
        Minecraft.getMinecraft().player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(fArray[0], fArray[1], Minecraft.getMinecraft().player.onGround));
    }

    private static void Method2177(BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d) {
        Class110.Method2175(blockPos, enumFacing, vec3d, EnumHand.MAIN_HAND);
    }

    private static void Method2175(BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d, EnumHand enumHand) {
        Class110.Method2178().processRightClickBlock(Minecraft.getMinecraft().player, Class110.Field1795.world, blockPos, enumFacing, vec3d, enumHand);
    }

    public static boolean Method2174(BlockPos blockPos) {
        return Class110.Method2179(blockPos).canCollideCheck(Class110.Method2180(blockPos), false);
    }

    private static Block Method2179(BlockPos blockPos) {
        return Class110.Method2180(blockPos).getBlock();
    }

    private static PlayerControllerMP Method2178() {
        return Minecraft.getMinecraft().playerController;
    }

    private static IBlockState Method2180(BlockPos blockPos) {
        return Minecraft.getMinecraft().world.getBlockState(blockPos);
    }

    public static boolean Method1262(BlockPos blockPos) {
        if (!Class110.Method2181(blockPos)) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                BlockPos blockPos2 = blockPos.offset(enumFacing);
                if (!Class110.Method2181(blockPos2)) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean Method2181(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (Minecraft.getMinecraft().world.getBlockState(blockPos2).getMaterial().isReplaceable()) continue;
            return true;
        }
        return false;
    }

    public static List Method1096(BlockPos blockPos, float f, int n, boolean bl, boolean bl2, int n2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = blockPos.getX();
        int n4 = blockPos.getY();
        int n5 = blockPos.getZ();
        int n6 = n3 - (int)f;
        while ((float)n6 <= (float)n3 + f) {
            int n7 = n5 - (int)f;
            while ((float)n7 <= (float)n5 + f) {
                int n8 = bl2 ? n4 - (int)f : n4;
                while (true) {
                    float f2 = n8;
                    float f3 = bl2 ? (float)n4 + f : (float)(n4 + n);
                    if (!(f2 < f3)) break;
                    double d = (n3 - n6) * (n3 - n6) + (n5 - n7) * (n5 - n7) + (bl2 ? (n4 - n8) * (n4 - n8) : 0);
                    if (!(!(d < (double)(f * f)) || bl && d < (double)((f - 1.0f) * (f - 1.0f)))) {
                        arrayList.add(new BlockPos(n6, n8 + n2, n7));
                    }
                    ++n8;
                }
                ++n7;
            }
            ++n6;
        }
        return arrayList;
    }

    public static Class285 Method1043(BlockPos blockPos) {
        if (!Class110.Field1795.world.checkNoEntityCollision(new AxisAlignedBB(blockPos))) {
            return Class285.NoEntityCollision;
        }
        if (!Class110.Method1262(blockPos)) {
            return Class285.NoNeighbors;
        }
        IBlockState iBlockState = Class110.Field1795.world.getBlockState(blockPos);
        if (iBlockState.getBlock() == Blocks.AIR) {
            BlockPos[] blockPosArray;
            for (BlockPos blockPos2 : blockPosArray = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.up(), blockPos.down()}) {
                IBlockState iBlockState2 = Class110.Field1795.world.getBlockState(blockPos2);
                if (iBlockState2.getBlock() == Blocks.AIR) continue;
                for (EnumFacing enumFacing : EnumFacing.values()) {
                    boolean bl;
                    BlockPos blockPos3 = blockPos.offset(enumFacing);
                    boolean bl2 = bl = Class110.Field1795.world.getBlockState(blockPos3).getBlock() == Blocks.WATER;
                    if (!Class110.Field1795.world.getBlockState(blockPos3).getBlock().canCollideCheck(Class110.Field1795.world.getBlockState(blockPos3), false)) continue;
                    return Class285.Ok;
                }
            }
            return Class285.NoNeighbors;
        }
        return Class285.AlreadyBlockThere;
    }

    public static Class109 Method2182(BlockPos blockPos, float f, boolean bl, boolean bl2, boolean bl3) {
        if (bl3) {
            return Class110.Method2183(blockPos, f, bl, bl2, false, EnumHand.OFF_HAND);
        }
        return Class110.Method2183(blockPos, f, bl, bl2, false, EnumHand.MAIN_HAND);
    }

    public static Class109 Method1044(BlockPos blockPos, float f, boolean bl, boolean bl2) {
        return Class110.Method2183(blockPos, f, bl, bl2, false, EnumHand.MAIN_HAND);
    }

    public static Class109 Method2183(BlockPos blockPos, float f, boolean bl, boolean bl2, boolean bl3, EnumHand enumHand) {
        Class285 class285;
        IBlockState iBlockState = Class110.Field1795.world.getBlockState(blockPos);
        boolean bl4 = iBlockState.getMaterial().isReplaceable();
        boolean bl5 = iBlockState.getBlock() instanceof BlockSlab;
        if (!bl4 && !bl5) {
            return Class109.NotReplaceable;
        }
        if (!Class110.Method1262(blockPos)) {
            return Class109.Neighbors;
        }
        if (!bl5 && (class285 = Class110.Method1043(blockPos)) != Class285.Ok && !bl4) {
            return Class109.CantPlace;
        }
        if (bl2 && bl5 && !iBlockState.isFullCube()) {
            return Class109.CantPlace;
        }
        class285 = new Vec3d(Class110.Field1795.player.posX, Class110.Field1795.player.posY + (double)Class110.Field1795.player.getEyeHeight(), Class110.Field1795.player.posZ);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            EnumActionResult enumActionResult;
            Vec3d vec3d;
            boolean bl6;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            boolean bl7 = bl6 = Class110.Field1795.world.getBlockState(blockPos2).getBlock() == Blocks.WATER;
            if (!Class110.Field1795.world.getBlockState(blockPos2).getBlock().canCollideCheck(Class110.Field1795.world.getBlockState(blockPos2), false) || !(class285.distanceTo(vec3d = new Vec3d((Vec3i)blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5))) <= (double)f)) continue;
            Block block = Class110.Field1795.world.getBlockState(blockPos2).getBlock();
            boolean bl8 = block.onBlockActivated((World)Class110.Field1795.world, blockPos, Class110.Field1795.world.getBlockState(blockPos), (EntityPlayer)Class110.Field1795.player, EnumHand.MAIN_HAND, enumFacing, 0.0f, 0.0f, 0.0f);
            if (Field938.contains(block) || Field939.contains(block) || bl8) {
                Class110.Field1795.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class110.Field1795.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            if (bl) {
                Class110.Method1263(vec3d);
            }
            if ((enumActionResult = Class110.Field1795.playerController.processRightClickBlock(Class110.Field1795.player, Class110.Field1795.world, blockPos2, enumFacing2, vec3d, enumHand)) == EnumActionResult.FAIL) continue;
            if (bl3) {
                Class110.Field1795.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
            } else {
                Class110.Field1795.player.swingArm(EnumHand.MAIN_HAND);
            }
            if (bl8) {
                Class110.Field1795.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class110.Field1795.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            return Class109.Placed;
        }
        return Class109.CantPlace;
    }

    public static boolean Method2184(BlockPos blockPos) {
        IBlockState iBlockState = Class110.Field1795.world.getBlockState(blockPos);
        return iBlockState.getBlock() == Blocks.WATER || iBlockState.getBlock() == Blocks.LAVA || iBlockState.getBlock() == Blocks.AIR;
    }

    public static float[] Method2185(int n, int n2, int n3, EnumFacing enumFacing) {
        return Class110.Method2186(n, n2, n3, enumFacing, 1.0);
    }

    public static float[] Method2186(int n, int n2, int n3, EnumFacing enumFacing, double d) {
        return Class110.Method2187((double)n + 0.5 + (double)enumFacing.getDirectionVec().getX() * d / 2.0, (double)n2 + 0.5 + (double)enumFacing.getDirectionVec().getY() * d / 2.0, (double)n3 + 0.5 + (double)enumFacing.getDirectionVec().getZ() * d / 2.0);
    }

    public static float[] Method2187(double d, double d2, double d3) {
        return Class110.Method2188(d, d2, d3, Class110.Field1795.player.posX, Class110.Field1795.player.posY + (double)Class110.Field1795.player.getEyeHeight(), Class110.Field1795.player.posZ);
    }

    public static float[] Method2188(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        double d10 = d9 < 0.0 && d7 < 0.0 ? 90.0 + Math.toDegrees(Math.atan(d9 / d7)) : (d9 < 0.0 && d7 > 0.0 ? -90.0 + Math.toDegrees(Math.atan(d9 / d7)) : Math.toDegrees(-Math.atan(d7 / d9)));
        double d11 = Math.sqrt(d7 * d7 + d9 * d9);
        double d12 = -Math.toDegrees(Math.atan(d8 / d11));
        d10 = Class110.Method2189((float)d10);
        d12 = Class110.Method2189((float)d12);
        d10 = Double.isNaN(d10) ? 0.0 : d10;
        d12 = Double.isNaN(d12) ? 0.0 : d12;
        return new float[]{(float)d10, (float)d12};
    }

    public static float Method2189(float f) {
        f %= 360.0f;
        while (f >= 180.0f) {
            f -= 360.0f;
        }
        while (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }
}
