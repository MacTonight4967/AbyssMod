package me.ciruu.abyss;

import me.ciruu.abyss.Globals;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class Class85 {
    public static boolean Method1585(BlockPos blockPos) {
        BlockPos[] blockPosArray;
        for (BlockPos blockPos2 : blockPosArray = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.OBSIDIAN) continue;
            return false;
        }
        return true;
    }

    public static boolean Method206(BlockPos blockPos) {
        BlockPos[] blockPosArray;
        for (BlockPos blockPos2 : blockPosArray = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.BEDROCK) continue;
            return false;
        }
        return true;
    }

    public static boolean Method208(BlockPos blockPos) {
        BlockPos[] blockPosArray;
        for (BlockPos blockPos2 : blockPosArray = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && (iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.OBSIDIAN)) continue;
            return false;
        }
        return true;
    }

    public static boolean Method1586(BlockPos blockPos) {
        BlockPos[] blockPosArray;
        for (BlockPos blockPos2 : blockPosArray = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.isFullBlock()) continue;
            return false;
        }
        return true;
    }
}
