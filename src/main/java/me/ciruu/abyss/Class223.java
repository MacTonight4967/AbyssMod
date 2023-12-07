package me.ciruu.abyss;

import java.awt.Color;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import me.ciruu.abyss.Class137;
import me.ciruu.abyss.Class140;
import me.ciruu.abyss.Class222;
import me.ciruu.abyss.Class224;
import me.ciruu.abyss.Class253;
import me.ciruu.abyss.Class263;
import me.ciruu.abyss.Class305;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class387;
import me.ciruu.abyss.Class394;
import me.ciruu.abyss.Class395;
import me.ciruu.abyss.Class396;
import me.ciruu.abyss.Class397;
import me.ciruu.abyss.Class398;
import me.ciruu.abyss.Class399;
import me.ciruu.abyss.Class400;
import me.ciruu.abyss.Class401;
import me.ciruu.abyss.Class402;
import me.ciruu.abyss.Class403;
import me.ciruu.abyss.Class404;
import me.ciruu.abyss.Class405;
import me.ciruu.abyss.Class70;
import me.ciruu.abyss.Class71;
import me.ciruu.abyss.Class72;
import me.ciruu.abyss.Class74;
import me.ciruu.abyss.Class75;
import me.ciruu.abyss.enums.Class264;
import me.ciruu.abyss.settings.Setting;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

