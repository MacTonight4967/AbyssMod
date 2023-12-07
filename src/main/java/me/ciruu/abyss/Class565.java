package me.ciruu.abyss;

import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class565 {
    static final int[] Field2208 = new int[TickEvent.Phase.values().length];

    static {
        try {
            Class565.Field2208[TickEvent.Phase.START.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class565.Field2208[TickEvent.Phase.END.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
