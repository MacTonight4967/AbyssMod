package me.ciruu.abyss;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import me.ciruu.abyss.modules.Module;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class Class220
implements Comparator {
    public final int compare(Object object, Object object2) {
        boolean bl = false;
        Module module = (Module)object;
        boolean bl2 = false;
        Comparable comparable = (Comparable)((Object)module.Method491());
        module = (Module)object2;
        Comparable comparable2 = comparable;
        bl2 = false;
        String string = module.Method491();
        return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)string));
    }
}
