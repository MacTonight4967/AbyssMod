package me.ciruu.abyss;

import java.util.UUID;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.MinecraftEvent;
import net.minecraft.entity.player.EntityPlayer;

public class Class179
extends MinecraftEvent {
    private final UUID Field399;
    private final EntityPlayer Field400;
    private final String Field401;

    public Class179(Class53 class53, UUID uUID, String string) {
        super(class53);
        this.Field399 = uUID;
        this.Field401 = string;
        this.Field400 = null;
    }

    public Class179(Class53 class53, EntityPlayer entityPlayer, UUID uUID, String string) {
        super(class53);
        this.Field400 = entityPlayer;
        this.Field399 = uUID;
        this.Field401 = string;
    }

    public String Method493() {
        return this.Field401;
    }

    public UUID Method494() {
        return this.Field399;
    }

    public EntityPlayer Method495() {
        return this.Field400;
    }
}
