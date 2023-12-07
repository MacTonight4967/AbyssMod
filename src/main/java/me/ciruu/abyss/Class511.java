package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class144;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class511 {
    static final int[] Field1904 = new int[Class144.values().length];

    static {
        try {
            Class511.Field1904[Class144.Rage.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class511.Field1904[Class144.Legit.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
