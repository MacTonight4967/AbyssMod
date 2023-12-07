package me.ciruu.abyss;

import java.awt.Color;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ciruu.abyss.Class137;
import me.ciruu.abyss.Class140;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class74;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Class224 {
    private final GuiTextField Field2224;
    private boolean Field2225;
    private boolean Field2226;
    @Nullable
    private Function1 Field2227;
    @Nullable
    private Function1 Field2228;
    @Nullable
    private Function1 Field2229;
    @NotNull
    private final Class137 Field2230;

    @NotNull
    public final String Method700() {
        return this.Field2224.text;
    }

    public final void Method1716(@NotNull String string) {
        this.Field2224.text = string;
    }

    public final int Method2829() {
        return this.Field2224.maxStringLength;
    }

    public final void Method1741(int n) {
        this.Field2224.maxStringLength = n;
    }

    public final boolean Method2830() {
        return this.Field2224.isFocused;
    }

    public final void Method2831(boolean bl) {
        this.Field2224.isFocused = bl;
    }

    public final boolean Method2832() {
        return this.Field2225;
    }

    public final void Method1687(boolean bl) {
        this.Field2225 = bl;
    }

    public final boolean Method2833() {
        return this.Field2226;
    }

    public final void Method2834(boolean bl) {
        this.Field2226 = bl;
    }

    @Nullable
    public final Function1 Method2835() {
        return this.Field2227;
    }

    public final void Method2836(@Nullable Function1 function1) {
        this.Field2227 = function1;
    }

    @Nullable
    public final Function1 Method2837() {
        return this.Field2228;
    }

    public final void Method1739(@Nullable Function1 function1) {
        this.Field2228 = function1;
    }

    @Nullable
    public final Function1 Method2838() {
        return this.Field2229;
    }

    public final void Method1740(@Nullable Function1 function1) {
        this.Field2229 = function1;
    }

    public final void Method1689() {
        if (!this.Field2225) {
            return;
        }
        this.Field2224.x = this.Field2230.Method1677();
        this.Field2224.y = this.Field2230.Method1678();
        this.Field2224.width = this.Field2230.Method1679() - 8;
        this.Field2224.height = this.Field2230.Method1676();
        this.Field2224.isEnabled = this.Field2226;
        this.Field2224.enableBackgroundDrawing = false;
        int n = this.Method2830() ? Color.GRAY.brighter().getRGB() : Color.GRAY.getRGB();
        Class140.Method608(this.Field2230.Method1677() - 1, this.Field2230.Method1678() - 1, this.Field2230.Method1679() + 2, this.Field2230.Method1676() + 2, n);
        Class140.Method608(this.Field2230.Method1677(), this.Field2230.Method1678(), this.Field2230.Method1679(), this.Field2230.Method1676(), Class74.Field172.Method165().getRGB());
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)1.0f, (float)2.0f, (float)0.0f);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.Field2224.drawTextBox();
        GlStateManager.popMatrix();
    }

    public final void Method1726(char c, int n) {
        if (!this.Field2225) {
            return;
        }
        if (this.Field2226 || n == 203 || n == 205 || n == 199 || n == 207) {
            String string = this.Method700();
            this.Field2224.textboxKeyTyped(this.Field2226 ? c : (char)'\u0000', n);
            if (Intrinsics.areEqual(this.Method700(), string) ^ true) {
                Function1 function1 = this.Field2227;
                if (function1 != null) {
                    Unit cfr_ignored_0 = (Unit)function1.invoke(this);
                }
            }
            if (n == 28 && this.Method2830()) {
                Function1 function1 = this.Field2229;
                if (function1 != null) {
                    Unit cfr_ignored_1 = (Unit)function1.invoke(this);
                }
                if (this.Field2224.isFocused) {
                    this.Method2831(false);
                    this.Method2849();
                }
            }
        }
    }

    public final void Method1732(int n, int n2, int n3) {
        boolean bl = this.Field2224.isFocused;
        if (this.Field2225 && this.Field2226) {
            this.Field2224.mouseClicked(n, n2, n3);
        } else {
            this.Field2224.isFocused = false;
        }
        if (this.Field2224.isFocused != bl) {
            this.Method2849();
        }
    }

    private final void Method2849() {
        block1: {
            if (!this.Method2830() && this.Field2224.selectionEnd != this.Field2224.cursorPosition) {
                this.Field2224.selectionEnd = this.Field2224.cursorPosition;
            }
            Function1 function1 = this.Field2228;
            if (function1 == null) break block1;
            Unit cfr_ignored_0 = (Unit)function1.invoke(this);
        }
    }

    @NotNull
    public final Class137 Method1688() {
        return this.Field2230;
    }

    public Class224(@NotNull Class137 class137) {
        GuiTextField guiTextField;
        this.Field2230 = class137;
        GuiTextField guiTextField2 = new GuiTextField(0, Class36.Method551(), 0, 0, 0, 0);
        Class224 class224 = this;
        boolean bl = false;
        boolean bl2 = false;
        GuiTextField guiTextField3 = guiTextField2;
        boolean bl3 = false;
        guiTextField3.setMaxStringLength(10000);
        class224.Field2224 = guiTextField = guiTextField2;
        this.Field2225 = true;
        this.Field2226 = true;
    }

    public Class224(Class137 class137, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            class137 = new Class137(0, 0, 0, 0, 15, null);
        }
        this(class137);
    }

    public Class224() {
        this(null, 1, null);
    }
}
