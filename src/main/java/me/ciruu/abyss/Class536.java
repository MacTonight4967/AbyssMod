package me.ciruu.abyss;

import me.ciruu.abyss.Class36;
import me.ciruu.abyss.modules.Module;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
private static class Class536
implements Comparable {
    private Module Field2011;
    private String Field2012;

    public Class536(Module module, String string) {
        this.Field2011 = module;
        this.Field2012 = string;
    }

    public Module getFeature() {
        return this.Field2011;
    }

    public String getText() {
        return this.Field2012;
    }

    public int compareTo(@NotNull Class536 class536) {
        return Integer.compare(Class36.Method259(class536.getText()), Class36.Method259(this.getText()));
    }

    public int compareTo(@NotNull Object object) {
        return this.compareTo((Class536)object);
    }
}
