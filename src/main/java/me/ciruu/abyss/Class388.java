package me.ciruu.abyss;

import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class70;
import me.ciruu.abyss.Class71;
import me.ciruu.abyss.Class72;
import me.ciruu.abyss.Class74;
import me.ciruu.abyss.Class75;
import me.ciruu.abyss.settings.Setting;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

public final class Class388
implements Class70 {
    private int Field1277;
    private int Field1278;
    private final int Field1279 = 16;
    private boolean Field1280;
    @NotNull
    private final Class71 Field1281;
    @NotNull
    private final Setting Field1282;

    public int Method1597() {
        return this.Field1277;
    }

    public void Method1598(int n) {
        this.Field1277 = n;
    }

    public int Method1599() {
        return this.Field1278;
    }

    public void Method1600(int n) {
        this.Field1278 = n;
    }

    public int Method1601() {
        return this.Method1602().Method157();
    }

    public int Method1603() {
        return this.Field1279;
    }

    public boolean Method1604() {
        return this.Field1280;
    }

    public void Method1605(boolean bl) {
        this.Field1280 = bl;
    }

    public int Method1606() {
        return Class36.Method259(((Class25)this.Method1607().getValue()).Method1608());
    }

    @Class72
    public void Method1609() {
        if (this.Method1604()) {
            return;
        }
        GL11.glLineWidth((float)1.0f);
        Gui.drawRect((int)this.Method1611(), (int)this.Method1612(), (int)(this.Method1611() + this.Method1602().Method157()), (int)(this.Method1612() + 16), (int)Class74.Field172.Method165().getRGB());
        Class36.Method63(((Class25)this.Method1607().getValue()).Method1608(), this.Method1611() + 2, this.Method1612() + 4, Class74.Field172.Method171().getRGB());
    }

    @NotNull
    public Class71 Method1602() {
        return this.Field1281;
    }

    public Class70 Method1615() {
        return this.Method1602();
    }

    @NotNull
    public Setting Method1607() {
        return this.Field1282;
    }

    public Class388(@NotNull Class71 class71, @NotNull Setting setting) {
        this.Field1281 = class71;
        this.Field1282 = setting;
        this.Field1279 = 16;
    }

    public int Method1611() {
        return Class75.Method184(this);
    }

    public int Method1612() {
        return Class75.Method185(this);
    }

    public void Method1616(int n, int n2) {
        Class75.Method433(this, n, n2);
    }

    public void Method1617(int n, int n2, int n3) {
        Class75.Method1618(this, n, n2, n3);
    }

    public void Method1619(int n, int n2, int n3) {
        Class75.Method187(this, n, n2, n3);
    }

    public void Method1620(int n, int n2, int n3, long l) {
        Class75.Method189(this, n, n2, n3, l);
    }

    public void Method1621(char c, int n) {
        Class75.Method1622(this, c, n);
    }

    public void Method1623(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method1624(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }
}
