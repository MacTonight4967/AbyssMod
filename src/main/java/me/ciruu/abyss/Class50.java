package me.ciruu.abyss;

import java.awt.Color;
import java.util.Objects;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class72;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.client.CustomFont;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

public class Class50 {
    public static RenderItem Field637 = Globals.mc.getRenderItem();
    public static ICamera Field638 = new Frustum();
    private static boolean Field639 = GL11.glIsEnabled((int)2896);
    private static boolean Field640 = GL11.glIsEnabled((int)3042);
    private static boolean Field641 = GL11.glIsEnabled((int)3553);
    private static boolean Field642 = GL11.glIsEnabled((int)2929);
    private static boolean Field643 = GL11.glIsEnabled((int)2848);

    @Class72
    public static void Method764(int n, int n2, int n3, int n4, int n5) {
        GL11.glLineWidth((float)1.0f);
        Gui.drawRect((int)n, (int)n2, (int)(n + n3), (int)(n2 + n4), (int)n5);
    }

    @Class72
    public static AxisAlignedBB Method767(AxisAlignedBB axisAlignedBB) {
        return new AxisAlignedBB(axisAlignedBB.minX - Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.minY - Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.minZ - Globals.mc.getRenderManager().viewerPosZ, axisAlignedBB.maxX - Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.maxY - Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.maxZ - Globals.mc.getRenderManager().viewerPosZ);
    }

    @Class72
    public static void Method769(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos((double)(n + 0), (double)(n2 + n6), (double)n7).tex((double)((float)(n3 + 0) * 0.00390625f), (double)((float)(n4 + n6) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double)(n + n5), (double)(n2 + n6), (double)n7).tex((double)((float)(n3 + n5) * 0.00390625f), (double)((float)(n4 + n6) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double)(n + n5), (double)(n2 + 0), (double)n7).tex((double)((float)(n3 + n5) * 0.00390625f), (double)((float)(n4 + 0) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double)(n + 0), (double)(n2 + 0), (double)n7).tex((double)((float)(n3 + 0) * 0.00390625f), (double)((float)(n4 + 0) * 0.00390625f)).endVertex();
        tessellator.draw();
    }

    public static void Method777(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = 1.0f / f9;
        float f12 = 1.0f / f10;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos((double)f, (double)(f2 + f8), 0.0).tex((double)(f3 * f11), (double)((f4 + f6) * f12)).endVertex();
        bufferBuilder.pos((double)(f + f7), (double)(f2 + f8), 0.0).tex((double)((f3 + f5) * f11), (double)((f4 + f6) * f12)).endVertex();
        bufferBuilder.pos((double)(f + f7), (double)f2, 0.0).tex((double)((f3 + f5) * f11), (double)(f4 * f12)).endVertex();
        bufferBuilder.pos((double)f, (double)f2, 0.0).tex((double)(f3 * f11), (double)(f4 * f12)).endVertex();
        tessellator.draw();
    }

