package me.ciruu.abyss.modules.hud;

import java.util.function.Predicate;
import me.ciruu.abyss.Class290;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.GameType;

public class ArmourHUD
extends Module {
    private final Setting damage = new Setting("Damage", "", this, true);
    private static RenderItem Field2003 = Minecraft.getMinecraft().getRenderItem();
    @EventHandler
    private Listener Field2004 = new Listener<Class35>(this::Method2435, new Predicate[0]);

    public ArmourHUD() {
        super("ArmourHUD", "", Class11.HUD);
        this.Method2436(this.damage);
    }

    private NonNullList Method2437() {
        if (Globals.mc.playerController.getCurrentGameType().equals((Object)GameType.CREATIVE) || Globals.mc.playerController.getCurrentGameType().equals((Object)GameType.SPECTATOR)) {
            return NonNullList.withSize((int)4, (Object)ItemStack.EMPTY);
        }
        return Globals.mc.player.inventory.armorInventory;
    }

    private void Method2435(Class35 class35) {
        GlStateManager.enableTexture2D();
        ScaledResolution scaledResolution = new ScaledResolution(Globals.mc);
        int n = scaledResolution.getScaledWidth() / 2;
        int n2 = 0;
        int n3 = scaledResolution.getScaledHeight() - 55 - (Globals.mc.player.isInWater() ? 10 : 0);
        for (ItemStack itemStack : this.Method2437()) {
            ++n2;
            if (itemStack.isEmpty()) continue;
            int n4 = n - 90 + (9 - n2) * 20 + 2;
            GlStateManager.enableDepth();
            ArmourHUD.Field2003.zLevel = 200.0f;
            Field2003.renderItemAndEffectIntoGUI(itemStack, n4, n3);
            Field2003.renderItemOverlayIntoGUI(Globals.mc.fontRenderer, itemStack, n4, n3, "");
            ArmourHUD.Field2003.zLevel = 0.0f;
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            String string = itemStack.getCount() > 1 ? itemStack.getCount() + "" : "";
            Class36.Method63(string, n4 + 19 - 2 - Class36.Method259(string), n3 + 9, 0xFFFFFF);
            if (!((Boolean)this.damage.getValue()).booleanValue()) continue;
            float f = ((float)itemStack.getMaxDamage() - (float)itemStack.getItemDamage()) / (float)itemStack.getMaxDamage();
            float f2 = 1.0f - f;
            int n5 = 100 - (int)(f2 * 100.0f);
            Class36.Method63(n5 + "", n4 + 8 - Class36.Method259(n5 + "") / 2, n3 - 11, Class290.Method1055((int)(f2 * 255.0f), (int)(f * 255.0f), 0));
        }
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
    }
}
