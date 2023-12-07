package me.ciruu.abyss;

import java.util.Iterator;
import me.ciruu.abyss.Class141;
import me.ciruu.abyss.Class213;
import me.ciruu.abyss.Class231;

public interface Class142
extends Iterator {
    public static final Class142 Field792 = new Class213();

    public static Class231 builder() {
        return new Class231();
    }

    public static Class142 singleton(Object object) {
        return new Class141(object);
    }

    public static Class142 empty() {
        return Field792;
    }

    public Class142 then(Object var1);

    public Class142 thenLast(Object var1);

    default public boolean isEmpty() {
        return !this.hasNext();
    }
}
