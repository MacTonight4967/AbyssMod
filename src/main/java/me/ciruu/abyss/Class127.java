package me.ciruu.abyss;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ciruu.abyss.Class129;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class128;
import me.ciruu.abyss.modules.hud.Notifications;

public class Class127 {
    private final List Field302 = new CopyOnWriteArrayList();

    public void Method342(Class128 class128, String string) {
        if (Manager.moduleManager.getModuleByClass(Notifications.class) != null && Manager.moduleManager.isModuleEnabled(Notifications.class)) {
            this.Method343(new Class129(class128, string));
        }
    }

    public void Method343(Class129 class129) {
        this.Field302.add(class129);
    }

    public void Method344(float f, float f2, int n, float f3, int n2, float f4) {
        if (this.Field302.isEmpty()) {
            return;
        }
        int n3 = 0;
        for (Class129 class129 : this.Field302) {
            if (class129.Method345(f3 * 1000.0f)) {
                this.Field302.remove(class129);
            }
            if (n3 <= n) {
                class129.Method346(f, f2, f3 * 1000.0f, f4);
            } else {
                class129.Method347();
            }
            f2 -= (float)n2;
            ++n3;
        }
    }
}
