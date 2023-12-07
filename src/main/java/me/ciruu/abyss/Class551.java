package me.ciruu.abyss;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
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

public final class Class551
implements Class70 {
    private int Field3455;
    private int Field3456;
    private final int Field3457 = 16;
    private boolean Field3458;
    private boolean Field3459;
    @NotNull
    private String Field3460;
    @NotNull
    private final Class71 Field3461;
    @NotNull
    private final Setting Field3462;

    public int Method4173() {
        return this.Field3455;
    }

    public void Method4174(int n) {
        this.Field3455 = n;
    }

    public int Method4175() {
        return this.Field3456;
    }

    public void Method4176(int n) {
        this.Field3456 = n;
    }

    public int Method4177() {
        return this.Method4178().Method157();
    }

    public int Method4179() {
        return this.Field3457;
    }

    public boolean Method4180() {
        return this.Field3458;
    }

    public void Method4181(boolean bl) {
        this.Field3458 = bl;
    }

    @NotNull
    public final String Method4182() {
        return this.Field3460;
    }

    public final void Method4183(@NotNull String string) {
        this.Field3460 = string;
    }

    public int Method4184() {
        return Class36.Method259("> " + this.Method4187().Method396());
    }

    @Class72
    public void Method4188() {
        GL11.glLineWidth((float)1.0f);
        Gui.drawRect((int)this.Method4190(), (int)this.Method4191(), (int)(this.Method4190() + this.Method4178().Method157()), (int)(this.Method4191() + 16), (int)(this.Field3459 ? Class74.Field172.Method413().getRGB() : Class74.Field172.Method165().getRGB()));
        Class36.Method63("> " + this.Method4187().Method396() + ": " + (String)this.Method4187().getValue(), this.Method4190() + 2, this.Method4191() + 4, Class74.Field172.Method171().getRGB());
    }

    public void Method4194(int n, int n2, int n3) {
        if (this.Method4195(n, n2) && n3 == 0 && this.Method4178().Method175()) {
            this.Field3459 = !this.Field3459;
        }
    }

    public void Method4196(char c, int n) {
        if (this.Field3459) {
            if (n != 0) {
                if (n != 28 && n != 14 && n != 42 && n != 58) {
                    this.Field3460 = this.Field3460 + c;
                    this.Method4187().setValue(this.Field3460);
                }
                if (n == 14) {
                    CharSequence charSequence = this.Field3460;
                    int n2 = 0;
                    if (charSequence.length() > 0) {
                        String string;
                        charSequence = this.Field3460;
                        n2 = 0;
                        int n3 = this.Field3460.length() - 1;
                        Class551 class551 = this;
                        boolean bl = false;
                        CharSequence charSequence2 = charSequence;
                        if (charSequence2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String string2 = ((String)charSequence2).substring(n2, n3);
                        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        class551.Field3460 = string = string2;
                        this.Method4187().setValue(this.Field3460);
                    }
                }
                if (n == 28 || n == 1) {
                    this.Field3459 = false;
                    this.Field3460 = "";
                }
            }
            if (n == 0) {
                this.Field3459 = false;
            }
        }
    }

    @NotNull
    public Class71 Method4178() {
        return this.Field3461;
    }

    public Class70 Method4202() {
        return this.Method4178();
    }

    @NotNull
    public Setting Method4187() {
        return this.Field3462;
    }

    public Class551(@NotNull Class71 class71, @NotNull Setting setting) {
        this.Field3461 = class71;
        this.Field3462 = setting;
        this.Field3457 = 16;
        this.Field3460 = "";
    }

    public int Method4190() {
        return Class75.Method184(this);
    }

    public int Method4191() {
        return Class75.Method185(this);
    }

    public void Method4203(int n, int n2) {
        Class75.Method433(this, n, n2);
    }

    public void Method4204(int n, int n2, int n3) {
        Class75.Method187(this, n, n2, n3);
    }

    public void Method4205(int n, int n2, int n3, long l) {
        Class75.Method189(this, n, n2, n3, l);
    }

    public void Method4206(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method4195(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }
}
