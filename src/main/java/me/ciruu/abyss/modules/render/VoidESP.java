package me.ciruu.abyss.modules.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Class50;
import me.ciruu.abyss.Class66;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class VoidESP
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    private final Setting radius = new Setting("Radius", "", (Module)this, (Object)10, 0, 30);
    private final Setting height = new Setting("Height", "", (Module)this, (Object)Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(5.0f));
    private final Setting color = new Setting("Color", "", this, new Color(122, 0, 255, 50));
    private final Setting box = new Setting("Box", "", this, true);
    private final Setting outline = new Setting("Outline", "", this, true);
    private final Setting width = new Setting("Width", "", this, 1, 1, 10, this.mainwindow, this.outline::getValue);
    public List Field1987 = new ArrayList();
    @EventHandler
    private Listener Field1988 = new Listener<EventPlayerUpdate>(this::Method2390, new Predicate[0]);
    @EventHandler
    private Listener Field1989 = new Listener<Class66>(this::Method2391, new Predicate[0]);

    public VoidESP() {
        super("VoidESP", "Highlights blocks over void.", Class11.RENDER);
        this.Method2392(this.radius);
        this.Method2392(this.height);
        this.Method2392(this.color);
        this.Method2392(this.box);
        this.Method2392(this.outline);
        this.Method2392(this.width);
    }

    private List Method2393() {
        return Class31.Method210(Class30.Method209((EntityPlayer)Globals.mc.player), ((Integer)this.radius.getValue()).intValue(), (Integer)this.radius.getValue(), false, true, 0).stream().filter(this::Method2394).collect(Collectors.toList());
    }

    private boolean Method2394(BlockPos blockPos) {
        return Globals.mc.world.getBlockState(blockPos).getBlock() == Blocks.AIR && blockPos.getY() < 1 && blockPos.getY() >= 0;
    }

    private void Method2391(Class66 class66) {
        if (Globals.mc.getRenderManager() == null || Globals.mc.getRenderManager().options == null || Globals.mc.player.dimension == 1) {
            return;
        }
        this.Field1987.forEach(this::Method2395);
    }

    private void Method2395(BlockPos blockPos) {
        Class50.Method790(blockPos, (Color)this.color.getValue(), true, new Color(((Color)this.color.getValue()).getRed(), ((Color)this.color.getValue()).getGreen(), ((Color)this.color.getValue()).getBlue(), 255), ((Integer)this.width.getValue()).intValue(), (Boolean)this.outline.getValue(), (Boolean)this.box.getValue(), ((Color)this.color.getValue()).getAlpha(), true, ((Float)this.height.getValue()).floatValue());
    }

    private void Method2390(EventPlayerUpdate eventPlayerUpdate) {
        if (Globals.mc.player == null) {
            return;
        }
        this.Field1987 = this.Method2393();
    }
}
