package gui.factories;

import javax.swing.*;
import java.util.LinkedList;

public class ReleaseThread extends Thread {

    private final LinkedList<Baloon> baloons;
    private final StoragePanel panel;

    ReleaseThread(LinkedList<Baloon> baloons, StoragePanel panel) {
        this.baloons = baloons;
        this.panel = panel;
    }

    public void run() {
        System.out.println("RELEASE START");
        int altitude;
        MAIN:
        while (baloons.size() > 0) {
            for (Baloon b : baloons) {
                altitude = b.getAltitude() + 1;
                if (altitude >= 500 && !b.isRed()) {
                    baloons.remove(b);
                    continue MAIN;
                } else if (altitude >= 750) {
                    baloons.remove(b);
                    continue MAIN;
                }
                b.setAltitude(altitude);
            }
            SwingUtilities.invokeLater(() -> {
                panel.load(baloons);
            });
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(panel::repaint);
        }
        System.out.println("RELEASE FINISH");
    }

}
