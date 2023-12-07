package me.ciruu.abyss;

import me.ciruu.abyss.Class142;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class141
implements Class142 {
    Object Field328;
    final Object Field329;

    Class141(Object object) {
        this.Field329 = object;
        this.Field328 = this.Field329;
    }

    @Override
    public Class142 then(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class142 thenLast(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return this.Field328 != null;
    }

    public Object next() {
        Object object = this.Field328;
        this.Field328 = null;
        return object;
    }
}
