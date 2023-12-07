package me.ciruu.abyss.enums;

import java.awt.Color;
import me.ciruu.abyss.Class234;
import net.minecraft.util.ResourceLocation;

/*
 * Exception performing whole class analysis ignored.
 */
public static enum Class128 {
    Info(new Color(68, 248, 68, 255), Class234.Field1187),
    Warning(new Color(255, 233, 76, 255), Class234.Field1188),
    Error(new Color(255, 45, 45, 255), Class234.Field1189);

    private final Color Field1184;
    private final ResourceLocation Field1185;

    /*
     * WARNING - void declaration
     */
    private Class128() {
        void var4_2;
        void var3_1;
        this.Field1184 = var3_1;
        this.Field1185 = var4_2;
    }

    public Color getColor() {
        return this.Field1184;
    }

    public ResourceLocation getImage() {
        return this.Field1185;
    }
}
