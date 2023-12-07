package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.hud.ChatWatermark;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.HoverEvent;

public class Globals {
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static EntityPlayerSP player = Minecraft.getMinecraft().player;

    public static int getScaleFactor() {
        int n = 0;
        int n2 = Globals.mc.gameSettings.guiScale;
        if (n2 == 0) {
            n2 = 1000;
        }
        while (n < n2 && Globals.mc.displayWidth / (n + 1) >= 320 && Globals.mc.displayHeight / (n + 1) >= 240) {
            ++n;
        }
        if (n == 0) {
            n = 1;
        }
        return n;
    }

    public static void printChatMessage(String string) {
        if (Globals.mc.ingameGUI != null || Globals.mc.player != null) {
            String string2 = Manager.moduleManager.isModuleEnabled(ChatWatermark.class) ? "?+[Abyss]" + ChatFormatting.WHITE + string : ChatFormatting.DARK_PURPLE + "[Abyss]" + ChatFormatting.WHITE + string;
            Globals.mc.ingameGUI.getChatGUI().printChatMessage((ITextComponent)new TextComponentString(string2));
        }
    }

    public static void printNewChatMessage(String string) {
        if (Globals.mc.player != null) {
            String string2 = Manager.moduleManager.isModuleEnabled(ChatWatermark.class) ? "?+[Abyss]" + string : ChatFormatting.DARK_PURPLE + "[Abyss]" + string;
            ITextComponent iTextComponent = new TextComponentString(string2).setStyle(new Style().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString("You found biggest Abyss secret ;)"))));
            Globals.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(iTextComponent, 5936);
        }
    }
}
