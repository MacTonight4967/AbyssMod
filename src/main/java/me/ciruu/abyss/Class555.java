package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.time.LocalDateTime;
import me.ciruu.abyss.Class99;
import me.ciruu.abyss.Globals;

public class Class555
extends Class99 {
    private String Field2139 = ChatFormatting.AQUA + "AbyssClient VoiceAssistant:" + ChatFormatting.RESET;

    public Class555(String string) {
        super(string);
    }

    public void Method2617(String[] stringArray) {
        if (stringArray[1].equalsIgnoreCase("time")) {
            Globals.printChatMessage(this.Field2139 + "It's" + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
        } else if (stringArray[1].equalsIgnoreCase("version")) {
            Globals.printChatMessage(this.Field2139 + "You are using Abyss" + "1.6.0");
        }
    }

    public boolean Method2618(String[] stringArray) {
        return stringArray[0].equalsIgnoreCase("what");
    }
}
