package me.ciruu.abyss;

import java.awt.image.BufferedImage;

/*
 * Exception performing whole class analysis ignored.
 */
private static class Class250 {
    private final int Field667;
    private final BufferedImage Field668;
    private final String Field669;
    private final int Field670;
    private final int Field671;

    public Class250(BufferedImage bufferedImage, int n, String string, int n2, int n3) {
        this.Field668 = bufferedImage;
        this.Field667 = n;
        this.Field669 = string;
        this.Field670 = n2;
        this.Field671 = n3;
    }

    public Class250(BufferedImage bufferedImage) {
        this.Field668 = bufferedImage;
        this.Field667 = -1;
        this.Field669 = null;
        this.Field670 = -1;
        this.Field671 = -1;
    }

    public BufferedImage Method954() {
        return this.Field668;
    }

    public int Method955() {
        return this.Field667;
    }

    public String Method956() {
        return this.Field669;
    }

    public int Method957() {
        return this.Field670;
    }

    public int Method958() {
        return this.Field671;
    }

    static BufferedImage Method959(Class250 class250) {
        return class250.Field668;
    }

    static int Method960(Class250 class250) {
        return class250.Field667;
    }
}
