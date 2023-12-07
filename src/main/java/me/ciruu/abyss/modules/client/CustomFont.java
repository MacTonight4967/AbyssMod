package me.ciruu.abyss.modules.client;

import java.awt.Font;
import java.util.function.Predicate;
import me.ciruu.abyss.Class139;
import me.ciruu.abyss.Class197;
import me.ciruu.abyss.Class198;
import me.ciruu.abyss.Class210;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class363;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class CustomFont
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    public final Setting newfontrenderer = new Setting("NewFontRenderer", "", (Module)this, (Object)true, this.mainwindow, CustomFont::Method1553);
    private final Setting size = new Setting("Size", "", this, Float.valueOf(40.0f), Float.valueOf(5.0f), Float.valueOf(60.0f), this.mainwindow, this.newfontrenderer::getValue);
    private final Setting custom = new Setting("Custom", "", (Module)this, (Object)false, this.mainwindow, this.newfontrenderer::getValue);
    private final Setting font = new Setting("Font", "", (Module)this, (Object)"Arial", this.mainwindow, this::Method1554);
    private final Setting type = new Setting("Type", "", (Module)this, (Object)Class363.PLAIN, this.mainwindow, this::Method1555);
    private final Setting fontsize = new Setting("FontSize", "", this, Float.valueOf(17.0f), Float.valueOf(5.0f), Float.valueOf(25.0f), this.mainwindow, this::Method1556);
    private final Setting antialias = new Setting("AntiAlias", "", (Module)this, (Object)true, this.mainwindow, this::Method1557);
    private final Setting fractionalmetrics = new Setting("FractionalMetrics", "", (Module)this, (Object)true, this.mainwindow, this::Method1558);
    public final Setting override = new Setting("Override", "", (Module)this, (Object)false, this.mainwindow, CustomFont::Method1559);
    @EventHandler
    private Listener Field1203 = new Listener<Class139>(this::Method1560, new Predicate[0]);
    @EventHandler
    private Listener Field1204 = new Listener<Class210>(this::Method1561, new Predicate[0]);

    public CustomFont() {
        super("CustomFont", "", Class11.CLIENT);
        this.Method1562(this.newfontrenderer);
        this.Method1562(this.size);
        this.Method1562(this.custom);
        this.Method1562(this.font);
        this.Method1562(this.type);
        this.Method1562(this.fontsize);
        this.Method1562(this.antialias);
        this.Method1562(this.fractionalmetrics);
        this.Method1562(this.override);
        Class36.Method552(new Class197(Class36.Field458.deriveFont(((Float)this.fontsize.getValue()).floatValue()), (Boolean)this.antialias.getValue(), (Boolean)this.fractionalmetrics.getValue()));
        if (((Boolean)this.custom.getValue()).booleanValue()) {
            try {
                Class36.Method553(new Class198(new Font((String)this.font.getValue(), ((Class363)((Object)this.type.getValue())).Field1206, ((Float)this.size.getValue()).intValue()).deriveFont(((Float)this.size.getValue()).floatValue())));
            }
            catch (Exception exception) {
                Class36.Method553(new Class198(Class36.Field458.deriveFont(((Float)this.size.getValue()).floatValue())));
            }
        } else {
            Class36.Method553(new Class198(Class36.Field458.deriveFont(((Float)this.size.getValue()).floatValue())));
        }
    }

    public void Method1563() {
        if (((Boolean)this.newfontrenderer.getValue()).booleanValue()) {
            if (((Boolean)this.custom.getValue()).booleanValue()) {
                try {
                    Class36.Method553(new Class198(new Font((String)this.font.getValue(), ((Class363)((Object)this.type.getValue())).Field1206, ((Float)this.size.getValue()).intValue()).deriveFont(((Float)this.size.getValue()).floatValue())));
                }
                catch (Exception exception) {
                    Class36.Method553(new Class198(Class36.Field458.deriveFont(((Float)this.size.getValue()).floatValue())));
                }
            } else {
                Class36.Method553(new Class198(Class36.Field458.deriveFont(((Float)this.size.getValue()).floatValue())));
            }
        } else {
            Class36.Method552(new Class197(Class36.Field458.deriveFont(((Float)this.fontsize.getValue()).floatValue()), (Boolean)this.antialias.getValue(), (Boolean)this.fractionalmetrics.getValue()));
        }
    }

    private void Method1561(Class210 class210) {
        this.Method1563();
    }

    private void Method1560(Class139 class139) {
        if (class139.Method1564() == this) {
            this.Method1563();
        }
    }

    private static boolean Method1559() {
        return true;
    }

    private boolean Method1558() {
        return (Boolean)this.newfontrenderer.getValue() == false;
    }

    private boolean Method1557() {
        return (Boolean)this.newfontrenderer.getValue() == false;
    }

    private boolean Method1556() {
        return (Boolean)this.newfontrenderer.getValue() == false;
    }

    private boolean Method1555() {
        return (Boolean)this.newfontrenderer.getValue() != false && (Boolean)this.custom.getValue() != false;
    }

    private boolean Method1554() {
        return (Boolean)this.newfontrenderer.getValue() != false && (Boolean)this.custom.getValue() != false;
    }

    private static boolean Method1553() {
        return true;
    }
}
