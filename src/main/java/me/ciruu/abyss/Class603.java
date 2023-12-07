package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.ciruu.abyss.Class163;

public class Class603
extends Class163 {
    public Class603() {
        super("tp", "Attempts to teleport you to certain coords", "tp x y z");
    }

    public void Method3051(String string) {
        double d;
        double d2;
        double d3;
        String[] stringArray = string.split("");
        if (stringArray == null || stringArray.length <= 3) {
            this.Method3052("Invalid Input");
            return;
        }
        try {
            d3 = Double.parseDouble(stringArray[1]);
            d2 = Double.parseDouble(stringArray[2]);
            d = Double.parseDouble(stringArray[3]);
        }
        catch (Exception exception) {
            this.Method3052(ChatFormatting.RED + "Invalid coordinates!");
            return;
        }
        this.Field2534.player.setPosition(d3, d2, d);
        if (this.Field2534.player.isRiding()) {
            this.Field2534.player.getRidingEntity().setPosition(d3, d2, d);
        }
    }
}