    public static void Method136(BlockPos blockPos, Color color, Color color2, float f) {
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        Vec3d vec3d = Class30.Method778(Globals.mc.getRenderViewEntity(), Globals.mc.getRenderPartialTicks());
        Class50.Method779(iBlockState.getSelectedBoundingBox((World)Globals.mc.world, blockPos).grow((double)0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, color2, f);
    }

    public static void Method780(BlockPos blockPos, Color color, Color color2, Color color3, float f) {
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        Vec3d vec3d = Class30.Method778((Entity)Globals.mc.player, Globals.mc.getRenderPartialTicks());
        Class50.Method781(iBlockState.getSelectedBoundingBox((World)Globals.mc.world, blockPos).grow((double)0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, color2, color3, f);
    }

    public static void Method781(AxisAlignedBB axisAlignedBB, Color color, Color color2, Color color3, float f) {
        float f2 = (float)color3.getRed() / 255.0f;
        float f3 = (float)color3.getGreen() / 255.0f;
        float f4 = (float)color3.getBlue() / 255.0f;
        float f5 = (float)color3.getAlpha() / 255.0f;
        float f6 = (float)color2.getRed() / 255.0f;
        float f7 = (float)color2.getGreen() / 255.0f;
        float f8 = (float)color2.getBlue() / 255.0f;
        float f9 = (float)color2.getAlpha() / 255.0f;
        float f10 = (float)color.getRed() / 255.0f;
        float f11 = (float)color.getGreen() / 255.0f;
        float f12 = (float)color.getBlue() / 255.0f;
        float f13 = (float)color.getAlpha() / 255.0f;
        double d = (axisAlignedBB.maxY - axisAlignedBB.minY) / 2.0;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)f);
        GL11.glBegin((int)1);
        GL11.glColor4d((double)f2, (double)f3, (double)f4, (double)f5);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glColor4d((double)f6, (double)f7, (double)f8, (double)f9);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)(axisAlignedBB.minY + d), (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)(axisAlignedBB.minY + d), (double)axisAlignedBB.minZ);
        GL11.glColor4f((float)f10, (float)f11, (float)f12, (float)f13);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glColor4d((double)f2, (double)f3, (double)f4, (double)f5);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glColor4d((double)f6, (double)f7, (double)f8, (double)f9);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)(axisAlignedBB.minY + d), (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)(axisAlignedBB.minY + d), (double)axisAlignedBB.maxZ);
        GL11.glColor4d((double)f10, (double)f11, (double)f12, (double)f13);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glColor4d((double)f2, (double)f3, (double)f4, (double)f5);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glColor4d((double)f6, (double)f7, (double)f8, (double)f9);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)(axisAlignedBB.minY + d), (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)(axisAlignedBB.minY + d), (double)axisAlignedBB.maxZ);
        GL11.glColor4d((double)f10, (double)f11, (double)f12, (double)f13);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glColor4d((double)f2, (double)f3, (double)f4, (double)f5);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glColor4d((double)f6, (double)f7, (double)f8, (double)f9);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)(axisAlignedBB.minY + d), (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)(axisAlignedBB.minY + d), (double)axisAlignedBB.minZ);
        GL11.glColor4d((double)f10, (double)f11, (double)f12, (double)f13);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glColor4d((double)f10, (double)f11, (double)f12, (double)f13);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method779(AxisAlignedBB axisAlignedBB, Color color, Color color2, float f) {
        float f2 = (float)color.getRed() / 255.0f;
        float f3 = (float)color.getGreen() / 255.0f;
        float f4 = (float)color.getBlue() / 255.0f;
        float f5 = (float)color.getAlpha() / 255.0f;
        float f6 = (float)color2.getRed() / 255.0f;
        float f7 = (float)color2.getGreen() / 255.0f;
        float f8 = (float)color2.getBlue() / 255.0f;
        float f9 = (float)color2.getAlpha() / 255.0f;
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
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f9).endVertex();
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

    public static void Method135(BlockPos blockPos, Color color, Color color2) {
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        Vec3d vec3d = Class30.Method778((Entity)Globals.mc.player, Globals.mc.getRenderPartialTicks());
        Class50.Method782(iBlockState.getSelectedBoundingBox((World)Globals.mc.world, blockPos).grow((double)0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, color2);
    }

    public static void Method782(AxisAlignedBB axisAlignedBB, Color color, Color color2) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        float f = (float)color2.getAlpha() / 255.0f;
        float f2 = (float)color2.getRed() / 255.0f;
        float f3 = (float)color2.getGreen() / 255.0f;
        float f4 = (float)color2.getBlue() / 255.0f;
        float f5 = (float)color.getAlpha() / 255.0f;
        float f6 = (float)color.getRed() / 255.0f;
        float f7 = (float)color.getGreen() / 255.0f;
        float f8 = (float)color.getBlue() / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        tessellator.draw();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Class72
    public static void Method783(BlockPos blockPos, Color color, double d, double d2) {
        Class50.Method784(blockPos, color, d, d2);
    }

    @Class72
    public static void Method137(BlockPos blockPos, Color color, boolean bl, Color color2, float f, boolean bl2, boolean bl3, int n, boolean bl4) {
        if (bl3) {
            Class50.Method788(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue(), n));
        }
        if (bl2) {
            Class50.Method789(blockPos, bl ? color2 : color, f, bl4);
        }
    }

    public static void Method790(BlockPos blockPos, Color color, boolean bl, Color color2, float f, boolean bl2, boolean bl3, int n, boolean bl4, double d) {
        if (bl3) {
            Class50.Method791(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue(), n), d);
        }
        if (bl2) {
            Class50.Method792(blockPos, bl ? color2 : color, f, bl4, d);
        }
    }

    @Class72
    public static void Method793(BlockPos blockPos, Color color, boolean bl, Color color2, float f, boolean bl2, boolean bl3, int n, boolean bl4) {
        if (bl3) {
            Class50.Method794(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue(), n));
        }
        if (bl2) {
            Class50.Method795(blockPos, bl ? color2 : color, f, bl4);
        }
    }

    @Class72
    public static void Method207(BlockPos blockPos, Color color, boolean bl, Color color2, float f, boolean bl2, boolean bl3, int n, boolean bl4) {
        if (bl3) {
            Class50.Method796(blockPos, new Color(color.getRed(), color.getGreen(), color.getBlue(), n));
        }
        if (bl2) {
            Class50.Method797(blockPos, bl ? color2 : color, f, bl4);
        }
    }

    public static void Method791(BlockPos blockPos, Color color, double d) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)blockPos.getX() - Globals.mc.getRenderManager().viewerPosX, (double)blockPos.getY() - Globals.mc.getRenderManager().viewerPosY, (double)blockPos.getZ() - Globals.mc.getRenderManager().viewerPosZ, (double)(blockPos.getX() + 1) - Globals.mc.getRenderManager().viewerPosX, (double)(blockPos.getY() + 1) - Globals.mc.getRenderManager().viewerPosY + d, (double)(blockPos.getZ() + 1) - Globals.mc.getRenderManager().viewerPosZ);
        Field638.setPosition(Objects.requireNonNull(Globals.mc.getRenderViewEntity()).posX, Globals.mc.getRenderViewEntity().posY, Globals.mc.getRenderViewEntity().posZ);
        if (Field638.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.minY + Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.minZ + Globals.mc.getRenderManager().viewerPosZ, axisAlignedBB.maxX + Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.maxY + Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.maxZ + Globals.mc.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GL11.glEnable((int)2848);
            GL11.glHint((int)3154, (int)4354);
            RenderGlobal.renderFilledBox((AxisAlignedBB)axisAlignedBB, (float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
            GL11.glDisable((int)2848);
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void Method792(BlockPos blockPos, Color color, float f, boolean bl, double d) {
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && Globals.mc.world.getWorldBorder().contains(blockPos)) {
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)blockPos.getX() - Globals.mc.getRenderManager().viewerPosX, (double)blockPos.getY() - Globals.mc.getRenderManager().viewerPosY, (double)blockPos.getZ() - Globals.mc.getRenderManager().viewerPosZ, (double)(blockPos.getX() + 1) - Globals.mc.getRenderManager().viewerPosX, (double)(blockPos.getY() + 1) - Globals.mc.getRenderManager().viewerPosY + d, (double)(blockPos.getZ() + 1) - Globals.mc.getRenderManager().viewerPosZ);
            Class50.Method798(axisAlignedBB.grow((double)0.002f), color, f);
        }
    }

    @Class72
    public static void Method799(float f, float f2, float f3, float f4, ScaledResolution scaledResolution) {
        GL11.glScissor((int)((int)(f * (float)scaledResolution.getScaleFactor())), (int)((int)((float)Globals.mc.displayHeight - f4 * (float)scaledResolution.getScaleFactor())), (int)((int)((f3 - f) * (float)scaledResolution.getScaleFactor())), (int)((int)((f4 - f2) * (float)scaledResolution.getScaleFactor())));
    }

    @Class72
    public static void Method802(float f, float f2, float f3, float f4, float f5, int n) {
        float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n & 0xFF) / 255.0f;
        float f9 = (float)(n >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        GL11.glLineWidth((float)f5);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f, (double)f2, 0.0).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos((double)f3, (double)f4, 0.0).color(f6, f7, f8, f9).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GL11.glDisable((int)2848);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    @Class72
    public static void Method817(float f, float f2, float f3, float f4, float f5, int n, int n2) {
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        float f10 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f11 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f12 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f13 = (float)(n2 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        GL11.glLineWidth((float)f5);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f, (double)f2, 0.0).color(f7, f8, f9, f6).endVertex();
        bufferBuilder.pos((double)f3, (double)f4, 0.0).color(f11, f12, f13, f10).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GL11.glDisable((int)2848);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    @Class72
    public static void Method796(BlockPos blockPos, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)blockPos.getX() - Globals.mc.getRenderManager().viewerPosX, (double)blockPos.getY() + 0.1 - Globals.mc.getRenderManager().viewerPosY, (double)blockPos.getZ() - Globals.mc.getRenderManager().viewerPosZ, (double)(blockPos.getX() + 1) - Globals.mc.getRenderManager().viewerPosX, (double)blockPos.getY() - Globals.mc.getRenderManager().viewerPosY, (double)(blockPos.getZ() + 1) - Globals.mc.getRenderManager().viewerPosZ);
        Field638.setPosition(Objects.requireNonNull(Globals.mc.getRenderViewEntity()).posX, Globals.mc.getRenderViewEntity().posY, Globals.mc.getRenderViewEntity().posZ);
        if (Field638.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.minY + Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.minZ + Globals.mc.getRenderManager().viewerPosZ, axisAlignedBB.maxX + Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.maxY + Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.maxZ + Globals.mc.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GL11.glEnable((int)2848);
            GL11.glHint((int)3154, (int)4354);
            RenderGlobal.renderFilledBox((AxisAlignedBB)axisAlignedBB, (float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
            GL11.glDisable((int)2848);
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    @Class72
    public static void Method794(BlockPos blockPos, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)blockPos.getX() - Globals.mc.getRenderManager().viewerPosX, (double)blockPos.getY() + 0.9 - Globals.mc.getRenderManager().viewerPosY, (double)blockPos.getZ() - Globals.mc.getRenderManager().viewerPosZ, (double)(blockPos.getX() + 1) - Globals.mc.getRenderManager().viewerPosX, (double)(blockPos.getY() + 1) - Globals.mc.getRenderManager().viewerPosY, (double)(blockPos.getZ() + 1) - Globals.mc.getRenderManager().viewerPosZ);
        Field638.setPosition(Objects.requireNonNull(Globals.mc.getRenderViewEntity()).posX, Globals.mc.getRenderViewEntity().posY, Globals.mc.getRenderViewEntity().posZ);
        if (Field638.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.minY + Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.minZ + Globals.mc.getRenderManager().viewerPosZ, axisAlignedBB.maxX + Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.maxY + Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.maxZ + Globals.mc.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GL11.glEnable((int)2848);
            GL11.glHint((int)3154, (int)4354);
            RenderGlobal.renderFilledBox((AxisAlignedBB)axisAlignedBB, (float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
            GL11.glDisable((int)2848);
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    @Class72
    public static void Method788(BlockPos blockPos, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)blockPos.getX() - Globals.mc.getRenderManager().viewerPosX, (double)blockPos.getY() - Globals.mc.getRenderManager().viewerPosY, (double)blockPos.getZ() - Globals.mc.getRenderManager().viewerPosZ, (double)(blockPos.getX() + 1) - Globals.mc.getRenderManager().viewerPosX, (double)(blockPos.getY() + 1) - Globals.mc.getRenderManager().viewerPosY, (double)(blockPos.getZ() + 1) - Globals.mc.getRenderManager().viewerPosZ);
        Field638.setPosition(Objects.requireNonNull(Globals.mc.getRenderViewEntity()).posX, Globals.mc.getRenderViewEntity().posY, Globals.mc.getRenderViewEntity().posZ);
        if (Field638.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.minY + Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.minZ + Globals.mc.getRenderManager().viewerPosZ, axisAlignedBB.maxX + Globals.mc.getRenderManager().viewerPosX, axisAlignedBB.maxY + Globals.mc.getRenderManager().viewerPosY, axisAlignedBB.maxZ + Globals.mc.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GL11.glEnable((int)2848);
            GL11.glHint((int)3154, (int)4354);
            RenderGlobal.renderFilledBox((AxisAlignedBB)axisAlignedBB, (float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
            GL11.glDisable((int)2848);
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    @Class72
    public static void Method789(BlockPos blockPos, Color color, float f, boolean bl) {
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && Globals.mc.world.getWorldBorder().contains(blockPos)) {
            Vec3d vec3d = Class30.Method778(Globals.mc.getRenderViewEntity(), Globals.mc.getRenderPartialTicks());
            Class50.Method798(iBlockState.getSelectedBoundingBox((World)Globals.mc.world, blockPos).grow((double)0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, f);
        }
    }

    @Class72
    public static void Method795(BlockPos blockPos, Color color, float f, boolean bl) {
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && Globals.mc.world.getWorldBorder().contains(blockPos)) {
            Vec3d vec3d = Class30.Method778(Globals.mc.getRenderViewEntity(), Globals.mc.getRenderPartialTicks());
            Class50.Method839(iBlockState.getSelectedBoundingBox((World)Globals.mc.world, blockPos).grow((double)0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, f);
        }
    }

    @Class72
    public static void Method797(BlockPos blockPos, Color color, float f, boolean bl) {
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        if ((bl || iBlockState.getMaterial() != Material.AIR) && Globals.mc.world.getWorldBorder().contains(blockPos)) {
            Vec3d vec3d = Class30.Method778(Globals.mc.getRenderViewEntity(), Globals.mc.getRenderPartialTicks());
            Class50.Method840(iBlockState.getSelectedBoundingBox((World)Globals.mc.world, blockPos).grow((double)0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), color, f);
        }
    }

    @Class72
    public static void Method840(AxisAlignedBB axisAlignedBB, Color color, float f) {
        float f2 = (float)color.getRed() / 255.0f;
        float f3 = (float)color.getGreen() / 255.0f;
        float f4 = (float)color.getBlue() / 255.0f;
        float f5 = (float)color.getAlpha() / 255.0f;
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
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.1, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.1, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.1, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.1, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.1, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY - 1.0, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY - 1.0, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.1, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.1, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY - 1.0, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY - 1.0, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY - 1.0, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY - 1.0, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.1, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY - 1.0, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY - 1.0, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void Method839(AxisAlignedBB axisAlignedBB, Color color, float f) {
        float f2 = (float)color.getRed() / 255.0f;
        float f3 = (float)color.getGreen() / 255.0f;
        float f4 = (float)color.getBlue() / 255.0f;
        float f5 = (float)color.getAlpha() / 255.0f;
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
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.9, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.9, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.9, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.9, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.9, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY + 0.9, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.9, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY + 0.9, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
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
    public static void Method798(AxisAlignedBB axisAlignedBB, Color color, float f) {
        float f2 = (float)color.getRed() / 255.0f;
        float f3 = (float)color.getGreen() / 255.0f;
        float f4 = (float)color.getBlue() / 255.0f;
        float f5 = (float)color.getAlpha() / 255.0f;
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
    public static void Method841(BlockPos blockPos, String string, int n) {
        GlStateManager.pushMatrix();
        Class50.Method842((float)blockPos.getX() + 0.5f, (float)blockPos.getY() + 1.0f, (float)blockPos.getZ() + 0.5f, (EntityPlayer)Globals.mc.player, 1.0f);
        GlStateManager.disableDepth();
        if (Manager.moduleManager.isModuleEnabled(CustomFont.class)) {
            GlStateManager.translate((double)(-((double)Class36.Method550().getStringWidth(string) / 2.0)), (double)0.0, (double)0.0);
            Class36.Method550().drawStringWithShadow(string, 0.0f, 0.0f, n);
        } else {
            GlStateManager.translate((double)(-((double)Class36.Method551().getStringWidth(string) / 2.0)), (double)0.0, (double)0.0);
            Class36.Method551().drawStringWithShadow(string, 0.0f, 0.0f, n);
        }
        GlStateManager.popMatrix();
    }

    public static void Method846(BlockPos blockPos, String string, int n) {
        GlStateManager.pushMatrix();
        Class50.Method842((float)blockPos.getX() + 0.5f, (float)blockPos.getY() + 0.5f, (float)blockPos.getZ() + 0.5f, (EntityPlayer)Globals.mc.player, 1.0f);
        GlStateManager.disableDepth();
        if (Manager.moduleManager.isModuleEnabled(CustomFont.class)) {
            GlStateManager.translate((double)(-((double)Class36.Method550().getStringWidth(string) / 2.0)), (double)0.0, (double)0.0);
            Class36.Method550().drawStringWithShadow(string, 0.0f, 0.0f, n);
        } else {
            GlStateManager.translate((double)(-((double)Class36.Method551().getStringWidth(string) / 2.0)), (double)0.0, (double)0.0);
            Class36.Method551().drawStringWithShadow(string, 0.0f, 0.0f, n);
        }
        GlStateManager.popMatrix();
    }

    @Class72
    public static void Method847(BlockPos blockPos, String string) {
        Class50.Method846(blockPos, string, -5592406);
    }

    public static void Method848(BlockPos blockPos, String string, float f) {
        GlStateManager.pushMatrix();
        Class50.Method842((float)blockPos.getX() + 0.5f, (float)blockPos.getY() + f, (float)blockPos.getZ() + 0.5f, (EntityPlayer)Globals.mc.player, 1.0f);
        GlStateManager.disableDepth();
        if (Manager.moduleManager.isModuleEnabled(CustomFont.class)) {
            GlStateManager.translate((double)(-((double)Class36.Method550().getStringWidth(string) / 2.0)), (double)0.0, (double)0.0);
            Class36.Method550().drawStringWithShadow(string, 0.0f, 0.0f, -5592406);
        } else {
            GlStateManager.translate((double)(-((double)Class36.Method551().getStringWidth(string) / 2.0)), (double)0.0, (double)0.0);
            Class36.Method551().drawStringWithShadow(string, 0.0f, 0.0f, -5592406);
        }
        GlStateManager.popMatrix();
    }

    @Class72
    public static void Method849(BlockPos blockPos, Color color, float f) {
        IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos);
        Vec3d vec3d = Class30.Method778((Entity)Globals.mc.player, Globals.mc.getRenderPartialTicks());
        Class50.Method851(iBlockState.getSelectedBoundingBox((World)Globals.mc.world, blockPos).grow((double)0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), f, Class50.Method850(color));
    }

    @Class72
    public static void Method784(BlockPos blockPos, Color color, double d, double d2) {
        double d3 = (double)blockPos.getX() - Globals.mc.renderManager.renderPosX;
        double d4 = (double)blockPos.getY() - Globals.mc.renderManager.renderPosY;
        double d5 = (double)blockPos.getZ() - Globals.mc.renderManager.renderPosZ;
        GL11.glPushMatrix();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4d((double)((float)color.getRed() / 255.0f), (double)((float)color.getGreen() / 255.0f), (double)((float)color.getBlue() / 255.0f), (double)0.25);
        Class50.Method856(new AxisAlignedBB(d3, d4, d5, d3 + d2, d4 + 1.0, d5 + d), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glColor4d((double)0.0, (double)0.0, (double)0.0, (double)0.5);
        Class50.Method857(new AxisAlignedBB(d3, d4, d5, d3 + d2, d4 + 1.0, d5 + d));
        GL11.glLineWidth((float)2.0f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    @Class72
    public static void Method92(float f, float f2, float f3, float f4, int n) {
        float f5 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f, (double)f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)f3, (double)f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)f3, (double)f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)f, (double)f2, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method860(float f, float f2, float f3, float f4, float f5, int n) {
        Class50.Method802(f, f2, f + f3, f2, f5, n);
        Class50.Method802(f + f3, f2, f + f3, f2 + f4, f5, n);
        Class50.Method802(f + f3, f2 + f4, f, f2 + f4, f5, n);
        Class50.Method802(f, f2 + f4, f, f2, f5, n);
    }

    public static void Method861(float f, float f2, float f3, float f4, float f5, int n) {
        Class50.Method92(f, f2, f - f5, f4, n);
        Class50.Method92(f3 + f5, f2, f3, f4, n);
        Class50.Method92(f, f2, f3, f2 - f5, n);
        Class50.Method92(f, f4 + f5, f3, f4, n);
    }

    public static void Method862(float f, float f2, float f3, float f4, int n, float f5) {
        float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f, (double)f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)f3, (double)f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)f3, (double)f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)f, (double)f2, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    @Class72
    public static void Method863(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        float f5 = (float)(n6 >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n6 & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)n + (double)n3, (double)n2, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos((double)n, (double)n2, 0.0).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos((double)n, (double)n2 + (double)n4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)n + (double)n3, (double)n2 + (double)n4, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void Method864(int n, int n2, int n3, int n4, int n5, int n6) {
        Class50.Method817(n, n2, n + n3, n2, 2.0f, n5, n6);
        Class50.Method817(n + n3, n2, n + n3, n2 + n4, 2.0f, n6, n5);
        Class50.Method817(n + n3, n2 + n4, n, n2 + n4, 2.0f, n5, n6);
        Class50.Method817(n, n2 + n4, n, n2, 2.0f, n6, n5);
    }

    public static void Method865(float f, float f2, float f3, float f4, Color color) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)color.getRed(), (float)color.getGreen(), (float)color.getBlue(), (float)color.getAlpha());
        GlStateManager.glLineWidth((float)f4);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(2, DefaultVertexFormats.POSITION);
        for (int i = 0; i <= 360; ++i) {
            bufferBuilder.pos((double)f + Math.sin((double)i * Math.PI / 180.0) * (double)f3, (double)f2 + Math.cos((double)i * Math.PI / 180.0) * (double)f3, 0.0);
        }
        tessellator.draw();
        GlStateManager.resetColor();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void Method866(float f, float f2, float f3, float f4, Color color) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float)f4);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(2, DefaultVertexFormats.POSITION);
        float[] fArray = new float[3];
        for (int i = 0; i <= 360; ++i) {
            Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fArray);
            fArray[0] = fArray[0] + 1.0f;
            color = new Color(Color.HSBtoRGB(fArray[0], fArray[1], fArray[2]));
            GlStateManager.color((float)color.getRed(), (float)color.getGreen(), (float)color.getBlue(), (float)color.getAlpha());
            bufferBuilder.pos((double)f + Math.sin((double)i * Math.PI / 180.0) * (double)f3, (double)f2 + Math.cos((double)i * Math.PI / 180.0) * (double)f3, 0.0);
        }
        tessellator.draw();
        GlStateManager.resetColor();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    @Class72
    public static void Method856(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f, f2, f3, f4).endVertex();
        tessellator.draw();
    }

    @Class72
    public static void Method857(AxisAlignedBB axisAlignedBB) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
    }

    @Class72
    public static void Method867() {
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)2929);
        double d = Globals.mc.getRenderManager().viewerPosX;
        double d2 = Globals.mc.getRenderManager().viewerPosY;
        double d3 = Globals.mc.getRenderManager().viewerPosZ;
        GL11.glPushMatrix();
        GL11.glTranslated((double)(-d), (double)(-d2), (double)(-d3));
    }

    @Class72
    public static void Method869(float f, float f2, float f3, float f4) {
        Class50.Method867();
        GL11.glColor4f((float)f, (float)f2, (float)f3, (float)f4);
    }

    @Class72
    public static void Method870() {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
    }

    @Class72
    public static AxisAlignedBB Method871(BlockPos blockPos) {
        return Globals.mc.world.getBlockState(blockPos).getBoundingBox((IBlockAccess)Globals.mc.world, blockPos).offset(blockPos);
    }

    @Class72
    public static void Method874(AxisAlignedBB axisAlignedBB) {
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
    }

    @Class72
    public static void Method878(BlockPos blockPos, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)blockPos.getX() - Globals.mc.getRenderManager().viewerPosX, (double)blockPos.getY() - Globals.mc.getRenderManager().viewerPosY, (double)blockPos.getZ() - Globals.mc.getRenderManager().viewerPosZ, (double)(blockPos.getX() + 1) - Globals.mc.getRenderManager().viewerPosX, (double)(blockPos.getY() + 1) - Globals.mc.getRenderManager().viewerPosY, (double)(blockPos.getZ() + 1) - Globals.mc.getRenderManager().viewerPosZ);
        int n = Class50.Method850(color);
        Class50.Method879(axisAlignedBB, n);
    }

    public static int Method880(int n, int n2, int n3, int n4) {
        return (n << 16) + (n2 << 8) + n3 + (n4 << 24);
    }

    public static int Method850(Color color) {
        return Class50.Method880(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    @Class72
    public static void Method879(AxisAlignedBB axisAlignedBB, int n) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n & 0xFF) / 255.0f;
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f).endVertex();
        tessellator.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Class72
    public static void Method851(AxisAlignedBB axisAlignedBB, float f, int n) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)f);
        float f2 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        tessellator.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Class72
    public static void Method881(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        GlStateManager.translate((double)((double)f - Globals.mc.getRenderManager().renderPosX), (double)((double)f2 - Globals.mc.getRenderManager().renderPosY), (double)((double)f3 - Globals.mc.getRenderManager().renderPosZ));
        GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(-Globals.mc.player.rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)Globals.mc.player.rotationPitch, (float)(Globals.mc.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((float)(-f4), (float)(-f4), (float)f4);
    }

    @Class72
    public static void Method842(float f, float f2, float f3, EntityPlayer entityPlayer, float f4) {
        Class50.Method881(f, f2, f3);
        int n = (int)entityPlayer.getDistance((double)f, (double)f2, (double)f3);
        float f5 = (float)n / 2.0f / (4.0f - f4);
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float)f5, (float)f5, (float)f5);
    }

    @Class72
    public static void Method886(AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4, float f5) {
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
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, 0.0f).endVertex();
        tessellator.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Class72
    public static void Method887(double d, double d2, double d3, float f, int n, int n2) {
        Sphere sphere = new Sphere();
        GL11.glPushMatrix();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.2f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        sphere.setDrawStyle(100013);
        GL11.glTranslated((double)(d - Globals.mc.renderManager.renderPosX), (double)(d2 - Globals.mc.renderManager.renderPosY), (double)(d3 - Globals.mc.renderManager.renderPosZ));
        sphere.draw(f, n, n2);
        GL11.glLineWidth((float)2.0f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void Method891(float f, float f2, float f3, Color color) {
        double[] dArray;
        double d;
        double d2;
        double d3;
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc((int)516, (float)0.001f);
        GlStateManager.enableBlend();
        GL11.glDisable((int)3553);
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.color((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        GL11.glBegin((int)9);
        for (d3 = 0.0; d3 < 36.0; d3 += 1.0) {
            d2 = d3 * 10.0 * Math.PI / 180.0;
            d = (d3 * 10.0 - 1.0) * Math.PI / 180.0;
            dArray = new double[]{Math.cos(d2) * (double)f3, -Math.sin(d2) * (double)f3, Math.cos(d) * (double)f3, -Math.sin(d) * (double)f3};
            GL11.glVertex2d((double)((double)f + dArray[0]), (double)((double)f2 + dArray[1]));
        }
        GL11.glEnd();
        GL11.glEnable((int)2848);
        GL11.glBegin((int)3);
        for (d3 = 0.0; d3 < 37.0; d3 += 1.0) {
            d2 = d3 * 10.0 * Math.PI / 180.0;
            d = (d3 * 10.0 - 1.0) * Math.PI / 180.0;
            dArray = new double[]{Math.cos(d2) * (double)f3, -Math.sin(d2) * (double)f3, Math.cos(d) * (double)f3, -Math.sin(d) * (double)f3};
            GL11.glVertex2d((double)((double)f + dArray[0]), (double)((double)f2 + dArray[1]));
        }
        GL11.glEnd();
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.resetColor();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.alphaFunc((int)516, (float)0.1f);
    }

    @Class72
    public static void Method892(float f) {
        Field639 = GL11.glIsEnabled((int)2896);
        Field640 = GL11.glIsEnabled((int)3042);
        Field641 = GL11.glIsEnabled((int)3553);
        Field642 = GL11.glIsEnabled((int)2929);
        Field643 = GL11.glIsEnabled((int)2848);
        Class50.Method894(Field639, Field640, Field641, Field642, Field643, f);
    }

    public static void Method895() {
        Class50.Method896(Field639, Field640, Field641, Field642, Field643);
    }

    @Class72
    private static void Method894(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, float f) {
        if (bl) {
            GL11.glDisable((int)2896);
        }
        if (!bl2) {
            GL11.glEnable((int)3042);
        }
        GL11.glLineWidth((float)f);
        if (bl3) {
            GL11.glDisable((int)3553);
        }
        if (bl4) {
            GL11.glDisable((int)2929);
        }
        if (!bl5) {
            GL11.glEnable((int)2848);
        }
        GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GL11.glHint((int)3154, (int)4354);
        GlStateManager.depthMask((boolean)false);
    }

    @Class72
    public static float[][] Method898(ModelBiped modelBiped) {
        float[][] fArrayArray = new float[5][];
        float[] fArray = new float[]{modelBiped.bipedHead.rotateAngleX, modelBiped.bipedHead.rotateAngleY, modelBiped.bipedHead.rotateAngleZ};
        fArrayArray[0] = fArray;
        float[] fArray2 = new float[]{modelBiped.bipedRightArm.rotateAngleX, modelBiped.bipedRightArm.rotateAngleY, modelBiped.bipedRightArm.rotateAngleZ};
        fArrayArray[1] = fArray2;
        float[] fArray3 = new float[]{modelBiped.bipedLeftArm.rotateAngleX, modelBiped.bipedLeftArm.rotateAngleY, modelBiped.bipedLeftArm.rotateAngleZ};
        fArrayArray[2] = fArray3;
        float[] fArray4 = new float[]{modelBiped.bipedRightLeg.rotateAngleX, modelBiped.bipedRightLeg.rotateAngleY, modelBiped.bipedRightLeg.rotateAngleZ};
        fArrayArray[3] = fArray4;
        float[] fArray5 = new float[]{modelBiped.bipedLeftLeg.rotateAngleX, modelBiped.bipedLeftLeg.rotateAngleY, modelBiped.bipedLeftLeg.rotateAngleZ};
        fArrayArray[4] = fArray5;
        return fArrayArray;
    }

    @Class72
    private static void Method896(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        GlStateManager.depthMask((boolean)true);
        if (!bl5) {
            GL11.glDisable((int)2848);
        }
        if (bl4) {
            GL11.glEnable((int)2929);
        }
        if (bl3) {
            GL11.glEnable((int)3553);
        }
        if (!bl2) {
            GL11.glDisable((int)3042);
        }
        if (bl) {
            GL11.glEnable((int)2896);
        }
    }

    @Class72
    public static void Method899(float f) {
        Class50.Method900();
        GL11.glPushAttrib((int)1048575);
        GL11.glDisable((int)3008);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glLineWidth((float)f);
        GL11.glEnable((int)2848);
        GL11.glEnable((int)2960);
        GL11.glClear((int)1024);
        GL11.glClearStencil((int)15);
        GL11.glStencilFunc((int)512, (int)1, (int)15);
        GL11.glStencilOp((int)7681, (int)7681, (int)7681);
        GL11.glPolygonMode((int)1032, (int)6913);
    }

    @Class72
    public static void Method907() {
        GL11.glStencilFunc((int)512, (int)0, (int)15);
        GL11.glStencilOp((int)7681, (int)7681, (int)7681);
        GL11.glPolygonMode((int)1032, (int)6914);
    }

    @Class72
    public static void Method908() {
        GL11.glStencilFunc((int)514, (int)1, (int)15);
        GL11.glStencilOp((int)7680, (int)7680, (int)7680);
        GL11.glPolygonMode((int)1032, (int)6913);
    }

    @Class72
    public static void Method909(Color color) {
        Class50.Method910(color);
        GL11.glDepthMask((boolean)false);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)10754);
        GL11.glPolygonOffset((float)1.0f, (float)-2000000.0f);
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)240.0f, (float)240.0f);
    }

    @Class72
    public static void Method913() {
        GL11.glPolygonOffset((float)1.0f, (float)2000000.0f);
        GL11.glDisable((int)10754);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)2960);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)3008);
        GL11.glPopAttrib();
    }

    @Class72
    public static void Method910(Color color) {
        GL11.glColor4d((double)((double)color.getRed() / 255.0), (double)((double)color.getGreen() / 255.0), (double)((double)color.getBlue() / 255.0), (double)((double)color.getAlpha() / 255.0));
    }

    public static void Method915(float f, float f2, float f3, float f4, float f5, float f6, float f7, int n) {
        float f8 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f9 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f10 = (float)(n & 0xFF) / 255.0f;
        float f11 = (float)(n >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        GL11.glLineWidth((float)f7);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GlStateManager.disableDepth();
        GL11.glEnable((int)34383);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f, (double)f2, (double)f3).color(f8, f9, f10, f11).endVertex();
        bufferBuilder.pos((double)f4, (double)f5, (double)f6).color(f8, f9, f10, f11).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GL11.glDisable((int)2848);
        GlStateManager.enableDepth();
        GL11.glDisable((int)34383);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    @Class72
    public static void Method900() {
        Framebuffer framebuffer = Globals.mc.framebuffer;
        if (framebuffer != null && framebuffer.depthBuffer > -1) {
            Class50.Method916(framebuffer);
            framebuffer.depthBuffer = -1;
        }
    }

    @Class72
    private static void Method916(Framebuffer framebuffer) {
        EXTFramebufferObject.glDeleteRenderbuffersEXT((int)framebuffer.depthBuffer);
        int n = EXTFramebufferObject.glGenRenderbuffersEXT();
        EXTFramebufferObject.glBindRenderbufferEXT((int)36161, (int)n);
        EXTFramebufferObject.glRenderbufferStorageEXT((int)36161, (int)34041, (int)Globals.mc.displayWidth, (int)Globals.mc.displayHeight);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int)36160, (int)36128, (int)36161, (int)n);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int)36160, (int)36096, (int)36161, (int)n);
    }
}
