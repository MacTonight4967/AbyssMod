package me.ciruu.abyss;

import me.ciruu.abyss.Class207;
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

public final class Class552
implements Class70 {
    private int Field3423;
    private int Field3424;
    private final int Field3425 = 16;
    private boolean Field3426;
    private boolean Field3427;
    @NotNull
    private final Class71 Field3428;
    @NotNull
    private final Setting Field3429;

    public int Method4119() {
        return this.Field3423;
    }

    public void Method4120(int n) {
        this.Field3423 = n;
    }

    public int Method4121() {
        return this.Field3424;
    }

    public void Method4122(int n) {
        this.Field3424 = n;
    }

    public int Method4123() {
        return this.Method4124().Method157();
    }

    public int Method4125() {
        return this.Field3425;
    }

    public boolean Method4126() {
        return this.Field3426;
    }

    public void Method4127(boolean bl) {
        this.Field3426 = bl;
    }

    public int Method4128() {
        return Class36.Method259("> " + this.Method4131().Method396());
    }

    @Class72
    public void Method4132() {
        GL11.glLineWidth((float)1.0f);
        Gui.drawRect((int)this.Method4134(), (int)this.Method4135(), (int)(this.Method4134() + this.Method4124().Method157()), (int)(this.Method4135() + 16), (int)(this.Field3427 ? Class74.Field172.Method413().getRGB() : Class74.Field172.Method165().getRGB()));
        Class36.Method63(this.Field3427 ? "> " + this.Method4131().Method396() + ": " + "listening..." : "> " + this.Method4131().Method396() + ": " + (Class207)this.Method4131().getValue(), this.Method4134() + 2, this.Method4135() + 4, Class74.Field172.Method171().getRGB());
    }

    public void Method4139(int n, int n2, int n3) {
        if (this.Method4140(n, n2) && this.Method4124().Method175()) {
            if (n3 == 0) {
                boolean bl = this.Field3427 = !this.Field3427;
            }
            if (n3 == 2) {
                ((Class207)this.Method4131().getValue()).Method977(0);
            }
        }
    }

    public void Method4141(char c, int n) {
        if (this.Field3427) {
            ((Class207)this.Method4131().getValue()).Method977(n);
            this.Field3427 = false;
        }
    }

    @NotNull
    public Class71 Method4124() {
        return this.Field3428;
    }

    public Class70 Method4142() {
        return this.Method4124();
    }

    @NotNull
    public Setting Method4131() {
        return this.Field3429;
    }

    public Class552(@NotNull Class71 class71, @NotNull Setting setting) {
        this.Field3428 = class71;
        this.Field3429 = setting;
        this.Field3425 = 16;
    }

    public int Method4134() {
        return Class75.Method184(this);
    }

    public int Method4135() {
        return Class75.Method185(this);
    }

    public void Method4143(int n, int n2) {
        Class75.Method433(this, n, n2);
    }

    public void Method4144(int n, int n2, int n3) {
        Class75.Method187(this, n, n2, n3);
    }

    public void Method4145(int n, int n2, int n3, long l) {
        Class75.Method189(this, n, n2, n3, l);
    }

    public void Method4146(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method4140(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }
}
