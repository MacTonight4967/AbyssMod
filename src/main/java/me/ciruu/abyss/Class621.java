package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class580;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class621 {
    static final int[] Field2729 = new int[Class580.values().length];

    static {
        try {
            Class621.Field2729[Class580.Normal.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class621.Field2729[Class580.DoubleTop.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class621.Field2729[Class580.Feet.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class621.Field2729[Class580.Face.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
