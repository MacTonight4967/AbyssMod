package me.ciruu.abyss;

import com.cout970.rocketdrm.JniUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;

public class Class636 {
    public static int Method3471(Iterable iterable, int n) {
        return (int)JniUtil.decodeInvoke("abyss$A6w*c%bm", (Iterable)iterable, (int)n);
    }

    public static Iterator Method3472(Iterable iterable) {
        return iterable.iterator();
    }

    public static boolean Method3473(Iterator iterator) {
        return iterator.hasNext();
    }

    public static Object Method3474(Iterator iterator) {
        return iterator.next();
    }

    public static boolean Method3475(Set set, Object object) {
        return set.contains(object);
    }

    public static Pair Method3476(Object object, Object object2) {
        return TuplesKt.to(object, object2);
    }

    public static boolean Method3477(Collection collection, Object object) {
        return collection.add(object);
    }

    public static Map Method3478(Iterable iterable) {
        return JniUtil.decodeInvoke("abyss$g#zTj2tu", (Iterable)iterable);
    }

    public static StringBuilder Method3479(StringBuilder stringBuilder, Object object) {
        return stringBuilder.append(object);
    }

    public static StringBuilder Method3480(StringBuilder stringBuilder, String string) {
        return stringBuilder.append(string);
    }

    public static void Method3481(Throwable throwable) {
        throwable.printStackTrace();
    }

    public static StringBuilder Method3482() {
        return new StringBuilder();
    }

    public static void Method3483(Set set) {
        set.clear();
    }

    public static boolean Method3484(Set set, Collection collection) {
        return set.addAll(collection);
    }

    public static boolean Method3485(Set set, Object object) {
        return set.remove(object);
    }

    public static boolean Method3486(Set set, Object object) {
        return set.add(object);
    }

    public static StringBuilder Method3487(StringBuilder stringBuilder, char c) {
        return stringBuilder.append(c);
    }

    public static GuiNewChat Method3488(GuiIngame guiIngame) {
        return guiIngame.getChatGUI();
    }

    public static void Method3489(GuiNewChat guiNewChat, ITextComponent iTextComponent) {
        guiNewChat.printChatMessage(iTextComponent);
    }

    public static boolean Method3490(Boolean bl) {
        return bl;
    }

    public static String Method3491(EntityPlayerSP entityPlayerSP) {
        return entityPlayerSP.getName();
    }

    public static boolean Method3492(Object object, Object object2) {
        return Intrinsics.areEqual(object, object2);
    }

    public static void Method3493(WorldClient worldClient, EntityPlayer entityPlayer, double d, double d2, double d3, SoundEvent soundEvent, SoundCategory soundCategory, float f, float f2) {
        worldClient.playSound(entityPlayer, d, d2, d3, soundEvent, soundCategory, f, f2);
    }

    public static LinkedHashSet Method3494() {
        return new LinkedHashSet();
    }
}
