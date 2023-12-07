package me.ciruu.abyss;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class Class375
implements X509TrustManager {
    @Override
    public void checkClientTrusted(@Nullable X509Certificate[] x509CertificateArray, @Nullable String string) {
    }

    @Override
    public void checkServerTrusted(@Nullable X509Certificate[] x509CertificateArray, @Nullable String string) {
    }

    @Override
    @NotNull
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    Class375() {
    }
}
