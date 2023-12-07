package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import me.ciruu.abyss.Class152;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class538;
import me.ciruu.abyss.Manager;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class537
extends Lambda
implements Function1 {
    final Class538 Field2013;

    public Object invoke(Object object) {
        this.invoke((Class35)object);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Class35 class35) {
        Class152 class152 = (Class152)Manager.moduleManager.getModuleByClass(Class152.class);
        if (class152.Method1432()) {
            if (!Class152.Field1086 && Class152.Field1081 == null) {
                Class538.Method2442(this.Field2013, "AutoCrystal:" + ChatFormatting.GREEN + "ON");
                Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue(), -1);
            }
            if (Class152.Field1086) {
                Class538.Method2442(this.Field2013, "AutoCrystal:" + ChatFormatting.YELLOW + "SWITCH");
                Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue(), -1);
            }
            if (Class152.Field1081 != null && !Class152.Field1086) {
                Class538.Method2442(this.Field2013, "AutoCrystal:" + ChatFormatting.AQUA + Class152.Field1081.getName());
                Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue(), -1);
            }
        } else {
            Class538.Method2442(this.Field2013, "AutoCrystal:" + ChatFormatting.RED + "OFF");
            Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue(), -1);
        }
        if (class152.Field1125 || ((Boolean)class152.Field995.getValue()).booleanValue() || ((Boolean)class152.Field1012.getValue()).booleanValue()) {
            Object object3;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Object object2 = Class152.Field975;
            int n = 0;
            boolean bl = false;
            synchronized (object2) {
                boolean bl2 = false;
                arrayList = new ArrayList(class152.Method1533());
                arrayList2 = new ArrayList(class152.Method1532());
                arrayList3 = new ArrayList(class152.Method1531());
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
            Class538.Method2442(this.Field2013, "Predict aciertos:" + ChatFormatting.DARK_AQUA + n + '/' + n2 + '(' + n * 100 / n2 + "%)");
            Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue() + 10, -1);
            Class538.Method2442(this.Field2013, "Predict media:" + ChatFormatting.DARK_AQUA + Class29.Method43(arrayList3) + ChatFormatting.RESET + ", Moda:" + ChatFormatting.DARK_AQUA + Class29.Method45(arrayList3));
            Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue() + 20, -1);
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
            Class538.Method2442(this.Field2013, "Predict diffs:" + ChatFormatting.DARK_AQUA + (String)object3);
            Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue() + 30, -1);
            Class538.Method2442(this.Field2013, "LastEntityId:" + ChatFormatting.DARK_AQUA + Class152.Field976.Field1161);
            Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue() + 40, -1);
            Class538.Method2442(this.Field2013, "Place attempts/s:" + ChatFormatting.DARK_AQUA + class152.Field1119);
            Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue() + 50, -1);
            Class538.Method2442(this.Field2013, "Break/s:" + ChatFormatting.DARK_AQUA + class152.Field1120);
            Class36.Method63(Class538.Method2443(this.Field2013), ((Number)Class538.Method2444(this.Field2013).getValue()).intValue(), ((Number)Class538.Method2445(this.Field2013).getValue()).intValue() + 60, -1);
        }
    }

    Class537(Class538 class538) {
        this.Field2013 = class538;
        super(1);
    }
}
