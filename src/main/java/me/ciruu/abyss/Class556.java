package me.ciruu.abyss;

import java.util.Comparator;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class536;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class556
implements Comparator {
    Class556() {
    }

    public int compare(Class536 class536, Class536 class5362) {
        return Class36.Method259(class5362.getText()) < Class36.Method259(class536.getText()) ? -1 : (Class36.Method259(class5362.getText()) == Class36.Method259(class536.getText()) ? 0 : 1);
    }

    public int compare(Object object, Object object2) {
        return this.compare((Class536)object, (Class536)object2);
    }
}
