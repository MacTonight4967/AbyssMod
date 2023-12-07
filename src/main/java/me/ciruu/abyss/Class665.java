package me.ciruu.abyss;

import java.util.Comparator;
import me.ciruu.abyss.Class36;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class665
implements Comparator {
    Class665() {
    }

    public int compare(String string, String string2) {
        return Class36.Method259(string2) < Class36.Method259(string) ? -1 : (Class36.Method259(string2) == Class36.Method259(string) ? 0 : 1);
    }

    public int compare(Object object, Object object2) {
        return this.compare((String)object, (String)object2);
    }
}
