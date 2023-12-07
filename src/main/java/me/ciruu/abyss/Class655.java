package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class656;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.combat.AutoCrystal;
import me.ciruu.abyss.modules.combat.Predict;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class655
extends Lambda
implements Function1 {
    final Class656 Field3180;

    public Object invoke(Object object) {
        this.invoke((Class35)object);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Class35 class35) {
        AutoCrystal autoCrystal = (AutoCrystal)Manager.moduleManager.getModuleByClass(AutoCrystal.class);
        Predict predict = (Predict)Manager.moduleManager.getModuleByClass(Predict.class);
        if (autoCrystal == null || predict == null) {
            return;
        }
        if (autoCrystal.Method3859()) {
            if (autoCrystal.Field70 == null) {
                Class656.Method3860(this.Field3180, "AutoCrystal:" + ChatFormatting.GREEN + "ON");
                Class36.Method63(Class656.Method3861(this.Field3180), ((Number)Class656.Method3862(this.Field3180).getValue()).intValue(), ((Number)Class656.Method3863(this.Field3180).getValue()).intValue(), -1);
            }
            if (autoCrystal.Field70 != null) {
                Class656.Method3860(this.Field3180, "AutoCrystal:" + ChatFormatting.AQUA + autoCrystal.Field70.getName());
                Class36.Method63(Class656.Method3861(this.Field3180), ((Number)Class656.Method3862(this.Field3180).getValue()).intValue(), ((Number)Class656.Method3863(this.Field3180).getValue()).intValue(), -1);
            }
        } else {
            Class656.Method3860(this.Field3180, "AutoCrystal:" + ChatFormatting.RED + "OFF");
            Class36.Method63(Class656.Method3861(this.Field3180), ((Number)Class656.Method3862(this.Field3180).getValue()).intValue(), ((Number)Class656.Method3863(this.Field3180).getValue()).intValue(), -1);
        }
        if (((Boolean)predict.predict.getValue()).booleanValue() && Manager.moduleManager.isModuleEnabled(AutoCrystal.class) && Manager.moduleManager.isModuleEnabled(Predict.class)) {
            Object object3;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Object object2 = Predict.Field18;
            int n = 0;
            boolean bl = false;
            synchronized (object2) {
                boolean bl2 = false;
                arrayList = new ArrayList(predict.Field40);
                arrayList2 = new ArrayList(predict.Field39);
                arrayList3 = new ArrayList(predict.Field38);
                object3 = Unit.INSTANCE;
            }
            int n2 = arrayList.size();
            if (n2 == 0) {
                n2 = 1;
            }
            n = 0;
            for (Object object3 : arrayList) {
                if (!((Boolean)object3).booleanValue()) continue;
                ++n;
            }
            Class656.Method3860(this.Field3180, "Predict aciertos:" + ChatFormatting.DARK_AQUA + n + '/' + n2 + '(' + n * 100 / n2 + "%)");
            Class36.Method63(Class656.Method3861(this.Field3180), ((Number)Class656.Method3862(this.Field3180).getValue()).intValue(), ((Number)Class656.Method3863(this.Field3180).getValue()).intValue() + 10, -1);
            Class656.Method3860(this.Field3180, "Predict media:" + ChatFormatting.DARK_AQUA + Class29.Method43(arrayList3) + ChatFormatting.RESET + ", Moda:" + ChatFormatting.DARK_AQUA + Class29.Method45(arrayList3));
            Class36.Method63(Class656.Method3861(this.Field3180), ((Number)Class656.Method3862(this.Field3180).getValue()).intValue(), ((Number)Class656.Method3863(this.Field3180).getValue()).intValue() + 20, -1);
            object3 = "";
            if (arrayList3.size() >= 1) {
                object3 = (String)object3 + (Integer)arrayList3.get(0);
            }
            if (arrayList3.size() >= 2) {
                object3 = (String)object3 + "," + (Integer)arrayList3.get(1);
            }
            if (arrayList3.size() >= 3) {
                object3 = (String)object3 + "," + (Integer)arrayList3.get(2);
            }
            if (arrayList3.size() >= 4) {
                object3 = (String)object3 + "," + (Integer)arrayList3.get(3);
            }
            Class656.Method3860(this.Field3180, "Predict diffs:" + ChatFormatting.DARK_AQUA + (String)object3);
            Class36.Method63(Class656.Method3861(this.Field3180), ((Number)Class656.Method3862(this.Field3180).getValue()).intValue(), ((Number)Class656.Method3863(this.Field3180).getValue()).intValue() + 30, -1);
            Class656.Method3860(this.Field3180, "LastEntityId:" + ChatFormatting.DARK_AQUA + Predict.Field19.Field65);
            Class36.Method63(Class656.Method3861(this.Field3180), ((Number)Class656.Method3862(this.Field3180).getValue()).intValue(), ((Number)Class656.Method3863(this.Field3180).getValue()).intValue() + 40, -1);
            Class656.Method3860(this.Field3180, "Place attempts/s:" + ChatFormatting.DARK_AQUA + predict.Field44);
            Class36.Method63(Class656.Method3861(this.Field3180), ((Number)Class656.Method3862(this.Field3180).getValue()).intValue(), ((Number)Class656.Method3863(this.Field3180).getValue()).intValue() + 50, -1);
            Class656.Method3860(this.Field3180, "Break/s:" + ChatFormatting.DARK_AQUA + predict.Field45);
            Class36.Method63(Class656.Method3861(this.Field3180), ((Number)Class656.Method3862(this.Field3180).getValue()).intValue(), ((Number)Class656.Method3863(this.Field3180).getValue()).intValue() + 60, -1);
        }
    }

    Class655(Class656 class656) {
        this.Field3180 = class656;
        super(1);
    }
}
