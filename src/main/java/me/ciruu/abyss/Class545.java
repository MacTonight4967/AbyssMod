package me.ciruu.abyss;

import java.util.UUID;
import net.minecraft.entity.player.EntityPlayer;

/*
 * Exception performing whole class analysis ignored.
 */
private static class Class545 {
    private final String Field3257;
    private final UUID Field3258;
    private final EntityPlayer Field3259;
    private final double Field3260;
    private final double Field3261;
    private final double Field3262;

    public Class545(String string, UUID uUID, EntityPlayer entityPlayer) {
        this.Field3257 = string;
        this.Field3258 = uUID;
        this.Field3259 = entityPlayer;
        this.Field3260 = entityPlayer.posX;
        this.Field3261 = entityPlayer.posY;
        this.Field3262 = entityPlayer.posZ;
    }

    public String Method2524() {
        return this.Field3257;
    }

    public UUID Method3933() {
        return this.Field3258;
    }

    public EntityPlayer Method2526() {
        return this.Field3259;
    }

    public double Method2528() {
        return this.Field3260;
    }

    public double Method2529() {
        return this.Field3261;
    }

    public double Method2530() {
        return this.Field3262;
    }
}
