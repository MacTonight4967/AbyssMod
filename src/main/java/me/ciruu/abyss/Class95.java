package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class96;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class95 {
    static final int[] Field246 = new int[Class96.values().length];

    static {
        try {
            Class95.Field246[Class96.Crystal.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class95.Field246[Class96.Gapple.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class95.Field246[Class96.Totem.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
