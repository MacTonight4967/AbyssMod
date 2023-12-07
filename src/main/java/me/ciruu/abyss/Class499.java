package me.ciruu.abyss;

import me.ciruu.abyss.Class501;
import me.ciruu.abyss.enums.Class500;

public class Class499 {
    private static final int Field1796 = 50;
    private static final Class501[] Field1797 = new Class501[Class500.values().length];

    public static void Method2190(Class500 class500) {
        Field1797[Class500.Method2191(class500)].Method2192(System.currentTimeMillis());
    }

    public static int Method2193(Class500 class500) {
        return Field1797[Class500.Method2191(class500)].Method2194(System.currentTimeMillis() - 1000L);
    }

    static {
        for (int i = 0; i < Field1797.length; ++i) {
            Class499.Field1797[i] = new Class501(50);
        }
    }
}
