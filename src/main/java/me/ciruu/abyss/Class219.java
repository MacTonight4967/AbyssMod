package me.ciruu.abyss;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class547;
import me.ciruu.abyss.Class553;
import me.ciruu.abyss.Class643;
import me.ciruu.abyss.Class71;
import me.ciruu.abyss.Class74;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.client.ClickGUI;
import me.ciruu.abyss.modules.client.Client;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Mouse;

public final class Class219
extends GuiScreen {
    @NotNull
    private Class553 Field2931 = new Class553(0, 0, "", false);
    @NotNull
    private static ArrayList Field2932;
    private static int Field2933;
    @NotNull
    private static ScaledResolution Field2934;
    @NotNull
    private static Integer[] Field2935;
    public static final Class643 Field2936;

    public void initGui() {
    }

    @NotNull
    public final Class553 getDesc() {
        return this.Field2931;
    }

    public final void setDesc(@NotNull Class553 class553) {
        this.Field2931 = class553;
    }

    public void drawScreen(int n, int n2, float f) {
        Class219.Field2935[0] = n;
        Class219.Field2935[1] = n2;
        this.checkMouseWheel();
        this.drawBackground();
        for (Class547 class547 : Field2932) {
            class547.Method3119();
            class547.Method3135(n, n2);
            for (Class71 class71 : class547.Method3098()) {
                class71.Method2597(n, n2);
            }
        }
        if (((Boolean)((Client)Manager.moduleManager.getModuleByClass(Client.class)).descriptions.getValue()).booleanValue()) {
            this.renderDescription();
        }
    }

    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        for (Class547 class547 : Field2932) {
            if (class547.Method3136(n, n2) && n3 == 0) {
                class547.Method3134(true);
                class547.Method3114(n - class547.Method3106());
                class547.Method3116(n2 - class547.Method3104());
            }
            if (class547.Method3136(n, n2) && n3 == 1) {
                class547.Method3101(!class547.Method3100());
            }
            if (!class547.Method3100()) continue;
            Object object2 = class547.Method3098();
            boolean bl = false;
            if (!(!object2.isEmpty())) continue;
            for (Object object2 : class547.Method3098()) {
                ((Class71)object2).Method2600(n, n2, n3);
            }
        }
    }

    protected void keyTyped(char c, int n) {
        for (Class547 class547 : Field2932) {
            if (!class547.Method3100() || n == 1) continue;
            Object object2 = class547.Method3098();
            boolean bl = false;
            if (!(!object2.isEmpty())) continue;
            for (Object object2 : class547.Method3098()) {
                ((Class71)object2).Method2605(c, n);
            }
        }
        if (n == 1) {
            this.mc.displayGuiScreen((GuiScreen)null);
            if (Manager.moduleManager.isModuleEnabled(ClickGUI.class)) {
                ((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).Method238();
            }
        }
    }

    protected void mouseReleased(int n, int n2, int n3) {
        for (Class547 class547 : Field2932) {
            class547.Method3134(false);
        }
        for (Class547 class547 : Field2932) {
            if (!class547.Method3100()) continue;
            Object object2 = class547.Method3098();
            boolean bl = false;
            if (!(!object2.isEmpty())) continue;
            for (Object object2 : class547.Method3098()) {
                ((Class71)object2).Method2603(n, n2, n3);
            }
        }
    }

    protected void mouseClickMove(int n, int n2, int n3, long l) {
        for (Class547 class547 : Field2932) {
            if (!class547.Method3100()) continue;
            Object object2 = class547.Method3098();
            boolean bl = false;
            if (!(!object2.isEmpty())) continue;
            for (Object object2 : class547.Method3098()) {
                ((Class71)object2).Method2604(n, n2, n3, l);
            }
        }
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    private final void renderDescription() {
        if (!this.Field2931.Method3031()) {
            return;
        }
        int n = 10;
        Gui.drawRect((int)Field2935[0], (int)(Field2935[1] - n), (int)(Field2935[0] + this.Field2931.Method3028() + 6), (int)(Field2935[1] - n + this.Field2931.Method3029() + 4), (int)Class74.Field172.Method165().getRGB());
        Class36.Method63(this.Field2931.Method3030(), (float)Field2935[0].intValue() + 3.0f, (float)Field2935[1].intValue() + 2.0f - (float)n, Class74.Field172.Method171().getRGB());
    }

    private final void checkMouseWheel() {
        block3: {
            int n;
            block2: {
                n = Mouse.getDWheel();
                if (n >= 0) break block2;
                Iterable iterable = Field2932;
                boolean bl = false;
                for (Object t : iterable) {
                    Class547 class547 = (Class547)t;
                    boolean bl2 = false;
                    class547.Method3105(class547.Method3104() - 10);
                }
                break block3;
            }
            if (n <= 0) break block3;
            Iterable iterable = Field2932;
            boolean bl = false;
            for (Object t : iterable) {
                Class547 class547 = (Class547)t;
                boolean bl3 = false;
                class547.Method3105(class547.Method3104() + 10);
            }
        }
    }

    private final void drawBackground() {
        if (((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).backgroundenabled.getValue()).booleanValue()) {
            Field2934 = new ScaledResolution(this.mc);
            if (((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).backgroundgradient.getValue()).booleanValue()) {
                this.drawGradientRect(0, 0, Field2934.getScaledWidth(), Field2934.getScaledHeight(), ((Color)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).backgroundcolortop.getValue()).getRGB(), ((Color)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).backgroundcolorbottom.getValue()).getRGB());
            } else {
                GuiScreen.drawRect((int)0, (int)0, (int)Field2934.getScaledWidth(), (int)Field2934.getScaledHeight(), (int)((Color)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).backgroundcolor.getValue()).getRGB());
            }
        }
    }

    public Class219() {
        int n = 5;
        for (Class11 class11 : Class11.values()) {
            Class547 class547 = new Class547(class11);
            class547.Method3107(n);
            Field2932.add(class547);
            n += ((Boolean)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).autowidth.getValue() == false ? (Integer)((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).width.getValue() : Integer.valueOf(class547.Method2567())) + 5;
        }
    }

    static {
        Field2936 = new Class643(null);
        Field2932 = new ArrayList();
        Field2934 = new ScaledResolution(Globals.mc);
        Field2935 = new Integer[]{1, 2};
        Field2933 = -1;
    }

    public static final ArrayList Method3624() {
        return Field2932;
    }

    public static final void Method3625(ArrayList arrayList) {
        Field2932 = arrayList;
    }

    public static final int Method3626() {
        return Field2933;
    }

    public static final void Method3627(int n) {
        Field2933 = n;
    }

    public static final ScaledResolution Method3628() {
        return Field2934;
    }

    public static final void Method3629(ScaledResolution scaledResolution) {
        Field2934 = scaledResolution;
    }

    public static final Integer[] Method3630() {
        return Field2935;
    }

    public static final void Method3631(Integer[] integerArray) {
        Field2935 = integerArray;
    }
}
