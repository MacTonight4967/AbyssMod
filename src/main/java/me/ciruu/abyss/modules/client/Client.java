package me.ciruu.abyss.modules.client;

import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;

public class Client
extends Module {
    public final Setting startupsound = new Setting("StartUpSound", "", this, false);
    public final Setting friendmessage = new Setting("FriendMessage", "Sends a DM to the person that you friended", this, false);
    public final Setting chatblur = new Setting("ChatBlur", "", this, false);
    public final Setting descriptions = new Setting("Descriptions", "", this, false);
    public final Setting cmdprefix = new Setting("CMDPrefix", "", this, "*");

    public Client() {
        super("Client", "", Class11.CLIENT);
        this.Method4032(this.startupsound);
        this.Method4032(this.friendmessage);
        this.Method4032(this.chatblur);
        this.Method4032(this.descriptions);
        this.Method4032(this.cmdprefix);
    }
}