public final class Class223
implements Class70 {
    private int Field1296;
    private int Field1297;
    private final int Field1298 = 170;
    private boolean Field1299;
    private float Field1300;
    private float Field1301;
    private float Field1302;
    private float Field1303;
    private final Class137 Field1304;
    private final Class137 Field1305;
    private final Class137 Field1306;
    private final Class224 Field1307;
    private final Class224 Field1308;
    private final Class224 Field1309;
    private final Class224 Field1310;
    private final Class224 Field1311;
    private final Class224 Field1312;
    private final Class224 Field1313;
    private final Class224 Field1314;
    private final Class137 Field1315;
    private final Class137 Field1316;
    @Nullable
    private Function1 Field1317;
    private Class264 Field1318;
    private boolean Field1319;
    @NotNull
    private final Class71 Field1320;
    @Nullable
    private final Setting Field1321;

    @NotNull
    public final Color Method1651() {
        return Class140.Method641(this.Method1653(this.Field1300, this.Field1301, Color.getHSBColor(this.Field1302, 1.0f, 1.0f)), this.Field1303);
    }

    public int Method1654() {
        return this.Field1296;
    }

    public void Method1655(int n) {
        this.Field1296 = n;
    }

    public int Method1656() {
        return this.Field1297;
    }

    public void Method1657(int n) {
        this.Field1297 = n;
    }

    public int Method1658() {
        return this.Field1298;
    }

    public int Method1659() {
        return this.Field1319 ? 150 : 16;
    }

    public boolean Method1660() {
        return this.Field1299;
    }

    public void Method1661(boolean bl) {
        this.Field1299 = bl;
    }

    @Nullable
    public final Function1 Method1662() {
        return this.Field1317;
    }

    public final void Method1663(@Nullable Function1 function1) {
        this.Field1317 = function1;
    }

    public int Method1664() {
        StringBuilder stringBuilder = new StringBuilder().append("> ");
        Setting setting = this.Method1667();
        if (setting == null) {
            Intrinsics.throwNpe();
        }
        return Class36.Method259(stringBuilder.append(setting.Method396()).toString()) + 5;
    }

    @Class72
    public void Method1669() {
        if (!this.Field1319) {
            GL11.glLineWidth((float)1.0f);
            Gui.drawRect((int)this.Method1671(), (int)this.Method1672(), (int)(this.Method1671() + this.Method1673().Method157()), (int)(this.Method1672() + 16), (int)Class74.Field172.Method165().getRGB());
            Gui.drawRect((int)(this.Method1671() + this.Method1673().Method157() - 16), (int)(this.Method1672() + 2), (int)(this.Method1671() + this.Method1673().Method157() - 4), (int)(this.Method1672() + 14), (int)this.Method1651().getRGB());
            StringBuilder stringBuilder = new StringBuilder().append("> ");
            Setting setting = this.Method1667();
            if (setting == null) {
                Intrinsics.throwNpe();
            }
            Class36.Method63(stringBuilder.append(setting.Method396()).toString(), this.Method1671() + 2, this.Method1672() + 4, Class74.Field172.Method171().getRGB());
        } else {
            String string;
            Object object = this.Field1304;
            boolean bl = false;
            boolean bl2 = false;
            Class137 class137 = object;
            boolean bl3 = false;
            class137.Method403(this.Method1671());
            class137.Method405(this.Method1672());
            class137.Method406(this.Method1658());
            class137.Method407(this.Method1659() / 2);
            object = this.Field1305;
            bl = false;
            bl2 = false;
            class137 = object;
            bl3 = false;
            class137.Method403(this.Method1671() + 5 + 26 + 5);
            class137.Method405(this.Method1672() + this.Field1304.Method1676() + 10);
            class137.Method406(this.Method1658() - 5 - 26 - 5 - 5);
            class137.Method407(10);
            object = this.Field1306;
            bl = false;
            bl2 = false;
            class137 = object;
            bl3 = false;
            class137.Method403(this.Method1671() + 5 + 26 + 5);
            class137.Method405(this.Method1672() + this.Field1304.Method1676() + 10 + 16);
            class137.Method406(this.Method1658() - 5 - 26 - 5 - 5);
            class137.Method407(10);
            Class140.Method608(this.Method1671(), this.Method1672(), this.Method1658(), this.Method1659(), Class74.Field172.Method165().getRGB());
            this.Method1680(this.Field1304.Method1677(), this.Field1304.Method1678(), this.Field1304.Method1679(), this.Field1304.Method1676(), Color.getHSBColor(this.Field1302, 1.0f, 1.0f));
            Class140.Method608((int)((float)this.Field1304.Method1677() + (float)this.Field1304.Method1679() * this.Field1300) - 1, (int)((float)this.Field1304.Method1678() + (float)this.Field1304.Method1676() * this.Field1301) - 1, 3, 3, Color.WHITE.getRGB());
            Class140.Method608((int)((float)this.Field1304.Method1677() + (float)this.Field1304.Method1679() * this.Field1300), (int)((float)this.Field1304.Method1678() + (float)this.Field1304.Method1676() * this.Field1301), 1, 1, this.Method1651().getRGB());
            this.Method1681(this.Method1671() + 5, this.Method1672() + this.Field1304.Method1676() + 10, 26, 26);
            Class140.Method608(this.Method1671() + 5, this.Method1672() + this.Field1304.Method1676() + 10, 26, 26, this.Method1651().getRGB());
            this.Method1682(this.Field1305.Method1677(), this.Field1305.Method1678(), this.Field1305.Method1679(), this.Field1305.Method1676());
            Class140.Method608((int)((float)this.Field1305.Method1677() + this.Field1302 * (float)this.Field1305.Method1679()) - 1, this.Field1305.Method1678() - 1, 1, 1, Color.WHITE.getRGB());
            Class140.Method608((int)((float)this.Field1305.Method1677() + this.Field1302 * (float)this.Field1305.Method1679()) - 1, this.Field1305.Method1678() + this.Field1305.Method1676() + 1, 1, 1, Color.WHITE.getRGB());
            this.Method1683(this.Field1306.Method1677(), this.Field1306.Method1678(), this.Field1306.Method1679(), this.Field1306.Method1676());
            Class140.Method608((int)((float)this.Field1306.Method1677() + this.Field1303 * (float)this.Field1306.Method1679()) - 1, this.Field1306.Method1678() - 1, 1, 1, Color.WHITE.getRGB());
            Class140.Method608((int)((float)this.Field1306.Method1677() + this.Field1303 * (float)this.Field1306.Method1679()) - 1, this.Field1306.Method1678() + this.Field1306.Method1676() + 1, 1, 1, Color.WHITE.getRGB());
            switch (Class263.Field706[this.Field1318.ordinal()]) {
                case 1: {
                    string = "HEX";
                    break;
                }
                case 2: {
                    string = "RGBA";
                    break;
                }
                case 3: {
                    string = "HSL";
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            object = string;
            Class36.Method559((String)object, (float)this.Method1671() + (float)this.Method1658() / 2.0f, (float)this.Field1306.Method1685() + 5.0f, Class74.Field172.Method171().getRGB());
            this.Field1315.Method403(this.Method1671() + 5);
            this.Field1315.Method405(this.Field1306.Method1685() + 5);
            this.Field1316.Method403(this.Method1671() + this.Method1658() - 5 - 10);
            this.Field1316.Method405(this.Field1306.Method1685() + 5);
            this.Field1315.Method1686(Color.GRAY);
            this.Field1316.Method1686(Color.GRAY);
            Class140.Method610(this.Field1315.Method1677() + 5, this.Field1315.Method1678() + 5, 6, 90.0f, Class74.Field172.Method171());
            Class140.Method610(this.Field1316.Method1677() + 5, this.Field1316.Method1678() + 5, 6, -90.0f, Class74.Field172.Method171());
            this.Field1307.Method1687(false);
            this.Field1308.Method1687(false);
            this.Field1309.Method1687(false);
            this.Field1310.Method1687(false);
            this.Field1311.Method1687(false);
            this.Field1312.Method1687(false);
            this.Field1313.Method1687(false);
            this.Field1314.Method1687(false);
            switch (Class263.Field707[this.Field1318.ordinal()]) {
                case 1: {
                    this.Field1307.Method1687(true);
                    break;
                }
                case 2: {
                    this.Field1308.Method1687(true);
                    this.Field1309.Method1687(true);
                    this.Field1310.Method1687(true);
                    this.Field1314.Method1687(true);
                    break;
                }
                case 3: {
                    this.Field1311.Method1687(true);
                    this.Field1312.Method1687(true);
                    this.Field1313.Method1687(true);
                    this.Field1314.Method1687(true);
                }
            }
            Class137 class1372 = this.Field1307.Method1688();
            bl2 = false;
            boolean bl4 = false;
            Class137 class1373 = class1372;
            boolean bl5 = false;
            class1373.Method403(this.Method1671() + (this.Method1658() - 70) / 2);
            class1373.Method405(this.Field1306.Method1678() + 32);
            class1373.Method406(70);
            class1373.Method407(12);
            class1372 = this.Field1308.Method1688();
            bl2 = false;
            bl4 = false;
            class1373 = class1372;
            bl5 = false;
            class1373.Method403(this.Method1671() + 6);
            class1373.Method405(this.Field1306.Method1678() + 32);
            class1373.Method406(35);
            class1373.Method407(12);
            class1372 = this.Field1309.Method1688();
            bl2 = false;
            bl4 = false;
            class1373 = class1372;
            bl5 = false;
            class1373.Method403(this.Method1671() + 47);
            class1373.Method405(this.Field1306.Method1678() + 32);
            class1373.Method406(35);
            class1373.Method407(12);
            class1372 = this.Field1310.Method1688();
            bl2 = false;
            bl4 = false;
            class1373 = class1372;
            bl5 = false;
            class1373.Method403(this.Method1671() + 88);
            class1373.Method405(this.Field1306.Method1678() + 32);
            class1373.Method406(35);
            class1373.Method407(12);
            class1372 = this.Field1311.Method1688();
            bl2 = false;
            bl4 = false;
            class1373 = class1372;
            bl5 = false;
            class1373.Method403(this.Method1671() + 6);
            class1373.Method405(this.Field1306.Method1678() + 32);
            class1373.Method406(35);
            class1373.Method407(12);
            class1372 = this.Field1312.Method1688();
            bl2 = false;
            bl4 = false;
            class1373 = class1372;
            bl5 = false;
            class1373.Method403(this.Method1671() + 47);
            class1373.Method405(this.Field1306.Method1678() + 32);
            class1373.Method406(35);
            class1373.Method407(12);
            class1372 = this.Field1313.Method1688();
            bl2 = false;
            bl4 = false;
            class1373 = class1372;
            bl5 = false;
            class1373.Method403(this.Method1671() + 88);
            class1373.Method405(this.Field1306.Method1678() + 32);
            class1373.Method406(35);
            class1373.Method407(12);
            class1372 = this.Field1314.Method1688();
            bl2 = false;
            bl4 = false;
            class1373 = class1372;
            bl5 = false;
            class1373.Method403(this.Method1671() + 129);
            class1373.Method405(this.Field1306.Method1678() + 32);
            class1373.Method406(35);
            class1373.Method407(12);
            this.Field1307.Method1689();
            this.Field1308.Method1689();
            this.Field1309.Method1689();
            this.Field1310.Method1689();
            this.Field1311.Method1689();
            this.Field1312.Method1689();
            this.Field1313.Method1689();
            this.Field1314.Method1689();
        }
    }

    @Class72
    private final void Method1681(int n, int n2, int n3, int n4) {
        int n5 = n3 / 2;
        int n6 = n4 / 2;
        Color color = new Color(200, 200, 200);
        Color color2 = new Color(150, 150, 150);
        Class140.Method608(n, n2, n5, n6, color.getRGB());
        Class140.Method608(n + n5, n2, n5, n6, color2.getRGB());
        Class140.Method608(n, n2 + n6, n5, n6, color2.getRGB());
        Class140.Method608(n + n5, n2 + n6, n5, n6, color.getRGB());
    }

    @Class72
    private final void Method1680(int n, int n2, int n3, int n4, Color color) {
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.shadeModel((int)7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        boolean bl = false;
        boolean bl2 = false;
        BufferBuilder bufferBuilder2 = bufferBuilder;
        boolean bl3 = false;
        bufferBuilder2.begin(7, DefaultVertexFormats.POSITION_COLOR);
        int n5 = 32;
        int n6 = 16;
        double d = (double)n3 / (double)n5;
        double d2 = (double)n4 / (double)n6;
        boolean bl4 = false;
        int n7 = 0;
        int n8 = n5;
        for (n7 = 0; n7 < n8; ++n7) {
            int n9 = n7;
            boolean bl5 = false;
            int n10 = n6;
            boolean bl6 = false;
            int n11 = 0;
            n11 = 0;
            int n12 = n10;
            while (n11 < n12) {
                int n13 = n11++;
                boolean bl7 = false;
                double d3 = (double)n + (double)n9 * d;
                double d4 = (double)n + (double)(n9 + 1) * d;
                double d5 = (double)n2 + (double)(n13 + 1) * d2;
                double d6 = (double)n2 + (double)n13 * d2;
                Color color2 = this.Method1653((float)(n9 + 1) / (float)n5, (float)n13 / (float)n6, color);
                Color color3 = this.Method1653((float)n9 / (float)n5, (float)n13 / (float)n6, color);
                Color color4 = this.Method1653((float)n9 / (float)n5, (float)(n13 + 1) / (float)n6, color);
                Color color5 = this.Method1653((float)(n9 + 1) / (float)n5, (float)(n13 + 1) / (float)n6, color);
                bufferBuilder2.pos(d4, d6, 0.0).color((float)color2.getRed() / 255.0f, (float)color2.getGreen() / 255.0f, (float)color2.getBlue() / 255.0f, 1.0f).endVertex();
                bufferBuilder2.pos(d3, d6, 0.0).color((float)color3.getRed() / 255.0f, (float)color3.getGreen() / 255.0f, (float)color3.getBlue() / 255.0f, 1.0f).endVertex();
                bufferBuilder2.pos(d3, d5, 0.0).color((float)color4.getRed() / 255.0f, (float)color4.getGreen() / 255.0f, (float)color4.getBlue() / 255.0f, 1.0f).endVertex();
                bufferBuilder2.pos(d4, d5, 0.0).color((float)color5.getRed() / 255.0f, (float)color5.getGreen() / 255.0f, (float)color5.getBlue() / 255.0f, 1.0f).endVertex();
            }
        }
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    @Class72
    private final Color Method1653(float f, float f2, Color color) {
        Color color2 = this.Method1708(Color.WHITE, color, f);
        return this.Method1708(color2, Color.BLACK, f2);
    }

    @Class72
    private final Color Method1708(Color color, Color color2, float f) {
        return new Color(MathKt.roundToInt(this.Method1709(color.getRed(), color2.getRed(), f)), MathKt.roundToInt(this.Method1709(color.getGreen(), color2.getGreen(), f)), MathKt.roundToInt(this.Method1709(color.getBlue(), color2.getBlue(), f)), MathKt.roundToInt(this.Method1709(color.getAlpha(), color2.getAlpha(), f)));
    }

    @Class72
    private final float Method1709(float f, float f2, float f3) {
        return (1.0f - f3) * f + f3 * f2;
    }

    @Class72
    private final void Method1682(int n, int n2, int n3, int n4) {
        double d = n2 + n4;
        double d2 = n2;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.shadeModel((int)7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        boolean bl = false;
        boolean bl2 = false;
        BufferBuilder bufferBuilder2 = bufferBuilder;
        boolean bl3 = false;
        bufferBuilder2.begin(7, DefaultVertexFormats.POSITION_COLOR);
        int n5 = 100;
        boolean bl4 = false;
        int n6 = 0;
        n6 = 0;
        int n7 = n5;
        while (n6 < n7) {
            int n8 = n6++;
            boolean bl5 = false;
            Color color = Color.getHSBColor((float)n8 / (float)n5, 1.0f, 1.0f);
            Color color2 = Color.getHSBColor((float)(n8 + 1) / (float)n5, 1.0f, 1.0f);
            double d3 = (double)n3 / (double)n5;
            double d4 = (double)n + (double)n8 * d3;
            double d5 = (double)n + (double)(n8 + 1) * d3;
            bufferBuilder2.pos(d4, d, 0.0).color((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, 1.0f).endVertex();
            bufferBuilder2.pos(d5, d, 0.0).color((float)color2.getRed() / 255.0f, (float)color2.getGreen() / 255.0f, (float)color2.getBlue() / 255.0f, 1.0f).endVertex();
            bufferBuilder2.pos(d5, d2, 0.0).color((float)color2.getRed() / 255.0f, (float)color2.getGreen() / 255.0f, (float)color2.getBlue() / 255.0f, 1.0f).endVertex();
            bufferBuilder2.pos(d4, d2, 0.0).color((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, 1.0f).endVertex();
        }
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    @Class72
    private final void Method1683(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        boolean bl;
        double d = n2 + n4;
        double d2 = n2;
        float f = (float)n3 / (float)n4;
        int n10 = n + n3;
        int n11 = 0;
        n11 = (int)Math.ceil(f);
        boolean bl2 = false;
        int n12 = 0;
        int n13 = n11;
        for (n12 = 0; n12 < n13; ++n12) {
            int n14 = n12;
            bl = false;
            n9 = n + n14 * (int)f;
            n8 = n9 + (int)f;
            n7 = n10;
            n6 = 0;
            n5 = Math.min(n8, n7);
            if ((float)(n8 = n5 - n9) <= 0.0f || n9 > n10) continue;
            this.Method1681(n9, n2, n8, n4);
        }
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.shadeModel((int)7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        n12 = 0;
        n13 = 0;
        BufferBuilder bufferBuilder2 = bufferBuilder;
        bl = false;
        bufferBuilder2.begin(7, DefaultVertexFormats.POSITION_COLOR);
        n9 = 100;
        n8 = 0;
        n7 = 0;
        n7 = 0;
        n6 = n9;
        while (n7 < n6) {
            n5 = n7++;
            boolean bl3 = false;
            Color color = Class140.Method641(this.Method1708(Color.WHITE, this.Method1651(), (float)n5 / (float)n9), (float)n5 / (float)n9);
            Color color2 = Class140.Method641(this.Method1708(Color.WHITE, this.Method1651(), (float)(n5 + 1) / (float)n9), (float)(n5 + 1) / (float)n9);
            double d3 = (double)n3 / (double)n9;
            double d4 = (double)n + (double)n5 * d3;
            double d5 = (double)n + (double)(n5 + 1) * d3;
            bufferBuilder2.pos(d4, d, 0.0).color((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f).endVertex();
            bufferBuilder2.pos(d5, d, 0.0).color((float)color2.getRed() / 255.0f, (float)color2.getGreen() / 255.0f, (float)color2.getBlue() / 255.0f, (float)color2.getAlpha() / 255.0f).endVertex();
            bufferBuilder2.pos(d5, d2, 0.0).color((float)color2.getRed() / 255.0f, (float)color2.getGreen() / 255.0f, (float)color2.getBlue() / 255.0f, (float)color2.getAlpha() / 255.0f).endVertex();
            bufferBuilder2.pos(d4, d2, 0.0).color((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f).endVertex();
        }
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    private final void Method1714() {
        block1: {
            this.Field1307.Method1716('#' + Class140.Method642(this.Method1651()));
            this.Field1308.Method1716(String.valueOf(this.Method1651().getRed()));
            this.Field1309.Method1716(String.valueOf(this.Method1651().getGreen()));
            this.Field1310.Method1716(String.valueOf(this.Method1651().getBlue()));
            this.Field1311.Method1716(String.valueOf(MathKt.roundToInt(this.Field1302 * (float)255)));
            this.Field1312.Method1716(String.valueOf(MathKt.roundToInt(this.Field1300 * (float)255)));
            this.Field1313.Method1716(String.valueOf(MathKt.roundToInt((1.0f - this.Field1301) * (float)255)));
            this.Field1314.Method1716(String.valueOf(this.Method1651().getAlpha()));
            Function1 function1 = this.Field1317;
            if (function1 != null) {
                Unit cfr_ignored_0 = (Unit)function1.invoke(this.Method1651());
            }
            Setting setting = this.Method1667();
            if (setting == null) break block1;
            setting.setValue(this.Method1651());
        }
    }

    @Class72
    private final void Method1718(int n, String string) {
        Color color;
        Object object;
        float[] fArray = Color.RGBtoHSB(this.Method1651().getRed(), this.Method1651().getGreen(), this.Method1651().getBlue(), null);
        switch (n) {
            case 0: {
                object = string;
                boolean bl = false;
                String string2 = object;
                if (string2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                color = Class140.Method649(((Object)StringsKt.trim((CharSequence)string2)).toString());
                if (color != null) break;
                color = this.Method1651();
                break;
            }
            case 1: {
                Integer n2 = StringsKt.toIntOrNull(string);
                color = new Color(RangesKt.coerceIn(n2 != null ? n2.intValue() : this.Method1651().getRed(), 0, 255), this.Method1651().getGreen(), this.Method1651().getBlue(), this.Method1651().getAlpha());
                break;
            }
            case 2: {
                Integer n3 = StringsKt.toIntOrNull(string);
                color = new Color(this.Method1651().getRed(), RangesKt.coerceIn(n3 != null ? n3.intValue() : this.Method1651().getGreen(), 0, 255), this.Method1651().getBlue(), this.Method1651().getAlpha());
                break;
            }
            case 3: {
                Integer n4 = StringsKt.toIntOrNull(string);
                color = new Color(this.Method1651().getRed(), this.Method1651().getGreen(), RangesKt.coerceIn(n4 != null ? n4.intValue() : this.Method1651().getBlue(), 0, 255), this.Method1651().getAlpha());
                break;
            }
            case 4: {
                Integer n5 = StringsKt.toIntOrNull(string);
                this.Field1302 = (float)RangesKt.coerceIn(n5 != null ? n5 : (int)(fArray[0] * (float)255), 0, 255) / 255.0f;
                this.Method1714();
                return;
            }
            case 5: {
                Integer n6 = StringsKt.toIntOrNull(string);
                this.Field1300 = (float)RangesKt.coerceIn(n6 != null ? n6 : (int)(fArray[1] * (float)255), 0, 255) / 255.0f;
                this.Method1714();
                return;
            }
            case 6: {
                Integer n7 = StringsKt.toIntOrNull(string);
                this.Field1301 = 1.0f - (float)RangesKt.coerceIn(n7 != null ? n7 : (int)(fArray[2] * (float)255), 0, 255) / 255.0f;
                this.Method1714();
                return;
            }
            case 7: {
                Integer n8 = StringsKt.toIntOrNull(string);
                color = new Color(this.Method1651().getRed(), this.Method1651().getGreen(), this.Method1651().getBlue(), RangesKt.coerceIn(n8 != null ? n8.intValue() : this.Method1651().getAlpha(), 0, 255));
                break;
            }
            default: {
                return;
            }
        }
        Color color2 = color;
        object = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);
        this.Field1303 = (float)color2.getAlpha() / 255.0f;
        this.Field1302 = (float)object[0];
        this.Field1300 = (float)object[1];
        this.Field1301 = 1.0f - object[2];
        this.Method1714();
    }

    private final void Method1724(Color color) {
        float[] fArray = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        this.Field1303 = (float)color.getAlpha() / 255.0f;
        this.Field1302 = fArray[0];
        this.Field1300 = fArray[1];
        this.Field1301 = 1.0f - fArray[2];
    }

    public void Method1725(char c, int n) {
        this.Field1307.Method1726(c, n);
        this.Field1308.Method1726(c, n);
        this.Field1309.Method1726(c, n);
        this.Field1310.Method1726(c, n);
        this.Field1311.Method1726(c, n);
        this.Field1312.Method1726(c, n);
        this.Field1313.Method1726(c, n);
        this.Field1314.Method1726(c, n);
    }

    public void Method1727(int n, int n2, int n3) {
        if (this.Method1673().Method175()) {
            if (this.Method1728(n, n2) && n3 == 1) {
                this.Field1319 = !this.Field1319;
                return;
            }
            if (this.Method1728(n, n2) && !this.Field1319 && n3 == 0) {
                return;
            }
            if (this.Method1728(n, n2) && n3 == 0) {
                Class264 class264;
                Class264[] class264Array;
                boolean bl;
                Class223 class223;
                Enum enum_;
                this.Method1729(n, n2);
                if (this.Field1315.Method1730(n, n2)) {
                    enum_ = this.Field1318;
                    class223 = this;
                    bl = false;
                    class264Array = Class264.values();
                    class223.Field1318 = class264 = class264Array[(enum_.ordinal() + 1) % class264Array.length];
                }
                if (this.Field1316.Method1730(n, n2)) {
                    enum_ = this.Field1318;
                    class223 = this;
                    bl = false;
                    class264Array = Class264.values();
                    class223.Field1318 = class264 = class264Array[(class264Array.length + enum_.ordinal() - 1) % class264Array.length];
                }
            }
            this.Field1307.Method1732(n, n2, n3);
            this.Field1308.Method1732(n, n2, n3);
            this.Field1309.Method1732(n, n2, n3);
            this.Field1310.Method1732(n, n2, n3);
            this.Field1311.Method1732(n, n2, n3);
            this.Field1312.Method1732(n, n2, n3);
            this.Field1313.Method1732(n, n2, n3);
            this.Field1314.Method1732(n, n2, n3);
        }
    }

    public void Method1733(int n, int n2, int n3, long l) {
        if (this.Method1673().Method175()) {
            if (this.Method1728(n, n2) && !this.Field1319 && n3 == 0) {
                return;
            }
            if (this.Method1728(n, n2) && n3 == 0) {
                this.Method1729(n, n2);
            }
        }
    }

    private final void Method1729(int n, int n2) {
        Pair pair = Class137.Method1734(this.Field1304, n, n2, false, 4, null);
        if (pair != null) {
            this.Field1300 = ((Number)pair.getFirst()).floatValue();
            this.Field1301 = ((Number)pair.getSecond()).floatValue();
            this.Method1714();
            return;
        }
        pair = Class137.Method1734(this.Field1305, n, n2, false, 4, null);
        if (pair != null) {
            this.Field1302 = ((Number)pair.getFirst()).floatValue();
            this.Method1714();
            return;
        }
        pair = Class137.Method1734(this.Field1306, n, n2, false, 4, null);
        if (pair != null) {
            this.Field1303 = ((Number)pair.getFirst()).floatValue();
            this.Method1714();
            return;
        }
    }

    @NotNull
    public Class71 Method1673() {
        return this.Field1320;
    }

    public Class70 Method1738() {
        return this.Method1673();
    }

    @Nullable
    public Setting Method1667() {
        return this.Field1321;
    }

    public Class223(@NotNull Class71 class71, @Nullable Setting setting) {
        this.Field1320 = class71;
        this.Field1321 = setting;
        this.Field1298 = 170;
        this.Field1300 = 1.0f;
        this.Field1303 = 1.0f;
        this.Field1304 = new Class137(0, 0, 0, 0, 15, null);
        this.Field1305 = new Class137(0, 0, 0, 0, 15, null);
        this.Field1306 = new Class137(0, 0, 0, 0, 15, null);
        this.Field1307 = new Class224(null, 1, null);
        this.Field1308 = new Class224(null, 1, null);
        this.Field1309 = new Class224(null, 1, null);
        this.Field1310 = new Class224(null, 1, null);
        this.Field1311 = new Class224(null, 1, null);
        this.Field1312 = new Class224(null, 1, null);
        this.Field1313 = new Class224(null, 1, null);
        this.Field1314 = new Class224(null, 1, null);
        this.Field1315 = new Class137(0, 0, 10, 10, 3, null);
        this.Field1316 = new Class137(0, 0, 10, 10, 3, null);
        this.Field1318 = Class264.HEX;
        Setting setting2 = this.Method1667();
        if (setting2 == null) {
            Intrinsics.throwNpe();
        }
        this.Method1724((Color)setting2.getValue());
        this.Method1714();
        this.Field1307.Method1739(new Class222(this));
        this.Field1308.Method1739(new Class394(this));
        this.Field1309.Method1739(new Class395(this));
        this.Field1310.Method1739(new Class396(this));
        this.Field1311.Method1739(new Class253(this));
        this.Field1312.Method1739(new Class397(this));
        this.Field1313.Method1739(new Class398(this));
        this.Field1314.Method1739(new Class399(this));
        this.Field1307.Method1740(new Class305(this));
        this.Field1308.Method1740(new Class400(this));
        this.Field1309.Method1740(new Class401(this));
        this.Field1310.Method1740(new Class402(this));
        this.Field1311.Method1740(new Class403(this));
        this.Field1312.Method1740(new Class404(this));
        this.Field1313.Method1740(new Class387(this));
        this.Field1314.Method1740(new Class405(this));
        this.Field1307.Method1741(9);
        this.Field1308.Method1741(3);
        this.Field1309.Method1741(3);
        this.Field1310.Method1741(3);
        this.Field1311.Method1741(3);
        this.Field1312.Method1741(3);
        this.Field1313.Method1741(3);
        this.Field1314.Method1741(3);
    }

    public int Method1671() {
        return Class75.Method184(this);
    }

    public int Method1672() {
        return Class75.Method185(this);
    }

    public void Method1742(int n, int n2) {
        Class75.Method433(this, n, n2);
    }

    public void Method1743(int n, int n2, int n3) {
        Class75.Method187(this, n, n2, n3);
    }

    public void Method1744(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method1728(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }

    public static final void Method701(Class223 class223, int n, String string) {
        class223.Method1718(n, string);
    }
}
