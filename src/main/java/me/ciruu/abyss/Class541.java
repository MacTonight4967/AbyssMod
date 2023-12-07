package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.ciruu.abyss.Class163;

public class Class541
extends Class163 {
    public Class541() {
        super("clip", "Allows you to clip certain blocks", "<h/v>clip distance");
        this.Field2064.add("hclip <distance>");
        this.Field2064.add("vclip <distance>");
    }

    public void Method2497(String string) {
        String[] stringArray = string.split("");
        if (stringArray == null || stringArray.length <= 1) {
            this.Method2498("Invalid Input");
            return;
        }
        if (stringArray[1].toLowerCase().startsWith("h")) {
            if (stringArray.length > 1) {
                try {
                    int n = Integer.parseInt(stringArray[2]);
                    double d = Math.cos(Math.toRadians(this.Field2065.player.rotationYaw + 90.0f));
                    double d2 = Math.sin(Math.toRadians(this.Field2065.player.rotationYaw + 90.0f));
                    this.Field2065.player.setPosition(this.Field2065.player.posX + (1.0 * (double)n * d + 0.0 * (double)n * d2), this.Field2065.player.posY, this.Field2065.player.posZ + (1.0 * (double)n * d2 - 0.0 * (double)n * d));
                    if (this.Field2065.player.isRiding()) {
                        this.Field2065.player.getRidingEntity().setPosition(this.Field2065.player.getRidingEntity().posX + (1.0 * (double)n * d + 0.0 * (double)n * d2), this.Field2065.player.getRidingEntity().posY, this.Field2065.player.getRidingEntity().posZ + (1.0 * (double)n * d2 - 0.0 * (double)n * d));
                    }
                }
                catch (Exception exception) {
                    this.Method2498(ChatFormatting.RED + "INVALID COMMAND");
                }
                return;
            }
            this.Method2498("hclip <distance>");
            return;
        }
        if (stringArray[1].toLowerCase().startsWith("v")) {
            if (stringArray.length > 1) {
                try {
                    int n = Integer.parseInt(stringArray[2]);
                    this.Field2065.player.setPosition(this.Field2065.player.posX, this.Field2065.player.posY + (double)n, this.Field2065.player.posZ);
                    if (this.Field2065.player.isRiding()) {
                        this.Field2065.player.getRidingEntity().setPosition(this.Field2065.player.getRidingEntity().posX, this.Field2065.player.getRidingEntity().posY + (double)n, this.Field2065.player.getRidingEntity().posZ);
                    }
                }
                catch (Exception exception) {
                    this.Method2498(ChatFormatting.RED + "INVALID COMMAND");
                }
            } else {
                this.Method2498("Usage: vclip <distance>");
                return;
            }
        }
    }
}
