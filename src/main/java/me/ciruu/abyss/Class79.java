package me.ciruu.abyss;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class Class79 {
    private HashMap Field180 = new HashMap();

    public void Method193() {
        this.Method194();
    }

    public void Method194() {
        File file = new File("Abyss/AliasList.json");
        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
            JsonObject jsonObject = new JsonParser().parse((Reader)bufferedReader).getAsJsonObject();
            this.Field180 = new HashMap();
            for (Map.Entry entry : jsonObject.entrySet()) {
                this.Field180.put(entry.getKey(), ((JsonElement)entry.getValue()).getAsString());
            }
            ((Reader)bufferedReader).close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void Method195() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("Abyss/AliasList.json", new String[0]), new OpenOption[0]);
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry entry : this.Field180.entrySet()) {
                jsonObject.addProperty((String)entry.getKey(), (String)entry.getValue());
            }
            gson.toJson((JsonElement)jsonObject, (Appendable)bufferedWriter);
            ((Writer)bufferedWriter).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public boolean Method196(Entity entity) {
        return entity instanceof EntityPlayer && this.Field180.containsKey(entity.getName());
    }

    public void Method197(String string, String string2) {
        this.Field180.put(string, string2);
        this.Method195();
    }

    public boolean Method198(String string) {
        if (!this.Field180.containsKey(string)) {
            return false;
        }
        this.Field180.remove(string);
        this.Method195();
        return true;
    }

    public boolean Method199(String string) {
        return this.Field180.containsKey(string);
    }

    public String Method200(String string) {
        return (String)this.Field180.get(string);
    }

    public HashMap Method201() {
        return this.Field180;
    }
}
