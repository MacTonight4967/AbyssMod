package me.ciruu.abyss;

import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.security.PrivilegedExceptionAction;
import me.ciruu.abyss.Class6;
import net.minecraft.network.Packet;

/*
 * Exception performing whole class analysis ignored.
 */
class Class180
implements PrivilegedExceptionAction {
    final Method Field402;
    final Packet Field403;
    final Class6 Field404;

    Class180(Class6 class6, Method method, Packet packet) {
        this.Field404 = class6;
        this.Field402 = method;
        this.Field403 = packet;
    }

    public Object run() throws Exception {
        try {
            ReflectPermission reflectPermission = new ReflectPermission("suppressAccessChecks");
            reflectPermission.checkGuard(null);
            System.out.println("Permission granted");
        }
        catch (SecurityException securityException) {
            System.out.println("Permission denied");
        }
        try {
            if (this.Field402.getName().equals("a") && this.Field402.getReturnType() == String.class) {
                System.out.println(this.Field402.getName() + " value =" + this.Field402.getDefaultValue());
                if (((Boolean)Class6.Method496(this.Field404).getValue()).booleanValue()) {
                    if (!this.Field402.isAccessible()) {
                        this.Field402.setAccessible(true);
                    }
                    System.out.println(this.Field402.invoke(this.Field403, 0, 0, 0));
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
