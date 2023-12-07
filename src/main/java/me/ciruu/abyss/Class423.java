package me.ciruu.abyss;

import java.awt.Color;
import me.ciruu.abyss.enums.Class567;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class Class423 {
    public static void Method2777(int n, int n2, float f, int n3) {
        Class423.Method2778(n, n2, f, n3, 50);
    }

    public static void Method2778(int n, int n2, float f, int n3, int n4) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.disableTexture2D();
        GL11.glBegin((int)6);
        for (int i = 0; i < n4; ++i) {
            float f2 = (float)n + f * MathHelper.sin((float)((float)((double)i * (6.28318530718 / (double)n4))));
            float f3 = (float)n2 + f * MathHelper.cos((float)((float)((double)i * (6.28318530718 / (double)n4))));
            float f4 = (float)(n3 >> 24 & 0xFF) / 255.0f;
            float f5 = (float)(n3 >> 16 & 0xFF) / 255.0f;
            float f6 = (float)(n3 >> 8 & 0xFF) / 255.0f;
            float f7 = (float)(n3 & 0xFF) / 255.0f;
            GL11.glColor4f((float)f5, (float)f6, (float)f7, (float)f4);
            GL11.glVertex2d((double)f2, (double)f3);
        }
        GL11.glEnd();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
        GlStateManager.bindTexture((int)0);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void Method2797(int n, int n2, float f, int n3, Class567 class567) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.disableTexture2D();
        GL11.glBegin((int)6);
        float f2 = (float)(n3 >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n3 & 0xFF) / 255.0f;
        GL11.glColor4f((float)f3, (float)f4, (float)f5, (float)f2);
        GL11.glVertex2d((double)n, (double)n2);
        if (class567 == Class567.TopLeft) {
            for (int i = 0; i <= 90; ++i) {
                GL11.glVertex2d((double)((double)n + Math.sin((double)i * 3.1415926 / 180.0) * (double)(f * -1.0f)), (double)((double)n2 + Math.cos((double)i * 3.1415926 / 180.0) * (double)(f * -1.0f)));
            }
        } else if (class567 == Class567.TopRight) {
            for (int i = 90; i <= 180; ++i) {
                GL11.glVertex2d((double)((double)n + Math.sin((double)i * 3.1415926 / 180.0) * (double)f), (double)((double)n2 + Math.cos((double)i * 3.1415926 / 180.0) * (double)f));
            }
        } else if (class567 == Class567.BottomLeft) {
            for (int i = 90; i <= 180; ++i) {
                GL11.glVertex2d((double)((double)n + Math.sin((double)i * 3.1415926 / 180.0) * (double)(f * -1.0f)), (double)((double)n2 + Math.cos((double)i * 3.1415926 / 180.0) * (double)(f * -1.0f)));
            }
        } else if (class567 == Class567.BottomRight) {
            for (int i = 0; i <= 90; ++i) {
                GL11.glVertex2d((double)((double)n + Math.sin((double)i * 3.1415926 / 180.0) * (double)f), (double)((double)n2 + Math.cos((double)i * 3.1415926 / 180.0) * (double)f));
            }
        }
        GL11.glEnd();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
        GlStateManager.bindTexture((int)0);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void Method2800(int n, int n2, int n3, int n4, float f) {
        float f2 = (float)(n4 >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n4 & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glShadeModel((int)7425);
        GlStateManager.glLineWidth((float)f);
        GL11.glBegin((int)2);
        for (int i = 0; i < 70; ++i) {
            float f6 = (float)n3 * MathHelper.cos((float)((float)((double)i * 0.08975979010256552)));
            float f7 = (float)n3 * MathHelper.sin((float)((float)((double)i * 0.08975979010256552)));
            GlStateManager.color((float)f3, (float)f4, (float)f5, (float)f2);
            GL11.glVertex2f((float)((float)n + f6), (float)((float)n2 + f7));
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public static void Method2615(int n, int n2, int n3, Color color, int n4, float f) {
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glShadeModel((int)7425);
        GlStateManager.glLineWidth((float)f);
        GL11.glBegin((int)2);
        float[] fArray = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fArray);
        Color color2 = new Color(Color.HSBtoRGB(fArray[0], fArray[1], fArray[2]));
        for (int i = 0; i < n4; ++i) {
            float f2 = (float)n3 * MathHelper.cos((float)((float)((double)i * (6.28318530718 / (double)n4))));
            float f3 = (float)n3 * MathHelper.sin((float)((float)((double)i * (6.28318530718 / (double)n4))));
            Class423.Method2814(color2);
            fArray[0] = fArray[0] + 1.0f / (float)n4;
            color2 = new Color(Color.HSBtoRGB(fArray[0], fArray[1], fArray[2]));
            GL11.glVertex2f((float)((float)n + f2), (float)((float)n2 + f3));
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public static void Method2815(float f, float f2, float f3, float f4, Color color) {
        Gui.drawRect((int)((int)f), (int)((int)f2), (int)((int)f3), (int)((int)f4), (int)color.getRGB());
    }

    public static void Method2818(float f, float f2, float f3, float f4, int n) {
        Gui.drawRect((int)((int)f), (int)((int)f2), (int)((int)f3), (int)((int)f4), (int)n);
    }

    public static void Method2819(float f, float f2, float f3, float f4, float f5, int n, int n2) {
        Class423.Method2818(f, f2, f3, f4, n2);
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glPushMatrix();
        GlStateManager.color((float)f7, (float)f8, (float)f9, (float)f6);
        GL11.glLineWidth((float)f5);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)f, (double)f2);
        GL11.glVertex2d((double)f, (double)f4);
        GL11.glVertex2d((double)f3, (double)f4);
        GL11.glVertex2d((double)f3, (double)f2);
        GL11.glVertex2d((double)f, (double)f2);
        GL11.glVertex2d((double)f3, (double)f2);
        GL11.glVertex2d((double)f, (double)f4);
        GL11.glVertex2d((double)f3, (double)f4);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
    }

    public static void Method2821(float f, float f2, float f3, float f4, float f5, Color color, Color color2) {
        Class423.Method2815(f, f2, f3, f4, color2);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glPushMatrix();
        Class423.Method2814(color);
        GL11.glLineWidth((float)f5);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)f, (double)f2);
        GL11.glVertex2d((double)f, (double)f4);
        GL11.glVertex2d((double)f3, (double)f4);
        GL11.glVertex2d((double)f3, (double)f2);
        GL11.glVertex2d((double)f, (double)f2);
        GL11.glVertex2d((double)f3, (double)f2);
        GL11.glVertex2d((double)f, (double)f4);
        GL11.glVertex2d((double)f3, (double)f4);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
    }

    public static void Method2822(int n) {
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n & 0xFF) / 255.0f;
        GlStateManager.color((float)f2, (float)f3, (float)f4, (float)f);
    }

    public static void Method2814(Color color) {
        GlStateManager.color((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
    }

    public static void Method2824(float f, float f2, float f3, float f4, float f5, int n) {
        float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n & 0xFF) / 255.0f;
        float f9 = (float)(n >> 24 & 0xFF) / 255.0f;
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.blendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GlStateManager.pushMatrix();
        GlStateManager.color((float)f6, (float)f7, (float)f8, (float)f9);
        GL11.glLineWidth((float)f5);
        GL11.glBegin((int)3);
        GL11.glVertex2f((float)f, (float)f2);
        GL11.glVertex2f((float)f3, (float)f4);
        GL11.glEnd();
        GlStateManager.popMatrix();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glDisable((int)2848);
    }

    public static void Method1794(int n, int n2, int n3, int n4, int n5, int n6) {
        Gui.drawRect((int)(n += n5), (int)n2, (int)(n3 -= n5), (int)n4, (int)n6);
        Gui.drawRect((int)(n - n5), (int)(n2 + n5), (int)n, (int)(n4 - n5), (int)n6);
        Gui.drawRect((int)n3, (int)(n2 + n5), (int)(n3 + n5), (int)(n4 - n5), (int)n6);
        Class423.Method2797(n, n2 + n5, n5, n6, Class567.TopLeft);
        Class423.Method2797(n, n4 - n5, n5, n6, Class567.BottomLeft);
        Class423.Method2797(n3, n2 + n5, n5, n6, Class567.TopRight);
        Class423.Method2797(n3, n4 - n5, n5, n6, Class567.BottomRight);
    }

    public static void Method1795(int n, int n2, int n3, int n4, int n5, float f, int n6) {
        Class423.Method2824(n += n5, n2, n3 -= n5, n2, f, n6);
        Class423.Method2824(n, n4, n3, n4, f, n6);
        Class423.Method2824(n - n5, n2 + n5, n - n5, n4 - n5, f, n6);
        Class423.Method2824(n3 + n5, n2 + n5, n3 + n5, n4 - n5, f, n6);
        Class423.Method2825(n, n2 + n5, n5, n6, f, Class567.TopLeft);
        Class423.Method2825(n, n4 - n5, n5, n6, f, Class567.BottomLeft);
        Class423.Method2825(n3, n2 + n5, n5, n6, f, Class567.TopRight);
        Class423.Method2825(n3, n4 - n5, n5, n6, f, Class567.BottomRight);
    }

    public static void Method2826(float f, float f2, float f3, float f4, float f5, int n, int n2) {
        float f6 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n2 & 0xFF) / 255.0f;
        float f9 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f10 = f5 / (float)(n - 1);
        double d = Math.tan(f10);
        float f11 = MathHelper.cos((float)f10);
        float f12 = f3 * MathHelper.cos((float)f4);
        float f13 = f3 * MathHelper.sin((float)f4);
        GlStateManager.pushMatrix();
        GlStateManager.color((float)f6, (float)f7, (float)f8, (float)f9);
        GL11.glBegin((int)3);
        for (int i = 0; i < n; ++i) {
            GL11.glVertex2f((float)(f12 + f), (float)(f13 + f2));
            float f14 = -f13;
            float f15 = f12;
            f12 = (float)((double)f12 + (double)f14 * d);
            f13 = (float)((double)f13 + (double)f15 * d);
            f12 *= f11;
            f13 *= f11;
        }
        GL11.glEnd();
        GlStateManager.popMatrix();
    }

    public static void Method2825(int n, int n2, float f, int n3, float f2, Class567 class567) {
        float f3 = (float)(n3 >> 24 & 0xFF) / 255.0f;
        float f4 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n3 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.color((float)f4, (float)f5, (float)f6, (float)f3);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)f2);
        GL11.glBegin((int)3);
        if (class567 == Class567.TopLeft) {
            for (int i = 0; i <= 90; ++i) {
                GL11.glVertex2d((double)((double)n + Math.sin((double)i * 3.1415926 / 180.0) * (double)(f * -1.0f)), (double)((double)n2 + Math.cos((double)i * 3.1415926 / 180.0) * (double)(f * -1.0f)));
            }
        } else if (class567 == Class567.TopRight) {
            for (int i = 90; i <= 180; ++i) {
                GL11.glVertex2d((double)((double)n + Math.sin((double)i * 3.1415926 / 180.0) * (double)f), (double)((double)n2 + Math.cos((double)i * 3.1415926 / 180.0) * (double)f));
            }
        } else if (class567 == Class567.BottomLeft) {
            for (int i = 90; i <= 180; ++i) {
                GL11.glVertex2d((double)((double)n + Math.sin((double)i * 3.1415926 / 180.0) * (double)(f * -1.0f)), (double)((double)n2 + Math.cos((double)i * 3.1415926 / 180.0) * (double)(f * -1.0f)));
            }
        } else if (class567 == Class567.BottomRight) {
            for (int i = 0; i <= 90; ++i) {
                GL11.glVertex2d((double)((double)n + Math.sin((double)i * 3.1415926 / 180.0) * (double)f), (double)((double)n2 + Math.cos((double)i * 3.1415926 / 180.0) * (double)f));
            }
        }
        GL11.glEnd();
        GlStateManager.popMatrix();
        GL11.glDisable((int)2848);
    }

    public static void Method2828(float f, float f2, float f3, float f4, float f5, float f6, int n) {
        float f7 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f9 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f10 = (float)(n & 0xFF) / 255.0f;
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.disableTexture2D();
        GL11.glBegin((int)4);
        GL11.glColor4f((float)f8, (float)f9, (float)f10, (float)f7);
        GL11.glVertex2d((double)f, (double)f2);
        GL11.glVertex2d((double)f3, (double)f4);
        GL11.glVertex2d((double)f5, (double)f6);
        GL11.glEnd();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
        GlStateManager.bindTexture((int)0);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }
}
