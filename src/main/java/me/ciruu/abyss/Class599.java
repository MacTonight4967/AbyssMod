package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class300;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class599 {
    static final int[] Field2496 = new int[Class300.values().length];

    static {
        try {
            Class599.Field2496[Class300.NORMAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class599.Field2496[Class300.SILENT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class599.Field2496[Class300.NONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
