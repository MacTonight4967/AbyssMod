package me.ciruu.abyss.enums;

/*
 * Exception performing whole class analysis ignored.
 */
public static enum Class11 {
    COMBAT("Combat", -65536),
    EXPLOIT("Exploit", -65536),
    MISC("Misc", -65536),
    MOVEMENT("Movement", -65536),
    RENDER("Render", -65536),
    HUD("Hud", -65536),
    CLIENT("Client", -65536);

    private final String Field3224;
    private final int Field3225;

    /*
     * WARNING - void declaration
     */
    private Class11() {
        void var4_2;
        void var3_1;
        this.Field3224 = var3_1;
        this.Field3225 = var4_2;
    }

    public int getColour() {
        return this.Field3225;
    }

    public String toString() {
        return this.Field3224;
    }
}
