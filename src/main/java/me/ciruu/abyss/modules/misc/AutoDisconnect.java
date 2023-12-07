package me.ciruu.abyss.modules.misc;

import java.util.function.Predicate;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.client.FMLClientHandler;

public class AutoDisconnect
extends Module {
    public final Setting totemCheck = new Setting("TotemCheck", "", this, true);
    public final Setting health = new Setting("Health", "", (Module)this, (Object)Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(36.0f));
    private final Setting disableOnLog = new Setting("Disable on Log", "", this, false);
    @EventHandler
    private final Listener Field3509 = new Listener<Class26>(this::Method4255, new Predicate[0]);

    public AutoDisconnect() {
        super("AutoDisconnect", "Disconnects automatically if your health is below the limit.", Class11.MISC);
        this.Method4256(this.totemCheck);
        this.Method4256(this.health);
        this.Method4256(this.disableOnLog);
    }

    private void Method4255(Class26 class26) {
        if (Globals.mc.player == null || Globals.mc.world == null) {
            return;
        }
        float f = Class30.Method1454((Entity)Globals.mc.player);
        if (f < ((Float)this.health.getValue()).floatValue() && (!((Boolean)this.totemCheck.getValue()).booleanValue() || Globals.mc.player.getHeldItemOffhand().getItem() != Items.TOTEM_OF_UNDYING)) {
            FMLClientHandler.instance().getClientToServerNetworkManager().closeChannel((ITextComponent)new TextComponentString("Disconnected with HP:" + f));
            if (((Boolean)this.disableOnLog.getValue()).booleanValue()) {
                this.Method4257();
            }
        }
    }
}
