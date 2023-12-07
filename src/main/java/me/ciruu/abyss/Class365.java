package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class366;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class365 {
    static final int[] Field1222 = new int[Class366.values().length];

    static {
        try {
            Class365.Field1222[Class366.Left.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class365.Field1222[Class366.Right.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class365.Field1222[Class366.Both.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
