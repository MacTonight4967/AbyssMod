package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class634;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class633 {
    static final int[] Field2850 = new int[Class634.values().length];

    static {
        try {
            Class633.Field2850[Class634.Packet.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class633.Field2850[Class634.Damage.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
