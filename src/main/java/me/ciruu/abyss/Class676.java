package me.ciruu.abyss;

import java.util.function.Predicate;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class Class676
extends Module {
    private final Setting Field3493 = new Setting("ChangeId", "", this, false);
    private final Setting Field3494 = new Setting("Id", "", this, "1000");
    private int Field3495 = 1000000;
    @EventHandler
    private Listener Field3496 = new Listener<EntityJoinWorldEvent>(this::Method4241, new Predicate[0]);

    public Class676() {
        super("ChangeCrystalID", "", Class11.MISC);
        this.Method4242(this.Field3493);
        this.Method4242(this.Field3494);
    }

    public void Method4243(boolean bl) {
        if (this.Method4244()) {
            this.Method4245(false);
            this.Method4246();
        }
    }

    public void Method4247() {
        super.Method13();
        if (((Boolean)this.Field3493.getValue()).booleanValue()) {
            Entity entity;
            RayTraceResult rayTraceResult = Globals.mc.objectMouseOver;
            RayTraceResult.Type type = rayTraceResult.typeOfHit;
            if (type == RayTraceResult.Type.ENTITY && (entity = rayTraceResult.entityHit) instanceof EntityEnderCrystal) {
                int n;
                try {
                    n = Integer.parseInt((String)this.Field3494.getValue());
                }
                catch (Exception exception) {
                    Globals.printChatMessage("Error, invalid ID!");
                    this.Method4248();
                    return;
                }
                entity.setEntityId(n);
                Globals.printChatMessage("Done!");
                Globals.printChatMessage("New ID:" + n);
                this.Method4248();
                return;
            }
            this.Method4248();
        }
    }

    private void Method4241(EntityJoinWorldEvent entityJoinWorldEvent) {
        if (entityJoinWorldEvent.getEntity() instanceof EntityEnderCrystal) {
            entityJoinWorldEvent.getEntity().setEntityId(this.Field3495);
            ++this.Field3495;
        }
    }
}
