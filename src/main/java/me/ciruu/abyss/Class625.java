package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class258;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class625 {
    static final int[] Field2776 = new int[Class258.values().length];

    static {
        try {
            Class625.Field2776[Class258.Left.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class625.Field2776[Class258.Right.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class625.Field2776[Class258.Both.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
