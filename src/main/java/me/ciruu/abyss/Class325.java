package me.ciruu.abyss;

import me.ciruu.abyss.Class326;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class3;
import me.ciruu.abyss.modules.render.Freecam;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class Class325 {
    private static final Minecraft Field948 = Minecraft.getMinecraft();
    private static float Field949;
    private static float Field950;
    private static boolean Field951;

    public static void Method1303(boolean bl) {
        Field951 = bl;
    }

    public static boolean Method1304() {
        return Field951;
    }

    public static boolean Method1305() {
        return Manager.moduleManager.getModuleByClass(Freecam.class) != null && Manager.moduleManager.isModuleEnabled(Freecam.class) && ((Freecam)Manager.moduleManager.getModuleByClass(Freecam.class)).mode.getValue() == Class3.Camera;
    }

    public static boolean Method1306() {
        return Class325.Method1305();
    }

    public static boolean Method1307() {
        return Class325.Method1305();
    }

    public static float Method1308() {
        return MathHelper.wrapDegrees((float)Field949);
    }

    public static float Method1309() {
        return MathHelper.wrapDegrees((float)Field950);
    }

    public static void Method1310(float f) {
        Field949 = f;
    }

    public static void Method1311(float f) {
        Field950 = f;
    }

    public static void Method1312(float f, float f2) {
        Class326 class326 = Class326.getCamera();
        if (class326 != null) {
            class326.setCameraRotations(f, f2);
        }
    }

    public static void Method1313(float f, float f2) {
        Class326 class326 = Class326.getCamera();
        if (class326 != null) {
            class326.updateCameraRotations(f, f2);
        }
    }

    public static void Method1314(ViewFrustum viewFrustum, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        if (n == n3 && n2 == n4) {
            return;
        }
        int n11 = Class325.Field948.gameSettings.renderDistanceChunks;
        ChunkProviderClient chunkProviderClient = Class325.Field948.world.getChunkProvider();
        if (n != n3) {
            n10 = n > n3 ? n3 + n11 : n - n11;
            n9 = n > n3 ? n + n11 : n3 - n11;
            for (n8 = n10; n8 <= n9; ++n8) {
                for (n7 = n2 - n11; n7 <= n2 + n11; ++n7) {
                    if (!chunkProviderClient.isChunkGeneratedAt(n8, n7)) continue;
                    n6 = n8 << 4;
                    n5 = n7 << 4;
                    viewFrustum.markBlocksForUpdate(n6, 0, n5, n6, 255, n5, false);
                }
            }
        }
        if (n2 != n4) {
            n10 = n2 > n4 ? n4 + n11 : n2 - n11;
            n9 = n2 > n4 ? n2 + n11 : n4 - n11;
            for (n8 = n10; n8 <= n9; ++n8) {
                for (n7 = n - n11; n7 <= n + n11; ++n7) {
                    if (!chunkProviderClient.isChunkGeneratedAt(n7, n8)) continue;
                    n6 = n7 << 4;
                    n5 = n8 << 4;
                    viewFrustum.markBlocksForUpdate(n6, 0, n5, n6, 255, n5, false);
                }
            }
        }
    }

    public static void Method1315(int n, int n2) {
        ChunkProviderClient chunkProviderClient = Class325.Field948.world.getChunkProvider();
        Entity entity = Globals.mc.getRenderViewEntity();
        int n3 = Class325.Field948.gameSettings.renderDistanceChunks;
        int n4 = entity.chunkCoordX;
        int n5 = entity.chunkCoordZ;
        int n6 = n - n3;
        int n7 = n + n3;
        int n8 = n2 - n3;
        int n9 = n2 + n3;
        int n10 = n4 - n3;
        int n11 = n4 + n3;
        int n12 = n5 - n3;
        int n13 = n5 + n3;
        for (int i = n12; i <= n13; ++i) {
            for (int j = n10; j <= n11; ++j) {
                if (j >= n6 && j <= n7 && i >= n8 && i <= n9 || !chunkProviderClient.isChunkGeneratedAt(j, i)) continue;
                int n14 = j << 4;
                int n15 = i << 4;
                Class325.Field948.world.markBlockRangeForRenderUpdate(n14, 0, n15, n14, 255, n15);
            }
        }
    }
}
