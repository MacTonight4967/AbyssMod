package me.ciruu.abyss;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Class164;

public class Class162
extends Class163 {
    public Class162() {
        super("History", "Lookup for a player old names", "history name");
    }

    public void Method444(String string) {
        String[] stringArray = string.split("");
        if (stringArray == null || stringArray.length <= 1) {
            this.Method445("Invalid Input");
            return;
        }
        String string2 = stringArray[1];
        if (string2 != null) {
            try {
                Objects.requireNonNull(string2);
                JsonArray jsonArray = new JsonArray();
                jsonArray.add(string2);
                JsonArray jsonArray2 = Class162.Method446(new URL("https://api.mojang.com/profiles/minecraft"), "POST", (JsonElement)jsonArray).getAsJsonArray();
                JsonObject jsonObject = jsonArray2.get(0).getAsJsonObject();
                UUID uUID = Class162.Method447(jsonObject.get("id").getAsString());
                Objects.requireNonNull(uUID);
                ArrayList arrayList = new ArrayList();
                Class162.Method448(uUID).forEach(arg_0 -> Class162.Method449(arrayList, arg_0));
                Object[] objectArray = new String[arrayList.size()];
                for (int i = 0; i < arrayList.size(); ++i) {
                    objectArray[i] = (String)arrayList.get(i);
                }
                this.Method445(Arrays.toString(objectArray));
            }
            catch (Exception exception) {
                this.Method445("Invalid player");
            }
        } else {
            this.Method445("Invalid player: null");
        }
    }

    public static List Method448(UUID uUID) throws IOException {
        JsonArray jsonArray = Class162.Method451(new URL("https://api.mojang.com/user/profiles/" + Class162.Method450(uUID) + "/names"), "GET").getAsJsonArray();
        ArrayList<Class164> arrayList = Lists.newArrayList();
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String string = jsonObject.get("name").getAsString();
            long l = jsonObject.has("changedToAt") ? jsonObject.get("changedToAt").getAsLong() : 0L;
            arrayList.add(new Class164(string, l));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static JsonElement Method446(URL uRL, String string, JsonElement jsonElement) throws IOException {
        JsonElement jsonElement2;
        block2: {
            Closeable closeable;
            HttpsURLConnection httpsURLConnection = null;
            Gson gson = new Gson();
            JsonParser jsonParser = new JsonParser();
            httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod(string);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            if (jsonElement != null) {
                closeable = new DataOutputStream(httpsURLConnection.getOutputStream());
                ((DataOutputStream)closeable).writeBytes(gson.toJson(jsonElement));
                ((FilterOutputStream)closeable).close();
            }
            closeable = new Scanner(httpsURLConnection.getInputStream());
            StringBuilder stringBuilder = new StringBuilder();
            while (((Scanner)closeable).hasNextLine()) {
                stringBuilder.append(((Scanner)closeable).nextLine());
                stringBuilder.append('\n');
            }
            ((Scanner)closeable).close();
            String string2 = stringBuilder.toString();
            jsonElement2 = jsonParser.parse(string2);
            if (httpsURLConnection == null) break block2;
            httpsURLConnection.disconnect();
        }
        return jsonElement2;
    }

    private static JsonElement Method451(URL uRL, String string) throws IOException {
        return Class162.Method446(uRL, string, null);
    }

    public static String Method450(UUID uUID) {
        return uUID.toString().replaceAll("-", "");
    }

    public static UUID Method447(String string) {
        if (string.contains("-")) {
            return UUID.fromString(string);
        }
        return UUID.fromString(string.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
    }

    private static void Method449(List list, Class164 class164) {
        list.add(Class164.Method452(class164));
    }
}
