package me.ciruu.abyss;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import me.ciruu.abyss.Class134;
import me.ciruu.abyss.Class72;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;

public class Class133 {
    private float Field306 = 512.0f;
    protected Class134[] Field307 = new Class134[256];
    protected Font Field308;
    protected boolean Field309;
    protected boolean Field310;
    protected int Field311 = -1;
    protected int Field312 = 0;
    protected DynamicTexture Field313;

    public Class133(Font font, boolean bl, boolean bl2) {
        this.Field308 = font;
        this.Field309 = bl;
        this.Field310 = bl2;
        this.Field313 = this.Method348(font, bl, bl2, this.Field307);
    }

    protected DynamicTexture Method348(Font font, boolean bl, boolean bl2, Class134[] class134Array) {
        BufferedImage bufferedImage = this.Method349(font, bl, bl2, class134Array);
        try {
            return new DynamicTexture(bufferedImage);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Class72
    protected BufferedImage Method349(Font font, boolean bl, boolean bl2, Class134[] class134Array) {
        int n = (int)this.Field306;
        BufferedImage bufferedImage = new BufferedImage(n, n, 2);
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setFont(font);
        graphics2D.setColor(new Color(255, 255, 255, 0));
        graphics2D.fillRect(0, 0, n, n);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, bl2 ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, bl ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, bl ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int n2 = 0;
        int n3 = 0;
        int n4 = 1;
        for (int i = 0; i < class134Array.length; ++i) {
            char c = (char)i;
            Class134 class134 = new Class134(this);
            Rectangle2D rectangle2D = fontMetrics.getStringBounds(String.valueOf(c), graphics2D);
            class134.Field314 = rectangle2D.getBounds().width + 8;
            class134.Field315 = rectangle2D.getBounds().height;
            if (n3 + class134.Field314 >= n) {
                n3 = 0;
                n4 += n2;
                n2 = 0;
            }
            if (class134.Field315 > n2) {
                n2 = class134.Field315;
            }
            class134.Field316 = n3;
            class134.Field317 = n4;
            if (class134.Field315 > this.Field311) {
                this.Field311 = class134.Field315;
            }
            class134Array[i] = class134;
            graphics2D.drawString(String.valueOf(c), n3 + 2, n4 + fontMetrics.getAscent());
            n3 += class134.Field314;
        }
        return bufferedImage;
    }

    @Class72
    public void Method361(Class134[] class134Array, char c, float f, float f2) throws ArrayIndexOutOfBoundsException {
        try {
            this.Method362(f, f2, class134Array[c].Field314, class134Array[c].Field315, class134Array[c].Field316, class134Array[c].Field317, class134Array[c].Field314, class134Array[c].Field315);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Class72
    protected void Method362(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f5 / this.Field306;
        float f10 = f6 / this.Field306;
        float f11 = f7 / this.Field306;
        float f12 = f8 / this.Field306;
        GL11.glTexCoord2f((float)(f9 + f11), (float)f10);
        GL11.glVertex2d((double)(f + f3), (double)f2);
        GL11.glTexCoord2f((float)f9, (float)f10);
        GL11.glVertex2d((double)f, (double)f2);
        GL11.glTexCoord2f((float)f9, (float)(f10 + f12));
        GL11.glVertex2d((double)f, (double)(f2 + f4));
        GL11.glTexCoord2f((float)f9, (float)(f10 + f12));
        GL11.glVertex2d((double)f, (double)(f2 + f4));
        GL11.glTexCoord2f((float)(f9 + f11), (float)(f10 + f12));
        GL11.glVertex2d((double)(f + f3), (double)(f2 + f4));
        GL11.glTexCoord2f((float)(f9 + f11), (float)f10);
        GL11.glVertex2d((double)(f + f3), (double)f2);
    }

    public int Method365(String string) {
        return this.Method366();
    }

    public int Method366() {
        return (this.Field311 - 8) / 2;
    }

    public int Method367(String string) {
        int n = 0;
        for (char c : string.toCharArray()) {
            if (c >= this.Field307.length || c < '\u0000') continue;
            n += this.Field307[c].Field314 - 8 + this.Field312;
        }
        return n / 2;
    }

    public boolean Method369() {
        return this.Field309;
    }

    public void Method370(boolean bl) {
        if (this.Field309 != bl) {
            this.Field309 = bl;
            this.Field313 = this.Method348(this.Field308, bl, this.Field310, this.Field307);
        }
    }

    public boolean Method371() {
        return this.Field310;
    }

    public void Method372(boolean bl) {
        if (this.Field310 != bl) {
            this.Field310 = bl;
            this.Field313 = this.Method348(this.Field308, this.Field309, bl, this.Field307);
        }
    }

    public Font Method373() {
        return this.Field308;
    }

    public void Method374(Font font) {
        this.Field308 = font;
        this.Field313 = this.Method348(font, this.Field309, this.Field310, this.Field307);
    }
}
