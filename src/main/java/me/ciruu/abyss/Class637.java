package me.ciruu.abyss;

import com.cout970.rocketdrm.JniUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.binary.Hex;
import org.java_websocket.exceptions.WebsocketNotConnectedException;

public class Class637 {
    public static void Method3495() {
        Intrinsics.throwNpe();
    }

    public static void Method3496(Throwable throwable) {
        throwable.printStackTrace();
    }

    public static boolean Method3497(Object object, Object object2) {
        return Intrinsics.areEqual(object, object2);
    }

    public static void Method3498(PrintStream printStream, Object object) {
        printStream.println(object);
    }

    public static Pair Method3499(Object object, Object object2) {
        return TuplesKt.to(object, object2);
    }

    public static Map Method3500(Pair pair) {
        return JniUtil.decodeInvoke("abyss$9twJT3AE", (Pair)pair);
    }

    public static String Method3501(Gson gson, Object object) {
        return gson.toJson(object);
    }

    public static StringBuilder Method3502(StringBuilder stringBuilder, String string) {
        return stringBuilder.append(string);
    }

    public static StringBuilder Method3503(StringBuilder stringBuilder, int n) {
        return stringBuilder.append(n);
    }

    public static StringBuilder Method3504() {
        return new StringBuilder();
    }

    public static JsonElement Method3505(JsonParser jsonParser, String string) {
        return jsonParser.parse(string);
    }

    public static JsonObject Method3506(JsonElement jsonElement) {
        return jsonElement.getAsJsonObject();
    }

    public static JsonElement Method3507(JsonObject jsonObject, String string) {
        return jsonObject.get(string);
    }

    public static String Method3508(JsonElement jsonElement) {
        return jsonElement.getAsString();
    }

    public static long Method3509(JsonElement jsonElement) {
        return jsonElement.getAsLong();
    }

    public static Instant Method3510(long l) {
        return Instant.ofEpochSecond(l);
    }

    public static JsonArray Method3511(JsonElement jsonElement) {
        return jsonElement.getAsJsonArray();
    }

    public static int Method3512(Iterable iterable, int n) {
        return (int)JniUtil.decodeInvoke("abyss$#l8P7kJ#", (Iterable)iterable, (int)n);
    }

    public static Iterator Method3513(Iterable iterable) {
        return iterable.iterator();
    }

    public static boolean Method3514(Iterator iterator) {
        return iterator.hasNext();
    }

    public static Object Method3515(Iterator iterator) {
        return iterator.next();
    }

    public static boolean Method3516(Collection collection, Object object) {
        return collection.add(object);
    }

    public static JsonParser Method3517() {
        return new JsonParser();
    }

    public static Map Method3518(Pair[] pairArray) {
        return JniUtil.decodeInvoke("abyss$NHK#vB6m", (Pair[])pairArray);
    }

    public static void Method3519(WebsocketNotConnectedException websocketNotConnectedException) {
        websocketNotConnectedException.printStackTrace();
    }

    public static void Method3520(Exception exception) {
        exception.printStackTrace();
    }

    public static GsonBuilder Method3521(GsonBuilder gsonBuilder) {
        return gsonBuilder.setPrettyPrinting();
    }

    public static Gson Method3522(GsonBuilder gsonBuilder) {
        return gsonBuilder.create();
    }

    public static boolean Method3523(File file) {
        return file.isFile();
    }

    public static String Method3524(File file) {
        return file.getName();
    }

    public static boolean Method3525(String string, String string2, boolean bl, int n, Object object) {
        return (boolean)JniUtil.decodeInvoke("abyss$KKouV9I#", (String)string, (String)string2, (boolean)bl, (int)n, (Object)object);
    }

    public static ZipEntry Method3526(ZipFile zipFile, String string) {
        return zipFile.getEntry(string);
    }

    public static InputStream Method3527(ZipFile zipFile, ZipEntry zipEntry) {
        return zipFile.getInputStream(zipEntry);
    }

    public static byte[] Method3528(InputStream inputStream) {
        return ByteStreamsKt.readBytes(inputStream);
    }

    public static String Method3529(byte[] byArray) {
        return Hex.encodeHexString(byArray);
    }

    public static GsonBuilder Method3530() {
        return new GsonBuilder();
    }
}
