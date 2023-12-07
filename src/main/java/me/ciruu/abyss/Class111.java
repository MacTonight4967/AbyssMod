package me.ciruu.abyss;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ciruu.abyss.Class112;
import me.ciruu.abyss.Class113;
import me.ciruu.abyss.Class116;
import me.ciruu.abyss.Class117;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.client.BubbleGUI;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Mouse;

public final class Class111
extends GuiScreen {
    @NotNull
    private Class113 Field271 = new Class113(0L, 0.0f, 0.0f);
    @NotNull
    private Class113 Field272 = new Class113(0L, 0.0f, 0.0f);
    private boolean Field273;
    private static boolean Field274;
    @NotNull
    private static ArrayList Field275;
    @NotNull
    private static ScaledResolution Field276;
    @NotNull
    private static Class113 Field277;
    private static boolean Field278;
    public static final Class112 Field279;

    @NotNull
    public final Class113 getAnim() {
        return this.Field271;
    }

    public final void setAnim(@NotNull Class113 class113) {
        this.Field271 = class113;
    }

    @NotNull
    public final Class113 getModuleAnimation() {
        return this.Field272;
    }

    public final void setModuleAnimation(@NotNull Class113 class113) {
        this.Field272 = class113;
    }

    public final boolean getCloseGUI() {
        return this.Field273;
    }

    public final void setCloseGUI(boolean bl) {
        this.Field273 = bl;
    }

    public void drawScreen(int n, int n2, float f) {
        if (Manager.moduleManager.isModuleEnabled(BubbleGUI.class) && Field277.Method261() && this.Field273) {
            ((BubbleGUI)Manager.moduleManager.getModuleByClass(BubbleGUI.class)).Method262();
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        float f2 = this.Field273 ? Field277.Method264() : this.Field271.Method264();
        Field276 = new ScaledResolution(Globals.mc);
        this.checkMouseWheel(n);
        for (Class116 class116 : Field275) {
            class116.Method268(f2);
            class116.Method269(n, n2);
            f2 += 60.0f;
            int n3 = this.getSelectedModule();
            float f3 = (float)Field276.getScaledHeight() / 2.0f - (float)11 - (float)(22 * n3);
            for (Class117 class117 : class116.Method271()) {
                class117.Method272(f3);
                f3 += (float)22;
            }
        }
    }

    protected void keyTyped(char c, int n) {
        if (n == 1) {
            if (Field274) {
                Field277 = new Class113(1000L, this.getFirstY(), (float)Field276.getScaledHeight() + 400.0f);
            }
            this.Field273 = true;
        }
        for (Class116 class116 : Field275) {
            class116.Method273(c, n);
        }
    }

    protected void mouseClicked(int n, int n2, int n3) {
        Iterable iterable = Field275;
        boolean bl = false;
        for (Object t : iterable) {
            Class116 class116 = (Class116)t;
            boolean bl2 = false;
            class116.Method275(n, n2, n3);
        }
    }

    protected void mouseReleased(int n, int n2, int n3) {
        for (Class116 class116 : Field275) {
            class116.Method276(n, n2, n3);
        }
    }

    protected void mouseClickMove(int n, int n2, int n3, long l) {
        for (Class116 class116 : Field275) {
            class116.Method277(n, n2, n3, l);
        }
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    public void initGui() {
        this.Field273 = false;
        Field276 = new ScaledResolution(Globals.mc);
        if (Field274) {
            this.hideButtons(null);
            float f = -500.0f;
            for (Class116 class116 : Field275) {
                class116.Method268(f);
                class116.Method278(this.getMainX());
                Object object = class116.Method271();
                boolean bl = false;
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    Object t = iterator.next();
                    Class117 class117 = (Class117)t;
                    boolean bl2 = false;
                    class117.Method279(Manager.Field280.getMainX() + (float)50);
                }
                f += 60.0f;
            }
            float f2 = (float)Field276.getScaledHeight() / (float)2 - (float)180;
            this.Field271 = new Class113(500L, -500.0f, f2);
        }
        Field274 = (Boolean)((BubbleGUI)Manager.moduleManager.getModuleByClass(BubbleGUI.class)).animation.getValue();
        if (!Field278) {
            Field278 = true;
            Iterable iterable = Field275;
            boolean bl = false;
            for (Object object : iterable) {
                Class116 class116 = (Class116)object;
                boolean bl3 = false;
                float f = (float)Field276.getScaledHeight() / 2.0f - (float)11;
                for (Class117 class117 : class116.Method271()) {
                    class117.Method272(f);
                    f += (float)22;
                }
            }
        }
    }

    public final float getMainX() {
        return (float)Field276.getScaledWidth() / 4.0f;
    }

    public final float getFirstY() {
        return ((Class116)Field275.get(0)).Method283();
    }

    public final void hideButtons(@Nullable Class116 class116) {
        for (Class116 class1162 : Field275) {
            class1162.Method285(Intrinsics.areEqual(class1162, class116) ^ true);
        }
    }

    public final float getMiddleY() {
        Class116 class116;
        int n = 0;
        Iterator iterator = Field275.iterator();
        while (iterator.hasNext() && (class116 = (Class116)iterator.next()).Method286()) {
            ++n;
        }
        return (float)Field276.getScaledHeight() / (float)2 - (float)(60 * n);
    }

    private final void checkMouseWheel(int n) {
        int n2 = Mouse.getDWheel();
        if (n2 == 0) {
            return;
        }
        this.checkCategoryWheel(n2, n);
        this.checkModuleWheel(n2, n);
    }

    private final void checkModuleWheel(int n, int n2) {
        if ((float)n2 > this.getMainX() + (float)150 || (float)n2 < this.getMainX() + (float)50) {
            return;
        }
        int n3 = -1;
        int n4 = this.getSelectedModule();
        int n5 = this.getModuleListSize();
        if (n > 0) {
            n3 = n4 <= 0 ? 0 : n4 - 1;
        }
        if (n < 0) {
            n3 = n4 == n5 - 1 ? n4 : n4 + 1;
        }
        if (n3 >= 0) {
            this.selectModule(n3);
        }
    }

    private final void selectModule(int n) {
        int n2 = 0;
        for (Class116 class116 : Field275) {
            if (class116.Method286()) continue;
            for (Class117 class117 : class116.Method271()) {
                class117.Method288(n2 == n);
                ++n2;
            }
        }
    }

    private final int getModuleListSize() {
        for (Class116 class116 : Field275) {
            if (class116.Method286()) continue;
            return class116.Method271().size();
        }
        return -1;
    }

    private final int getSelectedModule() {
        int n = 0;
        for (Class116 class116 : Field275) {
            if (class116.Method286()) continue;
            for (Class117 class117 : class116.Method271()) {
                if (class117.Method290()) {
                    return n;
                }
                ++n;
            }
        }
        return n;
    }

    private final float getFirstModuleY() {
        for (Class116 class116 : Field275) {
            if (class116.Method286()) continue;
            return ((Class117)class116.Method271().get(0)).Method291();
        }
        return 0.0f;
    }

    private final float getMiddleYModule() {
        int n = 0;
        for (Class116 class116 : Field275) {
            Class117 class117;
            if (class116.Method286()) continue;
            Iterator iterator = class116.Method271().iterator();
            while (iterator.hasNext() && !(class117 = (Class117)iterator.next()).Method290()) {
                ++n;
            }
            break block0;
        }
        return (float)Field276.getScaledHeight() / 2.0f - (float)11 - (float)(20 * (n - 1) + 10 + 2 * (n - 1));
    }

    private final void checkCategoryWheel(int n, int n2) {
        if ((float)n2 > this.getMainX() + (float)30 || (float)n2 < this.getMainX() - (float)30) {
            return;
        }
        int n3 = -1;
        int n4 = this.getUnhiddenCategory();
        if (n > 0) {
            n3 = n4 == -1 ? 3 : (n4 == 0 ? 0 : n4 - 1);
        }
        if (n < 0) {
            n3 = n4 == -1 ? 3 : (n4 == Field275.size() - 1 ? n4 : n4 + 1);
        }
        if (n3 >= 0 && n3 < Field275.size()) {
            this.hideButtons((Class116)Field275.get(n3));
            this.Field271 = new Class113(200L, this.getFirstY(), this.getMiddleY());
        }
    }

    private final int getUnhiddenCategory() {
        int n = 0;
        for (Class116 class116 : Field275) {
            if (!class116.Method286()) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public Class111() {
        for (Class11 class11 : Class11.values()) {
            Class116 class116 = new Class116(class11);
            Field275.add(class116);
        }
    }

    static {
        Field279 = new Class112(null);
        Field274 = true;
        Field275 = new ArrayList();
        Field276 = new ScaledResolution(Globals.mc);
        Field277 = new Class113(0L, 0.0f, 0.0f);
    }

    public static final boolean Method294() {
        return Field274;
    }

    public static final void Method295(boolean bl) {
        Field274 = bl;
    }

    public static final ArrayList Method296() {
        return Field275;
    }

    public static final void Method297(ArrayList arrayList) {
        Field275 = arrayList;
    }

    public static final ScaledResolution Method298() {
        return Field276;
    }

    public static final void Method299(ScaledResolution scaledResolution) {
        Field276 = scaledResolution;
    }

    public static final Class113 Method300() {
        return Field277;
    }

    public static final void Method301(Class113 class113) {
        Field277 = class113;
    }

    public static final boolean Method302() {
        return Field278;
    }

    public static final void Method303(boolean bl) {
        Field278 = bl;
    }
}
