package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class421;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class420 {
    static final int[] Field1366 = new int[Class421.values().length];

    static {
        try {
            Class420.Field1366[Class421.All.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class420.Field1366[Class421.Obby.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class420.Field1366[Class421.Echest.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class420.Field1366[Class421.BlackList.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class420.Field1366[Class421.Whitelist.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
