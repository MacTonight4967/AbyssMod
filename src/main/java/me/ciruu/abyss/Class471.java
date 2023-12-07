package me.ciruu.abyss;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class390;
import me.ciruu.abyss.Class50;
import me.ciruu.abyss.Globals;
import net.minecraft.client.gui.ScaledResolution;

public class Class471 {
    public final int Field1800 = 100;
    private final List Field1801 = new ArrayList();

    public void Method2020() {
        for (int i = 0; i < 100; ++i) {
            this.Field1801.add(Class390.Method1627());
        }
    }

    public void Method2195(Color color, float f, boolean bl, float f2, float f3, Class35 class35) {
        if (bl) {
            int n = 1;
            for (Class390 class390 : this.Field1801) {
                class390.Method1644(this.Method2196(class390, class35, color, f2));
                ++n;
            }
            for (Class390 class390 : this.Field1801) {
                for (Class390 class3902 : this.Field1801) {
                    if (!(class390.Method1646(class3902) <= f)) continue;
                    Class50.Method817(class390.Method1633(), class390.Method1637(), class3902.Method1633(), class3902.Method1637(), f3, class390.Method1643().getRGB(), class3902.Method1643().getRGB());
                }
            }
            this.Field1801.forEach(Class471::Method2197);
        } else {
            for (Class390 class390 : this.Field1801) {
                Class50.Method891(class390.Method1633(), class390.Method1637(), class390.Method1641(), color);
                for (Class390 class3903 : this.Field1801) {
                    if (!(class390.Method1646(class3903) <= f)) continue;
                    Class50.Method802(class390.Method1633(), class390.Method1637(), class3903.Method1633(), class3903.Method1637(), f3, color.getRGB());
                }
            }
        }
    }

    public void Method2198(int n, float f) {
        ScaledResolution scaledResolution = new ScaledResolution(Globals.mc);
        this.Field1801.forEach(arg_0 -> Class471.Method2199(n, f, arg_0));
        this.Field1801.forEach(arg_0 -> Class471.Method2200(scaledResolution, arg_0));
    }

    public void Method2201(int n) {
        this.Field1801.clear();
        for (int i = 0; i < n; ++i) {
            this.Field1801.add(Class390.Method1627());
        }
    }

    private Color Method2196(Class390 class390, Class35 class35, Color color, float f) {
        int n = class35.Method2006();
        int n2 = class35.Method1967();
        float f2 = class390.Method1633();
        float f3 = class390.Method1637();
        float[] fArray = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fArray);
        return Color.getHSBColor(fArray[0] + (f2 / (float)n + f3 / (float)n2) * f, fArray[1], fArray[2]);
    }

    private static void Method2200(ScaledResolution scaledResolution, Class390 class390) {
        class390.Method1649(scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());
    }

    private static void Method2199(int n, float f, Class390 class390) {
        class390.Method1645(n, f);
    }

    private static void Method2197(Class390 class390) {
        Class50.Method891(class390.Method1633(), class390.Method1637(), class390.Method1641(), class390.Method1643());
    }
}
