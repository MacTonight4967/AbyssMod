package me.ciruu.abyss;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Globals;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class Class308 {
    public static List Method2661(float f) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection)Class308.Method2662(Class30.Method209((EntityPlayer)Globals.mc.player), f, (int)f, false, true, 0).stream().filter(Class308::Method2663).collect(Collectors.toList()));
        return nonNullList;
    }

    public static List Method2664(float f, boolean bl) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection)Class308.Method2662(Class30.Method209((EntityPlayer)Globals.mc.player), f, (int)f, false, true, 0).stream().filter(arg_0 -> Class308.Method2665(bl, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    public static List Method2666(float f, boolean bl, boolean bl2) {
        NonNullList nonNullList = NonNullList.create();
        nonNullList.addAll((Collection)Class308.Method2662(Class30.Method209((EntityPlayer)Globals.mc.player), f, (int)f, false, true, 0).stream().filter(arg_0 -> Class308.Method2667(bl, bl2, arg_0)).collect(Collectors.toList()));
        return nonNullList;
    }

    public static List Method2662(BlockPos blockPos, float f, int n, boolean bl, boolean bl2, int n2) {
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
                        BlockPos blockPos2 = new BlockPos(n6, n8 + n2, n7);
                        arrayList.add(blockPos2);
                    }
                    ++n8;
                }
                ++n7;
            }
            ++n6;
        }
        return arrayList;
    }

    public static boolean Method2668(BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        try {
            return (Globals.mc.world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK || Globals.mc.world.getBlockState(blockPos).getBlock() == Blocks.OBSIDIAN) && Globals.mc.world.getBlockState(blockPos2).getBlock() == Blocks.AIR && Globals.mc.world.getBlockState(blockPos3).getBlock() == Blocks.AIR && Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty() && Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).isEmpty();
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static boolean Method1106(BlockPos blockPos, boolean bl, boolean bl2) {
        block8: {
            BlockPos blockPos2 = blockPos.add(0, 1, 0);
            BlockPos blockPos3 = blockPos.add(0, 2, 0);
            try {
                if (Globals.mc.world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && Globals.mc.world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
                    return false;
                }
                if (!(Globals.mc.world.getBlockState(blockPos2).getBlock() == Blocks.AIR && Globals.mc.world.getBlockState(blockPos3).getBlock() == Blocks.AIR || bl2)) {
                    return false;
                }
                if (bl) {
                    for (Entity entity : Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2))) {
                        if (entity instanceof EntityEnderCrystal) continue;
                        return false;
                    }
                    if (!bl2) {
                        for (Entity entity : Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3))) {
                            if (entity instanceof EntityEnderCrystal) continue;
                            return false;
                        }
                    }
                    break block8;
                }
                return Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2)).isEmpty() && (bl2 || Globals.mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos3)).isEmpty());
            }
            catch (Exception exception) {
                return false;
            }
        }
        return true;
    }

    private static boolean Method2667(boolean bl, boolean bl2, BlockPos blockPos) {
        return Class308.Method1106(blockPos, bl, bl2);
    }

    private static boolean Method2665(boolean bl, BlockPos blockPos) {
        return Class308.Method1106(blockPos, true, bl);
    }

    private static boolean Method2663(BlockPos blockPos) {
        return Class308.Method1106(blockPos, true, false);
    }
}
