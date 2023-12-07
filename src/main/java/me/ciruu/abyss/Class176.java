package me.ciruu.abyss;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.lwjgl.opengl.GL20;

public class Class176 {
    private final int Field2577;
    private final int Field2578;
    private final int Field2579;
    private final int Field2580;

    public Class176(String string) throws IOException {
        int n = GL20.glCreateProgram();
        GL20.glAttachShader((int)n, (int)this.Method3080("/shaders/passthrough.vsh", Class176.class.getResourceAsStream("/shaders/passthrough.vsh"), 35633));
        GL20.glAttachShader((int)n, (int)this.Method3080(string, Class176.class.getResourceAsStream(string), 35632));
        GL20.glLinkProgram((int)n);
        int n2 = GL20.glGetProgrami((int)n, (int)35714);
        if (n2 == 0) {
            System.err.println(GL20.glGetProgramInfoLog((int)n, (int)GL20.glGetProgrami((int)n, (int)35716)));
            throw new IllegalStateException("Shader failed to link");
        }
        this.Field2577 = n;
        GL20.glUseProgram((int)n);
        this.Field2578 = GL20.glGetUniformLocation((int)n, (CharSequence)"time");
        this.Field2579 = GL20.glGetUniformLocation((int)n, (CharSequence)"mouse");
        this.Field2580 = GL20.glGetUniformLocation((int)n, (CharSequence)"resolution");
        GL20.glUseProgram((int)0);
    }

    public void Method461(int n, int n2, float f, float f2, float f3) {
        GL20.glUseProgram((int)this.Field2577);
        GL20.glUniform2f((int)this.Field2580, (float)n, (float)n2);
        GL20.glUniform2f((int)this.Field2579, (float)(f / (float)n), (float)(1.0f - f2 / (float)n2));
        GL20.glUniform1f((int)this.Field2578, (float)f3);
    }

    private int Method3080(String string, InputStream inputStream, int n) throws IOException {
        int n2 = GL20.glCreateShader((int)n);
        GL20.glShaderSource((int)n2, (CharSequence)this.Method3081(inputStream));
        GL20.glCompileShader((int)n2);
        int n3 = GL20.glGetShaderi((int)n2, (int)35713);
        if (n3 == 0) {
            System.err.println(GL20.glGetShaderInfoLog((int)n2, (int)GL20.glGetShaderi((int)n2, (int)35716)));
            System.err.println("Caused by" + string);
            throw new IllegalStateException("Failed to compile shader:" + string);
        }
        return n2;
    }

    private String Method3081(InputStream inputStream) throws IOException {
        int n;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = new byte[512];
        while ((n = inputStream.read(byArray, 0, byArray.length)) != -1) {
            byteArrayOutputStream.write(byArray, 0, n);
        }
        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }
}
