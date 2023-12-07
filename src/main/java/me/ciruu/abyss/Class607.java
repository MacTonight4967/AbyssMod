package me.ciruu.abyss;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.ProtectionDomain;

public class Class607
implements ClassFileTransformer {
    private static Instrumentation Field2561;
    private byte[] Field2562;

    public static synchronized void agentmain(String string, Instrumentation instrumentation) {
        Field2561 = instrumentation;
    }

    public static synchronized void premain(String string, Instrumentation instrumentation) {
        Field2561 = instrumentation;
    }

    public static synchronized byte[] getClassFile(Class clazz) throws UnmodifiableClassException {
        Instrumentation instrumentation = Field2561;
        if (instrumentation == null) {
            throw new IllegalStateException("Agent has not been loaded");
        }
        Class607 class607 = new Class607();
        instrumentation.addTransformer(class607, true);
        instrumentation.retransformClasses(clazz);
        instrumentation.removeTransformer(class607);
        return class607.Field2562;
    }

    public byte[] transform(ClassLoader classLoader, String string, Class clazz, ProtectionDomain protectionDomain, byte[] byArray) throws IllegalClassFormatException {
        if (clazz != null) {
            this.Field2562 = byArray;
        }
        return null;
    }
}
