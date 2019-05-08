package gui.factories;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

class StoragePanel extends JPanel {

    private LinkedList<Baloon> baloons;

    StoragePanel() {
        setBackground(Color.DARK_GRAY);
        baloons = new LinkedList<>();
    }

    void load(LinkedList<Baloon> batch) {
        baloons = batch;
    }

    @Override
    protected void paintComponent(Graphics currentGraphics) {
        super.paintComponent(currentGraphics);
        Graphics2D mainGraphics = (Graphics2D) currentGraphics;

        int frameHeight = getHeight();
        int width = getWidth() / 99;
        int height = frameHeight / 99 * 4;
        double altitudeUnit = frameHeight / 1000.0;
        int positionX, altitudeY;

        for (Baloon baloon : baloons) {
            mainGraphics.setColor(baloon.getColor());
            positionX = baloon.getPosition() * width;
            altitudeY = frameHeight - (int) (baloon.getAltitude() * altitudeUnit);
            mainGraphics.fillOval(positionX, altitudeY, width, height);
        }
    }

}
