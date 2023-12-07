package me.ciruu.abyss;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import me.ciruu.abyss.Class180;
import me.ciruu.abyss.Class5;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.managers.RunnableManager;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.Packet;
import net.minecraft.util.StringUtils;
import sun.misc.Unsafe;

public class Class6
extends Module {
    private final Setting Field1529 = new Setting("Invoke", "", this, false);
    private final Setting Field1530 = new Setting("OnlyUseEntity", "", this, false);
    private final Setting Field1531 = new Setting("PrintMethods", "", this, true);
    private final Setting Field1532 = new Setting("GetDestroyEntities", "", this, true);
    private final Map Field1533 = new LinkedHashMap();
    private long Field1534 = 0L;
    @EventHandler
    private Listener Field1535 = new Listener<EventNetworkPostPacketEvent>(this::Method1947, new Predicate[0]);
    @EventHandler
    private Listener Field1536 = new Listener<EventNetworkPrePacketEvent>(this::Method1948, new Predicate[0]);
    static final Unsafe Field1537 = Class6.Method1957();
    static final boolean Field1538 = true;

    public Class6() {
        super("PacketLogNew", "", Class11.MISC);
        this.Method1949(this.Field1529);
        this.Method1949(this.Field1530);
        this.Method1949(this.Field1531);
        this.Method1949(this.Field1532);
    }

    public void Method1950() {
        super.Method13();
        this.Field1534 = System.currentTimeMillis();
        this.Field1533.clear();
    }

    public void Method1951() {
        super.Method15();
        try {
            this.Method1952();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void Method1953(long l, Packet packet) {
        this.Field1533.put(l, packet);
    }

    private void Method1952() throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, PrivilegedActionException, IllegalStateException {
        RunnableManager.runRunnable(this::Method1954);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void Method1955(String string) {
        string = string + "";
        try {
            Path path = Paths.get("Abyss/PacketLogger/", this.Field1534 + " client.txt");
            try {
                BufferedWriter bufferedWriter;
                block9: {
                    bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                    Throwable throwable = null;
                    try {
                        bufferedWriter.write(string);
                        if (bufferedWriter == null) return;
                        if (throwable == null) break block9;
                    }
                    catch (Throwable throwable2) {
                        throwable = throwable2;
                        throw throwable2;
                    }
                    try {
                        bufferedWriter.close();
                        return;
                    }
                    catch (Throwable throwable3) {
                        throwable.addSuppressed(throwable3);
                    }
                    return;
                }
                bufferedWriter.close();
                return;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static void Method1956(String string, Object ... objectArray) {
        System.out.print(string + ": 0x");
        long l = 0L;
        int n = Field1537.arrayBaseOffset(objectArray.getClass());
        int n2 = Field1537.arrayIndexScale(objectArray.getClass());
        switch (n2) {
            case 4: {
                long l2 = 8L;
                long l3 = ((long)Field1537.getInt((Object)objectArray, n) & 0xFFFFFFFFL) * l2;
                System.out.print(Long.toHexString(l3));
                l = l3;
                for (int i = 1; i < objectArray.length; ++i) {
                    long l4 = ((long)Field1537.getInt((Object)objectArray, n + i * 4) & 0xFFFFFFFFL) * l2;
                    if (l4 > l) {
                        System.out.print(", +" + Long.toHexString(l4 - l));
                    } else {
                        System.out.print(", -" + Long.toHexString(l - l4));
                    }
                    l = l4;
                }
                break;
            }
            case 8: {
                throw new AssertionError((Object)"Not supported");
            }
        }
        System.out.println();
    }

    private static Unsafe Method1957() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);
        }
        catch (Exception exception) {
            throw new AssertionError((Object)exception);
        }
    }

    private void Method1954() {
        Iterator iterator = this.Field1533.keySet().iterator();
        while (iterator.hasNext()) {
            long l = (Long)iterator.next();
            try {
                Packet packet = (Packet)this.Field1533.get(l);
                if (packet.getClass().getSimpleName().startsWith("S") && !packet.getClass().getSimpleName().equals("SPacketDestroyEntities") || ((Boolean)this.Field1530.getValue()).booleanValue() && packet.getClass().getSimpleName().startsWith("C") && !packet.getClass().getSimpleName().equals("CPacketUseEntity") || ((Boolean)this.Field1530.getValue()).booleanValue() && (packet.getClass().getSimpleName().equalsIgnoreCase("Position") || packet.getClass().getSimpleName().equalsIgnoreCase("Rotation") || packet.getClass().getSimpleName().equalsIgnoreCase("PositionRotation"))) continue;
                this.Method1955("[Client]" + packet.getClass().getSimpleName() + " > Time:" + l);
                System.out.println("[Client]" + packet.getClass().getSimpleName() + " > Time:" + l);
                for (Class<?> clazz = packet.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
                    this.Method1955("-----------------------------FIELDS-----------------------------");
                    for (Field field : clazz.getDeclaredFields()) {
                        if (field == null) continue;
                        Class<?> clazz2 = clazz;
                        AccessController.doPrivileged(new Class5(this, field, packet, clazz2));
                    }
                    if (!((Boolean)this.Field1531.getValue()).booleanValue()) continue;
                    this.Method1955("-----------------------------METHODS-----------------------------");
                    for (AccessibleObject accessibleObject : clazz.getDeclaredMethods()) {
                        if (accessibleObject == null) continue;
                        AccessController.doPrivileged(new Class180(this, (Method)accessibleObject, packet));
                        this.Method1955(StringUtils.stripControlCodes((String)("" + ((Method)accessibleObject).getName() + "" + ((Method)accessibleObject).toGenericString())));
                        System.out.println(StringUtils.stripControlCodes((String)("" + ((Method)accessibleObject).getName() + "" + ((Method)accessibleObject).toGenericString())));
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.Method1955("");
        }
    }

    private void Method1948(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        if (eventNetworkPrePacketEvent.Method1822() != Class53.PRE || !((Boolean)this.Field1532.getValue()).booleanValue()) {
            return;
        }
        this.Method1953(ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now()), eventNetworkPrePacketEvent.Method49());
    }

    private void Method1947(EventNetworkPostPacketEvent eventNetworkPostPacketEvent) {
        if (eventNetworkPostPacketEvent.Method1536() != Class53.PRE) {
            return;
        }
        this.Method1953(ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now()), eventNetworkPostPacketEvent.Method16());
    }

    static void Method4(Class6 class6, String string) {
        class6.Method1955(string);
    }

    static Setting Method496(Class6 class6) {
        return class6.Field1529;
    }
}
