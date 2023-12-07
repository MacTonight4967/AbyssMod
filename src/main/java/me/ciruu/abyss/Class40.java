package me.ciruu.abyss;

import com.google.gson.Gson;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Pair;
import me.ciruu.abyss.Class411;
import me.ciruu.abyss.Class637;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.client.WebChat;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.jetbrains.annotations.NotNull;

public final class Class40 {
    private static final Gson Field3088;
    private static Class411 Field3089;
    @NotNull
    private static final String Field3090;
    public static final Class40 Field96;

    @NotNull
    public final String Method1758() {
        return Field3090;
    }

    public final boolean Method3734() {
        boolean bl;
        if (Field3089 != null) {
            this.Method3735();
        }
        Field3089 = new Class411();
        try {
            Class411 class411 = Field3089;
            if (class411 == null) {
                Class637.Method3495();
            }
            class411.connect();
            bl = true;
        }
        catch (Throwable throwable) {
            Class637.Method3496(throwable);
            this.Method3735();
            bl = false;
        }
        return bl;
    }

    public final void Method3735() {
        if (Field3089 != null) {
            Class411 class411 = Field3089;
            if (class411 == null) {
                Class637.Method3495();
            }
            Class411 class4112 = class411;
            Field3089 = null;
            try {
                class4112.closeConnection(1000, "Disconnected");
            }
            catch (Throwable throwable) {
                Class637.Method3496(throwable);
            }
        }
    }

    public final void Method1752(@NotNull Class411 class411) {
        if (Class637.Method3497(class411, Field3089)) {
            WebChat webChat;
            WebChat webChat2 = webChat = (WebChat)Manager.moduleManager.getModuleByClass(WebChat.class);
            if (webChat2 != null) {
                webChat2.Method3736();
            }
            Field3089 = null;
        }
    }

    public final void Method1753() {
        block0: {
            String string = "Connected to webchat";
            boolean bl = false;
            Class637.Method3498(System.out, string);
            Class411 class411 = Field3089;
            if (class411 == null) break block0;
            class411.send(Class637.Method3501(Field3088, Class637.Method3500(Class637.Method3499("cmd", "list"))));
        }
    }

    public final void Method1755(int n, @NotNull String string, boolean bl) {
        Object object = Class637.Method3502(Class637.Method3502(Class637.Method3503(Class637.Method3502(Class637.Method3504(), "Disconnected from chat with exit code"), n), " additional info:"), string).toString();
        boolean bl2 = false;
        Class637.Method3498(System.out, object);
        Object object2 = object = (WebChat)Manager.moduleManager.getModuleByClass(WebChat.class);
        if (object2 != null) {
            ((WebChat)object2).Method3736();
        }
        this.Method3735();
    }

    /*
     * Exception decompiling
     */
    public final void Method1754(@NotNull String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Can't sort instructions [@NONE, blocks:[7] lbl106 : CaseStatement: default:\u000a, @NONE, blocks:[7] lbl106 : CaseStatement: default:\u000a]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.CompareByIndex.compare(CompareByIndex.java:25)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.CompareByIndex.compare(CompareByIndex.java:8)
         *     at java.util.TimSort.countRunAndMakeAscending(TimSort.java:360)
         *     at java.util.TimSort.sort(TimSort.java:220)
         *     at java.util.Arrays.sort(Arrays.java:1512)
         *     at java.util.ArrayList.sort(ArrayList.java:1462)
         *     at java.util.Collections.sort(Collections.java:177)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.buildSwitchCases(SwitchReplacer.java:271)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitch(SwitchReplacer.java:258)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:66)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:517)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at me.coley.recaf.decompile.cfr.CfrDecompiler.decompile(CfrDecompiler.java:71)
         *     at me.coley.plugin.decompile.DecompilePanel.lambda$startDecompile$2(DecompilePanel.java:78)
         *     at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
         *     at java.util.concurrent.FutureTask.run(FutureTask.java:266)
         *     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
         *     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
         *     at java.lang.Thread.run(Thread.java:748)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final boolean Method64(@NotNull String string) {
        if (Field3089 != null) {
            boolean bl;
            try {
                Class411 class411 = Field3089;
                if (class411 != null) {
                    class411.send(Class637.Method3501(Field3088, Class637.Method3518(new Pair[]{Class637.Method3499("cmd", "post"), Class637.Method3499("content", string)})));
                }
                bl = true;
            }
            catch (WebsocketNotConnectedException websocketNotConnectedException) {
                Class637.Method3519(websocketNotConnectedException);
                Field3089 = null;
                bl = false;
            }
            catch (Throwable throwable) {
                Class637.Method3496(throwable);
                bl = false;
            }
            return bl;
        }
        return false;
    }

    public final void Method1756(@NotNull Exception exception) {
        Class637.Method3520(exception);
    }

    private Class40() {
    }

    static {
        ZipFile zipFile;
        ZipEntry zipEntry;
        Class40 class40;
        Field96 = class40 = new Class40();
        Field3088 = Class637.Method3522(Class637.Method3521(Class637.Method3530()));
        String string = "fc2e52c70da8f1f65c718030787af367e4571e57ec0025949f6570943b8dfc20";
        if (Class637.Method3523(Manager.Field1647) && Class637.Method3525(Class637.Method3524(Manager.Field1647), ".jar", false, 2, null) && (zipEntry = Class637.Method3526(zipFile = new ZipFile(Manager.Field1647), "signature.dat")) != null) {
            string = Class637.Method3529(Class637.Method3528(Class637.Method3527(zipFile, zipEntry)));
        }
        Field3090 = string;
    }
}
