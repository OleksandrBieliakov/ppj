package gui.factories;

import javax.swing.*;
import java.util.LinkedList;

public class ReleaseThread extends Thread {

    private final LinkedList<Baloon> baloons;
    private final StoragePanel panel;
    private int sz;

    ReleaseThread(LinkedList<Baloon> baloons, StoragePanel panel) {
        this.baloons = baloons;
        this.panel = panel;
        sz = baloons.size();
    }

    private void altitudeWork() {
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

    private void altitudeInitial() {
        int altitude;
        for(Baloon b : baloons) {
            altitude = b.getAltitude() + 1;
            b.setAltitude(altitude);
            if(altitude == 1) {
                SwingUtilities.invokeLater(() -> {
                    panel.load(baloons);
                });
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SwingUtilities.invokeLater(panel::repaint);
                altitudeInitial();
                return;
            }
        }
    }

    public void run() {
        System.out.println("RELEASE START");
        SwingUtilities.invokeLater(panel::repaint);
        altitudeInitial();
        while (sz > 0) {
            SwingUtilities.invokeLater(this::altitudeWork);
            SwingUtilities.invokeLater(() -> {
                panel.load(baloons);
            });
            try {
                Thread.sleep(40);
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
