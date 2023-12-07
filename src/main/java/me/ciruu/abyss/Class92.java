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
import me.ciruu.abyss.Class415;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.client.Client;
import me.ciruu.abyss.modules.misc.DisableFriends;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class Class92 {
    private HashMap Field1348 = new HashMap();

    public void Method1759() {
        this.Method1760();
    }

    public void Method1760() {
        File file = new File("Abyss/FriendList.json");
        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
            JsonObject jsonObject = new JsonParser().parse((Reader)bufferedReader).getAsJsonObject();
            this.Field1348 = new HashMap();
            for (Map.Entry entry : jsonObject.entrySet()) {
                this.Field1348.put(entry.getKey(), ((JsonElement)entry.getValue()).getAsString());
            }
            ((Reader)bufferedReader).close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void Method1761() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("Abyss/FriendList.json", new String[0]), new OpenOption[0]);
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry entry : this.Field1348.entrySet()) {
                jsonObject.addProperty((String)entry.getKey(), (String)entry.getValue());
            }
            gson.toJson((JsonElement)jsonObject, (Appendable)bufferedWriter);
            ((Writer)bufferedWriter).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public boolean Method711(Entity entity) {
        return !Manager.moduleManager.isModuleEnabled(DisableFriends.class) && entity instanceof EntityPlayer && this.Field1348.containsKey(entity.getName());
    }

    public boolean Method1540(String string) {
        if (this.Field1348.containsKey(string)) {
            return false;
        }
        Class415 class415 = new Class415(string, Class415.Method1762(string));
        this.Field1348.put(class415.Method1763(), class415.Method1764());
        this.Method1761();
        if (((Boolean)((Client)Manager.moduleManager.getModuleByClass(Client.class)).friendmessage.getValue()).booleanValue()) {
            Globals.mc.player.sendChatMessage("/msg" + string + " You got added to" + Globals.mc.player.getName() + "'s friends list");
        }
        return true;
    }

    public boolean Method1542(String string) {
        if (!this.Field1348.containsKey(string)) {
            return false;
        }
        this.Field1348.remove(string);
        this.Method1761();
        return true;
    }

    public boolean Method233(String string) {
        return !Manager.moduleManager.isModuleEnabled(DisableFriends.class) && this.Field1348.containsKey(string);
    }

    public final HashMap Method1765() {
        return this.Field1348;
    }
}
