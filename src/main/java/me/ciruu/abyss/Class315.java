package me.ciruu.abyss;

import java.util.Random;
import net.minecraft.util.ChatAllowedCharacters;

/*
 * Exception performing whole class analysis ignored.
 */
private static class Class315 {
    public static int[] Field918 = new int[16];
    private static final Random Field3124;
    private static final String Field3125 = "\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u0000";

    private Class315() {
    }

    public static String Method1171(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (!ChatAllowedCharacters.isAllowedCharacter((char)c)) continue;
            int n = Field3124.nextInt("\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u0000".length());
            stringBuilder.append("\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u0000".charAt(n));
        }
        return stringBuilder.toString();
    }

    static {
        Class315.Field918[0] = 0;
        Class315.Field918[1] = 170;
        Class315.Field918[2] = 43520;
        Class315.Field918[3] = 43690;
        Class315.Field918[4] = 0xAA0000;
        Class315.Field918[5] = 0xAA00AA;
        Class315.Field918[6] = 0xFFAA00;
        Class315.Field918[7] = 0xAAAAAA;
        Class315.Field918[8] = 0x555555;
        Class315.Field918[9] = 0x5555FF;
        Class315.Field918[10] = 0x55FF55;
        Class315.Field918[11] = 0x55FFFF;
        Class315.Field918[12] = 0xFF5555;
        Class315.Field918[13] = 0xFF55FF;
        Class315.Field918[14] = 0xFFFF55;
        Class315.Field918[15] = 0xFFFFFF;
        Field3124 = new Random();
    }
}
