package me.ciruu.abyss;

import java.awt.Color;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

public final class Class118 {
    public static final Class118 Field282;

    public final void Method304() {
        GL11.glPushMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.clear((int)256);
        GlStateManager.enableBlend();
        GlStateManager.glTexEnvi((int)8960, (int)8704, (int)8448);
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.disableLighting();
    }

    public final void Method313() {
        GlStateManager.disableBlend();
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.popMatrix();
        GL11.glPopMatrix();
    }

    public final void Method320(float f, float f2, float f3, float f4, int n, int n2, float f5, float f6, float f7, float f8, @NotNull Color color) {
        int n3 = color.getRed();
        int n4 = color.getGreen();
        int n5 = color.getBlue();
        int n6 = color.getAlpha();
        float f9 = 1.0f / f7;
        float f10 = 1.0f / f8;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferBuilder.pos((double)f, (double)(f2 + f6), 0.0).tex((double)(f3 * f9), (double)((f4 + (float)n2) * f10)).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos((double)(f + f5), (double)(f2 + f6), 0.0).tex((double)((f3 + (float)n) * f9), (double)((f4 + (float)n2) * f10)).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos((double)(f + f5), (double)f2, 0.0).tex((double)((f3 + (float)n) * f9), (double)(f4 * f10)).color(n3, n4, n5, n6).endVertex();
        bufferBuilder.pos((double)f, (double)f2, 0.0).tex((double)(f3 * f9), (double)(f4 * f10)).color(n3, n4, n5, n6).endVertex();
        tessellator.draw();
    }

    private Class118() {
    }

    static {
        Class118 class118;
        Field282 = class118 = new Class118();
    }
}
