package me.ciruu.abyss.modules.hud;

import java.awt.Color;
import java.util.function.Predicate;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class Greeter
extends Module {
    private final Setting main = new Setting("MainLabel", "", this, new Class25("Main Settings"));
    private final Setting text = new Setting("Text", "", this, "Welcum to Abyss");
    private final Setting addPlayerName = new Setting("AddPlayerName", "", this, true);
    private final Setting colorLabel = new Setting("ColorLabel", "", this, new Class25("Color Settings"));
    public final Setting color = new Setting("Color", "", (Module)this, (Object)new Color(142, 0, 255, 255), this.colorLabel, Greeter::Method3692);
    public final Setting rainbow = new Setting("Rainbow", "", (Module)this, (Object)false, this.colorLabel, Greeter::Method3693);
    public final Setting speed = new Setting("Speed", "", this, Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(2.0f), this.colorLabel, this.rainbow::getValue);
    public final Setting saturation = new Setting("Saturation", "", this, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.colorLabel, this.rainbow::getValue);
    public final Setting brightness = new Setting("Brightness", "", this, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.colorLabel, this.rainbow::getValue);
    public final Setting gradient = new Setting("Gradient", "", (Module)this, (Object)false, this.colorLabel, this.rainbow::getValue);
    public final Setting delta = new Setting("Delta", "", this, Float.valueOf(-0.05f), Float.valueOf(-0.1f), Float.valueOf(0.1f), this.colorLabel, this::Method3694);
    @EventHandler
    private Listener Field2993 = new Listener<Class35>(this::Method3695, new Predicate[0]);

    public Greeter() {
        super("Greeter", "", Class11.HUD);
        this.Method3696(this.text);
        this.Method3696(this.addPlayerName);
        this.Method3696(this.colorLabel);
        this.Method3696(this.color);
        this.Method3696(this.rainbow);
        this.Method3696(this.speed);
        this.Method3696(this.saturation);
        this.Method3696(this.brightness);
        this.Method3696(this.gradient);
        this.Method3696(this.delta);
    }

    public int Method3697(int n) {
        double d = Math.ceil((double)(System.currentTimeMillis() + (long)n) / (20.0 * (double)((Float)this.speed.getValue()).floatValue()));
        return Color.getHSBColor((float)((d %= 360.0) / 360.0), ((Float)this.saturation.getValue()).floatValue(), ((Float)this.brightness.getValue()).floatValue()).getRGB();
    }

    private void Method3695(Class35 class35) {
        int n = class35.Method2006();
        if (((Boolean)this.gradient.getValue()).booleanValue() && ((Boolean)this.rainbow.getValue()).booleanValue()) {
            Class36.Method62((String)this.text.getValue() + ((Boolean)this.addPlayerName.getValue() != false ? "" + Globals.mc.player.getDisplayNameString() : ""), (float)n / 2.0f - (float)Class36.Method259((String)this.text.getValue() + ((Boolean)this.addPlayerName.getValue() != false ? "" + Globals.mc.player.getDisplayNameString() : "")) / 2.0f, 2.0f, ((Float)this.speed.getValue()).floatValue(), ((Float)this.saturation.getValue()).floatValue(), ((Float)this.brightness.getValue()).floatValue(), ((Float)this.delta.getValue()).floatValue(), true, 0.0f);
        } else {
            Class36.Method557((String)this.text.getValue() + ((Boolean)this.addPlayerName.getValue() != false ? "" + Globals.mc.player.getDisplayNameString() : ""), (float)n / 2.0f, 2.0f, (Boolean)this.rainbow.getValue() != false ? this.Method3697(0) : ((Color)this.color.getValue()).getRGB());
        }
    }

    private boolean Method3694() {
        return (Boolean)this.rainbow.getValue() != false && (Boolean)this.gradient.getValue() != false;
    }

    private static boolean Method3693() {
        return true;
    }

    private static boolean Method3692() {
        return true;
    }
}
