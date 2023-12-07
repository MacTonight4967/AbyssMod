package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class426;
import me.ciruu.abyss.enums.Class428;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class425 {
    static final int[] Field1389;
    static final int[] Field1390;

    static {
        Field1390 = new int[Class426.values().length];
        try {
            Class425.Field1390[Class426.Fast.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class425.Field1390[Class426.Setback.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field1389 = new int[Class428.values().length];
        try {
            Class425.Field1389[Class428.Down.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class425.Field1389[Class428.Up.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class425.Field1389[Class428.Preserve.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
