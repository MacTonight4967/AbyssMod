package me.ciruu.abyss;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import me.ciruu.abyss.Globals;

public class Class381 {
    private final ArrayList Field2733 = new ArrayList();
    private final ArrayList Field2734 = new ArrayList();
    private final String Field2735 = "Abyss/WhiteList.json";
    private final String Field2736 = "Abyss/BlackList.json";

    public void Method2142(String string, boolean bl) {
        if (string == null) {
            Globals.printChatMessage(ChatFormatting.RED + "Invalid Item");
        }
        if (bl && !this.Field2734.contains(string)) {
            this.Field2734.add(string);
            this.Method3344("Abyss/BlackList.json", true);
            Globals.printChatMessage(ChatFormatting.GREEN + "Added" + string + " to blacklist");
        } else if (!this.Field2733.contains(string)) {
            this.Field2733.add(string);
            this.Method3344("Abyss/WhiteList.json", false);
            Globals.printChatMessage(ChatFormatting.GREEN + "Added" + string + " to whitelist");
        }
    }

    public void Method2143(String string, boolean bl) {
        if (string == null) {
            Globals.printChatMessage(ChatFormatting.RED + "Invalid Item");
        }
        if (bl) {
            this.Field2734.remove(string);
            this.Method3344("Abyss/BlackList.json", true);
            Globals.printChatMessage(ChatFormatting.GREEN + "Deleted" + string + " from blacklist");
        } else {
            this.Field2733.remove(string);
            this.Method3344("Abyss/WhiteList.json", false);
            Globals.printChatMessage(ChatFormatting.GREEN + "Deleted" + string + " from whitelist");
        }
    }

    public boolean Method1595(String string, boolean bl) {
        if (string == null) {
            Globals.printChatMessage(ChatFormatting.RED + "Invalid Item");
        }
        if (bl) {
            return this.Field2734.contains(string);
        }
        return this.Field2733.contains(string);
    }

    public void Method2144(boolean bl) {
        if (bl) {
            Globals.printChatMessage(this.Field2734.toString());
        } else {
            Globals.printChatMessage(this.Field2733.toString());
        }
    }

    public void Method2026() {
        this.Field2733.clear();
        this.Field2734.clear();
        this.Method3345("Abyss/WhiteList.json", false);
        this.Method3345("Abyss/BlackList.json", true);
    }

    public void Method3345(String string, boolean bl) {
        File file = new File(string);
        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
            JsonObject jsonObject = new JsonParser().parse((Reader)bufferedReader).getAsJsonObject();
            for (Map.Entry entry : jsonObject.entrySet()) {
                if (bl) {
                    this.Field2734.add(entry.getKey());
                    continue;
                }
                this.Field2733.add(entry.getKey());
            }
            ((Reader)bufferedReader).close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void Method3344(String string, boolean bl) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(string, new String[0]), new OpenOption[0]);
            JsonObject jsonObject = new JsonObject();
            for (String string2 : bl ? this.Field2734 : this.Field2733) {
                jsonObject.addProperty(string2, string2);
            }
            gson.toJson((JsonElement)jsonObject, (Appendable)bufferedWriter);
            ((Writer)bufferedWriter).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
