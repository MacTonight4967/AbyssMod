package me.ciruu.abyss;

import java.util.Arrays;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Class137;
import me.ciruu.abyss.Class139;
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

public final class Class136
implements Class70 {
    private int Field318;
    private int Field319;
    private final int Field320 = 16;
    private boolean Field321;
    private final Class137 Field322;
    private boolean Field323;
    private boolean Field324;
    private String Field325;
    @NotNull
    private final Class71 Field326;
    @NotNull
    private final Setting Field327;

    public int Method375() {
        return this.Field318;
    }

    public void Method376(int n) {
        this.Field318 = n;
    }

    public int Method377() {
        return this.Field319;
    }

    public void Method378(int n) {
        this.Field319 = n;
    }

    public int Method379() {
        return this.Method380().Method157();
    }

    public int Method381() {
        return this.Field320;
    }

    public boolean Method382() {
        return this.Field321;
    }

    public void Method383(boolean bl) {
        this.Field321 = bl;
    }

    private final float Method384() {
        return ((Number)this.Method385().Method386()).floatValue();
    }

    private final float Method388() {
        return ((Number)this.Method385().Method389()).floatValue();
    }

    private final float Method390() {
        return ((Number)this.Method385().getValue()).floatValue();
    }

    private final void Method391(float f) {
        this.Method385().setValue(Float.valueOf(f));
    }

    public int Method393() {
        String string;
        CharSequence charSequence = this.Field325;
        StringBuilder stringBuilder = new StringBuilder().append("> ").append(this.Method385().Method396()).append(": ");
        boolean bl = false;
        boolean bl2 = charSequence.length() > 0;
        StringBuilder stringBuilder2 = stringBuilder;
        if (bl2) {
            string = this.Field325;
        } else {
            charSequence = "%.3f";
            Object[] objectArray = new Object[]{Float.valueOf(((Number)this.Method385().getValue()).floatValue())};
            stringBuilder = stringBuilder2;
            boolean bl3 = false;
            String string2 = String.format((String)charSequence, Arrays.copyOf(objectArray, objectArray.length));
            Intrinsics.checkExpressionValueIsNotNull(string2, "java.lang.String.format(this, *args)");
            String string3 = string2;
            stringBuilder2 = stringBuilder;
            string = string3;
        }
        return Class36.Method259(stringBuilder2.append(string).toString()) + 5;
    }

    @Class72
    public void Method401() {
        String string;
        Object object = this.Field322;
        boolean bl = false;
        boolean bl2 = false;
        Class137 class137 = object;
        boolean bl3 = false;
        class137.Method403(this.Method402());
        class137.Method405(this.Method404());
        class137.Method406(this.Method379());
        class137.Method407(this.Method381());
        GL11.glLineWidth((float)1.0f);
        Gui.drawRect((int)this.Method402(), (int)this.Method404(), (int)(this.Method402() + this.Method380().Method157()), (int)(this.Method404() + 16), (int)Class74.Field172.Method165().getRGB());
        Gui.drawRect((int)this.Method402(), (int)this.Method404(), (int)(this.Method402() + (int)((float)this.Method380().Method157() * this.Method411())), (int)(this.Method404() + 16), (int)(this.Field323 ? Class74.Field172.Method412().getRGB() : Class74.Field172.Method413().getRGB()));
        object = this.Field325;
        StringBuilder stringBuilder = new StringBuilder().append("> ").append(this.Method385().Method396()).append(": ");
        bl = false;
        boolean bl4 = object.length() > 0;
        StringBuilder stringBuilder2 = stringBuilder;
        if (bl4) {
            string = this.Field325;
        } else {
            object = "%.3f";
            Object[] objectArray = new Object[]{Float.valueOf(((Number)this.Method385().getValue()).floatValue())};
            stringBuilder = stringBuilder2;
            bl2 = false;
            String string2 = String.format((String)object, Arrays.copyOf(objectArray, objectArray.length));
            Intrinsics.checkExpressionValueIsNotNull(string2, "java.lang.String.format(this, *args)");
            String string3 = string2;
            stringBuilder2 = stringBuilder;
            string = string3;
        }
        Class36.Method63(stringBuilder2.append(string).toString(), this.Method402() + 2, this.Method404() + 4, Class74.Field172.Method171().getRGB());
    }

    public void Method414(int n, int n2, int n3) {
        if (!this.Method380().Method175()) {
            return;
        }
        if (this.Method415(n, n2)) {
            this.Field323 = true;
            this.Field324 = true;
            if (n3 == 0 && this.Method380().Method175()) {
                this.Method416(n, n2);
            }
        } else {
            this.Field323 = false;
            this.Field325 = "";
        }
    }

    private final void Method417(float f) {
        this.Method391(this.Method384() + (this.Method388() - this.Method384()) * RangesKt.coerceIn(f, 0.0f, 1.0f));
    }

    private final float Method411() {
        return (this.Method390() - this.Method384()) / (this.Method388() - this.Method384());
    }

    public void Method419(int n, int n2, int n3, long l) {
        if (!this.Method380().Method175()) {
            return;
        }
        if (n3 == 0 && this.Method380().Method175() && this.Field324) {
            this.Method416(n, n2);
        }
    }

    public void Method420(int n, int n2, int n3) {
        this.Field324 = false;
    }

    private final void Method416(int n, int n2) {
        Pair pair = this.Field322.Method421(n, n2, false);
        if (pair != null) {
            this.Method417(((Number)pair.getFirst()).floatValue());
            AbyssMod.EVENT_BUS.post(new Class139(this.Method380().Method159()));
        }
    }

    public void Method424(char c, int n) {
        if (this.Field323) {
            if (n != 0) {
                if (Class140.Method425(n) || n == 52 || n == 12) {
                    this.Field325 = this.Field325 + c;
                    Float f = StringsKt.toFloatOrNull(this.Field325);
                    this.Method391(RangesKt.coerceIn(f != null ? f.floatValue() : this.Method390(), this.Method384(), this.Method388()));
                    AbyssMod.EVENT_BUS.post(new Class139(this.Method380().Method159()));
                }
                if (n == 14) {
                    CharSequence charSequence = this.Field325;
                    int n2 = 0;
                    if (charSequence.length() > 0) {
                        String string;
                        charSequence = this.Field325;
                        n2 = 0;
                        int n3 = this.Field325.length() - 1;
                        Class136 class136 = this;
                        boolean bl = false;
                        CharSequence charSequence2 = charSequence;
                        if (charSequence2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String string2 = ((String)charSequence2).substring(n2, n3);
                        Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        class136.Field325 = string = string2;
                        Float f = StringsKt.toFloatOrNull(this.Field325);
                        this.Method391(RangesKt.coerceIn(f != null ? f.floatValue() : this.Method390(), this.Method384(), this.Method388()));
                        AbyssMod.EVENT_BUS.post(new Class139(this.Method380().Method159()));
                    }
                }
                if (n == 28 || n == 1) {
                    this.Field323 = false;
                    this.Field325 = "";
                }
            }
            if (n == 0) {
                this.Field323 = false;
                this.Field325 = "";
            }
        }
    }

    @NotNull
    public Class71 Method380() {
        return this.Field326;
    }

    public Class70 Method431() {
        return this.Method380();
    }

    @NotNull
    public Setting Method385() {
        return this.Field327;
    }

    public Class136(@NotNull Class71 class71, @NotNull Setting setting) {
        this.Field326 = class71;
        this.Field327 = setting;
        this.Field320 = 16;
        this.Field322 = new Class137(0, 0, 0, 0, 15, null);
        this.Field325 = "";
    }

    public int Method402() {
        return Class75.Method184(this);
    }

    public int Method404() {
        return Class75.Method185(this);
    }

    public void Method432(int n, int n2) {
        Class75.Method433(this, n, n2);
    }

    public void Method434(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method415(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }
}
