package me.ciruu.abyss;

import me.ciruu.abyss.Globals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;

/*
 * Exception performing whole class analysis ignored.
 */
public static class Class154 {
    private final int Field346;
    private final boolean Field347;
    private final boolean Field348;

    public Class154() {
        this.Field347 = true;
        this.Field346 = -1;
        this.Field348 = false;
    }

    public Class154(int n) {
        this.Field346 = n;
        this.Field348 = false;
        this.Field347 = false;
    }

    public Class154(int n, boolean bl) {
        this.Field346 = n;
        this.Field348 = bl;
        this.Field347 = false;
    }

    public void Method438() {
        if (this.Field347) {
            Globals.mc.playerController.updateController();
        }
        if (this.Field346 != -1) {
            Globals.mc.playerController.windowClick(0, this.Field346, 0, this.Field348 ? ClickType.QUICK_MOVE : ClickType.PICKUP, (EntityPlayer)Globals.mc.player);
        }
    }

    public boolean Method439() {
        return !this.Field347;
    }
}
