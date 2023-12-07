package me.ciruu.abyss.modules.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.HashMap;
import java.util.function.Predicate;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.world.World;

public class TotemPopCount
extends Module {
    private final Setting sendchatmsg = new Setting("SendChatMsg", "Sends to you a message when somebody pops a totem", this, true);
    public static HashMap Field1498 = new HashMap();
    @EventHandler
    private Listener Field2743 = new Listener<EventNetworkPrePacketEvent>(this::Method3357, new Predicate[0]);
    @EventHandler
    private Listener Field2744 = new Listener<EventPlayerUpdate>(this::Method3358, new Predicate[0]);

    public TotemPopCount() {
        super("TotemPopCount", "Counts totem pops from players.", Class11.MISC);
        this.Method3359(this.sendchatmsg);
    }

    private void Method3358(EventPlayerUpdate eventPlayerUpdate) {
        for (EntityPlayer entityPlayer : Globals.mc.world.playerEntities) {
            if (!Field1498.containsKey(entityPlayer.getName()) || !entityPlayer.isDead && !(entityPlayer.getHealth() <= 0.0f)) continue;
            int n = (Integer)Field1498.get(entityPlayer.getName());
            Field1498.remove(entityPlayer.getName());
            if (!((Boolean)this.sendchatmsg.getValue()).booleanValue()) continue;
            Globals.printChatMessage(ChatFormatting.WHITE + entityPlayer.getName() + " died after popping" + n + " totem(s)!");
        }
    }

    private void Method3357(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        SPacketEntityStatus sPacketEntityStatus;
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketEntityStatus && (sPacketEntityStatus = (SPacketEntityStatus)eventNetworkPrePacketEvent.Method49()).getOpCode() == 35) {
            Entity entity = sPacketEntityStatus.getEntity((World)Globals.mc.world);
            if (entity == null) {
                return;
            }
            int n = 1;
            if (Field1498.containsKey(entity.getName())) {
                n = (Integer)Field1498.get(entity.getName());
                Field1498.put(entity.getName(), ++n);
            } else {
                Field1498.put(entity.getName(), n);
            }
            if (((Boolean)this.sendchatmsg.getValue()).booleanValue()) {
                Globals.printChatMessage(ChatFormatting.WHITE + entity.getName() + " popped" + n + " totem(s)!");
            }
        }
    }
}
