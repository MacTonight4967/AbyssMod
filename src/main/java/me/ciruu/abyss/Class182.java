package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;
import me.ciruu.abyss.Class185;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class184;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class Class182
extends Module {
    private final Setting Field405 = new Setting("Main", "", this, new Class25("Main Settings"));
    public final Setting Field406 = new Setting("CustomFont", "", this, false);
    public final Setting Field407 = new Setting("ChatBackground", "", this, false);
    public final Setting Field408 = new Setting("Opacity", "", (Module)this, (Object)false, this.Field405, this::Method497);
    public final Setting Field409 = new Setting("ChatOpacity", "", this, 255, 0, 255, this.Field405, this::Method498);
    public final Setting Field410 = new Setting("NoChatShadow", "", this, false);
    private final Setting Field411 = new Setting("PlayerColor", "", this, (Object)Class184.WHITE);
    private final Setting Field412 = new Setting("TimeStamps", "", this, false);
    private final Setting Field413 = new Setting("24HourTime", "", (Module)this, (Object)false, this.Field405, this.Field412::getValue);
    private final Setting Field414 = new Setting("DateColor", "", (Module)this, (Object)Class184.GRAY, this.Field405, this.Field412::getValue);
    @EventHandler
    private Listener Field415 = new Listener<EventNetworkPrePacketEvent>(this::Method499, new Predicate[0]);

    public Class182() {
        super("CustomChat", "", Class11.CLIENT);
        this.Method500(this.Field406);
        this.Method500(this.Field407);
        this.Method500(this.Field408);
        this.Method500(this.Field409);
        this.Method500(this.Field410);
        this.Method500(this.Field411);
        this.Method500(this.Field412);
        this.Method500(this.Field413);
        this.Method500(this.Field414);
    }

    private boolean Method501(String string, String string2) {
        String string3;
        String string4 = string;
        String[] stringArray = string4.split("");
        String[] stringArray2 = string2.split("");
        stringArray[0] = stringArray2[0];
        if (stringArray[0].startsWith("<") && stringArray[0].endsWith(">")) {
            stringArray[0] = stringArray[0].replaceAll("<", "");
            stringArray[0] = stringArray[0].replaceAll(">", "");
            stringArray[0] = Class185.Method502((Class184)((Object)this.Field411.getValue())) + stringArray[0] + ChatFormatting.RESET;
            string3 = "<" + stringArray[0] + ">";
            for (int i = 1; i < stringArray.length; ++i) {
                string3 = string3 + "" + stringArray[i];
            }
            string = string3;
        }
        string4 = string;
        if (((Boolean)this.Field412.getValue()).booleanValue()) {
            string3 = "";
            string3 = (Boolean)this.Field413.getValue() != false ? new SimpleDateFormat("k:mm").format(new Date()) : new SimpleDateFormat("h:mm a").format(new Date());
            string4 = Class185.Method502((Class184)((Object)this.Field414.getValue())) + "[" + string3 + "]" + ChatFormatting.RESET + string;
        }
        Globals.mc.ingameGUI.getChatGUI().printChatMessage((ITextComponent)new TextComponentString(string4));
        return true;
    }

    private void Method499(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        SPacketChat sPacketChat;
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketChat && (sPacketChat = (SPacketChat)eventNetworkPrePacketEvent.Method49()).getType() != ChatType.GAME_INFO) {
            try {
                if (this.Method501(sPacketChat.getChatComponent().getFormattedText(), sPacketChat.getChatComponent().getUnformattedText())) {
                    eventNetworkPrePacketEvent.cancel();
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private boolean Method498() {
        return (Boolean)this.Field408.getValue() != false && (Boolean)this.Field407.getValue() == false;
    }

    private boolean Method497() {
        return (Boolean)this.Field407.getValue() == false;
    }
}
