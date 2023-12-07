package me.ciruu.abyss;

import java.awt.Color;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class72;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Class140 {
    @Class72
    public static final void Method606(@NotNull String string, int n, int n2, int n3, int n4) {
        Class36.Method63(string, (float)n - (float)Class36.Method259(string) + (float)n2, n3, n4);
    }

    @Class72
    public static final void Method607(int n, int n2, int n3, int n4, int n5) {
        Class140.Method608(n, n2, n3, 1, n5);
        Class140.Method608(n, n2 + n4 - 1, n3, n4, n5);
        Class140.Method608(n, n2, 1, n4, n5);
        Class140.Method608(n + n3 - 1, n2 + 1, n3, n4, n5);
    }

    @Class72
    public static final void Method608(int n, int n2, int n3, int n4, int n5) {
        Gui.drawRect((int)n, (int)n2, (int)(n + n3), (int)(n2 + n4), (int)n5);
    }

    @Class72
    public static final void Method610(int n, int n2, int n3, float f, @NotNull Color color) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((double)n, (double)n2, (double)0.0);
        GlStateManager.rotate((float)(f + 180.0f), (float)0.0f, (float)0.0f, (float)-1.0f);
        GlStateManager.scale((float)n3, (float)n3, (float)1.0f);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(0.5, -0.25, 0.0).endVertex();
        bufferBuilder.pos(-0.5, -0.25, 0.0).endVertex();
        bufferBuilder.pos(0.0, 0.5, 0.0).endVertex();
        bufferBuilder.pos(0.0, 0.5, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Class72
    public static final void Method632(int n, int n2, int n3, int n4, @NotNull String string, float f) {
        Minecraft.instance.getTextureManager().bindTexture(new ResourceLocation("abyss", string));
        Gui.drawScaledCustomSizeModalRect((int)n, (int)n2, (float)0.0f, (float)0.0f, (int)((int)f), (int)((int)f), (int)(n + n3), (int)(n2 + n4), (float)f, (float)f);
    }

    public static void Method636(int n, int n2, int n3, int n4, String string, float f, int n5, Object object) {
        if ((n5 & 0x20) != 0) {
            f = 16.0f;
        }
        Class140.Method632(n, n2, n3, n4, string, f);
    }

    @Class72
    @Nullable
    public static final Pair Method637(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5 - f;
        float f8 = f6 - f2;
        float f9 = f7 / f3;
        float f10 = f8 / f4;
        float f11 = f10;
        if (f11 >= 0.0f && f11 <= 1.0f && (f11 = f9) >= 0.0f && f11 <= 1.0f) {
            return TuplesKt.to(Float.valueOf(f9), Float.valueOf(f10));
        }
        return null;
    }

    @Class72
    @Nullable
    public static final Pair Method639(int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        float f;
        float f2;
        int n7 = n5 - n;
        int n8 = n6 - n2;
        float f3 = (float)n7 / (float)n3;
        float f4 = (float)n8 / (float)n4;
        if (!(!bl || (f2 = f4) >= 0.0f && f2 <= 1.0f && (f = f3) >= 0.0f && f <= 1.0f)) {
            return null;
        }
        return TuplesKt.to(Float.valueOf(f3), Float.valueOf(f4));
    }

    public static Pair Method640(int n, int n2, int n3, int n4, int n5, int n6, boolean bl, int n7, Object object) {
        if ((n7 & 0x40) != 0) {
            bl = true;
        }
        return Class140.Method639(n, n2, n3, n4, n5, n6, bl);
    }

    @Class72
    @NotNull
    public static final Color Method641(@NotNull Color color, float f) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)((float)255 * f));
    }

    @Class72
    @NotNull
    public static final String Method642(@NotNull Color color) {
        boolean bl = false;
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = false;
        boolean bl3 = false;
        StringBuilder stringBuilder2 = stringBuilder;
        boolean bl4 = false;
        int n = color.getRed();
        int n2 = 16;
        StringBuilder stringBuilder3 = stringBuilder2;
        boolean bl5 = false;
        String string = Integer.toString(n, CharsKt.checkRadix(n2));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        String string2 = string;
        String string3 = StringsKt.padStart(string2, 2, '0');
        n2 = 0;
        String string4 = string3;
        if (string4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string5 = string4.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(string5, "(this as java.lang.String).toUpperCase()");
        string2 = string5;
        stringBuilder3.append(string2);
        int n3 = color.getGreen();
        n2 = 16;
        stringBuilder3 = stringBuilder2;
        bl5 = false;
        String string6 = Integer.toString(n3, CharsKt.checkRadix(n2));
        Intrinsics.checkExpressionValueIsNotNull(string6, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        string2 = string6;
        String string7 = StringsKt.padStart(string2, 2, '0');
        n2 = 0;
        String string8 = string7;
        if (string8 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string9 = string8.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(string9, "(this as java.lang.String).toUpperCase()");
        string2 = string9;
        stringBuilder3.append(string2);
        int n4 = color.getBlue();
        n2 = 16;
        stringBuilder3 = stringBuilder2;
        bl5 = false;
        String string10 = Integer.toString(n4, CharsKt.checkRadix(n2));
        Intrinsics.checkExpressionValueIsNotNull(string10, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        string2 = string10;
        String string11 = StringsKt.padStart(string2, 2, '0');
        n2 = 0;
        String string12 = string11;
        if (string12 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string13 = string12.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(string13, "(this as java.lang.String).toUpperCase()");
        string2 = string13;
        stringBuilder3.append(string2);
        int n5 = color.getAlpha();
        n2 = 16;
        stringBuilder3 = stringBuilder2;
        bl5 = false;
        String string14 = Integer.toString(n5, CharsKt.checkRadix(n2));
        Intrinsics.checkExpressionValueIsNotNull(string14, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        string2 = string14;
        String string15 = StringsKt.padStart(string2, 2, '0');
        n2 = 0;
        String string16 = string15;
        if (string16 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string17 = string16.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(string17, "(this as java.lang.String).toUpperCase()");
        string2 = string17;
        stringBuilder3.append(string2);
        String string18 = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string18, "StringBuilder().apply(builderAction).toString()");
        return string18;
    }

    @Class72
    @Nullable
    public static final Color Method649(@NotNull String string) {
        String string2;
        int n;
        int n2;
        String string3;
        int n3;
        int n4 = 255;
        String string4 = string;
        if (StringsKt.startsWith$default(string4, "#", false, 2, null)) {
            String string5 = string4;
            int n5 = 1;
            n3 = 0;
            String string6 = string5;
            if (string6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string7 = string6.substring(n5);
            Intrinsics.checkExpressionValueIsNotNull(string7, "(this as java.lang.String).substring(startIndex)");
            string4 = string3 = string7;
        }
        switch (string4.length()) {
            case 3: {
                boolean bl = false;
                StringBuilder stringBuilder = new StringBuilder();
                n3 = 0;
                n2 = 0;
                StringBuilder stringBuilder2 = stringBuilder;
                n = 0;
                stringBuilder2.append(string4.charAt(0));
                stringBuilder2.append(string4.charAt(0));
                stringBuilder2.append(string4.charAt(1));
                stringBuilder2.append(string4.charAt(1));
                stringBuilder2.append(string4.charAt(2));
                stringBuilder2.append(string4.charAt(2));
                String string8 = stringBuilder.toString();
                Intrinsics.checkExpressionValueIsNotNull(string8, "StringBuilder().apply(builderAction).toString()");
                string2 = string3 = string8;
                break;
            }
            case 6: {
                string2 = string4;
                break;
            }
            case 8: {
                string2 = string4;
                break;
            }
            default: {
                return null;
            }
        }
        String string9 = string4 = string2;
        n3 = 0;
        n2 = 2;
        int n6 = 0;
        String string10 = string9;
        if (string10 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string11 = string10.substring(n3, n2);
        Intrinsics.checkExpressionValueIsNotNull(string11, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        string9 = string11;
        n3 = 16;
        n2 = 0;
        int n7 = Integer.parseInt(string9, CharsKt.checkRadix(n3));
        String string12 = string4;
        n2 = 2;
        n6 = 4;
        n = 0;
        String string13 = string12;
        if (string13 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string14 = string13.substring(n2, n6);
        Intrinsics.checkExpressionValueIsNotNull(string14, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        string12 = string14;
        n2 = 16;
        n6 = 0;
        int n8 = Integer.parseInt(string12, CharsKt.checkRadix(n2));
        String string15 = string4;
        n6 = 4;
        n = 6;
        boolean bl = false;
        String string16 = string15;
        if (string16 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string17 = string16.substring(n6, n);
        Intrinsics.checkExpressionValueIsNotNull(string17, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        string15 = string17;
        n6 = 16;
        n = 0;
        int n9 = Integer.parseInt(string15, CharsKt.checkRadix(n6));
        if (string4.length() == 8) {
            string15 = string4;
            n6 = 6;
            n = 8;
            bl = false;
            String string18 = string15;
            if (string18 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string19 = string18.substring(n6, n);
            Intrinsics.checkExpressionValueIsNotNull(string19, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            string15 = string19;
            n6 = 16;
            n = 0;
            n4 = Integer.parseInt(string15, CharsKt.checkRadix(n6));
        }
        return new Color(n7, n8, n9, n4);
    }

    @NotNull
    public static final Enum Method657(@NotNull Enum enum_) {
        boolean bl = false;
        Intrinsics.reifiedOperationMarker(5, "T");
        Enum[] enumArray = new Enum[]{};
        return enumArray[(enum_.ordinal() + 1) % enumArray.length];
    }

    @NotNull
    public static final Enum Method660(@NotNull Enum enum_) {
        boolean bl = false;
        Intrinsics.reifiedOperationMarker(5, "T");
        Enum[] enumArray = new Enum[]{};
        return enumArray[(enumArray.length + enum_.ordinal() - 1) % enumArray.length];
    }

    public static final boolean Method425(int n) {
        return n == 11 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9 || n == 10;
    }
}
