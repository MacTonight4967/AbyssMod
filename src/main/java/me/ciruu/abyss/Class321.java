package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class319;
import me.ciruu.abyss.enums.Class458;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class321 {
    static final int[] Field932;
    static final int[] Field1591;

    static {
        Field1591 = new int[Class458.values().length];
        try {
            Class321.Field1591[Class458.Box.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class321.Field1591[Class458.Line.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class321.Field1591[Class458.Both.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field932 = new int[Class319.values().length];
        try {
            Class321.Field932[Class319.FISHING_ROD.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class321.Field932[Class319.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class321.Field932[Class319.ARROW.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
