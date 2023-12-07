package me.ciruu.abyss;

import java.awt.Color;

public class Class290 {
    public static int Method1053(int n, int n2) {
        float f = (System.currentTimeMillis() + (long)n2) % (long)n;
        return Color.getHSBColor(f /= (float)n, 1.0f, 1.0f).getRGB();
    }

    public static Color Method1054(int n, int n2, float f) {
        float f2 = (System.currentTimeMillis() + (long)n2) % (long)n;
        return Color.getHSBColor(f2 /= (float)n, f, 1.0f);
    }

    public static int Method1055(int n, int n2, int n3) {
        return 0xFF000000 | (n & 0xFF) << 16 | (n2 & 0xFF) << 8 | n3 & 0xFF;
    }
}
