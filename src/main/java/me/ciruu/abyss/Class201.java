package me.ciruu.abyss;

import net.minecraft.util.math.RayTraceResult;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class201 {
    static final int[] Field478 = new int[RayTraceResult.Type.values().length];

    static {
        try {
            Class201.Field478[RayTraceResult.Type.MISS.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class201.Field478[RayTraceResult.Type.BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class201.Field478[RayTraceResult.Type.ENTITY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
