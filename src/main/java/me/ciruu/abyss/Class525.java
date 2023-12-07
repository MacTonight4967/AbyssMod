package me.ciruu.abyss;

import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import me.ciruu.abyss.Class137;
import me.ciruu.abyss.Class140;
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

public final class Class525
implements Class70 {
    private int Field1950;
    private int Field1951;
    private final int Field1952 = 16;
    private boolean Field1953;
    private final Class137 Field1954;
    private boolean Field1955;
    private boolean Field1956;
    private String Field1957;
    @NotNull
    private final Class71 Field1958;
    @NotNull
    private final Setting Field1959;

    public int Method2314() {
        return this.Field1950;
    }

    public void Method2315(int n) {
        this.Field1950 = n;
    }

    public int Method2316() {
        return this.Field1951;
    }

    public void Method2317(int n) {
        this.Field1951 = n;
    }

    public int Method2318() {
        return this.Method2319().Method157();
    }

    public int Method2320() {
        return this.Field1952;
    }

    public boolean Method2321() {
        return this.Field1953;
    }

    public void Method2322(boolean bl) {
        this.Field1953 = bl;
    }

    private final int Method2323() {
        return ((Number)this.Method2324().Method386()).intValue();
    }

    private final int Method2326() {
        return ((Number)this.Method2324().Method389()).intValue();
    }

    private final int Method2327() {
        return ((Number)this.Method2324().getValue()).intValue();
    }

    private final void Method2328(int n) {
        this.Method2324().setValue(n);
    }

    public int Method2329() {
        CharSequence charSequence = this.Field1957;
        StringBuilder stringBuilder = new StringBuilder().append("> ").append(this.Method2324().Method396()).append(": ");
        boolean bl = false;
        boolean bl2 = charSequence.length() > 0;
        return Class36.Method259(stringBuilder.append(bl2 ? this.Field1957 : String.valueOf(((Number)this.Method2324().getValue()).intValue())).toString()) + 5;
    }

    @Class72
    public void Method2333() {
        Object object = this.Field1954;
        boolean bl = false;
        boolean bl2 = false;
        Class137 class137 = object;
        boolean bl3 = false;
        class137.Method403(this.Method2334());
        class137.Method405(this.Method2335());
        class137.Method406(this.Method2318());
        class137.Method407(this.Method2320());
        GL11.glLineWidth((float)1.0f);
        Gui.drawRect((int)this.Method2334(), (int)this.Method2335(), (int)(this.Method2334() + this.Method2319().Method157()), (int)(this.Method2335() + 16), (int)Class74.Field172.Method165().getRGB());
        Gui.drawRect((int)this.Method2334(), (int)this.Method2335(), (int)(this.Method2334() + (int)((float)this.Method2319().Method157() * this.Method2339())), (int)(this.Method2335() + 16), (int)(this.Field1955 ? Class74.Field172.Method412().getRGB() : Class74.Field172.Method413().getRGB()));
        object = this.Field1957;
        StringBuilder stringBuilder = new StringBuilder().append("> ").append(this.Method2324().Method396()).append(": ");
        bl = false;
        boolean bl4 = object.length() > 0;
        Class36.Method63(stringBuilder.append(bl4 ? this.Field1957 : String.valueOf(((Number)this.Method2324().getValue()).intValue())).toString(), this.Method2334() + 2, this.Method2335() + 4, Class74.Field172.Method171().getRGB());
    }

    public void Method2340(int n, int n2, int n3) {
        if (!this.Method2319().Method175()) {
            return;
        }
        if (this.Method2341(n, n2)) {
            this.Field1955 = true;
            this.Field1956 = true;
            if (n3 == 0 && this.Method2319().Method175()) {
                this.Method2342(n, n2);
            }
        } else {
            this.Field1955 = false;
            this.Field1957 = "";
        }
    }

    private final void Method2343(float f) {
        this.Method2328(MathKt.roundToInt((float)this.Method2323() + (float)(this.Method2326() - this.Method2323()) * RangesKt.coerceIn(f, 0.0f, 1.0f)));
    }

    private final float Method2339() {
        return (float)(this.Method2327() - this.Method2323()) / (float)(this.Method2326() - this.Method2323());
    }

    public void Method2346(int n, int n2, int n3, long l) {
        if (!this.Method2319().Method175()) {
            return;
        }
        if (n3 == 0 && this.Method2319().Method175() && this.Field1956) {
            this.Method2342(n, n2);
        }
    }

    public void Method2347(int n, int n2, int n3) {
        this.Field1956 = false;
    }

    private final void Method2342(int n, int n2) {
        Pair pair = this.Field1954.Method421(n, n2, false);
        if (pair != null) {
            this.Method2343(((Number)pair.getFirst()).floatValue());
        }
    }

    public void Method2350(char c, int n) {
        if (this.Field1955) {
            if (n != 0) {
                if (Class140.Method425(n) || n == 12) {
                    this.Field1957 = this.Field1957 + c;
                    Integer n2 = StringsKt.toIntOrNull(this.Field1957);
                    this.Method2328(RangesKt.coerceIn(n2 != null ? n2.intValue() : this.Method2327(), this.Method2323(), this.Method2326()));
                }
                if (n == 14) {
                    CharSequence charSequence = this.Field1957;
                    int n3 = 0;
                    if (charSequence.length() > 0) {
                        String string;
                        charSequence = this.Field1957;
                        n3 = 0;
                        int n4 = this.Field1957.length() - 1;
                        Class525 class525 = this;
                        boolean bl = false;
                        CharSequence charSequence2 = charSequence;
                        if (charSequence2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String string2 = ((String)charSequence2).substring(n3, n4);
                        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        class525.Field1957 = string = string2;
                        Integer n5 = StringsKt.toIntOrNull(this.Field1957);
                        this.Method2328(RangesKt.coerceIn(n5 != null ? n5.intValue() : this.Method2327(), this.Method2323(), this.Method2326()));
                    }
                }
                if (n == 28 || n == 1) {
                    this.Field1955 = false;
                    this.Field1957 = "";
                }
            }
            if (n == 0) {
                this.Field1955 = false;
                this.Field1957 = "";
            }
        }
    }

    @NotNull
    public Class71 Method2319() {
        return this.Field1958;
    }

    public Class70 Method2358() {
        return this.Method2319();
    }

    @NotNull
    public Setting Method2324() {
        return this.Field1959;
    }

    public Class525(@NotNull Class71 class71, @NotNull Setting setting) {
        this.Field1958 = class71;
        this.Field1959 = setting;
        this.Field1952 = 16;
        this.Field1954 = new Class137(0, 0, 0, 0, 15, null);
        this.Field1957 = "";
    }

    public int Method2334() {
        return Class75.Method184(this);
    }

    public int Method2335() {
        return Class75.Method185(this);
    }

    public void Method2359(int n, int n2) {
        Class75.Method433(this, n, n2);
    }

    public void Method2360(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method2341(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }
}
