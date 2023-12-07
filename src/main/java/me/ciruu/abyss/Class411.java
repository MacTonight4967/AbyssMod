package me.ciruu.abyss;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ciruu.abyss.Class375;
import me.ciruu.abyss.Class40;
import me.ciruu.abyss.Class412;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Class411
extends WebSocketClient {
    private boolean Field1342;

    private final Thread getReadThread() {
        Field field = WebSocketClient.class.getDeclaredField("connectReadThread");
        boolean bl = false;
        boolean bl2 = false;
        Field field2 = field;
        boolean bl3 = false;
        field2.setAccessible(true);
        return (Thread)field.get(this);
    }

    private final Thread getWriteThread() {
        Field field = WebSocketClient.class.getDeclaredField("writeThread");
        boolean bl = false;
        boolean bl2 = false;
        Field field2 = field;
        boolean bl3 = false;
        field2.setAccessible(true);
        return (Thread)field.get(this);
    }

    public final boolean getConnected() {
        return this.Field1342;
    }

    private final void trustAllHosts() {
        TrustManager trustManager = new Class375();
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
            this.setSocketFactory(sSLContext.getSocketFactory());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {
        block1: {
            this.Field1342 = true;
            super.run();
            this.Field1342 = false;
            Class40 class40 = Class40.Field96;
            boolean bl = false;
            boolean bl2 = false;
            synchronized (class40) {
                boolean bl3 = false;
                Class40.Field96.Method1752(this);
                Unit unit = Unit.INSTANCE;
            }
            Thread thread = this.getWriteThread();
            if (thread == null) break block1;
            thread.interrupt();
        }
    }

    @Override
    public void onOpen(@Nullable ServerHandshake serverHandshake) {
        Class40 class40 = Class40.Field96;
        boolean bl = false;
        boolean bl2 = false;
        synchronized (class40) {
            boolean bl3 = false;
            Class40.Field96.Method1753();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override
    public void onMessage(@NotNull String string) {
        Class40 class40 = Class40.Field96;
        boolean bl = false;
        boolean bl2 = false;
        synchronized (class40) {
            boolean bl3 = false;
            Class40.Field96.Method1754(string);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override
    public void onClose(int n, @NotNull String string, boolean bl) {
        Class40 class40 = Class40.Field96;
        boolean bl2 = false;
        boolean bl3 = false;
        synchronized (class40) {
            boolean bl4 = false;
            Class40.Field96.Method1755(n, string, bl);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override
    public void onError(@NotNull Exception exception) {
        Class40 class40 = Class40.Field96;
        boolean bl = false;
        boolean bl2 = false;
        synchronized (class40) {
            boolean bl3 = false;
            Class40.Field96.Method1756(exception);
            Unit unit = Unit.INSTANCE;
        }
    }

    public Class411() {
        super(Class412.Method1757());
        this.addHeader("Authorization", "Basic" + Class40.Field96.Method1758());
        if (Intrinsics.areEqual(this.uri.getScheme(), "wss")) {
            this.trustAllHosts();
        }
        this.setReuseAddr(true);
        this.setTcpNoDelay(true);
    }
}
