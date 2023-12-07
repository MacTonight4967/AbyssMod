package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class283;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class282 {
    static final int[] Field782 = new int[Class283.values().length];

    static {
        try {
            Class282.Field782[Class283.Connected.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class282.Field782[Class283.Disconnected.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
