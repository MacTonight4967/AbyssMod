package me.ciruu.abyss.modules.client;

import java.awt.Color;
import java.util.function.Predicate;
import me.ciruu.abyss.Class219;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.gui.GuiChat;

public class Particles
extends Module {
    private final Setting chat = new Setting("Chat", "", this, true);
    private final Setting gui = new Setting("GUI", "", this, true);
    private final Setting radius = new Setting("Radius", "", (Module)this, (Object)Float.valueOf(50.0f), Float.valueOf(10.0f), Float.valueOf(500.0f));
    private final Setting speed = new Setting("Speed", "", (Module)this, (Object)Float.valueOf(0.5f), Float.valueOf(0.0f), Float.valueOf(5.0f));
    private final Setting delta = new Setting("Delta", "", (Module)this, (Object)1, 0, 5);
    private final Setting amount = new Setting("Amount", "", (Module)this, (Object)100, 1, 300);
    private final Setting linewidth = new Setting("LineWidth", "", (Module)this, (Object)Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(5.0f));
    private final Setting colorlabel = new Setting("ColorLabel", "", this, new Class25("Color Settings"));
    private final Setting color = new Setting("Color", "", (Module)this, (Object)new Color(142, 0, 255, 255), this.colorlabel, Particles::Method2959);
    private final Setting rainbow = new Setting("Rainbow", "", (Module)this, (Object)false, this.colorlabel, Particles::Method2960);
    private final Setting rspeed = new Setting("RSpeed", "", this, Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(2.0f), this.colorlabel, this.rainbow::getValue);
    private final Setting saturation = new Setting("Saturation", "", this, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.colorlabel, this.rainbow::getValue);
    private final Setting brightness = new Setting("Brightness", "", this, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.colorlabel, this.rainbow::getValue);
    private final Setting gradient = new Setting("Gradient", "", (Module)this, (Object)true, this.colorlabel, this.rainbow::getValue);
    private final Setting offset = new Setting("Offset", "", this, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(4.0f), this.colorlabel, this::Method2961);
    @EventHandler
    private Listener Field2444 = new Listener<Class26>(this::Method2962, new Predicate[0]);
    @EventHandler
    private Listener Field2445 = new Listener<Class35>(this::Method2963, new Predicate[0]);

    public Particles() {
        super("Particles", "", Class11.CLIENT);
        this.Method2964(this.chat);
        this.Method2964(this.gui);
        this.Method2964(this.radius);
        this.Method2964(this.speed);
        this.Method2964(this.delta);
        this.Method2964(this.amount);
        this.Method2964(this.linewidth);
        this.Method2964(this.colorlabel);
        this.Method2964(this.color);
        this.Method2964(this.rainbow);
        this.Method2964(this.rspeed);
        this.Method2964(this.saturation);
        this.Method2964(this.brightness);
        this.Method2964(this.gradient);
        this.Method2964(this.offset);
    }

    public void Method2965() {
        super.Method13();
        Manager.Field1648.Method2201((Integer)this.amount.getValue());
    }

    public Color Method2966() {
        return (Boolean)this.rainbow.getValue() != false ? this.Method2967(0) : (Color)this.color.getValue();
    }

    public Color Method2967(int n) {
        double d = Math.ceil((double)(System.currentTimeMillis() + (long)n) / (20.0 * (double)((Float)this.rspeed.getValue()).floatValue()));
        return Color.getHSBColor((float)((d %= 360.0) / 360.0), ((Float)this.saturation.getValue()).floatValue(), ((Float)this.brightness.getValue()).floatValue());
    }

    private void Method2963(Class35 class35) {
        if (((Boolean)this.chat.getValue()).booleanValue() && Globals.mc.currentScreen instanceof GuiChat || ((Boolean)this.gui.getValue()).booleanValue() && Globals.mc.currentScreen instanceof Class219) {
            Manager.Field1648.Method2195(this.Method2966(), ((Float)this.radius.getValue()).floatValue(), (Boolean)this.rainbow.getValue() != false && (Boolean)this.gradient.getValue() != false, ((Float)this.offset.getValue()).floatValue(), ((Float)this.linewidth.getValue()).floatValue(), class35);
        }
    }

    private void Method2962(Class26 class26) {
        if (((Boolean)this.chat.getValue()).booleanValue() && Globals.mc.currentScreen instanceof GuiChat || ((Boolean)this.gui.getValue()).booleanValue() && Globals.mc.currentScreen instanceof Class219) {
            Manager.Field1648.Method2198((Integer)this.delta.getValue(), ((Float)this.speed.getValue()).floatValue());
        }
    }

    private boolean Method2961() {
        return (Boolean)this.rainbow.getValue() != false && (Boolean)this.gradient.getValue() != false;
    }

    private static boolean Method2960() {
        return true;
    }

    private static boolean Method2959() {
        return true;
    }
}
