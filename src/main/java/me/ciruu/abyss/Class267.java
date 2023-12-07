package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class268;
import me.ciruu.abyss.enums.Class269;
import me.ciruu.abyss.enums.Class271;

/*
 * Exception performing whole class analysis ignored.
 */
static class Class267 {
    static final int[] Field749;
    static final int[] Field750;
    static final int[] Field751;

    static {
        Field751 = new int[Class271.values().length];
        try {
            Class267.Field751[Class271.Obsidian.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class267.Field751[Class271.Bedrock.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class267.Field751[Class271.Extended.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field750 = new int[Class269.values().length];
        try {
            Class267.Field750[Class269.Air.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class267.Field750[Class269.Ground.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class267.Field750[Class269.Flat.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class267.Field750[Class269.Slab.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class267.Field750[Class269.Double.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field749 = new int[Class268.values().length];
        try {
            Class267.Field749[Class268.Outline.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class267.Field749[Class268.Box.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            Class267.Field749[Class268.Both.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
