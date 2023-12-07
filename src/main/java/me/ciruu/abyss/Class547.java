package me.ciruu.abyss;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import me.ciruu.abyss.Class220;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class50;
import me.ciruu.abyss.Class70;
import me.ciruu.abyss.Class71;
import me.ciruu.abyss.Class74;
import me.ciruu.abyss.Class75;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.client.ClickGUI;
import me.ciruu.abyss.settings.Setting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Class547
implements Class70 {
    @NotNull
    private ArrayList Field2596;
    private boolean Field2597;
    private int Field2598;
    private int Field2599;
    private int Field2600;
    private int Field2601;
    private boolean Field2602;
    @Nullable
    private final Setting Field2603;
    private final int Field2604;
    private boolean Field2605;
    private int Field2606;
    private int Field2607;
    @NotNull
    private Color Field2608;
    @NotNull
    private Class11 Field2609;

    @NotNull
    public final ArrayList Method3098() {
        return this.Field2596;
    }

    public final void Method3099(@NotNull ArrayList arrayList) {
        this.Field2596 = arrayList;
    }

    public final boolean Method3100() {
        return this.Field2597;
    }

    public final void Method3101(boolean bl) {
        this.Field2597 = bl;
    }

    @Nullable
    public Class70 Method3102() {
        return null;
    }

    public int Method2567() {
        return this.Field2598;
    }

    public void Method3103(int n) {
        this.Field2598 = n;
    }

    public int Method3104() {
        return this.Field2599;
    }

    public void Method3105(int n) {
        this.Field2599 = n;
    }

    public int Method3106() {
        return this.Field2600;
    }

    public void Method3107(int n) {
        this.Field2600 = n;
    }

    public int Method3108() {
        return this.Field2601;
    }

    public void Method3109(int n) {
        this.Field2601 = n;
    }

    public boolean Method3110() {
        return this.Field2602;
    }

    public void Method3111(boolean bl) {
        this.Field2602 = bl;
    }

    @Nullable
    public Setting Method3112() {
        return this.Field2603;
    }

    public final int Method3113() {
        return this.Field2606;
    }

    public final void Method3114(int n) {
        this.Field2606 = n;
    }

    public final int Method3115() {
        return this.Field2607;
    }

    public final void Method3116(int n) {
        this.Field2607 = n;
    }

    @NotNull
    public final Color Method3117() {
        return this.Field2608;
    }

    public final void Method3118(@NotNull Color color) {
        this.Field2608 = color;
    }

    public final void Method3119() {
        Class50.Method764(this.Method3106(), this.Method3104(), this.Method2567(), this.Field2604, Class74.Field172.Method165().getRGB());
        Class36.Method557(this.Field2609.name(), this.Method3106() + this.Method2567() / 2, this.Method3104() + 6, Class74.Field172.Method171().getRGB());
        if (this.Field2597) {
            Collection collection = this.Field2596;
            boolean bl = false;
            if (!collection.isEmpty()) {
                int n;
                Object object;
                Iterable iterable = this.Field2596;
                int n2 = 0;
                Object object22 = iterable;
                Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                boolean bl2 = false;
                Iterator iterator2 = object22.iterator();
                while (iterator2.hasNext()) {
                    Object t = iterator2.next();
                    Class71 class71 = (Class71)t;
                    object = collection2;
                    boolean bl3 = false;
                    Integer n3 = class71.Method2568();
                    object.add(n3);
                }
                Integer n4 = (Integer)CollectionsKt.max((List)collection2);
                int n5 = n4 != null ? n4 : 0;
                Object object3 = this;
                if (!((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).autowidth.getValue()).booleanValue()) {
                    n = ((Number)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).width.getValue()).intValue();
                } else {
                    int n6 = 88;
                    object = object3;
                    n2 = 0;
                    int n7 = Math.max(n6, n5);
                    object3 = object;
                    n = n7;
                }
                ((Class547)object3).Method3103(n);
                int n8 = 16;
                n2 = 1;
                for (Object object22 : this.Field2596) {
                    ((Class71)object22).Method2549(n8);
                    n8 += ((Class71)object22).Method2553();
                    ((Class71)object22).Method2576(this.Field2608);
                    ((Class71)object22).Method2578(this.Method3133(n2 * 300));
                    if (n2 == 1) {
                        ((Class71)object22).Method2576(((Class71)object22).Method2577());
                    }
                    this.Field2608 = ((Class71)object22).Method2577();
                    ((Class71)object22).Method2589();
                    ++n2;
                }
            }
        }
    }

    public final void Method3134(boolean bl) {
        this.Field2605 = bl;
    }

    public final void Method3135(int n, int n2) {
        if (this.Field2605) {
            this.Method3107(n - this.Field2606);
            this.Method3105(n2 - this.Field2607);
        }
    }

    public final boolean Method3136(int n, int n2) {
        return n >= this.Method3106() && n <= this.Method3106() + this.Method2567() && n2 >= this.Method3104() && n2 <= this.Method3104() + this.Field2604;
    }

    public final void Method2601() {
        int n = this.Field2604;
        for (Class71 class71 : this.Field2596) {
            class71.Method2612(n);
            n += class71.Method2553();
        }
        this.Method3109(n);
    }

    @NotNull
    public final Color Method3133(int n) {
        Float f = (Float)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).rsatenabled.getValue();
        Float f2 = (Float)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).rbrightenabled.getValue();
        double d = Math.ceil((double)(System.currentTimeMillis() + (long)n) / (double)(((Number)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).enabledoffset.getValue()).floatValue() * (float)2 + (float)2));
        return Color.getHSBColor((float)((d %= 360.0) / (double)360.0f), f.floatValue(), f2.floatValue());
    }

    @NotNull
    public final Class11 Method3142() {
        return this.Field2609;
    }

    public final void Method3143(@NotNull Class11 class11) {
        this.Field2609 = class11;
    }

    public Class547(@NotNull Class11 class11) {
        Object object;
        Object object2;
        this.Field2609 = class11;
        this.Field2596 = new ArrayList();
        this.Field2598 = 88;
        this.Field2599 = 5;
        this.Field2600 = 5;
        this.Field2608 = Class74.Field172.Method413();
        this.Field2604 = 16;
        this.Field2606 = 0;
        this.Field2597 = true;
        this.Field2605 = false;
        Object object322 = Manager.moduleManager.getModules().values();
        boolean bl = false;
        Object object4 = object322;
        Collection collection = new ArrayList();
        boolean bl2 = false;
        Iterator iterator2 = object4.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            if (!(object2 instanceof Module)) continue;
            collection.add(object2);
        }
        object322 = (List)collection;
        bl = false;
        object4 = object322;
        boolean bl3 = false;
        Object object5 = new Class220();
        List<Object> list = CollectionsKt.sortedWith(object4, object5);
        for (Object object322 : list) {
            if (object322.Method3148() != this.Field2609) continue;
            object4 = new Class71((Module)object322, this);
            this.Field2596.add(object4);
        }
        Iterable iterable = this.Field2596;
        boolean bl4 = false;
        Object object6 = iterable;
        object5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        boolean bl5 = false;
        object2 = object6.iterator();
        while (object2.hasNext()) {
            Object e = object2.next();
            Class71 class71 = (Class71)e;
            object = object5;
            boolean bl6 = false;
            Integer n = class71.Method2568();
            object.add(n);
        }
        Integer n = (Integer)CollectionsKt.max((List)object5);
        int n2 = n != null ? n : 0;
        int n3 = 88;
        object = this;
        bl4 = false;
        int n4 = Math.max(n3, n2);
        ((Class547)object).Method3103(n4);
        this.Method2601();
    }

    public int Method3150() {
        return Class75.Method183(this);
    }

    public int Method3151() {
        return Class75.Method184(this);
    }

    public int Method3152() {
        return Class75.Method185(this);
    }

    public void Method3153() {
        Class75.Method2713(this);
    }

    public void Method3154(int n, int n2) {
        Class75.Method433(this, n, n2);
    }

    public void Method3155(int n, int n2, int n3) {
        Class75.Method1618(this, n, n2, n3);
    }

    public void Method3156(int n, int n2, int n3) {
        Class75.Method187(this, n, n2, n3);
    }

    public void Method3157(int n, int n2, int n3, long l) {
        Class75.Method189(this, n, n2, n3, l);
    }

    public void Method3158(char c, int n) {
        Class75.Method1622(this, c, n);
    }

    public void Method3159(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method3160(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }
}
