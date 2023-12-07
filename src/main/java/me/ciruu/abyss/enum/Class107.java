package me.ciruu.abyss.enums;

import net.minecraft.util.math.BlockPos;

/*
 * Exception performing whole class analysis ignored.
 */
public static enum Class107 {
    DOWN(0, -1, 0),
    UP(0, 1, 0),
    NORTH(0, 0, -1),
    EAST(1, 0, 0),
    SOUTH(0, 0, 1),
    WEST(-1, 0, 0);

    private final int Field262;
    private final int Field263;
    private final int Field264;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Class107(int n3) {
        void var5_3;
        void var4_2;
        this.Field262 = n3;
        this.Field263 = var4_2;
        this.Field264 = var5_3;
    }

    public BlockPos offset(BlockPos blockPos) {
        return blockPos.add(this.Field262, this.Field263, this.Field264);
    }

    public BlockPos forward(BlockPos blockPos, int n) {
        return blockPos.add(this.Field262 * n, 0, this.Field264 * n);
    }

    public BlockPos backward(BlockPos blockPos, int n) {
        return blockPos.add(-this.Field262 * n, 0, -this.Field264 * n);
    }

    public BlockPos left(BlockPos blockPos, int n) {
        return blockPos.add(this.Field264 * n, 0, -this.Field262 * n);
    }

    public BlockPos right(BlockPos blockPos, int n) {
        return blockPos.add(-this.Field264 * n, 0, this.Field262 * n);
    }
}
