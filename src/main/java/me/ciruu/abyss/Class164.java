package me.ciruu.abyss;

import java.util.Objects;

/*
 * Exception performing whole class analysis ignored.
 */
public static class Class164
implements Comparable {
    private final String Field1499;
    private final long Field1500;

    public Class164(String string, long l) {
        this.Field1499 = string;
        this.Field1500 = l;
    }

    public Class164(String string) {
        this(string, 0L);
    }

    public String getName() {
        return this.Field1499;
    }

    public long getTimeChanged() {
        return this.Field1500;
    }

    public int compareTo(Class164 class164) {
        return Long.compare(class164.Field1500, this.Field1500);
    }

    public boolean equals(Object object) {
        return object instanceof Class164 && this.Field1499.equalsIgnoreCase(((Class164)object).getName()) && this.Field1500 == ((Class164)object).Field1500;
    }

    public int hashCode() {
        return Objects.hash(this.Field1499, this.Field1500);
    }

    public int compareTo(Object object) {
        return this.compareTo((Class164)object);
    }

    static String Method452(Class164 class164) {
        return class164.Field1499;
    }
}
