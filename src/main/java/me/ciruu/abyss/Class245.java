package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class246;
import me.ciruu.abyss.enums.Class247;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class245 {
    static final int[] Field1239;
    static final int[] Field665;

    static {
        Field665 = new int[Class247.values().length];
        try {
            Class245.Field665[Class247.NEW_ONLY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class245.Field665[Class247.OLD_ONLY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class245.Field665[Class247.ALL.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field1239 = new int[Class246.values().length];
        try {
            Class245.Field1239[Class246.IS_FULL_CHUNK.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class245.Field1239[Class246.TIMING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
