package me.ciruu.abyss;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import me.ciruu.abyss.Class142;
import me.ciruu.abyss.Class213;

/*
 * Exception performing whole class analysis ignored.
 */
public static class Class212
implements Class142 {
    private final List Field487 = Lists.newArrayList();

    private Class212() {
    }

    private Class212(Collection collection) {
        this.Field487.addAll(collection);
    }

    @Override
    public Class142 then(Object object) {
        this.Field487.add(0, object);
        return this;
    }

    @Override
    public Class142 thenLast(Object object) {
        this.Field487.add(object);
        return null;
    }

    @Override
    public boolean hasNext() {
        return !this.Field487.isEmpty();
    }

    public Object next() {
        return this.Field487.remove(0);
    }

    Class212(Collection collection, Class213 class213) {
        this(collection);
    }
}
