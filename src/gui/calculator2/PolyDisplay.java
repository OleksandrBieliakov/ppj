package gui.calculator2;

import javax.swing.*;
import java.awt.*;

class PolyDisplay extends JPanel {

    private MainFrame frame;

    PolyDisplay (MainFrame f) {
        frame = f;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        for(Polynomial p : frame.list) {
            if(p.isDisplayed) {
                g.setColor(p.color);
                int x1 = -100, y1 = p.getY(x1);
                int x2,y2;
                for(int i = x1 + 1; i <= 100; ++i) {
                    x2 = i;
                    y2 = p.getY(x2);
                    g.drawLine(x1, y1, x2, y2);
                    x1 = x2;
                    y1 = y2;
                }
            }
        }

    }


}
