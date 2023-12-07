package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class128;
import me.ciruu.abyss.modules.hud.Notifications;
import me.ciruu.abyss.modules.render.ImageESP;
import net.minecraft.client.renderer.texture.DynamicTexture;

public class Class186
extends Class163 {
    public Class186() {
        super("Image", "Loads an image for ImageESP Module", "image name");
    }

    public void Method503(String string) {
        block6: {
            String[] stringArray = string.split("");
            if (stringArray == null || stringArray.length <= 1) {
                this.Method504("Invalid Input");
                return;
            }
            String string2 = stringArray[1];
            if (string2 != null) {
                try {
                    BufferedImage bufferedImage = ImageIO.read(new File("Abyss/Images/" + string2 + ".png"));
                    if (bufferedImage != null) {
                        DynamicTexture dynamicTexture = new DynamicTexture(bufferedImage);
                        dynamicTexture.loadTexture(this.Field419.getResourceManager());
                        ImageESP.Field420 = this.Field419.getTextureManager().getDynamicTextureLocation("ABYSS_" + string2, dynamicTexture);
                        this.Method505(Class128.Info, "Image" + string2 + " loaded!");
                        break block6;
                    }
                    Globals.printChatMessage(ChatFormatting.RED + "Failed to load image");
                    this.Method505(Class128.Error, "Failed to load image:" + string2 + "!");
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    Globals.printChatMessage(ChatFormatting.RED + "Invalid image");
                    this.Method505(Class128.Error, "Invalid image");
                }
            } else {
                Globals.printChatMessage(ChatFormatting.RED + "Invalid image");
                this.Method505(Class128.Error, "Invalid image");
            }
        }
    }

    private void Method505(Class128 class128, String string) {
        if (((Boolean)((Notifications)Manager.moduleManager.getModuleByClass(Notifications.class)).image.getValue()).booleanValue()) {
            Manager.Field424.Method342(class128, string);
        }
    }
}
