package me.ciruu.abyss;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import me.ciruu.abyss.Class207;
import me.ciruu.abyss.Class219;
import me.ciruu.abyss.Class350;
import me.ciruu.abyss.Class39;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.modules.client.WebChat;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class533
extends Lambda
implements Function1 {
    final WebChat Field2001;

    public Object invoke(Object object) {
        this.invoke((Class350)object);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Class350 class350) {
        if (!(Globals.mc.currentScreen instanceof GuiChat) && !(Globals.mc.currentScreen instanceof Class219) && ((Class207)WebChat.Method2434(this.Field2001).getValue()).Method592() == class350.Method1535()) {
            Globals.mc.displayGuiScreen((GuiScreen)new Class39());
        }
    }

    Class533(WebChat webChat) {
        this.Field2001 = webChat;
        super(1);
    }
}
