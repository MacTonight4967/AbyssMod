package me.ciruu.abyss;

import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Class139;
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

public final class Class549
implements Class70 {
    private int Field3136;
    private int Field3137;
    private final int Field3138 = 16;
    private boolean Field3139;
    @NotNull
    private final Class71 Field3140;
    @NotNull
    private final Setting Field3141;

    public int Method3768() {
        return this.Field3136;
    }

    public void Method3769(int n) {
        this.Field3136 = n;
    }

    public int Method3770() {
        return this.Field3137;
    }

    public void Method3771(int n) {
        this.Field3137 = n;
    }

    public int Method3772() {
        return this.Method3773().Method157();
    }

    public int Method3774() {
        return this.Field3138;
    }

    public boolean Method3775() {
        return this.Field3139;
    }

    public void Method3776(boolean bl) {
        this.Field3139 = bl;
    }

    public int Method3777() {
        return Class36.Method259("> " + this.Method3780().Method396());
    }

    @Class72
    public void Method3781() {
        if (this.Method3775()) {
            return;
        }
        GL11.glLineWidth((float)1.0f);
        Gui.drawRect((int)this.Method3783(), (int)this.Method3784(), (int)(this.Method3783() + this.Method3773().Method157()), (int)(this.Method3784() + 16), (int)((Boolean)this.Method3780().getValue() != false ? Class74.Field172.Method413().getRGB() : Class74.Field172.Method165().getRGB()));
        Class36.Method63("> " + this.Method3780().Method396(), this.Method3783() + 2, this.Method3784() + 4, Class74.Field172.Method171().getRGB());
    }

    public void Method3788(int n, int n2, int n3) {
        if (this.Method3789(n, n2) && n3 == 0 && this.Method3773().Method175()) {
            this.Method3780().setValue((Boolean)this.Method3780().getValue() == false);
            AbyssMod.EVENT_BUS.post(new Class139(this.Method3773().Method159()));
        }
    }

    @NotNull
    public Class71 Method3773() {
        return this.Field3140;
    }

    public Class70 Method3791() {
        return this.Method3773();
    }

    @NotNull
    public Setting Method3780() {
        return this.Field3141;
    }

    public Class549(@NotNull Class71 class71, @NotNull Setting setting) {
        this.Field3140 = class71;
        this.Field3141 = setting;
        this.Field3138 = 16;
    }

    public int Method3783() {
        return Class75.Method184(this);
    }

    public int Method3784() {
        return Class75.Method185(this);
    }

    public void Method3792(int n, int n2) {
        Class75.Method433(this, n, n2);
    }

    public void Method3793(int n, int n2, int n3) {
        Class75.Method187(this, n, n2, n3);
    }

    public void Method3794(int n, int n2, int n3, long l) {
        Class75.Method189(this, n, n2, n3, l);
    }

    public void Method3795(char c, int n) {
        Class75.Method1622(this, c, n);
    }

    public void Method3796(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method3789(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }
}
