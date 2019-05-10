package gui.factories;

import javax.swing.*;
import java.util.Iterator;
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
        Iterator<Baloon> iterator = baloons.iterator();
        while (iterator.hasNext()) {
            Baloon baloon =  iterator.next();
            altitude = baloon.getAltitude() + 1;
            if (altitude >= 500 && !baloon.isRed() || altitude >= 750) {
                iterator.remove();
                sz--;
            } else {
                baloon.setAltitude(altitude);
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
