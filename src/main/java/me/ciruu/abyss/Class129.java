package me.ciruu.abyss;

import java.awt.Color;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class50;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class128;

public class Class129 {
    private Class128 Field1623;
    private String Field1624;
    private String Field1625;
    private final Class22 Field1626 = new Class22();
    private long Field1627;
    private float Field1628;
    private float Field1629 = 30.0f;
    private boolean Field1630 = false;
    private float Field1631;
    private boolean Field1632 = false;

    public Class129(Class128 class128, String string) {
        this.Field1623 = class128;
        this.Field1624 = class128.name();
        this.Field1625 = string;
        this.Field1627 = System.nanoTime();
        this.Field1631 = this.Field1628 = (float)Math.max(150, Class36.Method259(string) + 35);
        this.Field1626.Method47();
    }

    public Class129(Class128 class128, String string, String string2) {
        this.Field1623 = class128;
        this.Field1624 = string;
        this.Field1625 = string2;
        this.Field1627 = System.nanoTime();
        this.Field1631 = this.Field1628 = (float)Math.max(150, Class36.Method259(string2) + 35);
        this.Field1626.Method47();
    }

    public void Method346(float f, float f2, float f3, float f4) {
        if (this.Field1628 > 150.0f) {
            f -= this.Field1628 - 150.0f;
        }
        f += this.Field1631;
        if (!this.Field1632) {
            this.Field1631 -= f4;
        }
        Class50.Method862(f, f2, f + this.Field1628, f2 + this.Field1629, Color.BLACK.getRGB(), 0.75f);
        Class50.Method861(f + this.Field1628, f2 + this.Field1629, f, f2, 1.0f, this.Field1623.getColor().getRGB());
        Class50.Method862(f + 4.0f, f2 + 4.0f, f + 26.0f, f2 + 26.0f, this.Field1623.getColor().getRGB(), 1.0f);
        Globals.mc.renderEngine.bindTexture(this.Field1623.getImage());
        Class50.Method777(f + 5.0f, f2 + 5.0f, 0.0f, 0.0f, 16.0f, 16.0f, 20.0f, 20.0f, 16.0f, 16.0f);
        Class36.Method63(this.Field1624, f + 30.0f, f2 + 5.0f, this.Field1623.getColor().getRGB());
        Class36.Method63(this.Field1625, f + 30.0f, f2 + 15.0f, Color.WHITE.getRGB());
        if (this.Field1631 <= 0.0f && !this.Field1632) {
            this.Field1631 = 0.0f;
            this.Method347();
            this.Field1632 = true;
        }
        if (this.Field1626.Method50((long)f3) && this.Field1632) {
            this.Field1631 += f4;
            if (this.Field1631 >= this.Field1628) {
                this.Field1630 = true;
            }
        }
    }

    public boolean Method345(float f) {
        return this.Field1626.Method50((long)f) && this.Field1630;
    }

    public void Method347() {
        this.Field1626.Method47();
    }
}
