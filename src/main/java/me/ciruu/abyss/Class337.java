package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class151;
import me.ciruu.abyss.enums.Class260;
import me.ciruu.abyss.enums.Class339;
import me.ciruu.abyss.enums.Class340;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class337 {
    static final int[] Field1155;
    static final int[] Field1162;
    static final int[] Field1163;
    static final int[] Field1167;

    static {
        Field1167 = new int[Class339.values().length];
        try {
            Class337.Field1167[Class339.Always.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class337.Field1167[Class339.Efficient.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class337.Field1167[Class339.OnlyOwn.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field1163 = new int[Class151.values().length];
        try {
            Class337.Field1163[Class151.Off.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class337.Field1163[Class151.Place.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class337.Field1163[Class151.All.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class337.Field1163[Class151.Break.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field1162 = new int[Class340.values().length];
        try {
            Class337.Field1162[Class340.None.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class337.Field1162[Class340.Toggle.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class337.Field1162[Class340.Always.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field1155 = new int[Class260.values().length];
        try {
            Class337.Field1155[Class260.PlaceBreak.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class337.Field1155[Class260.BreakPlace.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
