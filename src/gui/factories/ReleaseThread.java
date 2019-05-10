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

    private void altitudeWork() {
        int sz = baloons.size();
        int altitude;
        for (int i = 0; i < sz; ++i) {
            altitude = baloons.get(i).getAltitude() + 1;
            if (altitude >= 500 && !baloons.get(i).isRed()) {
                baloons.remove(baloons.get(i--));
                sz--;
            } else if (altitude >= 750) {
                baloons.remove(baloons.get(i--));
                sz--;
            } else {
                baloons.get(i).setAltitude(altitude);
            }
        }
    }

    public void run() {
        System.out.println("RELEASE START");
        while (baloons.size() > 0) {
            SwingUtilities.invokeLater(this::altitudeWork);
            SwingUtilities.invokeLater(() -> {
                panel.load(baloons);
            });
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(panel::repaint);
        }
        SwingUtilities.invokeLater(() -> {
            panel.load(baloons);
        });
        SwingUtilities.invokeLater(panel::repaint);
        System.out.println("RELEASE FINISH");
    }

}
