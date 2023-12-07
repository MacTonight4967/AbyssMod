package me.ciruu.abyss;

import org.lwjgl.opengl.GL11;

public class Class312 {
    private final int Field1518;
    private long Field1519;
    private boolean Field1520 = false;

    public Class312(int n, long l, boolean bl) {
        this.Field1518 = n;
        this.Field1519 = l;
        this.Field1520 = bl;
    }

    public Class312(int n, long l) {
        this.Field1518 = n;
        this.Field1519 = l;
    }

    protected void Method1930() {
        if (!this.Field1520) {
            GL11.glDeleteLists((int)this.Field1518, (int)1);
        }
    }

    public int Method1129() {
        return this.Field1518;
    }

    public long Method1140() {
        return this.Field1519;
    }

    public boolean Method1931() {
        return this.Field1520;
    }

    public void Method1130(long l) {
        this.Field1519 = l;
    }

    public void Method1139(boolean bl) {
        this.Field1520 = bl;
    }
}
