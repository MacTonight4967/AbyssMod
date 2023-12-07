package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class303;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class302 {
    static final int[] Field868 = new int[Class303.values().length];

    static {
        try {
            Class302.Field868[Class303.TICK.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class302.Field868[Class303.VIRTUE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class302.Field868[Class303.DIRECT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
