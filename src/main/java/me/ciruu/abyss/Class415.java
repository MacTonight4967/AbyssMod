package me.ciruu.abyss;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import me.ciruu.abyss.Globals;
import org.apache.commons.io.IOUtils;

/*
 * Exception performing whole class analysis ignored.
 */
public static class Class415 {
    private String Field2745;
    private String Field2746;

    public Class415(String string) {
        this.Field2745 = string;
        try {
            this.Field2746 = Class415.Method1762(string);
        }
        catch (Exception exception) {
            Globals.printChatMessage("Couldn't find uuid for" + string);
            this.Field2746 = "";
        }
    }

    public Class415(String string, String string2) {
        this.Field2745 = string;
        this.Field2746 = string2;
    }

    public String Method1763() {
        return this.Field2745;
    }

    public String Method1764() {
        return this.Field2746;
    }

    public static String Method1762(String string) {
        JsonParser jsonParser = new JsonParser();
        String string2 = "https://api.mojang.com/users/profiles/minecraft/" + string;
        try {
            String string3 = IOUtils.toString(new URL(string2), StandardCharsets.UTF_8);
            if (string3.isEmpty()) {
                return "invalid name";
            }
            JsonObject jsonObject = (JsonObject)jsonParser.parse(string3);
            return Class415.Method3360(jsonObject.get("id").toString());
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "error";
        }
    }

    private static String Method3360(String string) {
        String string2 = "";
        string2 = string2 + string.substring(1, 9) + "-";
        string2 = string2 + string.substring(9, 13) + "-";
        string2 = string2 + string.substring(13, 17) + "-";
        string2 = string2 + string.substring(17, 21) + "-";
        string2 = string2 + string.substring(21, 33);
        return string2;
    }
}
