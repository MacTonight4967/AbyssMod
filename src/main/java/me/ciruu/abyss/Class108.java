package me.ciruu.abyss;

import java.util.HashMap;
import java.util.Map;
import me.ciruu.abyss.Class273;
import me.ciruu.abyss.enums.Class107;
import me.ciruu.abyss.enums.Class272;
import me.ciruu.abyss.enums.Class274;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class Class108 {
    public static final Minecraft Field3179 = Minecraft.getMinecraft();

    public static Class272 Method3854(Block block) {
        if (block == Blocks.BEDROCK) {
            return Class272.UNBREAKABLE;
        }
        if (block == Blocks.OBSIDIAN || block == Blocks.ENDER_CHEST || block == Blocks.ANVIL) {
            return Class272.RESISTANT;
        }
        return Class272.BREAKABLE;
    }

    public static Class273 Method1012(BlockPos blockPos, boolean bl, boolean bl2) {
        Class273 class273 = new Class273();
        HashMap hashMap = Class108.Method3855(blockPos);
        if (hashMap.containsKey((Object)Class107.DOWN) && hashMap.remove((Object)Class107.DOWN, (Object)Class272.BREAKABLE) && !bl2) {
            class273.Method3605(Class272.BREAKABLE);
            return class273;
        }
        int n = hashMap.size();
        hashMap.entrySet().removeIf(Class108::Method3856);
        if (hashMap.size() != n) {
            class273.Method3605(Class272.RESISTANT);
        }
        if ((n = hashMap.size()) == 0) {
            class273.Method3604(Class274.SINGLE);
            class273.Method3606(new AxisAlignedBB(blockPos));
            return class273;
        }
        if (n == 1 && !bl) {
            return Class108.Method3857(class273, blockPos, (Class107)((Object)hashMap.keySet().stream().findFirst().get()));
        }
        class273.Method3605(Class272.BREAKABLE);
        return class273;
    }

    private static Class273 Method3857(Class273 class273, BlockPos blockPos, Class107 class107) {
        BlockPos blockPos2 = class107.offset(blockPos);
        HashMap hashMap = Class108.Method3855(blockPos2);
        int n = hashMap.size();
        hashMap.entrySet().removeIf(Class108::Method3858);
        if (hashMap.size() != n) {
            class273.Method3605(Class272.RESISTANT);
        }
        if (hashMap.containsKey((Object)Class107.DOWN)) {
            class273.Method3604(Class274.CUSTOM);
            hashMap.remove((Object)Class107.DOWN);
        }
        if (hashMap.size() > 1) {
            class273.Method3604(Class274.NONE);
            return class273;
        }
        double d = Math.min(blockPos.getX(), blockPos2.getX());
        double d2 = Math.max(blockPos.getX(), blockPos2.getX()) + 1;
        double d3 = Math.min(blockPos.getZ(), blockPos2.getZ());
        double d4 = Math.max(blockPos.getZ(), blockPos2.getZ()) + 1;
        class273.Method3606(new AxisAlignedBB(d, (double)blockPos.getY(), d3, d2, (double)(blockPos.getY() + 1), d4));
        if (class273.Method1013() != Class274.CUSTOM) {
            class273.Method3604(Class274.DOUBLE);
        }
        return class273;
    }

    public static HashMap Method3855(BlockPos blockPos) {
        HashMap<Class107, Class272> hashMap = new HashMap<Class107, Class272>();
        Class272 class272 = Class108.Method3854(Class108.Field3179.world.getBlockState(Class107.DOWN.offset(blockPos)).getBlock());
        if (class272 != Class272.UNBREAKABLE) {
            hashMap.put(Class107.DOWN, class272);
        }
        if ((class272 = Class108.Method3854(Class108.Field3179.world.getBlockState(Class107.NORTH.offset(blockPos)).getBlock())) != Class272.UNBREAKABLE) {
            hashMap.put(Class107.NORTH, class272);
        }
        if ((class272 = Class108.Method3854(Class108.Field3179.world.getBlockState(Class107.SOUTH.offset(blockPos)).getBlock())) != Class272.UNBREAKABLE) {
            hashMap.put(Class107.SOUTH, class272);
        }
        if ((class272 = Class108.Method3854(Class108.Field3179.world.getBlockState(Class107.EAST.offset(blockPos)).getBlock())) != Class272.UNBREAKABLE) {
            hashMap.put(Class107.EAST, class272);
        }
        if ((class272 = Class108.Method3854(Class108.Field3179.world.getBlockState(Class107.WEST.offset(blockPos)).getBlock())) != Class272.UNBREAKABLE) {
            hashMap.put(Class107.WEST, class272);
        }
        return hashMap;
    }

    private static boolean Method3858(Map.Entry entry) {
        return entry.getValue() == Class272.RESISTANT;
    }

    private static boolean Method3856(Map.Entry entry) {
        return entry.getValue() == Class272.RESISTANT;
    }
}
