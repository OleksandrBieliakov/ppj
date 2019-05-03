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
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(panel);
    }

    void addBaloon(Baloon baloon) {
        if (size == 99) {
            System.out.println("RELEASE CALL");
            new ReleaseThread(baloons, panel).start();
            baloons.clear();
            size = 0;
        }
        baloon.setPosition(size);
        baloon.setAltitude(size++);
        baloons.add(baloon);
        System.out.println("(" + size + ")col: " + baloon.getColor() + ", a: " + baloon.getAltitude() + ", p: " + baloon.getPosition());
    }


}
