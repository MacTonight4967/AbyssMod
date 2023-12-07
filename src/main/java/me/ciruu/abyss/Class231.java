package me.ciruu.abyss;

import com.google.common.collect.Queues;
import java.util.Collection;
import java.util.Queue;
import me.ciruu.abyss.Class142;
import me.ciruu.abyss.Class212;

/*
 * Exception performing whole class analysis ignored.
 */
public static class Class231 {
    private final Queue Field561 = Queues.newArrayDeque();

    public Class231 Method714(Object object) {
        this.Field561.add(object);
        return this;
    }

    public Class231 Method715(Collection collection) {
        this.Field561.addAll(collection);
        return this;
    }

    public Class231 Method716(Class142 class142) {
        while (class142.hasNext()) {
            this.Field561.add(class142.next());
        }
        return this;
    }

    public Class142 Method717() {
        return new Class212(this.Field561, null);
    }
}
