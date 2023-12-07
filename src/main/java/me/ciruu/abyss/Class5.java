package me.ciruu.abyss;

import java.lang.reflect.Field;
import java.lang.reflect.ReflectPermission;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import me.ciruu.abyss.Class6;
import net.minecraft.network.Packet;
import net.minecraft.util.StringUtils;

/*
 * Exception performing whole class analysis ignored.
 */
class Class5
implements PrivilegedExceptionAction {
    final Field Field6;
    final Packet Field7;
    final Class Field8;
    final Class6 Field9;

    Class5(Class6 class6, Field field, Packet packet, Class clazz) {
        this.Field9 = class6;
        this.Field6 = field;
        this.Field7 = packet;
        this.Field8 = clazz;
    }

    public Object run() throws Exception {
        Object[] objectArray;
        try {
            objectArray = new ReflectPermission("suppressAccessChecks");
            objectArray.checkGuard(null);
            System.out.println("Permission granted");
        }
        catch (SecurityException securityException) {
            System.out.println("Permission denied");
        }
        if (this.Field6.getType().getSimpleName().equals(this.Field7.getClass().getSimpleName())) {
            Class6.Method4(this.Field9, StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName())));
            System.out.println(StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName())));
            return null;
        }
        if (this.Field6.getType() == this.Field8) {
            Class6.Method4(this.Field9, StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName())));
            System.out.println(StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName())));
            return null;
        }
        if (!this.Field6.isAccessible()) {
            this.Field6.setAccessible(true);
        }
        if (this.Field6.get(this.Field7) instanceof String[]) {
            objectArray = (String[])this.Field6.get(this.Field7);
            Class6.Method4(this.Field9, StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName() + " =" + Arrays.toString(objectArray))));
            System.out.println(StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName() + " =" + Arrays.toString(objectArray))));
            return null;
        }
        if (this.Field6.get(this.Field7) instanceof int[]) {
            objectArray = (int[])this.Field6.get(this.Field7);
            Class6.Method4(this.Field9, StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName() + " =" + Arrays.toString((int[])objectArray))));
            System.out.println(StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName() + " =" + Arrays.toString((int[])objectArray))));
            return null;
        }
        Class6.Method4(this.Field9, StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName() + " =" + this.Field6.get(this.Field7))));
        System.out.println(StringUtils.stripControlCodes((String)("" + this.Field6.getType().getSimpleName() + "" + this.Field6.getName() + " =" + this.Field6.get(this.Field7))));
        return null;
    }
}
