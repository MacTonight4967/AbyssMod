package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class380;
import me.ciruu.abyss.enums.Class61;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class379 {
    static final int[] Field1254;
    static final int[] Field1256;

    static {
        Field1256 = new int[Class61.values().length];
        try {
            Class379.Field1256[Class61.Steal.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class379.Field1256[Class61.Drop.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field1254 = new int[Class380.values().length];
        try {
            Class379.Field1254[Class380.All.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class379.Field1254[Class380.BlackList.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class379.Field1254[Class380.Whitelist.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
