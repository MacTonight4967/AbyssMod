package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class592;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class591 {
    static final int[] Field2408 = new int[Class592.values().length];

    static {
        try {
            Class591.Field2408[Class592.COD.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class591.Field2408[Class592.CSGO.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class591.Field2408[Class592.None.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
