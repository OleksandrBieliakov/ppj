package gui.calculator2;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");
        Calculator cal = new Calculator();
        f.add(cal);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
    }
}
