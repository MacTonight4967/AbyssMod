package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ciruu.abyss.Class136;
import me.ciruu.abyss.Class207;
import me.ciruu.abyss.Class223;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class50;
import me.ciruu.abyss.Class525;
import me.ciruu.abyss.Class546;
import me.ciruu.abyss.Class547;
import me.ciruu.abyss.Class549;
import me.ciruu.abyss.Class550;
import me.ciruu.abyss.Class551;
import me.ciruu.abyss.Class552;
import me.ciruu.abyss.Class69;
import me.ciruu.abyss.Class70;
import me.ciruu.abyss.Class72;
import me.ciruu.abyss.Class74;
import me.ciruu.abyss.Class75;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class218;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.client.ClickGUI;
import me.ciruu.abyss.settings.Setting;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

public final class Class71
implements Class70 {
    private boolean Field2109;
    private final ArrayList Field2110;
    private boolean Field2111;
    private int Field2112;
    private int Field2113;
    private boolean Field2114;
    @Nullable
    private final Setting Field2115;
    private final Class546 Field2116;
    private boolean Field2117;
    private int Field2118;
    private boolean Field2119;
    @NotNull
    private Color Field2120;
    @NotNull
    private Color Field2121;
    @NotNull
    private final Module Field2122;
    @NotNull
    private final Class547 Field2123;

    public final boolean Method2543() {
        return this.Field2109;
    }

    public final void Method2544(boolean bl) {
        this.Field2109 = bl;
    }

    public final boolean Method175() {
        return this.Field2111;
    }

    public final void Method2545(boolean bl) {
        this.Field2111 = bl;
    }

    public int Method2546() {
        return this.Field2112;
    }

    public void Method2547(int n) {
        this.Field2112 = n;
    }

    public int Method2548() {
        return this.Field2113;
    }

    public void Method2549(int n) {
        this.Field2113 = n;
    }

    public boolean Method2550() {
        return this.Field2114;
    }

    public void Method2551(boolean bl) {
        this.Field2114 = bl;
    }

    @Nullable
    public Setting Method2552() {
        return this.Field2115;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int Method2553() {
        int n;
        int n2;
        boolean bl;
        int n3;
        Iterable iterable;
        int n4;
        int n5 = 16;
        if (!this.Field2111) {
            n4 = 0;
        } else {
            boolean bl2;
            Class70 class70;
            iterable = this.Field2110;
            n3 = n5;
            bl = false;
            Iterable iterable2 = iterable;
            Object object = new ArrayList();
            boolean bl3 = false;
            for (Object t : iterable2) {
                class70 = (Class70)t;
                bl2 = false;
                Setting setting = class70.Method2232();
                if (!Intrinsics.areEqual(setting != null ? setting.Field2124 : null, this.Field2116.Method2558())) continue;
                object.add(t);
            }
            List list = (List)object;
            iterable = list;
            bl = false;
            iterable2 = iterable;
            object = new ArrayList();
            bl3 = false;
            for (Object t : iterable2) {
                class70 = (Class70)t;
                bl2 = false;
                Object object2 = class70.Method2232();
                if (!(object2 != null && (object2 = ((Setting)object2).Method2561()) != null ? object2.getAsBoolean() : true)) continue;
                object.add(t);
            }
            list = (List)object;
            iterable = list;
            bl = false;
            int n6 = 0;
            for (Object e : iterable) {
                Class70 class702 = (Class70)e;
                int n7 = n6;
                boolean bl4 = false;
                int n8 = class702.Method2238();
                n6 = n7 + n8;
            }
            n2 = n6;
            n5 = n3;
            n4 = n2 + (this.Field2117 ? 16 : 0);
        }
        int n9 = n5 + n4;
        if (this.Field2111) {
            iterable = this.Field2122.Method591();
            n3 = n9;
            bl = false;
            n2 = !iterable.isEmpty() ? 1 : 0;
            n9 = n3;
            if (n2 != 0) {
                n = 16;
                return n9 + n;
            }
        }
        n = 0;
        return n9 + n;
    }

    public int Method157() {
        int n;
        if (!((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).autowidth.getValue()).booleanValue()) {
            n = ((Number)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).width.getValue()).intValue();
        } else {
            int n2 = this.Method2566().Method2567();
            int n3 = this.Method2568();
            boolean bl = false;
            n = Math.max(n2, n3);
        }
        return n;
    }

    public int Method2568() {
        int n = Class36.Method259(this.Field2122.Method491() + " >") + 5;
        Iterable iterable = this.Field2110;
        boolean bl = false;
        Iterable iterable2 = iterable;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        boolean bl2 = false;
        for (Object t : iterable2) {
            Class70 class70 = (Class70)t;
            Collection collection2 = collection;
            boolean bl3 = false;
            Integer n2 = class70.Method2241();
            collection2.add(n2);
        }
        Integer n3 = (Integer)CollectionsKt.max((List)collection);
        int n4 = n3 != null ? n3 : 0;
        bl = false;
        return Math.max(n, n4);
    }

    @NotNull
    public final Color Method2575() {
        return this.Field2120;
    }

    public final void Method2576(@NotNull Color color) {
        this.Field2120 = color;
    }

    @NotNull
    public final Color Method2577() {
        return this.Field2121;
    }

    public final void Method2578(@NotNull Color color) {
        this.Field2121 = color;
    }

    private final void Method2579() {
        List list = Manager.Field1638.Method2580(this.Field2122);
        if (list == null) {
            return;
        }
        List list2 = list;
        Object object2 = list2;
        boolean bl = false;
        if (!object2.isEmpty()) {
            this.Field2110.add(this.Field2116);
            for (Object object2 : Manager.Field1638.Method2580(this.Field2122)) {
                Class70 class70;
                Object object3;
                Object object4 = ((Setting)object2).getValue();
                if (object4 instanceof Class25) {
                    this.Field2116.Method2583().add(((Class25)object4).Method1608());
                }
                if ((object3 = ((Setting)object2).getValue()) instanceof Boolean) {
                    Object object5 = object2;
                    if (object5 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type me.ciruu.abyss.setting.Setting<kotlin.Boolean>");
                    }
                    class70 = new Class549(this, (Setting)object5);
                } else if (object3 instanceof Enum) {
                    Object object6 = object2;
                    if (object6 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type me.ciruu.abyss.setting.Setting<kotlin.Enum<*>>");
                    }
                    class70 = new Class550(this, (Setting)object6);
                } else if (object3 instanceof String) {
                    Object object7 = object2;
                    if (object7 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type me.ciruu.abyss.setting.Setting<kotlin.String>");
                    }
                    class70 = new Class551(this, (Setting)object7);
                } else if (object3 instanceof Integer) {
                    Object object8 = object2;
                    if (object8 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type me.ciruu.abyss.setting.Setting<kotlin.Int>");
                    }
                    class70 = new Class525(this, (Setting)object8);
                } else if (object3 instanceof Float) {
                    Object object9 = object2;
                    if (object9 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type me.ciruu.abyss.setting.Setting<kotlin.Float>");
                    }
                    class70 = new Class136(this, (Setting)object9);
                } else if (object3 instanceof Class207) {
                    Object object10 = object2;
                    if (object10 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type me.ciruu.abyss.setting.Setting<me.ciruu.abyss.setting.Bind>");
                    }
                    class70 = new Class552(this, (Setting)object10);
                } else {
                    if (!(object3 instanceof Color)) continue;
                    Object object11 = object2;
                    if (object11 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type me.ciruu.abyss.setting.Setting<java.awt.Color>");
                    }
                    class70 = new Class223(this, (Setting)object11);
                }
                Class70 class702 = class70;
                this.Field2110.add(class702);
            }
            if (this.Field2116.Method2583().size() == 1) {
                this.Field2110.remove(this.Field2116);
                this.Field2117 = false;
            }
        }
        this.Field2110.add(new Class69(this, null));
    }

    private final void Method2586() {
        int n = 16;
        for (Class70 class70 : this.Field2110) {
            if (class70 instanceof Class546 || class70 instanceof Class69) {
                class70.Method2236(n);
                n += class70.Method2238();
                continue;
            }
            Object object = class70.Method2232();
            if (object != null && (object = ((Setting)object).Method2561()) != null && !object.getAsBoolean()) continue;
            Setting setting = class70.Method2232();
            if (!StringsKt.equals$default(setting != null ? setting.Field2124 : null, this.Field2116.Method2558(), false, 2, null)) continue;
            class70.Method2236(n);
            n += class70.Method2238();
        }
    }

    @Class72
    public void Method2589() {
        this.Method2586();
        if (this.Method2550()) {
            return;
        }
        GL11.glLineWidth((float)1.0f);
        this.Method2591();
        this.Method2592();
        if (this.Field2119) {
            if (this.Field2118 > 40) {
                this.Method2593(true);
            } else {
                this.Method2593(false);
            }
        }
        Class36.Method63(this.Field2122.Method491(), this.Method2594() + 2, this.Method2595() + 2 + 2, Class74.Field172.Method171().getRGB());
        if (this.Field2110.size() > 1) {
            Class36.Method63(this.Field2111 ? "v" : ">", this.Method2594() + this.Method157() - 10, this.Method2595() + 2 + 2, Class74.Field172.Method171().getRGB());
        }
        if (this.Field2111) {
            Object object2 = this.Field2110;
            boolean bl = false;
            if (!object2.isEmpty()) {
                for (Object object2 : this.Field2110) {
                    if (object2 instanceof Class546 || object2 instanceof Class69) {
                        object2.Method2244();
                        continue;
                    }
                    Object object3 = object2.Method2232();
                    if (object3 != null && (object3 = ((Setting)object3).Method2561()) != null && !object3.getAsBoolean()) continue;
                    Setting setting = object2.Method2232();
                    if (!StringsKt.equals$default(setting != null ? setting.Field2124 : null, this.Field2116.Method2558(), false, 2, null)) continue;
                    object2.Method2244();
                }
            }
        }
    }

    public void Method2597(int n, int n2) {
        this.Field2109 = this.Method2598(n, n2);
        Object object2 = this.Field2110;
        boolean bl = false;
        if (!object2.isEmpty()) {
            for (Object object2 : this.Field2110) {
                if (object2 instanceof Class546 || object2 instanceof Class69) {
                    object2.Method2245(n, n2);
                    continue;
                }
                Object object3 = object2.Method2232();
                if (object3 != null && (object3 = ((Setting)object3).Method2561()) != null && !object3.getAsBoolean()) continue;
                Setting setting = object2.Method2232();
                if (!StringsKt.equals$default(setting != null ? setting.Field2124 : null, this.Field2116.Method2558(), false, 2, null)) continue;
                object2.Method2245(n, n2);
            }
        }
        if (this.Method2599(n, n2)) {
            int n3 = this.Field2118;
            this.Field2118 = n3 + 1;
            this.Field2119 = true;
        } else {
            this.Field2118 = 0;
            this.Field2119 = false;
        }
    }

    public void Method2600(int n, int n2, int n3) {
        if (this.Method2599(n, n2) && n3 == 0) {
            this.Field2122.Method581();
            return;
        }
        if (this.Method2599(n, n2) && n3 == 1) {
            this.Field2111 = !this.Field2111;
            this.Method2566().Method2601();
            return;
        }
        if (this.Method2599(n, n2) && n3 == 2) {
            this.Field2122.Method585(!this.Field2122.Method492());
            ChatFormatting chatFormatting = ChatFormatting.GREEN;
            ChatFormatting chatFormatting2 = ChatFormatting.RED;
            Globals.printChatMessage(this.Field2122.Method491() + " visibility:" + (!this.Field2122.Method492() ? chatFormatting + " ON" : chatFormatting2 + " OFF"));
            return;
        }
        for (Class70 class70 : this.Field2110) {
            if (class70 instanceof Class546 || class70 instanceof Class69) {
                class70.Method2246(n, n2, n3);
                continue;
            }
            Object object = class70.Method2232();
            if (object != null && (object = ((Setting)object).Method2561()) != null && !object.getAsBoolean()) continue;
            Setting setting = class70.Method2232();
            if (Intrinsics.areEqual(setting != null ? setting.Field2124 : null, this.Field2116.Method2558()) ^ true) continue;
            class70.Method2246(n, n2, n3);
            this.Method2566().Method2601();
        }
    }

    public void Method2603(int n, int n2, int n3) {
        for (Class70 class70 : this.Field2110) {
            if (class70 instanceof Class546 || class70 instanceof Class69) {
                class70.Method2247(n, n2, n3);
                continue;
            }
            Object object = class70.Method2232();
            if (object != null && (object = ((Setting)object).Method2561()) != null && !object.getAsBoolean()) continue;
            Setting setting = class70.Method2232();
            if (Intrinsics.areEqual(setting != null ? setting.Field2124 : null, this.Field2116.Method2558()) ^ true) continue;
            class70.Method2247(n, n2, n3);
        }
    }

    public void Method2604(int n, int n2, int n3, long l) {
        if (this.Field2111) {
            for (Class70 class70 : this.Field2110) {
                if (class70 instanceof Class546 || class70 instanceof Class69) {
                    class70.Method2248(n, n2, n3, l);
                    continue;
                }
                Object object = class70.Method2232();
                if (object != null && (object = ((Setting)object).Method2561()) != null && !object.getAsBoolean()) continue;
                Setting setting = class70.Method2232();
                if (Intrinsics.areEqual(setting != null ? setting.Field2124 : null, this.Field2116.Method2558()) ^ true) continue;
                class70.Method2248(n, n2, n3, l);
            }
        }
    }

    public void Method2605(char c, int n) {
        for (Class70 class70 : this.Field2110) {
            class70.Method2249(c, n);
        }
    }

    private final boolean Method2599(int n, int n2) {
        return n > this.Method2594() && n < this.Method2594() + this.Method157() && n2 > this.Method2595() && n2 < this.Method2595() + 16;
    }

    private final void Method2591() {
        if (((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).gradientenabled.getValue()).booleanValue() && ((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).renabled.getValue()).booleanValue()) {
            if ((Class218)((Object)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).gradientmode.getValue()) == Class218.Button) {
                if (!((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).ignoredisabled.getValue()).booleanValue()) {
                    Class50.Method863(this.Method2594(), this.Method2595(), this.Method157(), 16, this.Field2122.Method490() ? Class74.Field172.Method413().getRGB() : Class74.Field172.Method165().getRGB(), this.Field2122.Method490() ? Class74.Field172.Method702().getRGB() : Class74.Field172.Method165().getRGB());
                } else {
                    Class50.Method863(this.Method2594(), this.Method2595(), this.Method157(), 16, Class74.Field172.Method413().getRGB(), Class74.Field172.Method702().getRGB());
                }
            } else if ((Class218)((Object)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).gradientmode.getValue()) == Class218.Frame) {
                if (!((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).ignoredisabled.getValue()).booleanValue()) {
                    Class50.Method863(this.Method2594(), this.Method2595(), this.Method157(), 16, this.Field2122.Method490() ? this.Field2120.getRGB() : Class74.Field172.Method165().getRGB(), this.Field2122.Method490() ? this.Field2121.getRGB() : Class74.Field172.Method165().getRGB());
                } else {
                    Class50.Method863(this.Method2594(), this.Method2595(), this.Method157(), 16, this.Field2120.getRGB(), this.Field2121.getRGB());
                }
            }
        } else {
            Gui.drawRect((int)this.Method2594(), (int)this.Method2595(), (int)(this.Method2594() + this.Method157()), (int)(this.Method2595() + 16), (int)(this.Field2122.Method490() ? Class74.Field172.Method413().getRGB() : Class74.Field172.Method165().getRGB()));
        }
    }

    private final void Method2592() {
        if (((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).gradientline.getValue()).booleanValue() && ((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).rline.getValue()).booleanValue()) {
            Class50.Method817(this.Method2594(), this.Method2595(), this.Method2594() + this.Method157(), this.Method2595(), 2.0f, Class74.Field172.Method703().getRGB(), Class74.Field172.Method704().getRGB());
        } else {
            Class50.Method802(this.Method2594(), this.Method2595(), this.Method2594() + this.Method157(), this.Method2595(), 2.0f, Class74.Field172.Method703().getRGB());
        }
    }

    private final void Method2593(boolean bl) {
        Manager.Field534.getDesc().Method2607(this.Field2122.Method586());
        Manager.Field534.getDesc().Method2608(Class36.Method260());
        Manager.Field534.getDesc().Method2609(Class36.Method259(this.Field2122.Method586()));
        Manager.Field534.getDesc().Method2610(bl && !this.Field2122.Method586().equals(""));
    }

    @NotNull
    public final Module Method159() {
        return this.Field2122;
    }

    @NotNull
    public Class547 Method2566() {
        return this.Field2123;
    }

    public Class70 Method2611() {
        return this.Method2566();
    }

    public Class71(@NotNull Module module, @NotNull Class547 class547) {
        this.Field2122 = module;
        this.Field2123 = class547;
        this.Field2110 = new ArrayList();
        this.Field2116 = new Class546(this);
        this.Field2117 = true;
        this.Field2120 = new Color(255, 255, 255, 255);
        this.Field2121 = new Color(255, 255, 255, 255);
        this.Method2579();
    }

    public int Method2594() {
        return Class75.Method184(this);
    }

    public int Method2595() {
        return Class75.Method185(this);
    }

    public void Method2612(int n) {
        Class75.Method191(this, n);
    }

    public boolean Method2598(int n, int n2) {
        return Class75.Method192(this, n, n2);
    }
}
