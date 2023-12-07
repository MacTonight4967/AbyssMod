package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class217;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class216 {
    static final int[] Field500 = new int[Class217.values().length];

    static {
        try {
            Class216.Field500[Class217.Motion.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class216.Field500[Class217.Strict.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
