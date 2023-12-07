package me.ciruu.abyss;

import java.io.File;
import java.io.IOException;

public class Class466 {
    public void Method2017() {
        try {
            this.Method3932("Abyss");
            this.Method3932("Abyss/Features");
            this.Method3932("Abyss/Features/default");
            this.Method3932("Abyss/HUD");
            this.Method3932("Abyss/Images");
            this.Method3932("Abyss/PacketLogger");
            this.Method3932("Abyss/Voice");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void Method3932(String string) throws IOException {
        new File(string).mkdirs();
    }
}
