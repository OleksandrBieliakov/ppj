package gui.factories;

import javax.swing.*;
import java.util.LinkedList;

class Storage extends JFrame {

    private LinkedList<Baloon> baloons;
    private StoragePanel panel;
    private int size = 0;

    Storage() {
        baloons = new LinkedList<>();
        panel = new StoragePanel();
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(panel);
    }

    void addBaloon(Baloon baloon) {
        if (size == 99) {
            System.out.println("RELEASE CALL");
            SwingUtilities.invokeLater(panel::clearStatic);
            new ReleaseThread(new LinkedList<>(baloons), panel).start();
            baloons.clear();
            size = 0;
        }
        baloon.setPosition(size);
        baloon.setAltitude(size++);
        baloons.add(baloon);
        SwingUtilities.invokeLater(() -> {
            panel.addStatic(baloon);
        });
        SwingUtilities.invokeLater(panel::repaint);
        System.out.println("(" + size + ")col: " + baloon.getColor() + ", a: " + baloon.getAltitude() + ", p: " + baloon.getPosition());
    }


}
