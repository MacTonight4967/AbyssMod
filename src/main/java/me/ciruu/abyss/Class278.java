package me.ciruu.abyss;

import java.awt.Color;
import me.ciruu.abyss.Globals;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

public class Class278 {
    public static void Method1767(Color color) {
        GlStateManager.color((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
    }

    public static void Method1768(BlockPos blockPos, double d, Color color, int n) {
        Class278.Method1769(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0, d, 1.0, color, color.getAlpha(), n);
    }

    public static void Method1770(AxisAlignedBB axisAlignedBB, boolean bl, double d, Color color, int n) {
        Class278.Method1003(axisAlignedBB, bl, d, color, color.getAlpha(), n);
    }

    public static void Method1003(AxisAlignedBB axisAlignedBB, boolean bl, double d, Color color, int n, int n2) {
        if (bl) {
            Class278.Method1769(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX - axisAlignedBB.minX, axisAlignedBB.maxY - axisAlignedBB.minY, axisAlignedBB.maxZ - axisAlignedBB.minZ, color, n, n2);
        } else {
            Class278.Method1769(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX - axisAlignedBB.minX, d, axisAlignedBB.maxZ - axisAlignedBB.minZ, color, n, n2);
        }
    }

    public static void Method1769(double d, double d2, double d3, double d4, double d5, double d6, Color color, int n, int n2) {
        GlStateManager.disableAlpha();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        Class278.Method1767(color);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        Class278.Method1771(new AxisAlignedBB(d, d2, d3, d + d4, d2 + d5, d3 + d6), color, n, bufferBuilder, n2, false);
        tessellator.draw();
        GlStateManager.enableAlpha();
    }

    public static void Method1772(BlockPos blockPos, double d, float f, Color color) {
        Class278.Method1005(Class278.Method1773(blockPos, 1.0, d, 1.0), f, color, color.getAlpha());
    }

    public static void Method1774(AxisAlignedBB axisAlignedBB, double d, Color color) {
        Class278.Method1005(axisAlignedBB, d, color, color.getAlpha());
    }

    public static void Method1005(AxisAlignedBB axisAlignedBB, double d, Color color, int n) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float)((float)d));
        Class278.Method1767(color);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
        Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
        Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
        Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
        Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
        Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
        Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
        Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
        Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
        Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
        Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
        Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
        Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
        Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
        Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
        Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
        tessellator.draw();
    }

    public static void Method1776(BlockPos blockPos, int n, Color color, int n2) {
        Class278.Method1004(Class278.Method1773(blockPos, 1.0, 1.0, 1.0), n, color, color.getAlpha(), n2);
    }

    public static void Method1777(BlockPos blockPos, int n, Color color, int n2, int n3) {
        Class278.Method1004(Class278.Method1773(blockPos, 1.0, 1.0, 1.0), n, color, n2, n3);
    }

    public static void Method1778(AxisAlignedBB axisAlignedBB, int n, Color color, int n2) {
        Class278.Method1004(axisAlignedBB, n, color, color.getAlpha(), n2);
    }

    public static void Method1004(AxisAlignedBB axisAlignedBB, int n, Color color, int n2, int n3) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.glLineWidth((float)n);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        Class278.Method1771(axisAlignedBB, color, n2, bufferBuilder, n3, true);
        tessellator.draw();
    }

    private static void Method1779(double d, double d2, double d3, BufferBuilder bufferBuilder) {
        bufferBuilder.pos(d - Globals.mc.getRenderManager().viewerPosX, d2 - Globals.mc.getRenderManager().viewerPosY, d3 - Globals.mc.getRenderManager().viewerPosZ).endVertex();
    }

    private static void Method1775(double d, double d2, double d3, Color color, int n, BufferBuilder bufferBuilder) {
        bufferBuilder.pos(d - Globals.mc.getRenderManager().viewerPosX, d2 - Globals.mc.getRenderManager().viewerPosY, d3 - Globals.mc.getRenderManager().viewerPosZ).color(color.getRed(), color.getGreen(), color.getBlue(), n).endVertex();
    }

    private static AxisAlignedBB Method1773(BlockPos blockPos, double d, double d2, double d3) {
        double d4 = blockPos.getX();
        double d5 = blockPos.getY();
        double d6 = blockPos.getZ();
        return new AxisAlignedBB(d4, d5, d6, d4 + d, d5 + d2, d6 + d3);
    }

    private static void Method1771(AxisAlignedBB axisAlignedBB, Color color, int n, BufferBuilder bufferBuilder, int n2, boolean bl) {
        if ((n2 & 0x20) != 0) {
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
            if (bl) {
                Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            }
        }
        if ((n2 & 0x10) != 0) {
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
            if (bl) {
                Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            }
        }
        if ((n2 & 4) != 0) {
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
            if (bl) {
                Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            }
        }
        if ((n2 & 8) != 0) {
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
            if (bl) {
                Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            }
        }
        if ((n2 & 2) != 0) {
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, color, n, bufferBuilder);
            if (bl) {
                Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ, color, n, bufferBuilder);
            }
        }
        if ((n2 & 1) != 0) {
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, color, color.getAlpha(), bufferBuilder);
            Class278.Method1775(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            if (bl) {
                Class278.Method1775(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, color, color.getAlpha(), bufferBuilder);
            }
        }
    }

    public static void Method1780() {
        GL11.glHint((int)3154, (int)4354);
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.shadeModel((int)7425);
        GlStateManager.depthMask((boolean)false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GL11.glEnable((int)2848);
        GL11.glEnable((int)34383);
    }

    public static void Method1781() {
        GL11.glDisable((int)34383);
        GL11.glDisable((int)2848);
        GlStateManager.enableAlpha();
        GlStateManager.enableCull();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.glLineWidth((float)1.0f);
        GlStateManager.shadeModel((int)7424);
        GL11.glHint((int)3154, (int)4352);
    }
}
