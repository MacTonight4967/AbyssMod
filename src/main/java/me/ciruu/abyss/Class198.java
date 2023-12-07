package me.ciruu.abyss;

import java.awt.Color;
import java.awt.Font;
import me.ciruu.abyss.Class310;
import me.ciruu.abyss.Class315;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class Class198
extends FontRenderer {
    private Font Field913;
    private Class310 Field914;
    private Class310 Field915;
    private Class310 Field916;
    private Class310 Field917;

    public Class198(Font font) {
        super(Minecraft.getMinecraft().gameSettings, new ResourceLocation("textures/font/ascii.png"), null, false);
        this.Field913 = font;
        this.Field914 = new Class310(font);
        this.Field915 = new Class310(font.deriveFont(1));
        this.Field916 = new Class310(font.deriveFont(2));
        this.Field917 = new Class310(font.deriveFont(3));
        this.FONT_HEIGHT = this.getHeight();
    }

    public int getHeight() {
        return this.Field914.Method1127() / 2;
    }

    public int getSize() {
        return this.Field914.Method1138().getSize();
    }

    public void drawString(String string, float f, float f2, int n) {
        this.drawString(string, f, f2, n, false);
    }

    public int drawStringWithShadow(String string, float f, float f2, int n) {
        return this.drawString(string, f, f2, n, true);
    }

    public void drawCenteredString(String string, float f, float f2, int n, boolean bl) {
        this.drawString(string, f - (float)this.getStringWidth(string) / 2.0f, f2, n, bl);
    }

    public void drawCenteredString(String string, float f, float f2, int n) {
        this.drawString(string, f - (float)this.getStringWidth(string) / 2.0f, f2, n);
    }

    public int drawString(String string, float f, float f2, int n, boolean bl) {
        float f3 = f2 - 3.0f;
        if (string.contains("\n")) {
            String[] stringArray = string.split("\n");
            float f4 = 0.0f;
            for (String string2 : stringArray) {
                this.drawText(string2, f, f3 + f4, n, bl);
                f4 += (float)this.getHeight();
            }
            return 0;
        }
        if (bl) {
            GL20.glUseProgram((int)0);
            this.drawText(string, f + 0.5f, f3 + 0.5f, new Color(0, 0, 0, 150).getRGB(), true);
        }
        return this.drawText(string, f, f3, n, false);
    }

    private int drawText(String string, float f, float f2, int n, boolean bl) {
        if (string == null) {
            return 0;
        }
        if (string.isEmpty()) {
            return (int)f;
        }
        GlStateManager.translate((double)((double)f - 1.5), (double)((double)f2 + 0.5), (double)0.0);
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.enableTexture2D();
        int n2 = n;
        if ((n2 & 0xFC000000) == 0) {
            n2 |= 0xFF000000;
        }
        int n3 = n2 >> 24 & 0xFF;
        if (string.contains(String.valueOf('\u00a7'))) {
            String[] stringArray = string.split(String.valueOf('\u00a7'));
            Class310 class310 = this.Field914;
            double d = 0.0;
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = false;
            boolean bl5 = false;
            boolean bl6 = false;
            for (int i = 0; i < stringArray.length; ++i) {
                String string2 = stringArray[i];
                if (string2.isEmpty()) continue;
                if (i == 0) {
                    class310.Method1128(string2, d, 0.0, n2);
                    d += (double)class310.Method1137(string2);
                    continue;
                }
                String string3 = string2.substring(1);
                char c = string2.charAt(0);
                int n4 = "0123456789abcdefklmnor".indexOf(c);
                switch (n4) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 9: 
                    case 10: 
                    case 11: 
                    case 12: 
                    case 13: 
                    case 14: 
                    case 15: {
                        if (!bl) {
                            n2 = Class315.Field918[n4] | n3 << 24;
                        }
                        bl3 = false;
                        bl4 = false;
                        bl2 = false;
                        bl6 = false;
                        bl5 = false;
                        break;
                    }
                    case 16: {
                        bl2 = true;
                        break;
                    }
                    case 17: {
                        bl3 = true;
                        break;
                    }
                    case 18: {
                        bl5 = true;
                        break;
                    }
                    case 19: {
                        bl6 = true;
                        break;
                    }
                    case 20: {
                        bl4 = true;
                        break;
                    }
                    case 21: {
                        n2 = n;
                        if ((n2 & 0xFC000000) == 0) {
                            n2 |= 0xFF000000;
                        }
                        bl3 = false;
                        bl4 = false;
                        bl2 = false;
                        bl6 = false;
                        bl5 = false;
                    }
                }
                class310 = bl3 && bl4 ? this.Field917 : (bl3 ? this.Field915 : (bl4 ? this.Field916 : this.Field914));
                if (bl2) {
                    class310.Method1128(Class315.Method1171(string3), d, 0.0, n2);
                } else {
                    class310.Method1128(string3, d, 0.0, n2);
                }
                if (bl5) {
                    this.drawLine(d / 2.0 + 1.0, (double)class310.Method1127() / 3.0, (d + (double)class310.Method1137(string3)) / 2.0 + 1.0, (double)class310.Method1127() / 3.0, (float)this.FONT_HEIGHT / 16.0f);
                }
                if (bl6) {
                    this.drawLine(d / 2.0 + 1.0, (double)class310.Method1127() / 2.0, (d + (double)class310.Method1137(string3)) / 2.0 + 1.0, (double)class310.Method1127() / 2.0, (float)this.FONT_HEIGHT / 16.0f);
                }
                d += (double)class310.Method1137(string3);
            }
        } else {
            this.Field914.Method1128(string, 0.0, 0.0, n2);
        }
        GlStateManager.disableBlend();
        GlStateManager.translate((double)(-((double)f - 1.5)), (double)(-((double)f2 + 0.5)), (double)0.0);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        return (int)(f + (float)this.getStringWidth(string));
    }

    private void drawLine(double d, double d2, double d3, double d4, float f) {
        GL11.glDisable((int)3553);
        GL11.glLineWidth((float)f);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)d, (double)d2);
        GL11.glVertex2d((double)d3, (double)d4);
        GL11.glEnd();
        GL11.glEnable((int)3553);
    }

    public int getColorCode(char c) {
        return Class315.Field918[Class198.getColorIndex(c)];
    }

    public int getStringWidth(String string) {
        String string2 = string;
        if (string.contains(String.valueOf('\u00a7'))) {
            String[] stringArray = string.split(String.valueOf('\u00a7'));
            Class310 class310 = this.Field914;
            int n = 0;
            boolean bl = false;
            boolean bl2 = false;
            for (int i = 0; i < stringArray.length; ++i) {
                String string3 = stringArray[i];
                if (string3.isEmpty()) continue;
                if (i == 0) {
                    n += class310.Method1137(string3);
                    continue;
                }
                String string4 = string3.substring(1);
                char c = string3.charAt(0);
                int n2 = Class198.getColorIndex(c);
                if (n2 < 16) {
                    bl = false;
                    bl2 = false;
                } else if (n2 == 17) {
                    bl = true;
                } else if (n2 == 20) {
                    bl2 = true;
                } else if (n2 == 21) {
                    bl = false;
                    bl2 = false;
                }
                class310 = bl && bl2 ? this.Field917 : (bl ? this.Field915 : (bl2 ? this.Field916 : this.Field914));
                n += class310.Method1137(string4);
            }
            return n / 2;
        }
        return this.Field914.Method1137(string2) / 2;
    }

    public int getCharWidth(char c) {
        return this.getStringWidth(String.valueOf(c));
    }

    public void onResourceManagerReload(IResourceManager iResourceManager) {
    }

    protected void bindTexture(ResourceLocation resourceLocation) {
    }

    public static int getColorIndex(char c) {
        switch (c) {
            case '0': 
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': 
            case '8': 
            case '9': {
                return c - 48;
            }
            case 'a': 
            case 'b': 
            case 'c': 
            case 'd': 
            case 'e': 
            case 'f': {
                return c - 97 + 10;
            }
            case 'k': 
            case 'l': 
            case 'm': 
            case 'n': 
            case 'o': {
                return c - 107 + 16;
            }
            case 'r': {
                return 21;
            }
        }
        return -1;
    }
}
