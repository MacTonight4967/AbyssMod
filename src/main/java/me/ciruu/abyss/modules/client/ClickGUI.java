package me.ciruu.abyss.modules.client;

import java.awt.Color;
import java.util.function.Predicate;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class74;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class218;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public class ClickGUI
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    public final Setting framecolor = new Setting("FrameColor", "", this, new Color(19, 18, 18, 151));
    public final Setting enabledcolor = new Setting("EnabledColor", "", this, new Color(106, 0, 193, 255));
    public final Setting fontcolor = new Setting("FontColor", "", this, new Color(255, 255, 255, 255));
    public final Setting linecolor = new Setting("LineColor", "", this, new Color(142, 0, 255, 255));
    public final Setting typingslidercolor = new Setting("TypingSliderColor", "", this, new Color(160, 0, 160, 255));
    private final Setting saveonclose = new Setting("SaveOnClose", "", this, true);
    public final Setting autowidth = new Setting("AutoWidth", "", this, false);
    public final Setting width = new Setting("Width", "", this, 90, 90, 170, this.mainwindow, this::Method672);
    private final Setting rainbow = new Setting("rainbow", "", this, new Class25("Rainbow Settings"));
    public final Setting rline = new Setting("RLine", "", (Module)this, (Object)false, this.rainbow, ClickGUI::Method673);
    private final Setting rspeedline = new Setting("RSpeedLine", "", this, Float.valueOf(7.0f), Float.valueOf(0.001f), Float.valueOf(10.0f), this.rainbow, this.rline::getValue);
    private final Setting rsatline = new Setting("RSatLine", "", this, Float.valueOf(0.5f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.rainbow, this.rline::getValue);
    private final Setting rbrightline = new Setting("RBrightLine", "", this, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.rainbow, this.rline::getValue);
    public final Setting gradientline = new Setting("GradientLine", "", (Module)this, (Object)false, this.rainbow, this.rline::getValue);
    private final Setting lineoffset = new Setting("LineOffset", "", this, Float.valueOf(3.0f), Float.valueOf(0.0f), Float.valueOf(7.0f), this.rainbow, this::Method674);
    public final Setting renabled = new Setting("REnabled", "", (Module)this, (Object)false, this.rainbow, ClickGUI::Method675);
    public final Setting rspeedenabled = new Setting("RSpeedEnabled", "", this, Float.valueOf(7.0f), Float.valueOf(0.001f), Float.valueOf(10.0f), this.rainbow, this.renabled::getValue);
    public final Setting rsatenabled = new Setting("RSatEnabled", "", this, Float.valueOf(0.5f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.rainbow, this.renabled::getValue);
    public final Setting rbrightenabled = new Setting("RBrightEnabled", "", this, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.rainbow, this.renabled::getValue);
    public final Setting gradientenabled = new Setting("GradientEnabled", "", (Module)this, (Object)false, this.rainbow, this.renabled::getValue);
    public final Setting enabledoffset = new Setting("EnabledOffset", "", this, Float.valueOf(10.0f), Float.valueOf(2.0f), Float.valueOf(20.0f), this.rainbow, this::Method676);
    public final Setting ignoredisabled = new Setting("IgnoreDisabled", "", (Module)this, (Object)false, this.rainbow, this::Method677);
    public final Setting gradientmode = new Setting("GradientMode", "", (Module)this, (Object)Class218.Button, this.rainbow, this::Method678);
    private final Setting backgroundwindow = new Setting("background", "", this, new Class25("Background Settings"));
    public final Setting backgroundenabled = new Setting("Background", "", (Module)this, (Object)false, this.backgroundwindow, ClickGUI::Method679);
    public final Setting backgroundgradient = new Setting("Gradient", "", (Module)this, (Object)true, this.backgroundwindow, this.backgroundenabled::getValue);
    public final Setting backgroundcolor = new Setting("BackgroundColor", "", (Module)this, (Object)new Color(0, 0, 0, 180), this.backgroundwindow, this::Method680);
    public final Setting backgroundcolortop = new Setting("BgColorTop", "", (Module)this, (Object)new Color(0, 0, 0, 0), this.backgroundwindow, this::Method681);
    public final Setting backgroundcolorbottom = new Setting("BgColorBottom", "", (Module)this, (Object)new Color(142, 0, 255, 180), this.backgroundwindow, this::Method682);
    @EventHandler
    private Listener Field532 = new Listener<Class26>(this::Method683, new Predicate[0]);

    public ClickGUI() {
        super("ClickGUI", "", Class11.CLIENT);
        this.Method684(Keyboard.getKeyName((int)25));
        this.Method685(this.framecolor);
        this.Method685(this.enabledcolor);
        this.Method685(this.fontcolor);
        this.Method685(this.linecolor);
        this.Method685(this.typingslidercolor);
        this.Method685(this.saveonclose);
        this.Method685(this.autowidth);
        this.Method685(this.width);
        this.Method685(this.rainbow);
        this.Method685(this.rline);
        this.Method685(this.rspeedline);
        this.Method685(this.rsatline);
        this.Method685(this.rbrightline);
        this.Method685(this.gradientline);
        this.Method685(this.lineoffset);
        this.Method685(this.renabled);
        this.Method685(this.rspeedenabled);
        this.Method685(this.rsatenabled);
        this.Method685(this.rbrightenabled);
        this.Method685(this.gradientenabled);
        this.Method685(this.enabledoffset);
        this.Method685(this.ignoredisabled);
        this.Method685(this.gradientmode);
        this.Method685(this.backgroundwindow);
        this.Method685(this.backgroundenabled);
        this.Method685(this.backgroundgradient);
        this.Method685(this.backgroundcolor);
        this.Method685(this.backgroundcolortop);
        this.Method685(this.backgroundcolorbottom);
    }

    public void Method686(boolean bl) {
        this.Method687(false);
        this.Method688();
    }

    public void Method689() {
        super.Method13();
        Globals.mc.displayGuiScreen((GuiScreen)Manager.Field534);
    }

    public void Method688() {
        super.Method15();
        if (((Boolean)this.saveonclose.getValue()).booleanValue() && Globals.mc.world != null) {
            Module.Method597();
        }
    }

    private Color Method690(int n, float f, float f2) {
        float f3 = System.currentTimeMillis() % (long)n;
        return Color.getHSBColor(f3 /= (float)n, f, f2);
    }

    private Color Method691(int n, float f, float f2, int n2) {
        float f3 = System.currentTimeMillis() % (long)n + (long)n2;
        return Color.getHSBColor(f3 /= (float)n, f, f2);
    }

    private void Method683(Class26 class26) {
        Class74.Field172.Method692((Color)this.framecolor.getValue());
        Class74.Field172.Method693((Color)this.fontcolor.getValue());
        Class74.Field172.Method694((Color)this.typingslidercolor.getValue());
        if (!((Boolean)this.renabled.getValue()).booleanValue()) {
            Class74.Field172.Method695((Color)this.enabledcolor.getValue());
        } else {
            Class74.Field172.Method695(this.Method690((int)(((Float)this.rspeedenabled.getValue()).floatValue() * 1000.0f), ((Float)this.rsatenabled.getValue()).floatValue(), ((Float)this.rbrightenabled.getValue()).floatValue()));
            if (((Boolean)this.gradientenabled.getValue()).booleanValue() && this.gradientmode.getValue() == Class218.Button) {
                Class74.Field172.Method696(this.Method691((int)(((Float)this.rspeedenabled.getValue()).floatValue() * 1000.0f), ((Float)this.rsatenabled.getValue()).floatValue(), ((Float)this.rbrightenabled.getValue()).floatValue(), (int)(((Float)this.enabledoffset.getValue()).floatValue() * 1000.0f)));
            }
        }
        if (!((Boolean)this.rline.getValue()).booleanValue()) {
            Class74.Field172.Method697((Color)this.linecolor.getValue());
        } else {
            Class74.Field172.Method697(this.Method690((int)(((Float)this.rspeedline.getValue()).floatValue() * 1000.0f), ((Float)this.rsatline.getValue()).floatValue(), ((Float)this.rbrightline.getValue()).floatValue()));
            if (((Boolean)this.gradientline.getValue()).booleanValue()) {
                Class74.Field172.Method698(this.Method691((int)(((Float)this.rspeedline.getValue()).floatValue() * 1000.0f), ((Float)this.rsatline.getValue()).floatValue(), ((Float)this.rbrightline.getValue()).floatValue(), (int)(((Float)this.lineoffset.getValue()).floatValue() * 1000.0f)));
            }
        }
    }

    private boolean Method682() {
        return (Boolean)this.backgroundenabled.getValue() != false && (Boolean)this.backgroundgradient.getValue() != false;
    }

    private boolean Method681() {
        return (Boolean)this.backgroundenabled.getValue() != false && (Boolean)this.backgroundgradient.getValue() != false;
    }

    private boolean Method680() {
        return (Boolean)this.backgroundenabled.getValue() != false && (Boolean)this.backgroundgradient.getValue() == false;
    }

    private static boolean Method679() {
        return true;
    }

    private boolean Method678() {
        return (Boolean)this.renabled.getValue() != false && (Boolean)this.gradientenabled.getValue() != false;
    }

    private boolean Method677() {
        return (Boolean)this.renabled.getValue() != false && (Boolean)this.gradientenabled.getValue() != false;
    }

    private boolean Method676() {
        return (Boolean)this.renabled.getValue() != false && (Boolean)this.gradientenabled.getValue() != false;
    }

    private static boolean Method675() {
        return true;
    }

    private boolean Method674() {
        return (Boolean)this.rline.getValue() != false && (Boolean)this.gradientline.getValue() != false;
    }

    private static boolean Method673() {
        return true;
    }

    private boolean Method672() {
        return (Boolean)this.autowidth.getValue() == false;
    }
}
