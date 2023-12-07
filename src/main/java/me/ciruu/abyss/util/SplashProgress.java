package me.ciruu.abyss.util;

import java.awt.Color;
import me.ciruu.abyss.Class36;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;

public class SplashProgress {
    private static final int MAX = 7;
    private static int Progress;
    private static String Current;
    private static ResourceLocation splash;
    private static TextureManager texturemgr;

    public static void Update() {
        if (Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getLanguageManager() == null || Minecraft.getMinecraft().getTextureManager() == null) {
            return;
        }
        SplashProgress.drawSplash(Minecraft.getMinecraft().getTextureManager());
    }

    public static void setProgress(int n, String string) {
        Progress = n;
        Current = string;
        SplashProgress.Update();
    }

    public static void drawSplash(TextureManager textureManager) {
        if (texturemgr == null) {
            texturemgr = textureManager;
        }
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        int n = scaledResolution.getScaleFactor();
        Framebuffer framebuffer = new Framebuffer(scaledResolution.getScaledWidth() * n, scaledResolution.getScaledHeight() * n, true);
        framebuffer.bindFramebuffer(false);
        GlStateManager.matrixMode((int)5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho((double)0.0, (double)scaledResolution.getScaledWidth(), (double)scaledResolution.getScaledHeight(), (double)0.0, (double)1000.0, (double)3000.0);
        GlStateManager.matrixMode((int)5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)-2000.0f);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        if (splash == null) {
            splash = new ResourceLocation("abyss:textures/abyss-screen.png");
        }
        textureManager.bindTexture(splash);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Gui.drawScaledCustomSizeModalRect((int)0, (int)0, (float)0.0f, (float)0.0f, (int)1920, (int)1080, (int)scaledResolution.getScaledWidth(), (int)scaledResolution.getScaledHeight(), (float)1920.0f, (float)1080.0f);
        SplashProgress.drawProgress();
        framebuffer.unbindFramebuffer();
        framebuffer.framebufferRender(scaledResolution.getScaledWidth() * n, scaledResolution.getScaledHeight() * n);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc((int)516, (float)0.1f);
        Minecraft.getMinecraft().updateDisplay();
    }

    private static void drawProgress() {
        if (Minecraft.getMinecraft().gameSettings == null || Minecraft.getMinecraft().getTextureManager() == null) {
            return;
        }
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        double d = Progress;
        double d2 = d / 7.0 * (double)scaledResolution.getScaledWidth();
        Gui.drawRect((int)0, (int)(scaledResolution.getScaledHeight() - 35), (int)scaledResolution.getScaledWidth(), (int)scaledResolution.getScaledHeight(), (int)new Color(0, 0, 0, 50).getRGB());
        Class36.Field465.Method556(Current, 20.0f, scaledResolution.getScaledHeight() - 25, -1);
        String string = Progress + "/" + 7;
        Class36.Field465.Method556(string, scaledResolution.getScaledWidth() - 20 - Class36.Field465.Method563(string), scaledResolution.getScaledHeight() - 25, -505290241);
        Gui.drawRect((int)0, (int)(scaledResolution.getScaledHeight() - 2), (int)((int)d2), (int)scaledResolution.getScaledHeight(), (int)new Color(3, 169, 244).getRGB());
        Gui.drawRect((int)0, (int)(scaledResolution.getScaledHeight() - 2), (int)scaledResolution.getScaledWidth(), (int)scaledResolution.getScaledHeight(), (int)new Color(0, 0, 0, 10).getRGB());
    }

    static {
        Current = "";
    }
}
