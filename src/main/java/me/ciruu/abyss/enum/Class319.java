package me.ciruu.abyss.enums;

/*
 * Exception performing whole class analysis ignored.
 */
static enum Class319 {
    NONE(0.0f, 0.0f),
    ARROW(1.5f, 0.05f),
    POTION(0.5f, 0.05f),
    EXPERIENCE(0.7f, 0.07f),
    FISHING_ROD(1.5f, 0.04f),
    NORMAL(1.5f, 0.03f);

    private final float Field1970;
    private final float Field1971;

    /*
     * WARNING - void declaration
     */
    private Class319() {
        void var4_2;
        void var3_1;
        this.Field1970 = var3_1;
        this.Field1971 = var4_2;
    }

    public float getVelocity() {
        return this.Field1970;
    }

    public float getGravity() {
        return this.Field1971;
    }
}
