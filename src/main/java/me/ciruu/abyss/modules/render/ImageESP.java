package me.ciruu.abyss.modules.render;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import javax.imageio.ImageIO;
import me.ciruu.abyss.Class139;
import me.ciruu.abyss.Class234;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class354;
import me.ciruu.abyss.Class47;
import me.ciruu.abyss.Class470;
import me.ciruu.abyss.Class502;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class ImageESP
extends Module {
    private final Setting renderplayer = new Setting("RenderPlayer", "", this, false);
    private final Setting franco = new Setting("Franco", "", this, false);
    public static ResourceLocation Field420;
    public static ResourceLocation Field1820;
    private final ICamera Field1821 = new Frustum();
    @EventHandler
    private Listener Field1822 = new Listener<Class139>(this::Method2211, new Predicate[0]);
    @EventHandler
    private Listener Field1823 = new Listener<Class35>(this::Method2212, new Predicate[0]);
    @EventHandler
    private Listener Field1824 = new Listener<RenderPlayerEvent.Pre>(this::Method2213, new Predicate[0]);

    public ImageESP() {
        super("ImageESP", "Render images over players.", Class11.RENDER);
        this.Method2214(this.renderplayer);
        if (Manager.beta) {
            this.Method2214(this.franco);
        }
    }

    public void Method2215() {
        super.Method13();
        if (((Boolean)this.franco.getValue()).booleanValue() && Manager.beta) {
            this.Method2216();
        }
        if (Field420 == null) {
            Globals.printChatMessage(ChatFormatting.RED + "Image not loaded!");
            this.Method2217();
        }
    }

    public void Method2218() {
        super.Method15();
        Globals.mc.getSoundHandler().stopSounds();
    }

    private void Method2216() {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(Globals.mc.getResourceManager().getResource(Class234.Field1809).getInputStream());
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (bufferedImage != null) {
            DynamicTexture dynamicTexture = new DynamicTexture(bufferedImage);
            try {
                dynamicTexture.loadTexture(Globals.mc.getResourceManager());
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            Field1820 = Field420;
            Field420 = Globals.mc.getTextureManager().getDynamicTextureLocation("ABYSS_FRANCO", dynamicTexture);
        }
        Globals.mc.getSoundHandler().stopSounds();
        Globals.mc.world.playSound((EntityPlayer)Globals.mc.player, Globals.mc.player.posX, Globals.mc.player.posY, Globals.mc.player.posZ, Class470.Field1825, SoundCategory.PLAYERS, 3.0f, 1.0f);
    }

    private void Method2213(RenderPlayerEvent.Pre pre) {
        if (!((Boolean)this.renderplayer.getValue()).booleanValue() && !pre.getEntity().equals((Object)Globals.mc.player)) {
            pre.setCanceled(true);
        }
    }

    private void Method2212(Class35 class35) {
        if (Field420 == null) {
            return;
        }
        double d = Globals.mc.player.lastTickPosX + (Globals.mc.player.posX - Globals.mc.player.lastTickPosX) * (double)class35.Method2219();
        double d2 = Globals.mc.player.lastTickPosY + (Globals.mc.player.posY - Globals.mc.player.lastTickPosY) * (double)class35.Method2219();
        double d3 = Globals.mc.player.lastTickPosZ + (Globals.mc.player.posZ - Globals.mc.player.lastTickPosZ) * (double)class35.Method2219();
        this.Field1821.setPosition(d, d2, d3);
        ArrayList<Object> arrayList = new ArrayList<Object>(Globals.mc.world.playerEntities);
        arrayList.sort(Comparator.comparing(ImageESP::Method2220).reversed());
        for (EntityPlayer entityPlayer : arrayList) {
            int n;
            if (entityPlayer == Globals.mc.getRenderViewEntity() || !entityPlayer.isEntityAlive() || !this.Field1821.isBoundingBoxInFrustum(entityPlayer.getEntityBoundingBox())) continue;
            Vec3d vec3d = Class354.Method2221((Entity)entityPlayer, class35.Method2219());
            Vec3d vec3d2 = vec3d.add(new Vec3d(0.0, entityPlayer.getRenderBoundingBox().maxY - entityPlayer.posY, 0.0));
            Class502 class502 = Class47.Method2205(vec3d2.x, vec3d2.y, vec3d2.z);
            Class502 class5022 = Class47.Method2205(vec3d.x, vec3d.y, vec3d.z);
            if (!class502.Field1826 && !class5022.Field1826) continue;
            int n2 = n = class5022.Field1827 - class502.Field1827;
            int n3 = (int)((double)class502.Field1828 - (double)n / 1.8);
            int n4 = class502.Field1827;
            Globals.mc.renderEngine.bindTexture(Field420);
            GlStateManager.color((float)255.0f, (float)255.0f, (float)255.0f);
            Gui.drawScaledCustomSizeModalRect((int)n3, (int)n4, (float)0.0f, (float)0.0f, (int)n, (int)n2, (int)n, (int)n2, (float)n, (float)n2);
        }
    }

    private static Float Method2220(Object object) {
        return Float.valueOf(Globals.mc.player.getDistance((Entity)((EntityPlayer)object)));
    }

    private void Method2211(Class139 class139) {
        if (class139.Method1564() == this) {
            if (((Boolean)((ImageESP)class139.Method1564()).franco.getValue()).booleanValue() && Manager.beta) {
                this.Method2216();
            } else {
                if (Field1820 != null) {
                    Field420 = Field1820;
                }
                Globals.mc.getSoundHandler().stopSounds();
            }
        }
    }
}
