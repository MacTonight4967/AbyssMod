package me.ciruu.abyss;

import net.minecraft.network.play.server.SPacketPlayerListItem;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class153 {
    static final int[] Field345 = new int[SPacketPlayerListItem.Action.values().length];

    static {
        try {
            Class153.Field345[SPacketPlayerListItem.Action.ADD_PLAYER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class153.Field345[SPacketPlayerListItem.Action.REMOVE_PLAYER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
