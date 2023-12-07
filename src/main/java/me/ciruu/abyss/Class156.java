package me.ciruu.abyss;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

public class Class156 {
    private TrayIcon Field349 = null;

    public Class156() {
        try {
            SystemTray systemTray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/assets/abyss/textures/logofinalnobg.png"));
            TrayIcon trayIcon = new TrayIcon(image, "Abyss");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Abyss");
            systemTray.add(trayIcon);
            this.Field349 = trayIcon;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void Method440(int n) {
        if (this.Field349 != null) {
            this.Field349.displayMessage("Abyss", "Position in queue:" + n, TrayIcon.MessageType.INFO);
        }
    }
}
