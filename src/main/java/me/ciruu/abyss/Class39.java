package me.ciruu.abyss;

import net.minecraft.client.gui.GuiChat;

public final class Class39
extends GuiChat {
    public void drawScreen(int n, int n2, float f) {
        GuiChat.drawRect((int)2, (int)(this.height - 14), (int)(this.width - 2), (int)(this.height - 2), (int)0x70FF0000);
        super.drawScreen(n, n2, f);
    }
}
