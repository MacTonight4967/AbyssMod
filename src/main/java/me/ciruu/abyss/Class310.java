package me.ciruu.abyss;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.ciruu.abyss.Class311;
import me.ciruu.abyss.Class312;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class Class310 {
    private static boolean Field883 = false;
    private static final ArrayList Field884 = new ArrayList();
    private static int Field885 = 0;
    private static final int Field886 = 600;
    private static final int Field887 = 30000;
    private final Font Field888;
    private int Field889;
    private int Field890;
    private int Field891 = -1;
    private Class311[] Field892 = null;
    private final HashMap Field893 = new HashMap();
    private int Field894 = 0;
    private int Field895 = 0;
    private int Field896 = 0;

    public static void Method1122() {
        if (Field885++ > 600) {
            Field884.forEach(Class310::Method1123);
            Field885 = 0;
        }
    }

    private void Method1123() {
        long l = System.currentTimeMillis();
        this.Field893.entrySet().stream().filter(arg_0 -> Class310.Method1124(l, arg_0)).forEach(this::Method1125);
    }

    public Class310(Font font, int n, int n2) {
        this.Field888 = font;
        this.Field889 = n;
        this.Field890 = n2;
        this.Field892 = new Class311[n2];
        this.Method1126(n, n2);
        Field884.add(this);
    }

    public Class310(Font font) {
        this(font, 0, 255);
    }

    public int Method1127() {
        return (this.Field891 - 8) / 2;
    }

    public void Method1128(String string, double d, double d2, int n) {
        double d3 = 0.25;
        double d4 = 4.0;
        GlStateManager.pushMatrix();
        GlStateManager.scale((double)0.25, (double)0.25, (double)0.25);
        GL11.glTranslated((double)(d * 2.0), (double)(d2 * 2.0 - 2.0), (double)0.0);
        GlStateManager.bindTexture((int)this.Field894);
        float f = (float)(n >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n & 0xFF) / 255.0f;
        float f4 = (float)(n >> 24 & 0xFF) / 255.0f;
        GlStateManager.color((float)f, (float)f2, (float)f3, (float)f4);
        double d5 = 0.0;
        Class312 class312 = (Class312)this.Field893.get(string);
        if (class312 != null) {
            GL11.glCallList((int)class312.Method1129());
            class312.Method1130(System.currentTimeMillis());
            GlStateManager.popMatrix();
            return;
        }
        int n2 = -1;
        if (Field883) {
            n2 = GL11.glGenLists((int)1);
            GL11.glNewList((int)n2, (int)4865);
        }
        GL11.glBegin((int)7);
        for (char c : string.toCharArray()) {
            Class311 class311;
            if (Character.getNumericValue(c) >= this.Field892.length) {
                GL11.glEnd();
                GlStateManager.scale((double)4.0, (double)4.0, (double)4.0);
                Minecraft.getMinecraft().fontRenderer.drawString(String.valueOf(c), (float)d5 * 0.25f + 1.0f, 2.0f, n, false);
                d5 += (double)Minecraft.getMinecraft().fontRenderer.getStringWidth(String.valueOf(c)) * 4.0;
                GlStateManager.scale((double)0.25, (double)0.25, (double)0.25);
                GlStateManager.bindTexture((int)this.Field894);
                GlStateManager.color((float)f, (float)f2, (float)f3, (float)f4);
                GL11.glBegin((int)7);
                continue;
            }
            if (this.Field892.length <= c || (class311 = this.Field892[c]) == null) continue;
            this.Method1131(class311, (float)d5, 0.0f);
            d5 += (double)Class311.Method1132(class311) - 8.0;
        }
        GL11.glEnd();
        if (Field883) {
            this.Field893.put(string, new Class312(n2, System.currentTimeMillis()));
            GL11.glEndList();
        }
        GlStateManager.popMatrix();
    }

    private void Method1131(Class311 class311, float f, float f2) {
        float f3 = Class311.Method1132(class311);
        float f4 = Class311.Method1133(class311);
        float f5 = Class311.Method1134(class311);
        float f6 = Class311.Method1135(class311);
        float f7 = f5 / (float)this.Field895;
        float f8 = f6 / (float)this.Field896;
        float f9 = f3 / (float)this.Field895;
        float f10 = f4 / (float)this.Field896;
        GL11.glTexCoord2f((float)f7, (float)f8);
        GL11.glVertex2f((float)f, (float)f2);
        GL11.glTexCoord2f((float)f7, (float)(f8 + f10));
        GL11.glVertex2f((float)f, (float)(f2 + f4));
        GL11.glTexCoord2f((float)(f7 + f9), (float)(f8 + f10));
        GL11.glVertex2f((float)(f + f3), (float)(f2 + f4));
        GL11.glTexCoord2f((float)(f7 + f9), (float)f8);
        GL11.glVertex2f((float)(f + f3), (float)f2);
    }

    private void Method1126(int n, int n2) {
        Object object;
        BufferedImage[] bufferedImageArray = new BufferedImage[n2];
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        for (int i = n; i < n2; ++i) {
            object = this.Method1136((char)i);
            Class311 class311 = new Class311(n4, n5, ((BufferedImage)object).getWidth(), ((BufferedImage)object).getHeight());
            if (Class311.Method1133(class311) > this.Field891) {
                this.Field891 = Class311.Method1133(class311);
            }
            if (Class311.Method1133(class311) > n3) {
                n3 = Class311.Method1133(class311);
            }
            if (this.Field892.length <= i) continue;
            this.Field892[i] = class311;
            bufferedImageArray[i] = object;
            if ((n4 += Class311.Method1132(class311)) <= 2048) continue;
            if (n4 > this.Field895) {
                this.Field895 = n4;
            }
            n4 = 0;
            n5 += n3;
            n3 = 0;
        }
        this.Field896 = n5 + n3;
        BufferedImage bufferedImage = new BufferedImage(this.Field895, this.Field896, 2);
        object = (Graphics2D)bufferedImage.getGraphics();
        ((Graphics)object).setFont(this.Field888);
        ((Graphics)object).setColor(new Color(255, 255, 255, 0));
        ((Graphics)object).fillRect(0, 0, this.Field895, this.Field896);
        ((Graphics)object).setColor(Color.WHITE);
        for (int i = n; i < n2; ++i) {
            if (bufferedImageArray[i] == null || this.Field892[i] == null) continue;
            ((Graphics)object).drawImage(bufferedImageArray[i], Class311.Method1134(this.Field892[i]), Class311.Method1135(this.Field892[i]), null);
        }
        this.Field894 = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)bufferedImage, (boolean)true, (boolean)true);
    }

    private BufferedImage Method1136(char c) {
        int n;
        Graphics2D graphics2D = (Graphics2D)new BufferedImage(1, 1, 2).getGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setFont(this.Field888);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int n2 = fontMetrics.charWidth(c) + 8;
        if (n2 <= 8) {
            n2 = 7;
        }
        if ((n = fontMetrics.getHeight() + 3) <= 0) {
            n = this.Field888.getSize();
        }
        BufferedImage bufferedImage = new BufferedImage(n2, n, 2);
        Graphics2D graphics2D2 = (Graphics2D)bufferedImage.getGraphics();
        graphics2D2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D2.setFont(this.Field888);
        graphics2D2.setColor(Color.WHITE);
        graphics2D2.drawString(String.valueOf(c), 3, 1 + fontMetrics.getAscent());
        return bufferedImage;
    }

    public int Method1137(String string) {
        int n = 0;
        for (int n2 : string.toCharArray()) {
            Class311 class311;
            int n3 = n2 < this.Field892.length ? n2 : 3;
            if (this.Field892.length <= n3 || (class311 = this.Field892[n3]) == null) continue;
            n += Class311.Method1132(class311) - 8;
        }
        return n / 2;
    }

    public Font Method1138() {
        return this.Field888;
    }

    private void Method1125(Map.Entry entry) {
        GL11.glDeleteLists((int)((Class312)entry.getValue()).Method1129(), (int)1);
        ((Class312)entry.getValue()).Method1139(true);
        this.Field893.remove(entry.getKey());
    }

    private static boolean Method1124(long l, Map.Entry entry) {
        return l - ((Class312)entry.getValue()).Method1140() > 30000L;
    }
}
