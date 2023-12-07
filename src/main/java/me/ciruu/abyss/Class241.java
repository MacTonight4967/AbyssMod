package me.ciruu.abyss;

import me.ciruu.abyss.Class72;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

/*
 * Exception performing whole class analysis ignored.
 */
public static class Class241
extends Tessellator {
    public static Class241 Field1992 = new Class241();

    public Class241() {
        super(0x200000);
    }

    @Class72
    public static void prepare(int n) {
        Class241.prepareGL();
        Class241.begin(n);
    }

    @Class72
    public static void prepareGL() {
        GL11.glBlendFunc((int)770, (int)771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float)1.5f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
    }

    @Class72
    public static void begin(int n) {
        Field1992.getBuffer().begin(n, DefaultVertexFormats.POSITION_COLOR);
    }

    @Class72
    public static void release() {
        Class241.render();
        Class241.releaseGL();
    }

    @Class72
    public static void render() {
        Field1992.draw();
    }

    @Class72
    public static void releaseGL() {
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
    }

    @Class72
    public static void drawBox(BlockPos blockPos, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        Class241.drawBox(blockPos, n4, n5, n6, n3, n2);
    }

    @Class72
    public static void drawBox(float f, float f2, float f3, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        Class241.drawBox(Field1992.getBuffer(), f, f2, f3, 1.0f, 1.0f, 1.0f, n4, n5, n6, n3, n2);
    }

    @Class72
    public static void drawBox(BlockPos blockPos, int n, int n2, int n3, int n4, int n5) {
        Class241.drawBox(Field1992.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n, n2, n3, n4, n5);
    }

    @Class72
    public static BufferBuilder getBufferBuilder() {
        return Field1992.getBuffer();
    }

    @Class72
    public static void drawBox(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 1) != 0) {
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 2) != 0) {
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 4) != 0) {
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 8) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x10) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x20) != 0) {
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
    }

    @Class72
    public static void drawLines(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 0x11) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x12) != 0) {
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x21) != 0) {
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x22) != 0) {
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 5) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 6) != 0) {
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 9) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0xA) != 0) {
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x14) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x24) != 0) {
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x18) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x28) != 0) {
            bufferBuilder.pos((double)(f + f4), (double)f2, (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)(f + f4), (double)(f2 + f5), (double)(f3 + f6)).color(n, n2, n3, n4).endVertex();
        }
    }

    @Class72
    public static void drawBoundingBox(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)f);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Class72
    public static void drawFullBox(AxisAlignedBB axisAlignedBB, BlockPos blockPos, float f, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        Class241.drawFullBox(axisAlignedBB, blockPos, f, n4, n5, n6, n3, n2);
    }

    @Class72
    public static void drawFullBox(AxisAlignedBB axisAlignedBB, BlockPos blockPos, float f, int n, int n2, int n3, int n4, int n5) {
        Class241.prepare(7);
        Class241.drawBox(blockPos, n, n2, n3, n4, 63);
        Class241.release();
        Class241.drawBoundingBox(axisAlignedBB, f, n, n2, n3, n5);
    }

    @Class72
    public static void drawHalfBox(BlockPos blockPos, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        Class241.drawHalfBox(blockPos, n4, n5, n6, n3, n2);
    }

    @Class72
    public static void drawHalfBox(BlockPos blockPos, int n, int n2, int n3, int n4, int n5) {
        Class241.drawBox(Field1992.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 0.5f, 1.0f, n, n2, n3, n4, n5);
    }
}
