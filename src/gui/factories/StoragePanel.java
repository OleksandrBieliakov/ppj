package gui.factories;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

class StoragePanel extends JPanel {

    private LinkedList<Baloon> baloons;
    private LinkedList<Baloon> staticBaloons;

    StoragePanel() {
        setBackground(Color.DARK_GRAY);
        baloons = new LinkedList<>();
        staticBaloons = new LinkedList<>();
    }

    void load(LinkedList<Baloon> batch) {
        baloons = batch;
    }

    void addStatic(Baloon baloon) {
        staticBaloons.add(baloon);
    }

    void clearStatic() {
        staticBaloons.clear();
    }

    @Override
    protected void paintComponent(Graphics currentGraphics) {
        super.paintComponent(currentGraphics);
        Graphics2D mainGraphics = (Graphics2D) currentGraphics;

        int frameHeight = getHeight();
        int width = getWidth() / 99;
        int height = frameHeight / 99 * 2;
        double altitudeUnit = (double)frameHeight / 1000;
        int positionX, altitudeY;
        frameHeight -= height;

        if(baloons != null) {
            for (Baloon baloon : baloons) {
                mainGraphics.setColor(baloon.getColor());
                positionX = baloon.getPosition() * width;
                altitudeY = frameHeight - (int) (baloon.getAltitude() * altitudeUnit);
                mainGraphics.fillOval(positionX, altitudeY, width, height);
            }
        } else {
            System.out.println("Baloons - NULL !!!");
        }

        for (Baloon baloon : staticBaloons) {
            mainGraphics.setColor(baloon.getColor());
            positionX = baloon.getPosition() * width;
            mainGraphics.fillOval(positionX, frameHeight, width, height);
        }
    }

}