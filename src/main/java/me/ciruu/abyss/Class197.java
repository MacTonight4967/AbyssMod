package me.ciruu.abyss;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import me.ciruu.abyss.Class133;
import me.ciruu.abyss.Class134;
import me.ciruu.abyss.Class72;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.client.NameChanger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;

public class Class197
extends Class133 {
    protected Class134[] Field2610 = new Class134[256];
    protected Class134[] Field2611 = new Class134[256];
    protected Class134[] Field2612 = new Class134[256];
    private final int[] Field2613 = new int[32];
    private final String Field2614 = "0123456789abcdefklmnor";
    String Field2615;
    int Field2616;
    protected DynamicTexture Field2617;
    protected DynamicTexture Field2618;
    protected DynamicTexture Field2619;

    public Class197(Font font, boolean bl, boolean bl2) {
        super(font, bl, bl2);
        this.Method3181();
        this.Method3182();
    }

    public String Method3183() {
        return this.Field2615;
    }

    public int Method3184() {
        return this.Field2616;
    }

    public void Method3185(String string) {
        this.Field2615 = string;
    }

    public void Method3186(int n) {
        this.Field2616 = n;
    }

    public float Method554(String string, double d, double d2, int n) {
        float f = this.Method3187(string, d + 1.0, d2 + 1.0, n, true);
        return Math.max(f, this.Method3187(string, d, d2, n, false));
    }

    public float Method556(String string, float f, float f2, int n) {
        return this.Method3187(string, f, f2, n, false);
    }

    public float Method558(String string, float f, float f2, int n) {
        return this.Method554(string, f - (float)(this.Method563(string) / 2), f2, n);
    }

    public float Method560(String string, float f, float f2, int n) {
        return this.Method556(string, f - (float)(this.Method563(string) / 2), f2, n);
    }

    @Class72
    public float Method3187(String string, double d, double d2, int n, boolean bl) {
        d -= 1.0;
        d2 -= 2.0;
        if (string == null) {
            return 0.0f;
        }
        if (n == 0x20FFFFFF) {
            n = 0xFFFFFF;
        }
        if ((n & 0xFC000000) == 0) {
            n |= 0xFF000000;
        }
        if (bl) {
            n = (n & 0xFCFCFC) >> 2 | n & 0xFF000000;
        }
        if (Manager.moduleManager.getModuleByClass(NameChanger.class) != null && Manager.moduleManager.isModuleEnabled(NameChanger.class)) {
            string = string.replace(Minecraft.getMinecraft().getSession().getUsername(), (CharSequence)((NameChanger)Manager.moduleManager.getModuleByClass(NameChanger.class)).newname.getValue());
        }
        Class134[] class134Array = this.Field2621;
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = true;
        d *= 2.0;
        d2 *= 2.0;
        if (bl7) {
            GL11.glPushMatrix();
            GlStateManager.scale((double)0.5, (double)0.5, (double)0.5);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc((int)770, (int)771);
            GlStateManager.color((float)((float)(n >> 16 & 0xFF) / 255.0f), (float)((float)(n >> 8 & 0xFF) / 255.0f), (float)((float)(n & 0xFF) / 255.0f), (float)f);
            int n2 = string.length();
            GlStateManager.enableTexture2D();
            GlStateManager.bindTexture((int)this.Field2622.getGlTextureId());
            GL11.glBindTexture((int)3553, (int)this.Field2622.getGlTextureId());
            for (int i = 0; i < n2; ++i) {
                char c = string.charAt(i);
                if (c == '\u00a7' && i < n2) {
                    int n3 = 21;
                    try {
                        n3 = "0123456789abcdefklmnor".indexOf(string.charAt(i + 1));
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    if (n3 < 16) {
                        bl3 = false;
                        bl4 = false;
                        bl2 = false;
                        bl6 = false;
                        bl5 = false;
                        GlStateManager.bindTexture((int)this.Field2622.getGlTextureId());
                        class134Array = this.Field2621;
                        if (n3 < 0 || n3 > 15) {
                            n3 = 15;
                        }
                        if (bl) {
                            n3 += 16;
                        }
                        int n4 = this.Field2613[n3];
                        GlStateManager.color((float)((float)(n4 >> 16 & 0xFF) / 255.0f), (float)((float)(n4 >> 8 & 0xFF) / 255.0f), (float)((float)(n4 & 0xFF) / 255.0f), (float)f);
                    } else if (n3 == 16) {
                        bl2 = true;
                    } else if (n3 == 17) {
                        bl3 = true;
                        if (bl4) {
                            GlStateManager.bindTexture((int)this.Field2619.getGlTextureId());
                            class134Array = this.Field2612;
                        } else {
                            GlStateManager.bindTexture((int)this.Field2617.getGlTextureId());
                            class134Array = this.Field2610;
                        }
                    } else if (n3 == 18) {
                        bl5 = true;
                    } else if (n3 == 19) {
                        bl6 = true;
                    } else if (n3 == 20) {
                        bl4 = true;
                        if (bl3) {
                            GlStateManager.bindTexture((int)this.Field2619.getGlTextureId());
                            class134Array = this.Field2612;
                        } else {
                            GlStateManager.bindTexture((int)this.Field2618.getGlTextureId());
                            class134Array = this.Field2611;
                        }
                    } else if (n3 == 21) {
                        bl3 = false;
                        bl4 = false;
                        bl2 = false;
                        bl6 = false;
                        bl5 = false;
                        GlStateManager.color((float)((float)(n >> 16 & 0xFF) / 255.0f), (float)((float)(n >> 8 & 0xFF) / 255.0f), (float)((float)(n & 0xFF) / 255.0f), (float)f);
                        GlStateManager.bindTexture((int)this.Field2622.getGlTextureId());
                        class134Array = this.Field2621;
                    }
                    ++i;
                    continue;
                }
                if (c >= class134Array.length || c < '\u0000') continue;
                GL11.glBegin((int)4);
                this.Method3206(class134Array, c, (float)d, (float)d2);
                GL11.glEnd();
                if (bl5) {
                    this.Method3208(d, d2 + (double)(class134Array[c].Field315 / 2), d + (double)class134Array[c].Field314 - 8.0, d2 + (double)(class134Array[c].Field315 / 2), 1.0f);
                }
                if (bl6) {
                    this.Method3208(d, d2 + (double)class134Array[c].Field315 - 2.0, d + (double)class134Array[c].Field314 - 8.0, d2 + (double)class134Array[c].Field315 - 2.0, 1.0f);
                }
                d += (double)(class134Array[c].Field314 - 8 + this.Field2623);
            }
            GL11.glHint((int)3155, (int)4352);
            GL11.glPopMatrix();
        }
        return (float)d / 2.0f;
    }

    @Class72
    public int Method563(String string) {
        if (string == null) {
            return 0;
        }
        int n = 0;
        Class134[] class134Array = this.Field2621;
        boolean bl = false;
        boolean bl2 = false;
        int n2 = string.length();
        for (int i = 0; i < n2; ++i) {
            char c = string.charAt(i);
            if (c == '\u00a7' && i < n2) {
                int n3 = "0123456789abcdefklmnor".indexOf(c);
                if (n3 < 16) {
                    bl = false;
                    bl2 = false;
                } else if (n3 == 17) {
                    bl = true;
                    class134Array = bl2 ? this.Field2612 : this.Field2610;
                } else if (n3 == 20) {
                    bl2 = true;
                    class134Array = bl ? this.Field2612 : this.Field2611;
                } else if (n3 == 21) {
                    bl = false;
                    bl2 = false;
                    class134Array = this.Field2621;
                }
                ++i;
                continue;
            }
            if (c >= class134Array.length || c < '\u0000') continue;
            n += class134Array[c].Field314 - 8 + this.Field2623;
        }
        return n / 2;
    }

    public void Method3211(Font font) {
        super.Method374(font);
        this.Method3182();
    }

    public void Method3212(boolean bl) {
        super.Method370(bl);
        this.Method3182();
    }

    public void Method3213(boolean bl) {
        super.Method372(bl);
        this.Method3182();
    }

    private void Method3182() {
        this.Field2617 = this.Method3215(this.Field2624.deriveFont(1), this.Field2625, this.Field2626, this.Field2610);
        this.Field2618 = this.Method3215(this.Field2624.deriveFont(2), this.Field2625, this.Field2626, this.Field2611);
        this.Field2619 = this.Method3215(this.Field2624.deriveFont(3), this.Field2625, this.Field2626, this.Field2612);
    }

    @Class72
    private void Method3208(double d, double d2, double d3, double d4, float f) {
        GL11.glDisable((int)3553);
        GL11.glLineWidth((float)f);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)d, (double)d2);
        GL11.glVertex2d((double)d3, (double)d4);
        GL11.glEnd();
        GL11.glEnable((int)3553);
    }

    @Class72
    public List Method3220(String string, double d) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if ((double)this.Method563(string) > d) {
            String[] stringArray = string.split(" ");
            String string2 = "";
            char c = '\uffff';
            for (String string3 : stringArray) {
                for (int i = 0; i < string3.toCharArray().length; ++i) {
                    char c2 = string3.toCharArray()[i];
                    if (c2 != '\u00a7' || i >= string3.toCharArray().length - 1) continue;
                    c = string3.toCharArray()[i + 1];
                }
                StringBuilder stringBuilder = new StringBuilder();
                if ((double)this.Method563(stringBuilder.append(string2).append(string3).append(" ").toString()) < d) {
                    string2 = string2 + string3 + " ";
                    continue;
                }
                arrayList.add(string2);
                string2 = "\u00a7" + c + string3 + " ";
            }
            if (string2.length() > 0) {
                if ((double)this.Method563(string2) < d) {
                    arrayList.add("\u00a7" + c + string2 + " ");
                    string2 = "";
                } else {
                    for (String string4 : this.Method3228(string2, d)) {
                        arrayList.add(string4);
                    }
                }
            }
        } else {
            arrayList.add(string);
        }
        return arrayList;
    }

    @Class72
    public List Method3228(String string, double d) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = "";
        char c = '\uffff';
        char[] cArray = string.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            char c2 = cArray[i];
            if (c2 == '\u00a7' && i < cArray.length - 1) {
                c = cArray[i + 1];
            }
            StringBuilder stringBuilder = new StringBuilder();
            if ((double)this.Method563(stringBuilder.append(string2).append(c2).toString()) < d) {
                string2 = string2 + c2;
                continue;
            }
            arrayList.add(string2);
            string2 = "\u00a7" + c + String.valueOf(c2);
        }
        if (string2.length() > 0) {
            arrayList.add(string2);
        }
        return arrayList;
    }

    private void Method3181() {
        for (int i = 0; i < 32; ++i) {
            int n = (i >> 3 & 1) * 85;
            int n2 = (i >> 2 & 1) * 170 + n;
            int n3 = (i >> 1 & 1) * 170 + n;
            int n4 = (i >> 0 & 1) * 170 + n;
            if (i == 6) {
                n2 += 85;
            }
            if (i >= 16) {
                n2 /= 4;
                n3 /= 4;
                n4 /= 4;
            }
            this.Field2613[i] = (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
        }
    }

    public String Method562(String string, int n) {
        return this.Method3232(string, n, false);
    }

    @Class72
    public String Method3232(String string, int n, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        int n3 = bl ? string.length() - 1 : 0;
        int n4 = bl ? -1 : 1;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i = n3; i >= 0 && i < string.length() && n2 < n; i += n4) {
            char c = string.charAt(i);
            float f = this.Method563(string);
            if (bl2) {
                bl2 = false;
                if (c != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl3 = false;
                    }
                } else {
                    bl3 = true;
                }
            } else if (f < 0.0f) {
                bl2 = true;
            } else {
                n2 = (int)((float)n2 + f);
                if (bl3) {
                    ++n2;
                }
            }
            if (n2 > n) break;
            if (bl) {
                stringBuilder.insert(0, c);
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
