package me.ciruu.abyss.modules.misc;

import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class167;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;

public class CrackedUtils
extends Module {
    private final Setting main = new Setting("Main", "", this, new Class25("Main Settings"));
    private final Setting mode = new Setting("Mode", "", this, (Object)Class167.Register);
    private final Setting repeat = new Setting("Repeat", "", (Module)this, (Object)false, this.main, this::Method4318);
    private final Setting pass = new Setting("Pass", "", this, "password");

    public CrackedUtils() {
        super("CrackedUtils", "Performs /register and /login automatically for cracked servers.", Class11.MISC);
        this.Method4319(this.mode);
        this.Method4319(this.repeat);
        this.Method4319(this.pass);
    }

    public void Method4320(boolean bl) {
        if (this.Method4321()) {
            this.Method4322(false);
            this.Method4323();
        }
    }

    public void Method4324() {
        super.Method13();
        if (Globals.mc.player == null || Globals.mc.world == null) {
            this.Method4325();
            return;
        }
        switch ((Class167)((Object)this.mode.getValue())) {
            case Register: {
                Globals.mc.player.sendChatMessage("/register" + (String)this.pass.getValue() + ((Boolean)this.repeat.getValue() != false ? "" + (String)this.pass.getValue() : ""));
                break;
            }
            case Login: {
                Globals.mc.player.sendChatMessage("login" + (String)this.pass.getValue());
            }
        }
        this.Method4325();
    }

    private boolean Method4318() {
        return this.mode.getValue() == Class167.Register;
    }
}
