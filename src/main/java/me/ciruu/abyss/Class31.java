package me.ciruu.abyss;

import com.google.common.util.concurrent.AtomicDouble;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import me.ciruu.abyss.Class110;
import me.ciruu.abyss.Class152;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class72;
import me.ciruu.abyss.Class84;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class Class31 {
    public static List Field912;
    public static List Field933;
    public static EnumFacing Field934;
    public static final List Field935;
    public static final List Field936;
    public static List Field937;

    @Class72
    public static List Method1196(float f, Class clazz) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection)Class31.Method210(Class30.Method209((EntityPlayer)Globals.mc.player), f, (int)f, false, true, 0).stream().filter(arg_0 -> Class31.Method1199(clazz, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    @Class72
    public static List Method1204(BlockPos blockPos) {
        ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
        for (EnumFacing enumFacing : EnumFacing.values()) {
            IBlockState iBlockState;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!Globals.mc.world.getBlockState(blockPos2).getBlock().canCollideCheck(Globals.mc.world.getBlockState(blockPos2), false) || (iBlockState = Globals.mc.world.getBlockState(blockPos2)).getMaterial().isReplaceable()) continue;
            arrayList.add(enumFacing);
        }
        return arrayList;
    }

    @Class72
    public static EnumFacing Method1214(BlockPos blockPos) {
        Iterator iterator = Class31.Method1204(blockPos).iterator();
        if (iterator.hasNext()) {
            EnumFacing enumFacing = (EnumFacing)iterator.next();
            return enumFacing;
        }
        return null;
    }

    @Class72
    public static EnumFacing Method1218(BlockPos blockPos) {
        RayTraceResult rayTraceResult = Globals.mc.world.rayTraceBlocks(new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ), new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getX() - 0.5, (double)blockPos.getX() + 0.5));
        return rayTraceResult != null && rayTraceResult.sideHit != null ? rayTraceResult.sideHit : EnumFacing.UP;
    }

    @Class72
    public static int Method533(BlockPos blockPos, boolean bl) {
        return Class31.Method1222(blockPos, bl, true);
    }

    @Class72
    public static int Method1222(BlockPos blockPos, boolean bl, boolean bl2) {
        Block block = Globals.mc.world.getBlockState(blockPos).getBlock();
        if (!(block instanceof BlockAir || block instanceof BlockLiquid || block instanceof BlockTallGrass || block instanceof BlockFire || block instanceof BlockDeadBush || block instanceof BlockSnow)) {
            return 0;
        }
        if (!Class31.Method1223(blockPos, bl, 0.0f)) {
            return -1;
        }
        if (bl2) {
            for (EnumFacing enumFacing : Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos))) {
                if (enumFacing instanceof EntityItem || enumFacing instanceof EntityXPOrb) continue;
                return 1;
            }
        }
        for (EnumFacing enumFacing : Class31.Method1204(blockPos)) {
            if (!Class31.Method1225(blockPos.offset(enumFacing))) continue;
            return 3;
        }
        return 2;
    }

    @Class72
    public static void Method1226(BlockPos blockPos, Vec3d vec3d, EnumHand enumHand, EnumFacing enumFacing, boolean bl) {
        if (bl) {
            float f = (float)(vec3d.x - (double)blockPos.getX());
            float f2 = (float)(vec3d.y - (double)blockPos.getY());
            float f3 = (float)(vec3d.z - (double)blockPos.getZ());
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
        } else {
            Globals.mc.playerController.processRightClickBlock(Globals.mc.player, Globals.mc.world, blockPos, enumFacing, vec3d, enumHand);
        }
        Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
        Globals.mc.rightClickDelayTimer = 4;
    }

    @Class72
    public static void Method1232(BlockPos blockPos, float f, boolean bl, EnumHand enumHand, AtomicDouble atomicDouble, AtomicDouble atomicDouble2, AtomicBoolean atomicBoolean) {
        Vec3d vec3d = Class84.Method1233();
        Vec3d vec3d2 = new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5);
        double d = vec3d.squareDistanceTo(vec3d2);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            Vec3d vec3d3 = vec3d2.add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
            double d2 = vec3d.squareDistanceTo(vec3d3);
            if (!(d2 <= Class29.Method114(f)) || !(d2 < d) || Globals.mc.world.rayTraceBlocks(vec3d, vec3d3, false, true, false) != null) continue;
            if (bl) {
                float[] fArray = Class84.Method1240(vec3d3);
                atomicDouble.set(fArray[0]);
                atomicDouble2.set(fArray[1]);
                atomicBoolean.set(true);
            }
            Globals.mc.playerController.processRightClickBlock(Globals.mc.player, Globals.mc.world, blockPos, enumFacing, vec3d3, enumHand);
            Globals.mc.player.swingArm(enumHand);
            Globals.mc.rightClickDelayTimer = 4;
            break;
        }
    }

    @Class72
    public static boolean Method541(BlockPos blockPos, boolean bl, boolean bl2, boolean bl3) {
        if (Class31.Method1243(blockPos)) {
            EnumFacing[] enumFacingArray;
            for (EnumFacing enumFacing : enumFacingArray = EnumFacing.values()) {
                Block block = Globals.mc.world.getBlockState(blockPos.offset(enumFacing)).getBlock();
                Vec3d vec3d = new Vec3d((double)blockPos.getX() + 0.5 + (double)enumFacing.getXOffset() * 0.5, (double)blockPos.getY() + 0.5 + (double)enumFacing.getYOffset() * 0.5, (double)blockPos.getZ() + 0.5 + (double)enumFacing.getZOffset() * 0.5);
                if (Field912.contains(block) || !(Globals.mc.player.getPositionEyes(Globals.mc.getRenderPartialTicks()).distanceTo(vec3d) <= 4.25)) continue;
                float[] fArray = new float[]{Globals.mc.player.rotationYaw, Globals.mc.player.rotationPitch};
                if (bl) {
                    Class31.Method1251(vec3d.x, vec3d.y, vec3d.z);
                }
                if (Field933.contains(block)) {
                    Globals.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Globals.mc.player, CPacketEntityAction.Action.START_SNEAKING));
                }
                if (bl3) {
                    Globals.mc.playerController.processRightClickBlock(Globals.mc.player, Globals.mc.world, blockPos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i)blockPos), EnumHand.OFF_HAND);
                } else {
                    Globals.mc.playerController.processRightClickBlock(Globals.mc.player, Globals.mc.world, blockPos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d((Vec3i)blockPos), EnumHand.MAIN_HAND);
                }
                if (Field933.contains(block)) {
                    Globals.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Globals.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                if (bl2) {
                    Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(fArray[0], fArray[1], Globals.mc.player.onGround));
                }
                if (bl3) {
                    Globals.mc.player.swingArm(EnumHand.OFF_HAND);
                } else {
                    Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
                }
                return true;
            }
        }
        return false;
    }

    @Class72
    public static boolean Method1243(BlockPos blockPos) {
        try {
            if (Field912.contains(Globals.mc.world.getBlockState(blockPos).getBlock())) {
                Entity entity;
                AxisAlignedBB axisAlignedBB = new AxisAlignedBB(blockPos);
                Iterator iterator = Globals.mc.world.loadedEntityList.iterator();
                do {
                    if (iterator.hasNext()) continue;
                    return true;
                } while (!((entity = (Entity)iterator.next()) instanceof EntityLivingBase) || !axisAlignedBB.intersects(entity.getEntityBoundingBox()));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    @Class72
    public static void Method1251(double d, double d2, double d3) {
        double d4 = d - Globals.mc.player.posX;
        double d5 = d2 - (Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight());
        double d6 = d3 - Globals.mc.player.posZ;
        double d7 = Math.sqrt(d4 * d4 + d6 * d6);
        float f = (float)Math.toDegrees(Math.atan2(d6, d4)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d5, d7)));
        Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(f, f2, Globals.mc.player.onGround));
    }

    @Class72
    public static boolean Method536(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        EnumFacing enumFacing = Class31.Method1214(blockPos);
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i)blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = Globals.mc.world.getBlockState(blockPos2).getBlock();
        if (!Globals.mc.player.isSneaking() && (Field935.contains(block) || Field936.contains(block))) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Globals.mc.player, CPacketEntityAction.Action.START_SNEAKING));
            Globals.mc.player.setSneaking(true);
            bl4 = true;
        }
        if (bl) {
            Class84.Method1260(vec3d, true);
        }
        Class31.Method1226(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
        Globals.mc.rightClickDelayTimer = 4;
        return bl4 || bl3;
    }

    public static boolean Method1261(BlockPos blockPos, boolean bl, float f) {
        if (!Globals.mc.world.getBlockState(blockPos).getMaterial().isReplaceable()) {
            return false;
        }
        if (!Class110.Method1262(blockPos)) {
            return false;
        }
        Vec3d vec3d = new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            Vec3d vec3d2;
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            if (!Globals.mc.world.getBlockState(blockPos2).getBlock().canCollideCheck(Globals.mc.world.getBlockState(blockPos2), false) || !(vec3d.distanceTo(vec3d2 = new Vec3d((Vec3i)blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5))) <= (double)f)) continue;
            Block block = Globals.mc.world.getBlockState(blockPos2).getBlock();
            if (Class110.Field938.contains(block) || Class110.Field939.contains(block)) {
                Globals.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Globals.mc.player, CPacketEntityAction.Action.START_SNEAKING));
                Globals.mc.player.setSneaking(true);
            }
            if (bl) {
                Class110.Method1263(vec3d2);
            }
            Class31.Method1226(blockPos2, vec3d2, EnumHand.MAIN_HAND, enumFacing2, true);
            Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
            return true;
        }
        return false;
    }

    @Class72
    public static boolean Method1264(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = false;
        EnumFacing enumFacing = Class31.Method1214(blockPos);
        Globals.printChatMessage(enumFacing.toString());
        if (enumFacing == null) {
            return bl3;
        }
        BlockPos blockPos2 = blockPos.offset(enumFacing);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        Vec3d vec3d = new Vec3d((Vec3i)blockPos2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
        Block block = Globals.mc.world.getBlockState(blockPos2).getBlock();
        if (!Globals.mc.player.isSneaking() && (Field935.contains(block) || Field936.contains(block))) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Globals.mc.player, CPacketEntityAction.Action.START_SNEAKING));
            bl4 = true;
        }
        if (bl) {
            Manager.Field456.Method1265(vec3d);
        }
        Class31.Method1226(blockPos2, vec3d, enumHand, enumFacing2, bl2);
        Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
        Globals.mc.rightClickDelayTimer = 4;
        return bl4 || bl3;
    }

    @Class72
    public static void Method1266(BlockPos blockPos, EnumHand enumHand, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = Class31.Method1264(blockPos, enumHand, bl, bl2, bl3);
        if (!bl3 && bl4) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Globals.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
    }

    @Class72
    public static Vec3d[] Method1267(Vec3d vec3d) {
        return new Vec3d[]{new Vec3d(vec3d.x, vec3d.y - 1.0, vec3d.z), new Vec3d(vec3d.x != 0.0 ? vec3d.x * 2.0 : vec3d.x, vec3d.y, vec3d.x != 0.0 ? vec3d.z : vec3d.z * 2.0), new Vec3d(vec3d.x == 0.0 ? vec3d.x + 1.0 : vec3d.x, vec3d.y, vec3d.x == 0.0 ? vec3d.z : vec3d.z + 1.0), new Vec3d(vec3d.x == 0.0 ? vec3d.x - 1.0 : vec3d.x, vec3d.y, vec3d.x == 0.0 ? vec3d.z : vec3d.z - 1.0), new Vec3d(vec3d.x, vec3d.y + 1.0, vec3d.z)};
    }

    @Class72
    public static List Method1268(float f) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection)Class31.Method210(Class30.Method209((EntityPlayer)Globals.mc.player), f, (int)f, false, true, 0).stream().filter(Class31::Method1269).collect(Collectors.toList()));
        return nonNullList;
    }

    @Class72
    public static List Method210(BlockPos blockPos, float f, int n, boolean bl, boolean bl2, int n2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = blockPos.getX();
        int n4 = blockPos.getY();
        int n5 = blockPos.getZ();
        int n6 = n3 - (int)f;
        while ((float)n6 <= (float)n3 + f) {
            int n7 = n5 - (int)f;
            while ((float)n7 <= (float)n5 + f) {
                int n8 = bl2 ? n4 - (int)f : n4;
                int n9 = bl2 ? n4 + (int)f : n4 + n;
                for (int i = n8; i < n9; ++i) {
                    int n10 = n3 - n6;
                    int n11 = n5 - n7;
                    int n12 = n4 - i;
                    float f2 = f - 1.0f;
                    double d = n10 * n10 + n11 * n11 + (bl2 ? n12 * n12 : 0);
                    if (!(d < (double)(f * f)) || bl && !(d >= (double)(f2 * f2))) continue;
                    arrayList.add(new BlockPos(n6, i + n2, n7));
                }
                ++n7;
            }
            ++n6;
        }
        return arrayList;
    }

    @Class72
    public static boolean Method1269(BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        try {
            return (Globals.mc.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || Globals.mc.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN) && Globals.mc.world.getBlockState(blockPos2).getBlock() == Blocks.AIR && Globals.mc.world.getBlockState(blockPos3).getBlock() == Blocks.AIR && Globals.mc.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos2)).isEmpty();
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Class72
    public static List Method1273(float f, boolean bl) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection)Class31.Method210(Class30.Method209((EntityPlayer)Globals.mc.player), f, (int)f, false, true, 0).stream().filter(arg_0 -> Class31.Method1274(bl, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    @Class72
    public static boolean Method1275(BlockPos blockPos, boolean bl) {
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        boolean bl2 = (Boolean)((Class152)Manager.moduleManager.getModuleByClass(Class152.class)).Field940.getValue();
        if (!bl2) {
            try {
                if (Globals.mc.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && Globals.mc.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
                    return false;
                }
                if (Globals.mc.world.getBlockState(blockPos2).getBlock() == Blocks.AIR && Globals.mc.world.getBlockState(blockPos3).getBlock() == Blocks.AIR) {
                    if (bl) {
                        Entity entity;
                        Iterator iterator = Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).iterator();
                        do {
                            if (iterator.hasNext()) continue;
                            iterator = Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).iterator();
                            do {
                                if (iterator.hasNext()) continue;
                                return true;
                            } while ((entity = (Entity)iterator.next()) instanceof EntityEnderCrystal);
                            return false;
                        } while ((entity = (Entity)iterator.next()) instanceof EntityEnderCrystal);
                        return false;
                    }
                    return Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty() && Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).isEmpty();
                }
                return false;
            }
            catch (Exception exception) {
                return false;
            }
        }
        try {
            if (Globals.mc.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && Globals.mc.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
                return false;
            }
            if (Globals.mc.world.getBlockState(blockPos2).getBlock() == Blocks.AIR) {
                if (bl) {
                    Entity entity;
                    Iterator iterator = Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).iterator();
                    do {
                        if (iterator.hasNext()) continue;
                        return true;
                    } while ((entity = (Entity)iterator.next()) instanceof EntityEnderCrystal);
                    return false;
                }
                return Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty();
            }
            return false;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static boolean Method1225(BlockPos blockPos) {
        return Class31.Method1277(blockPos).canCollideCheck(Class31.Method1278(blockPos), false);
    }

    private static Block Method1277(BlockPos blockPos) {
        return Class31.Method1278(blockPos).getBlock();
    }

    private static IBlockState Method1278(BlockPos blockPos) {
        return Globals.mc.world.getBlockState(blockPos);
    }

    public static boolean Method1279(Entity entity) {
        if (entity != null) {
            BlockPos blockPos = new BlockPos(entity.posX, entity.posY + 2.0, entity.posZ);
            return Class31.Method1280(blockPos);
        }
        return false;
    }

    public static void Method1281(String string, BlockPos blockPos) {
        Globals.printChatMessage(string + blockPos.getX() + "x," + blockPos.getY() + "y," + blockPos.getZ() + "z");
    }

    @Class72
    public static void Method1282(BlockPos blockPos, EnumHand enumHand) {
        RayTraceResult rayTraceResult = Globals.mc.world.rayTraceBlocks(new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ), new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY() - 0.5, (double)blockPos.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult != null && rayTraceResult.sideHit != null ? rayTraceResult.sideHit : EnumFacing.UP;
        Vec3d vec3d = ((Class152)Manager.moduleManager.getModuleByClass(Class152.class)).Field941;
        if (Manager.moduleManager.isModuleEnabled(Class152.class) && ((Boolean)((Class152)Manager.moduleManager.getModuleByClass(Class152.class)).Field942.getValue()).booleanValue() && vec3d != null && rayTraceResult != null) {
            float f = (float)(vec3d.x - (double)blockPos.getX());
            float f2 = (float)(vec3d.y - (double)blockPos.getY());
            float f3 = (float)(vec3d.z - (double)blockPos.getZ());
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
        } else {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, 0.0f, 0.0f, 0.0f));
        }
    }

    public static void Method52(BlockPos blockPos, EnumHand enumHand, boolean bl, Vec3d vec3d) {
        if (bl && vec3d != null) {
            RayTraceResult rayTraceResult = Globals.mc.world.rayTraceBlocks(new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ), vec3d);
            EnumFacing enumFacing = rayTraceResult != null && rayTraceResult.sideHit != null ? rayTraceResult.sideHit : EnumFacing.UP;
            float f = (float)(vec3d.x - (double)blockPos.getX());
            float f2 = (float)(vec3d.y - (double)blockPos.getY());
            float f3 = (float)(vec3d.z - (double)blockPos.getZ());
            boolean bl2 = false;
            if (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && !rayTraceResult.getBlockPos().equals((Object)blockPos)) {
                bl2 = true;
                f2 = 1.0f;
                Field934 = EnumFacing.UP;
                enumFacing = EnumFacing.UP;
            }
            if (!bl2) {
                Field934 = enumFacing;
                switch (enumFacing) {
                    case UP: {
                        f2 = 1.0f;
                        break;
                    }
                    case DOWN: {
                        f2 = 0.0f;
                        break;
                    }
                    case NORTH: {
                        f3 = 1.0f;
                        break;
                    }
                    case SOUTH: {
                        f3 = 0.0f;
                        break;
                    }
                    case WEST: {
                        f = 0.0f;
                        break;
                    }
                    case EAST: {
                        f = 1.0f;
                    }
                }
            }
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f, f2, f3));
        } else {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, EnumFacing.UP, enumHand, 0.0f, 0.0f, 0.0f));
        }
    }

    @Class72
    public static BlockPos[] Method1283(Vec3d[] vec3dArray) {
        BlockPos[] blockPosArray = new BlockPos[vec3dArray.length];
        for (int i = 0; i < vec3dArray.length; ++i) {
            blockPosArray[i] = new BlockPos(vec3dArray[i]);
        }
        return blockPosArray;
    }

    public static Vec3d Method1284(BlockPos blockPos) {
        return new Vec3d((Vec3i)blockPos);
    }

    public static BlockPos Method1285(Vec3d vec3d) {
        return new BlockPos(vec3d);
    }

    public static Boolean Method1286(BlockPos blockPos) {
        int n = Class84.Method1287();
        if (n == 0 && (double)blockPos.getZ() - Globals.mc.player.getPositionVector().z < 0.0) {
            return false;
        }
        if (n == 1 && (double)blockPos.getX() - Globals.mc.player.getPositionVector().x > 0.0) {
            return false;
        }
        return n == 2 && (double)blockPos.getZ() - Globals.mc.player.getPositionVector().z > 0.0 ? false : n != 3 || (double)blockPos.getX() - Globals.mc.player.getPositionVector().x >= 0.0;
    }

    public static boolean Method1288(Entity entity) {
        if (entity != null) {
            BlockPos blockPos = new BlockPos(entity.posX, entity.posY - 1.0, entity.posZ);
            return Class31.Method1280(blockPos);
        }
        return false;
    }

    public static boolean Method1280(BlockPos blockPos) {
        return !Class31.Method1289(blockPos);
    }

    public static boolean Method1289(BlockPos blockPos) {
        return Class31.Method1290(Globals.mc.world.getBlockState(blockPos).getBlock());
    }

    public static boolean Method1290(Block block) {
        return Field937.contains(block);
    }

    public static Vec3d[] Method1291(Vec3d vec3d, Vec3d[] vec3dArray) {
        Vec3d[] vec3dArray2 = new Vec3d[vec3dArray.length];
        for (int i = 0; i < vec3dArray.length; ++i) {
            vec3dArray2[i] = vec3d.add(vec3dArray[i]);
        }
        return vec3dArray2;
    }

    public static Vec3d[] Method1292(EntityPlayer entityPlayer, Vec3d[] vec3dArray) {
        return Class31.Method1291(entityPlayer.getPositionVector(), vec3dArray);
    }

    public static boolean Method1293(BlockPos blockPos) {
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        return block.getBlockHardness(iBlockState, (World)Globals.mc.world, blockPos) != -1.0f;
    }

    public static boolean Method1294(BlockPos blockPos) {
        Block block = Globals.mc.world.getBlockState(blockPos).getBlock();
        return !(block instanceof BlockLiquid) && block.getMaterial((IBlockState)null) != Material.AIR;
    }

    public static List Method1295(Vec3d vec3d, int n) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>(4);
        for (Vec3d vec3d2 : Class31.Method1296(n)) {
            BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
            Block block = Globals.mc.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow)) continue;
            arrayList.add(vec3d2);
        }
        return arrayList;
    }

    public static List Method1297(Entity entity, int n) {
        return Class31.Method1295(entity.getPositionVector(), n);
    }

    public static boolean Method1298(Entity entity, int n) {
        return Class31.Method1297(entity, n).size() == 0;
    }

    public static boolean Method1299(BlockPos blockPos) {
        return Globals.mc.world.isAirBlock(blockPos) || Globals.mc.world.getBlockState(blockPos).getBlock() == Blocks.SNOW_LAYER || Globals.mc.world.getBlockState(blockPos).getBlock() == Blocks.TALLGRASS || Globals.mc.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid;
    }

    @Class72
    public static boolean Method1223(BlockPos blockPos, boolean bl, float f) {
        return !bl || Globals.mc.world.rayTraceBlocks(new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ), new Vec3d((double)blockPos.getX(), (double)((float)blockPos.getY() + f), (double)blockPos.getZ()), false, true, false) == null;
    }

    @Class72
    public static boolean Method1300(BlockPos blockPos, boolean bl) {
        return Class31.Method1223(blockPos, bl, 1.0f);
    }

    public static boolean Method1301(BlockPos blockPos) {
        return Class31.Method1300(blockPos, true);
    }

    public static List Method1302(int n) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>(4);
        arrayList.add(new Vec3d(-1.0, (double)n, 0.0));
        arrayList.add(new Vec3d(1.0, (double)n, 0.0));
        arrayList.add(new Vec3d(0.0, (double)n, -1.0));
        arrayList.add(new Vec3d(0.0, (double)n, 1.0));
        return arrayList;
    }

    public static Vec3d[] Method1296(int n) {
        List list = Class31.Method1302(n);
        Vec3d[] vec3dArray = new Vec3d[list.size()];
        return list.toArray(vec3dArray);
    }

    private static boolean Method1274(boolean bl, BlockPos blockPos) {
        return Class31.Method1275(blockPos, bl);
    }

    private static boolean Method1199(Class clazz, BlockPos blockPos) {
        return clazz.isInstance(Globals.mc.world.getBlockState(blockPos).getBlock());
    }

    static {
        Field934 = EnumFacing.UP;
        Field912 = Arrays.asList(Blocks.AIR, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.VINE, Blocks.SNOW_LAYER, Blocks.TALLGRASS, Blocks.FIRE);
        Field933 = Arrays.asList(Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.ANVIL, Blocks.WOODEN_BUTTON, Blocks.STONE_BUTTON, Blocks.UNPOWERED_COMPARATOR, Blocks.UNPOWERED_REPEATER, Blocks.POWERED_REPEATER, Blocks.POWERED_COMPARATOR, Blocks.OAK_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE, Blocks.ACACIA_FENCE_GATE, Blocks.BREWING_STAND, Blocks.DISPENSER, Blocks.DROPPER, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.JUKEBOX, Blocks.BEACON, Blocks.BED, Blocks.FURNACE, Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.CAKE, Blocks.ENCHANTING_TABLE, Blocks.DRAGON_EGG, Blocks.HOPPER, Blocks.REPEATING_COMMAND_BLOCK, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.CRAFTING_TABLE);
        Field935 = Arrays.asList(Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR, Blocks.ENCHANTING_TABLE);
        Field936 = Arrays.asList(Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX);
        Field937 = Arrays.asList(Blocks.FLOWING_LAVA, Blocks.FLOWER_POT, Blocks.SNOW, Blocks.CARPET, Blocks.END_ROD, Blocks.SKULL, Blocks.FLOWER_POT, Blocks.TRIPWIRE, Blocks.TRIPWIRE_HOOK, Blocks.WOODEN_BUTTON, Blocks.LEVER, Blocks.STONE_BUTTON, Blocks.LADDER, Blocks.UNPOWERED_COMPARATOR, Blocks.POWERED_COMPARATOR, Blocks.UNPOWERED_REPEATER, Blocks.POWERED_REPEATER, Blocks.UNLIT_REDSTONE_TORCH, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WIRE, Blocks.AIR, Blocks.PORTAL, Blocks.END_PORTAL, Blocks.WATER, Blocks.FLOWING_WATER, Blocks.LAVA, Blocks.FLOWING_LAVA, Blocks.SAPLING, Blocks.RED_FLOWER, Blocks.YELLOW_FLOWER, Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES, Blocks.BEETROOTS, Blocks.REEDS, Blocks.PUMPKIN_STEM, Blocks.MELON_STEM, Blocks.WATERLILY, Blocks.NETHER_WART, Blocks.COCOA, Blocks.CHORUS_FLOWER, Blocks.CHORUS_PLANT, Blocks.TALLGRASS, Blocks.DEADBUSH, Blocks.VINE, Blocks.FIRE, Blocks.RAIL, Blocks.ACTIVATOR_RAIL, Blocks.DETECTOR_RAIL, Blocks.GOLDEN_RAIL, Blocks.TORCH);
    }
}
