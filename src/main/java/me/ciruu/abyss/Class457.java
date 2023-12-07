package me.ciruu.abyss;

import me.ciruu.abyss.Class99;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;

public class Class457
extends Class99 {
    public Class457(String string) {
        super(string);
    }

    public void Method1987(String[] stringArray) {
        if (stringArray[0].equalsIgnoreCase("add")) {
            this.Method1988(false);
        } else if (stringArray[0].equalsIgnoreCase("delete")) {
            this.Method1988(true);
        }
    }

    public void Method1988(boolean bl) {
        RayTraceResult rayTraceResult = Globals.mc.objectMouseOver;
        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.ENTITY) {
            return;
        }
        Entity entity = rayTraceResult.entityHit;
        if (!(entity instanceof EntityPlayer)) {
            return;
        }
        if (bl) {
            if (Manager.Field223.Method711(entity)) {
                Manager.Field223.Method1542(entity.getName());
                Globals.printChatMessage(String.format("%s has been removed.", entity.getName()));
            }
        } else {
            Manager.Field223.Method1540(entity.getName());
            Globals.printChatMessage(String.format("%s has been added.", entity.getName()));
        }
    }

    public boolean Method1989(String[] stringArray) {
        return stringArray[0].equalsIgnoreCase("add") || stringArray[0].equalsIgnoreCase("delete") && stringArray[1].equalsIgnoreCase("friend");
    }
}
