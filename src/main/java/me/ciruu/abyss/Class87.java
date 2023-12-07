package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class53;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class87 {
    static final int[] Field225 = new int[Class53.values().length];

    static {
        try {
            Class87.Field225[Class53.PRE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class87.Field225[Class53.POST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
