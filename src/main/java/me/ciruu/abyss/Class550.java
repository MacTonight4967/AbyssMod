package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Class139;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class522;
import me.ciruu.abyss.Class70;
import me.ciruu.abyss.Class71;
import me.ciruu.abyss.Class72;
import me.ciruu.abyss.Class74;
import me.ciruu.abyss.Class75;
import me.ciruu.abyss.settings.Setting;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;

public final class Class550
implements Class70 {
    private int Field2852;
    private int Field2853;
    private final int Field2854 = 16;
    private boolean Field2855;
    @NotNull
    private final Class71 Field2856;
    @NotNull
    private final Setting Field2857;

    @NotNull
    public final String Method3440() {
        return this.Method3442().Method396().toString() + " " + ChatFormatting.GRAY + (Enum)this.Method3442().getValue();
    }

    public int Method3445() {
        return this.Field2852;
    }

    public void Method3446(int n) {
        this.Field2852 = n;
    }

    public int Method3447() {
        return this.Field2853;
    }

    public void Method3448(int n) {
        this.Field2853 = n;
    }

    public int Method3449() {
        return this.Method3450().Method157();
    }

    public int Method3451() {
        return this.Field2854;
    }

    public boolean Method3452() {
        return this.Field2855;
    }

    public void Method3453(boolean bl) {
        this.Field2855 = bl;
    }

    public int Method3454() {
        return Class36.Method259("> " + this.Method3440()) + 5;
    }

    @Class72
    public void Method3455() {
        if (this.Method3452()) {
            return;
        }
        Gui.drawRect((int)this.Method3456(), (int)this.Method3457(), (int)(this.Method3456() + this.Method3450().Method157()), (int)(this.Method3457() + 16), (int)Class74.Field172.Method165().getRGB());
        Class36.Method63("> " + this.Method3440(), this.Method3456() + 2, this.Method3457() + 4, -1);
    }

    public void Method3460(int n, int n2, int n3) {
        if (this.Method3461(n, n2) && this.Method3450().Method175()) {
            if (n3 == 0) {
                this.Method3442().Method3463(this.Method3442().Method3462(false));
                AbyssMod.EVENT_BUS.post(new Class139(this.Method3450().Method159()));
                AbyssMod.EVENT_BUS.post(new Class522());
            }
            if (n3 == 1) {
                this.Method3442().Method3463(this.Method3442().Method3462(true));
                AbyssMod.EVENT_BUS.post(new Class139(this.Method3450().Method159()));
                AbyssMod.EVENT_BUS.post(new Class522());
            }
        }
    }

    @NotNull
    public Class71 Method3450() {
        return this.Field2856;
    }

    public Class70 Method3465() {
        return this.Method3450();
    }

    @NotNull
    public Setting Method3442() {
        return this.Field2857;
    }

    public Class550(@NotNull Class71 class71, @NotNull Setting setting) {
        this.Field2856 = class71;
        this.Field2857 = setting;
        this.Field2854 = 16;
    }

    public int Method3456() {
        return Class75.Method184(this);
    }

    public int Method3457() {
        return Class75.Method185(this);
    }

    public void Method3466(int n, int n2) {
        Class75.Method433(this, n, n2);
    }

    public void Method3467(int n, int n2, int n3) {
        Class75.Method187(this, n, n2, n3);
    }

    public void Method3468(int n, int n2, int n3, long l) {
        Class75.Method189(this, n, n2, n3, l);
    }

    public void Method3469(char c, int n) {
        Class75.Method1622(this, c, n);
    }

    public void Method3470(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method3461(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }
}
