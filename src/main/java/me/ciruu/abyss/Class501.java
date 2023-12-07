package me.ciruu.abyss;

public class Class501 {
    private final long[] Field3062;
    private int Field3063 = 0;

    public Class501(int n) {
        this.Field3062 = new long[n];
    }

    public long[] Method3723() {
        return this.Field3062;
    }

    public void Method2192(long l) {
        this.Field3063 = (this.Field3063 + 1) % this.Field3062.length;
        this.Field3062[this.Field3063] = l;
    }

    public int Method2194(long l) {
        for (int i = 0; i < this.Field3062.length; ++i) {
            if (this.Field3062[this.Field3063 < i ? this.Field3062.length - i + this.Field3063 : this.Field3063 - i] >= l) continue;
            return i;
        }
        return this.Field3062.length;
    }
}
