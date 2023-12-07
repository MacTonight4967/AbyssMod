package me.ciruu.abyss.modules.client;

import me.ciruu.abyss.Class25;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class173;
import me.ciruu.abyss.enums.Class175;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;

public class ScreenShaders
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    public final Setting mode = new Setting("Mode", "", this, (Object)Class173.Static);
    public final Setting shader = new Setting("Shader", "", (Module)this, (Object)Class175.RedLines, this.mainwindow, this::Method718);
    public final Setting fps = new Setting("FPS", "", (Module)this, (Object)60, 5, 60);

    public ScreenShaders() {
        super("ScreenShaders", "", Class11.CLIENT);
        this.Method719(this.mode);
        this.Method719(this.shader);
        this.Method719(this.fps);
    }

    private boolean Method718() {
        return this.mode.getValue() == Class173.Static;
    }
}
