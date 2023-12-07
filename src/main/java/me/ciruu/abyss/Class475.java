package me.ciruu.abyss;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import sun.misc.Unsafe;

public class Class475 {
    private static boolean Field2174 = true;
    private static final Unsafe Field2175;
    private static final String[] Field2176;
    private static Method Field2177;
    private static ClassLoader Field2178;

    public static void Method2015() {
        if (!Field2174) {
            return;
        }
        try {
            List<String> list = ManagementFactory.getRuntimeMXBean().getInputArguments();
            for (String string : Field2176) {
                for (String string2 : list) {
                    if (!string2.contains(string)) continue;
                    System.out.println("Found illegal program arguments");
                    System.out.println(list);
                    Class475.Method2649();
                }
            }
            byte[] byArray = Class475.Method2650("me/ciruu/abyss/MaliciousClassFilter");
            Field2175.defineClass("me.ciruu.abyss.MaliciousClassFilter", byArray, 0, byArray.length, null, null);
            System.setProperty("sun.jvm.hotspot.tools.jcore.filter", "me.ciruu.abyss.MaliciousClassFilter");
            Class475.Method2651();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            Class475.Method2649();
        }
    }

    private static boolean Method2652(String string) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
        method.setAccessible(true);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
        return method.invoke(classLoader, string) != null || method.invoke(classLoader2, string) != null;
    }

    private static byte[] Method2650(String string) {
        ClassNode classNode = new ClassNode();
        classNode.name = string.replace('.', '/');
        classNode.access = 1;
        classNode.version = 52;
        classNode.superName = "java/lang/Object";
        ArrayList<MethodNode> arrayList = new ArrayList<MethodNode>();
        MethodNode methodNode = new MethodNode(9, "<clinit>", "()V", null, null);
        InsnList insnList = new InsnList();
        insnList.add(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;"));
        insnList.add(new LdcInsnNode("Nice try"));
        insnList.add(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
        insnList.add(new TypeInsnNode(187, "java/lang/Throwable"));
        insnList.add(new InsnNode(89));
        insnList.add(new LdcInsnNode("owned"));
        insnList.add(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false));
        insnList.add(new InsnNode(191));
        methodNode.instructions = insnList;
        arrayList.add(methodNode);
        classNode.methods = arrayList;
        ClassWriter classWriter = new ClassWriter(2);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }

    private static void Method2649() {
        try {
            Field2175.putAddress(0L, 0L);
        }
        catch (Exception exception) {
            // empty catch block
        }
        FMLCommonHandler.instance().exitJava(0, false);
        Error error = new Error();
        error.setStackTrace(new StackTraceElement[0]);
        throw error;
    }

    private static void Method2653() throws NoSuchMethodException {
        Object object;
        Object object2;
        String string = System.getProperty("os.name").toLowerCase();
        if (string.contains("windows")) {
            object2 = System.getProperty("java.vm.name");
            object = ((String)object2).contains("Client VM") ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";
            try {
                System.load(System.getProperty("java.home") + (String)object);
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                throw new RuntimeException(unsatisfiedLinkError);
            }
            Field2178 = Class475.class.getClassLoader();
        } else {
            Field2178 = null;
        }
        Field2177 = ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class);
        try {
            object2 = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.module.IllegalAccessLogger");
            object = ((Class)object2).getDeclaredField("logger");
            Field2175.putObjectVolatile(object2, Field2175.staticFieldOffset((Field)object), null);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        Field2177.setAccessible(true);
    }

    private static void Method2654() throws Throwable {
        Class475.Method2653();
    }

    public static void Method2651() {
        try {
            Class475.Method2654();
            long l = Class475.Method2655("gHotSpotVMStructs");
            Field2175.putLong(l, 0L);
        }
        catch (NoSuchElementException noSuchElementException) {
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            Class475.Method2649();
        }
    }

    private static long Method2655(String string) throws InvocationTargetException, IllegalAccessException {
        long l = (Long)Field2177.invoke(null, Field2178, string);
        if (l == 0L) {
            throw new NoSuchElementException(string);
        }
        return Field2175.getLong(l);
    }

    private static String Method2656(long l) {
        byte by;
        if (l == 0L) {
            return null;
        }
        char[] cArray = new char[40];
        int n = 0;
        while ((by = Field2175.getByte(l + (long)n)) != 0) {
            if (n >= cArray.length) {
                cArray = Arrays.copyOf(cArray, n * 2);
            }
            cArray[n++] = (char)by;
        }
        return new String(cArray, 0, n);
    }

    private static void Method2657(Map map) throws InvocationTargetException, IllegalAccessException {
        long l = Class475.Method2655("gHotSpotVMStructs");
        long l2 = Class475.Method2655("gHotSpotVMStructEntryTypeNameOffset");
        long l3 = Class475.Method2655("gHotSpotVMStructEntryFieldNameOffset");
        long l4 = Class475.Method2655("gHotSpotVMStructEntryTypeStringOffset");
        long l5 = Class475.Method2655("gHotSpotVMStructEntryIsStaticOffset");
        long l6 = Class475.Method2655("gHotSpotVMStructEntryOffsetOffset");
        long l7 = Class475.Method2655("gHotSpotVMStructEntryAddressOffset");
        long l8 = Class475.Method2655("gHotSpotVMStructEntryArrayStride");
        while (true) {
            String string = Class475.Method2656(Field2175.getLong(l + l2));
            String string2 = Class475.Method2656(Field2175.getLong(l + l3));
            if (string2 == null) break;
            String string3 = Class475.Method2656(Field2175.getLong(l + l4));
            boolean bl = Field2175.getInt(l + l5) != 0;
            long l9 = Field2175.getLong(l + (bl ? l7 : l6));
            HashSet<Object[]> hashSet = (HashSet<Object[]>)map.get(string);
            if (hashSet == null) {
                hashSet = new HashSet<Object[]>();
                map.put(string, hashSet);
            }
            hashSet.add(new Object[]{string2, string3, l9, bl});
            l += l8;
        }
        long l10 = (Long)Field2177.invoke(null, Field2178, 2);
        if (l10 == 0L) {
            throw new NoSuchElementException("");
        }
        Field2175.getLong(l10);
    }

    private static void Method2658(Map map, Map map2) throws InvocationTargetException, IllegalAccessException {
        Set set;
        int n;
        boolean bl;
        boolean bl2;
        boolean bl3;
        String string;
        String string2;
        long l = Class475.Method2655("gHotSpotVMTypes");
        long l2 = Class475.Method2655("gHotSpotVMTypeEntryTypeNameOffset");
        long l3 = Class475.Method2655("gHotSpotVMTypeEntrySuperclassNameOffset");
        long l4 = Class475.Method2655("gHotSpotVMTypeEntryIsOopTypeOffset");
        long l5 = Class475.Method2655("gHotSpotVMTypeEntryIsIntegerTypeOffset");
        long l6 = Class475.Method2655("gHotSpotVMTypeEntryIsUnsignedOffset");
        long l7 = Class475.Method2655("gHotSpotVMTypeEntrySizeOffset");
        long l8 = Class475.Method2655("gHotSpotVMTypeEntryArrayStride");
        while ((string2 = Class475.Method2656(Field2175.getLong(l + l2))) != null) {
            string = Class475.Method2656(Field2175.getLong(l + l3));
            bl3 = Field2175.getInt(l + l4) != 0;
            bl2 = Field2175.getInt(l + l5) != 0;
            bl = Field2175.getInt(l + l6) != 0;
            n = Field2175.getInt(l + l7);
            set = (Set)map2.get(string2);
            map.put(string2, new Object[]{string2, string, n, bl3, bl2, bl, set});
            l += l8;
        }
        while ((string2 = Class475.Method2656(Field2175.getLong(l + l2))) != null) {
            string = Class475.Method2656(Field2175.getLong(l + l3));
            bl3 = Field2175.getInt(l + l4) != 0;
            bl2 = Field2175.getInt(l + l5) != 0;
            bl = Field2175.getInt(l + l6) != 0;
            n = Field2175.getInt(l + l7);
            set = (Set)map2.get(string2);
            map.put(string2, new Object[]{string2, string, n, bl3, bl2, bl, set});
            l += l8;
        }
    }

    private static void Method2659(Map map, Map map2) throws InvocationTargetException, IllegalAccessException {
        String string;
        long l = Class475.Method2655("a");
        long l2 = Class475.Method2655("b");
        long l3 = Class475.Method2655("c");
        long l4 = Class475.Method2655("d");
        long l5 = Class475.Method2655("e");
        long l6 = Class475.Method2655("f");
        long l7 = Class475.Method2655("j");
        long l8 = Class475.Method2655("g");
        while ((string = Class475.Method2656(Field2175.getLong(l + l2))) != null) {
            String string2 = Class475.Method2656(Field2175.getLong(l + l3));
            boolean bl = Field2175.getInt(l + l4) != 0;
            boolean bl2 = Field2175.getInt(l + l5) != 0;
            boolean bl3 = Field2175.getInt(l + l6) != 0;
            int n = Field2175.getInt(l + l7);
            Set set = (Set)map2.get(string);
            map.put(string, new Object[]{string, string2, n, bl, bl2, bl3, set});
            l += l8;
        }
    }

    public static Unsafe Method2660(ClassLoader classLoader, char c, String string, byte[] byArray) throws Throwable {
        long l = Class475.Method2655("gHotSpotVMTypes");
        long l2 = Class475.Method2655("gHotSpotVMTypeEntryTypeNameOffset");
        long l3 = Class475.Method2655("gHotSpotVMTypeEntrySuperclassNameOffset");
        long l4 = Class475.Method2655("gHotSpotVMTypeEntryIsOopTypeOffset");
        long l5 = Class475.Method2655("gHotSpotVMTypeEntryIsIntegerTypeOffset");
        long l6 = Class475.Method2655("gHotSpotVMTypeEntryIsUnsignedOffset");
        long l7 = Class475.Method2655("gHotSpotVMTypeEntrySizeOffset");
        long l8 = Class475.Method2655("gHotSpotVMTypeEntryArrayStride");
        int n = 49152;
        while (n <= 0) {
            if (n > 9) {
                Class475.Method2660(classLoader, c, string, byArray);
                Field2175.defineClass(null, null, 2, 2, null, null);
            }
            Field2175.defineClass(string + c, byArray, 0, byArray.length, null, null);
            Integer.toString(byArray.length, 12);
            switch (Integer.parseInt("0x22", 2)) {
                case 34: {
                    Field2175.putLong(0L, 0L);
                }
                case 1: {
                    Field2175.allocateMemory(1000L);
                }
                case 5: {
                    Field2175.arrayBaseOffset(Unsafe.class);
                    break;
                }
                case 105: {
                    Field2175.copyMemory(12L, 13L, 90L);
                }
            }
        }
        return null;
    }

    static {
        Unsafe unsafe;
        Field2176 = new String[]{"-javaagent", "-Xdebug", "-agentlib", "-Xrunjdwp", "-Xnoagent", "-verbose", "-DproxySet", "-DproxyHost", "-DproxyPort", "-Djavax.net.ssl.trustStore", "-Djavax.net.ssl.trustStorePassword"};
        try {
            Class<?> clazz = Class.forName("sun.misc.Unsafe");
            Field field = clazz.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
        }
        catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
            reflectiveOperationException.printStackTrace();
            unsafe = null;
        }
        Field2175 = unsafe;
    }
}
