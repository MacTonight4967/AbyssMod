package me.ciruu.abyss.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Class12;
import me.ciruu.abyss.Class205;
import me.ciruu.abyss.Class207;
import me.ciruu.abyss.Class208;
import me.ciruu.abyss.Class210;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class128;
import me.ciruu.abyss.managers.RunnableManager;
import me.ciruu.abyss.modules.client.ChatNotifier;
import me.ciruu.abyss.modules.hud.Notifications;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.Listenable;
import net.minecraft.client.Minecraft;

public class Module
extends Class12
implements Class205,
Listenable {
    private static final Object Field479 = new Object();
    private String Field480;
    private boolean Field481;
    private boolean Field482;
    private String Field483;
    private float Field484 = 0.0f;

    public Module(String string, String string2, Class11 class11) {
        super(string, class11);
        this.Field480 = string2;
        this.Field483 = "NONE";
    }

    public Module(String string, String string2, Class11 class11, Boolean bl) {
        super(string, class11);
        this.Field480 = string2;
        this.Field482 = bl;
        this.Field483 = "NONE";
    }

    public Module(String string, String string2, Class11 class11, String string3) {
        super(string, class11);
        this.Field480 = string2;
        this.Field483 = string3;
    }

    public void Method581() {
        this.Field481 = !this.Field481;
        this.Method582(this.Field481);
    }

    public void Method13() {
        this.Field484 = 0.0f;
        AbyssMod.EVENT_BUS.subscribe(this);
        if (Manager.moduleManager.getModuleByClass(ChatNotifier.class) != null && Manager.moduleManager.isModuleEnabled(ChatNotifier.class)) {
            Globals.printNewChatMessage(ChatFormatting.WHITE + this.Method491() + ChatFormatting.GREEN + " ON");
        }
        if (Manager.moduleManager.getModuleByClass(Notifications.class) != null && ((Boolean)((Notifications)Manager.moduleManager.getModuleByClass(Notifications.class)).toggleFeature.getValue()).booleanValue()) {
            Manager.Field424.Method342(Class128.Info, ChatFormatting.WHITE + this.Method491() + ChatFormatting.GREEN + " enabled!");
        }
    }

    public void Method15() {
        AbyssMod.EVENT_BUS.unsubscribe(this);
        if (Manager.moduleManager.getModuleByClass(ChatNotifier.class) != null && Manager.moduleManager.isModuleEnabled(ChatNotifier.class)) {
            Globals.printNewChatMessage(ChatFormatting.WHITE + this.Method491() + ChatFormatting.RED + " OFF");
        }
        if (Manager.moduleManager.getModuleByClass(Notifications.class) != null && ((Boolean)((Notifications)Manager.moduleManager.getModuleByClass(Notifications.class)).toggleFeature.getValue()).booleanValue()) {
            Manager.Field424.Method342(Class128.Info, ChatFormatting.WHITE + this.Method491() + ChatFormatting.RED + " disabled!");
        }
    }

    public void Method582(boolean bl) {
        if (bl) {
            this.Method13();
        } else {
            this.Method15();
        }
    }

    public void Method583(boolean bl) {
        if (this.Field481 && bl) {
            return;
        }
        if (!this.Field481 && !bl) {
            return;
        }
        this.Field481 = bl;
        if (bl) {
            this.Method13();
        } else {
            this.Method15();
        }
    }

    public boolean Method490() {
        return this.Field481;
    }

    public void Method584(boolean bl) {
        this.Field481 = bl;
    }

    public void Method177(String string) {
        this.Field483 = string;
    }

    public String Method160() {
        return this.Field483;
    }

    public void Method585(boolean bl) {
        this.Field482 = bl;
    }

    public boolean Method492() {
        return this.Field482;
    }

    public String Method586() {
        return this.Field480;
    }

    public String Method587() {
        return null;
    }

    public float Method588() {
        return this.Field484;
    }

    public void Method589(float f) {
        this.Field484 = f;
    }

    private JsonObject Method590() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("enabled", Boolean.valueOf(!this.Method491().equals("ClickGUI") && this.Method490()));
        jsonObject.addProperty("display", this.Method491());
        jsonObject.addProperty("keybind", this.Method160());
        jsonObject.addProperty("hidden", Boolean.valueOf(this.Method492()));
        JsonObject jsonObject2 = new JsonObject();
        for (Setting setting : this.Method591()) {
            JsonPrimitive jsonPrimitive;
            String string;
            Object object = setting.getValue();
            if (object instanceof Class25) continue;
            JsonObject jsonObject3 = new JsonObject();
            try {
                string = object.getClass().getSimpleName();
            }
            catch (InternalError internalError) {
                string = object.getClass().getName();
            }
            if (object instanceof Integer) {
                jsonPrimitive = new JsonPrimitive((Number)((Integer)object));
            } else if (object instanceof String) {
                jsonPrimitive = new JsonPrimitive((String)object);
            } else if (object instanceof Boolean) {
                jsonPrimitive = new JsonPrimitive(Boolean.valueOf((Boolean)object));
            } else if (object instanceof Float) {
                jsonPrimitive = new JsonPrimitive((Number)Float.valueOf(((Float)object).floatValue()));
            } else if (object instanceof Double) {
                jsonPrimitive = new JsonPrimitive((Number)((Double)object));
            } else if (object instanceof Enum) {
                string = "Enum";
                jsonPrimitive = new JsonPrimitive((Number)((Enum)object).ordinal());
            } else if (object instanceof Color) {
                JsonArray jsonArray = new JsonArray();
                jsonArray.add((Number)((Color)object).getRed());
                jsonArray.add((Number)((Color)object).getGreen());
                jsonArray.add((Number)((Color)object).getBlue());
                jsonArray.add((Number)((Color)object).getAlpha());
                jsonPrimitive = jsonArray;
            } else if (object instanceof Class207) {
                string = "Bind";
                jsonPrimitive = new JsonPrimitive((Number)((Class207)object).Method592());
            } else {
                throw new IllegalStateException("No se puede guardar" + object.getClass() + ", valor:" + object);
            }
            jsonObject3.addProperty("type", string);
            jsonObject3.add("value", (JsonElement)jsonPrimitive);
            jsonObject2.add(setting.Method396(), (JsonElement)jsonObject3);
        }
        jsonObject.add("settings", (JsonElement)jsonObject2);
        return jsonObject;
    }

    private void Method593(JsonObject jsonObject) {
        this.Method583(jsonObject.get("enabled").getAsBoolean());
        this.Method594(jsonObject.get("display").getAsString());
        this.Method177(jsonObject.get("keybind").getAsString());
        this.Method585(jsonObject.get("hidden").getAsBoolean());
        if (!jsonObject.has("settings")) {
            return;
        }
        JsonObject jsonObject2 = jsonObject.get("settings").getAsJsonObject();
        JsonObject jsonObject3 = this.Method590().getAsJsonObject("settings");
        for (Setting setting : this.Method591()) {
            if (!jsonObject2.has(setting.Method396())) continue;
            try {
                JsonObject jsonObject4 = jsonObject3.get(setting.Method396()).getAsJsonObject();
                JsonObject jsonObject5 = jsonObject2.get(setting.Method396()).getAsJsonObject();
                String string = jsonObject4.get("type").getAsString();
                String string2 = jsonObject5.get("type").getAsString();
                JsonElement jsonElement = jsonObject5.get("value");
                if (!string.equals(string2)) {
                    System.err.println("Setting type changed from" + string2 + " to" + string + ", reverting to default (" + setting.Method396() + ")");
                    setting.setValue(setting.Method595());
                    continue;
                }
                switch (string2) {
                    case "Integer": {
                        setting.setValue(jsonElement.getAsNumber().intValue());
                        break;
                    }
                    case "Boolean": {
                        setting.setValue(jsonElement.getAsBoolean());
                        break;
                    }
                    case "String": {
                        setting.setValue(jsonElement.getAsString());
                        break;
                    }
                    case "Float": {
                        setting.setValue(Float.valueOf(jsonElement.getAsNumber().floatValue()));
                        break;
                    }
                    case "Double": {
                        setting.setValue(jsonElement.getAsNumber().doubleValue());
                        break;
                    }
                    case "Enum": {
                        ?[] objArray = setting.getValue().getClass().getEnumConstants();
                        setting.setValue(objArray[jsonElement.getAsInt()]);
                        break;
                    }
                    case "Color": {
                        JsonArray jsonArray = jsonElement.getAsJsonArray();
                        setting.setValue(new Color(jsonArray.get(0).getAsInt(), jsonArray.get(1).getAsInt(), jsonArray.get(2).getAsInt(), jsonArray.get(3).getAsInt()));
                        break;
                    }
                    case "Bind": {
                        setting.setValue(new Class207(jsonElement.getAsInt()));
                    }
                }
            }
            catch (Exception exception) {
                System.err.println("Corrupted value for" + setting.Method396() + ", ignoring");
                setting.setValue(setting.Method595());
            }
        }
    }

    public void Method596() {
        File file = new File("Abyss/Features/" + Class208.Field486 + "/" + this.Method491() + ".json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = this.Method590();
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(file.toPath(), new OpenOption[0]);
            gson.toJson((JsonElement)jsonObject, (Appendable)bufferedWriter);
            ((Writer)bufferedWriter).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void Method597() {
        System.out.println("Saving all settings...");
        RunnableManager.runRunnable(Module::Method598);
        System.out.println("Saved all settings!");
    }

    public void Method600() {
        JsonObject jsonObject;
        File file = new File("Abyss/Features/" + Class208.Field486 + "/" + this.Method491() + ".json");
        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
            jsonObject = new JsonParser().parse((Reader)bufferedReader).getAsJsonObject();
            ((Reader)bufferedReader).close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        Minecraft.getMinecraft().addScheduledTask(() -> this.Method601(jsonObject));
    }

    public static void Method602() {
        RunnableManager.runRunnable(Module::Method603);
    }

    private static void Method603() {
        System.out.println("Loading all settings...");
        Object object = Field479;
        synchronized (object) {
            for (Module module : Manager.moduleManager.getModules().values()) {
                module.Method600();
            }
        }
        Minecraft.getMinecraft().addScheduledTask(Module::Method605);
    }

    private static void Method605() {
        System.out.println("Loaded all settings!");
        AbyssMod.EVENT_BUS.post(new Class210());
    }

    private void Method601(JsonObject jsonObject) {
        this.Method593(jsonObject);
    }

    private static void Method598() {
        Object object = Field479;
        synchronized (object) {
            for (Module module : Manager.moduleManager.getModules().values()) {
                module.Method596();
            }
        }
    }
}
