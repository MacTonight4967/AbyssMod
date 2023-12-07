package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class497;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class496 {
    static final int[] Field1760 = new int[Class497.values().length];

    static {
        try {
            Class496.Field1760[Class497.Normal.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class496.Field1760[Class497.Pause.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
