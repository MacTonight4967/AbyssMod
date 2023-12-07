package me.ciruu.abyss;

import javax.annotation.Nullable;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.render.Freecam;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.stats.RecipeBook;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Class326
extends EntityPlayerSP {
    @Nullable
    private static Entity Field3127;
    @Nullable
    private static Class326 Field3128;
    private static boolean Field3129;
    private static float Field3130;
    private static float Field3131;
    private static float Field3132;
    private static boolean Field3133;

    public Class326(Minecraft minecraft, World world, NetHandlerPlayClient netHandlerPlayClient, StatisticsManager statisticsManager, RecipeBook recipeBook) {
        super(minecraft, world, netHandlerPlayClient, statisticsManager, recipeBook);
    }

    public boolean isSpectator() {
        return true;
    }

    public static void movementTick(boolean bl, boolean bl2) {
        Class326 class326 = Class326.getCamera();
        if (class326 != null) {
            Minecraft minecraft = Minecraft.getMinecraft();
            class326.updateLastTickPosition();
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            GameSettings gameSettings = minecraft.gameSettings;
            if (gameSettings.keyBindForward.isKeyDown()) {
                f += 1.0f;
            }
            if (gameSettings.keyBindBack.isKeyDown()) {
                f -= 1.0f;
            }
            if (gameSettings.keyBindLeft.isKeyDown()) {
                f3 += 1.0f;
            }
            if (gameSettings.keyBindRight.isKeyDown()) {
                f3 -= 1.0f;
            }
            if (gameSettings.keyBindJump.isKeyDown()) {
                f2 += 1.0f;
            }
            if (gameSettings.keyBindSneak.isKeyDown()) {
                f2 -= 1.0f;
            }
            if (gameSettings.keyBindSprint.isKeyDown()) {
                Field3133 = true;
            } else if (f == 0.0f) {
                Field3133 = false;
            }
            float f4 = 0.15f;
            float f5 = f3 * f3 + f * f;
            f5 = f != 0.0f && f3 != 0.0f ? (float)Math.sqrt((double)f5 * 0.6) : 1.0f;
            Field3130 = Class326.getRampedMotion(Field3130, f, f4) / f5;
            Field3132 = Class326.getRampedMotion(Field3132, f2, f4);
            Field3131 = Class326.getRampedMotion(Field3131, f3, f4) / f5;
            f = Field3133 ? Field3130 * 3.0f : Field3130;
            class326.handleMotion(f, Field3132, Field3131);
        }
    }

    private static float getRampedMotion(float f, float f2, float f3) {
        if (f2 != 0.0f) {
            if (f2 < 0.0f) {
                f3 *= -1.0f;
            }
            if (f2 < 0.0f != f < 0.0f) {
                f = 0.0f;
            }
            f = MathHelper.clamp((float)(f + f3), (float)-1.0f, (float)1.0f);
        } else {
            f *= 0.5f;
        }
        return f;
    }

    private static double getMoveSpeed() {
        double d = 0.07;
        if (Manager.moduleManager.getModuleByClass(Freecam.class) != null) {
            d = ((Float)((Freecam)Manager.moduleManager.getModuleByClass(Freecam.class)).speed.getValue()).floatValue() / 10.0f;
        }
        return d * 10.0;
    }

    private void handleMotion(float f, float f2, float f3) {
        double d = Math.sin((double)this.rotationYaw * Math.PI / 180.0);
        double d2 = Math.cos((double)this.rotationYaw * Math.PI / 180.0);
        double d3 = Class326.getMoveSpeed();
        this.motionX = ((double)f3 * d2 - (double)f * d) * d3;
        this.motionY = (double)f2 * d3;
        this.motionZ = ((double)f * d2 + (double)f3 * d) * d3;
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.chunkCoordX = (int)Math.floor(this.posX) >> 4;
        this.chunkCoordY = (int)Math.floor(this.posY) >> 4;
        this.chunkCoordZ = (int)Math.floor(this.posZ) >> 4;
    }

    private void updateLastTickPosition() {
        this.prevPosX = this.lastTickPosX = this.posX;
        this.prevPosY = this.lastTickPosY = this.posY;
        this.prevPosZ = this.lastTickPosZ = this.posZ;
    }

    public void setCameraRotations(float f, float f2) {
        this.rotationYaw = f;
        this.rotationPitch = f2;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.setRotationYawHead(this.rotationYaw);
        this.setRenderYawOffset(this.rotationYaw);
    }

    public void updateCameraRotations(float f, float f2) {
        this.rotationYaw += f * 0.15f;
        this.rotationPitch = MathHelper.clamp((float)(this.rotationPitch - f2 * 0.15f), (float)-90.0f, (float)90.0f);
        this.setCameraRotations(this.rotationYaw, this.rotationPitch);
    }

    private static Class326 createCameraEntity(Minecraft minecraft) {
        Class326 class326 = new Class326(minecraft, (World)minecraft.world, minecraft.player.connection, minecraft.player.getStatFileWriter(), minecraft.player.getRecipeBook());
        class326.noClip = true;
        EntityPlayerSP entityPlayerSP = minecraft.player;
        if (entityPlayerSP != null) {
            class326.setLocationAndAngles(entityPlayerSP.posX, entityPlayerSP.posY, entityPlayerSP.posZ, entityPlayerSP.rotationYaw, entityPlayerSP.rotationPitch);
            class326.prevRotationYaw = class326.rotationYaw;
            class326.prevRotationPitch = class326.rotationPitch;
            class326.setRotationYawHead(class326.rotationYaw);
            class326.setRenderYawOffset(class326.rotationYaw);
        }
        return class326;
    }

    @Nullable
    public static Class326 getCamera() {
        return Field3128;
    }

    public static void setCameraState(boolean bl) {
        Minecraft minecraft = Minecraft.getMinecraft();
        if (bl) {
            Class326.createAndSetCamera(minecraft);
        } else {
            Class326.removeCamera(minecraft);
        }
    }

    private static void createAndSetCamera(Minecraft minecraft) {
        Field3128 = Class326.createCameraEntity(minecraft);
        Field3127 = minecraft.getRenderViewEntity();
        Field3129 = minecraft.renderChunksMany;
        minecraft.setRenderViewEntity((Entity)Field3128);
        minecraft.renderChunksMany = false;
    }

    private static void removeCamera(Minecraft minecraft) {
        minecraft.setRenderViewEntity(Field3127);
        minecraft.renderChunksMany = Field3129;
        if (minecraft.world != null && Field3128 != null) {
            Class326.markChunksForRebuildOnDeactivation(Class326.Field3128.chunkCoordX, Class326.Field3128.chunkCoordZ);
        }
        Field3127 = null;
        Field3128 = null;
    }

    public static void markChunksForRebuildOnDeactivation(int n, int n2) {
        ChunkProviderClient chunkProviderClient = Globals.mc.world.getChunkProvider();
        Entity entity = Globals.mc.getRenderViewEntity();
        int n3 = Globals.mc.gameSettings.renderDistanceChunks;
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
                Globals.mc.world.markBlockRangeForRenderUpdate(n14, 0, n15, n14, 255, n15);
            }
        }
    }
}
