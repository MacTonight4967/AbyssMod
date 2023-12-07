package me.ciruu.abyss;

public class Class22 {
    private long Field1720 = -1L;
    private long Field1721;

    public boolean Method2123(double d) {
        return this.Method2124(System.nanoTime() - this.Field1720) >= (long)(d * 1000.0);
    }

    public boolean Method2125(double d) {
        return this.Method2124(System.nanoTime() - this.Field1720) >= (long)(d * 1000.0 * 60.0);
    }

    public boolean Method2126(double d) {
        return this.Method2124(System.nanoTime() - this.Field1720) >= (long)(d * 10.0);
    }

    public boolean Method2127(double d) {
        return this.Method2124(System.nanoTime() - this.Field1720) >= (long)(d * 100.0);
    }

    public boolean Method50(long l) {
        return this.Method2124(System.nanoTime() - this.Field1720) >= l;
    }

    public boolean Method2128(long l) {
        return System.nanoTime() - this.Field1720 >= l;
    }

    public void Method2129(long l) {
        this.Field1720 = System.nanoTime() - l * 1000000L;
    }

    public long Method2130() {
        return this.Method2124(System.nanoTime() - this.Field1720);
    }

    public final boolean Method2131(long l) {
        return System.currentTimeMillis() - this.Field1721 >= l;
    }

    public void Method47() {
        this.Field1720 = System.nanoTime();
    }

    public long Method2124(long l) {
        return l / 1000000L;
    }

    public long Method2132() {
        return this.Field1720;
    }
}
