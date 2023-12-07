package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.ciruu.abyss.Class101;
import me.ciruu.abyss.Class116;
import me.ciruu.abyss.Class232;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class423;
import me.ciruu.abyss.Class631;
import me.ciruu.abyss.Class632;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.Module;
import org.jetbrains.annotations.NotNull;

public final class Class117
implements Class631 {
    private float Field3396;
    private float Field3397;
    private boolean Field3398;
    @NotNull
    private final Module Field3399;
    @NotNull
    private final Class116 Field3400;

    public float Method4058() {
        return this.Field3396;
    }

    public void Method279(float f) {
        this.Field3396 = f;
    }

    public float Method291() {
        return this.Field3397;
    }

    public void Method272(float f) {
        this.Field3397 = f;
    }

    public boolean Method290() {
        return this.Field3398;
    }

    public void Method288(boolean bl) {
        this.Field3398 = bl;
    }

    public float Method4059() {
        return 20.0f;
    }

    public float Method4060() {
        return 100.0f;
    }

    public void Method3565() {
        if (this.Method4061().Method286() || Manager.Field280.getCloseGUI()) {
            return;
        }
        this.Method4062();
    }

    public void Method3566(int n, int n2, int n3) {
        if (!this.Method4061().Method286() && this.Method4063(n, n2)) {
            if (n3 == 0) {
                this.Field3399.Method581();
            } else if (n3 == 2) {
                this.Field3399.Method585(!this.Field3399.Method492());
                ChatFormatting chatFormatting = ChatFormatting.GREEN;
                ChatFormatting chatFormatting2 = ChatFormatting.RED;
                Globals.printChatMessage(this.Field3399.Method491() + " visibility:" + (!this.Field3399.Method492() ? chatFormatting + " ON" : chatFormatting2 + " OFF"));
            }
        }
    }

    public void Method4067(int n, int n2, int n3) {
    }

    public void Method4068(int n, int n2, int n3, long l) {
    }

    public void Method4069(char c, int n) {
    }

    private final void Method4062() {
        Class423.Method2815(this.Method4058(), this.Method291(), this.Method4058() + this.Method4060(), this.Method291() + this.Method4059(), this.Field3399.Method490() ? Class232.Field570.Method720() : Class232.Field570.Method721());
        Class36.Method63(this.Field3399.Method491(), this.Method4058() + (float)3, this.Method291() + this.Method4059() / 3.0f, this.Field3399.Method490() ? Color.WHITE.getRGB() : Class232.Field570.Method722().getRGB());
        if (this.Method290()) {
            float f = this.Method291() + this.Method4059() / (float)2;
            float f2 = this.Method4058() - 13.0f;
            float f3 = f;
            float f4 = this.Method4058();
            float f5 = f + 6.0f;
            float f6 = this.Method4058();
            float f7 = f - 6.0f;
            Class423.Method2828(f2, f3, f4, f5, f6, f7, this.Field3399.Method490() ? Class232.Field570.Method720().getRGB() : Class232.Field570.Method721().getRGB());
        }
    }

    @NotNull
    public final Module Method4071() {
        return this.Field3399;
    }

    @NotNull
    public Class116 Method4061() {
        return this.Field3400;
    }

    public Class101 Method4072() {
        return this.Method4061();
    }

    public Class117(@NotNull Module module, @NotNull Class116 class116) {
        this.Field3399 = module;
        this.Field3400 = class116;
    }

    public void Method4073(int n, int n2) {
        Class632.Method3843(this, n, n2);
    }

    public void Method4074(int n) {
        Class632.Method3848(this, n);
    }

    public boolean Method4063(int n, int n2) {
        return Class632.Method3849(this, n, n2);
    }
}
