package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.io.File;
import java.util.Arrays;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class128;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.hud.Notifications;
import org.apache.commons.io.FileUtils;

public class Class208 {
    public static String Field486 = "default";
    public static String[] Field2276;

    public static void Method2116() {
        Class208.Method2117();
        Class208.Method2016();
        Module.Method602();
        Class208.Method2877(Class128.Info, "Reloaded profiles!");
    }

    public static void Method2119(String string) {
        File file = new File("Abyss/Features/" + string + "/");
        boolean bl = file.mkdir();
        if (!bl) {
            Globals.printChatMessage(ChatFormatting.RED + string + "profile already exist!");
        } else {
            try {
                File file2 = new File("Abyss/Features/" + string + "/");
                File file3 = new File("Abyss/Features/" + Field486 + "/");
                FileUtils.copyDirectory(file3, file2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        Class208.Method2877(Class128.Info, "Added profile" + string + "!");
    }

    public static void Method2118(String string) {
        String string2 = null;
        Class208.Method2016();
        Class208.Method2117();
        for (String string3 : Field2276) {
            if (!string.equalsIgnoreCase(string3)) continue;
            string2 = string3;
            break;
        }
        if (string2 == null) {
            Globals.printChatMessage(ChatFormatting.RED + "Invalid profile name to load!");
            Class208.Method2877(Class128.Error, "Invalid profile with name:" + string + "!");
            return;
        }
        Field486 = string2;
        Globals.printChatMessage(ChatFormatting.GREEN + "Profile" + Field486 + " loaded!");
        Class208.Method2877(Class128.Info, "Loaded profile" + string + "!");
        Class208.Method2116();
    }

    public static void Method2120(String string) {
        File file = new File("Abyss/Features/" + string + "/");
        if (file.delete()) {
            Globals.printChatMessage(ChatFormatting.GREEN + "Profile" + Field486 + " deleted!");
            Class208.Method2877(Class128.Info, "Deleted profile" + string + "!");
        } else {
            Globals.printChatMessage(ChatFormatting.RED + "Cannot delete profile" + string);
            Class208.Method2877(Class128.Error, "Cannot delete profile" + string + "!");
        }
    }

    public static void Method2016() {
        File file = new File("Abyss/Features/");
        Field2276 = file.list(Class208::Method2878);
    }

    public static void Method2117() {
        Globals.printChatMessage("Profiles:" + Arrays.toString(Field2276));
    }

    private static void Method2877(Class128 class128, String string) {
        if (((Boolean)((Notifications)Manager.moduleManager.getModuleByClass(Notifications.class)).profile.getValue()).booleanValue()) {
            Manager.Field424.Method342(class128, string);
        }
    }

    private static boolean Method2878(File file, String string) {
        return new File(file, string).isDirectory();
    }
}
