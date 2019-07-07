package gui.calculator2;

import javax.swing.*;

class CalButton extends JButton {

    Calculator cal;
    String title;

    CalButton(String title, Calculator cal) {
        setText(title);
        this.title = title;
        this.cal = cal;
        addListener();
    }

    void addListener() {
        addActionListener(e -> {
            cal.setOutput(cal.getOutput() + title);
        });
    }
}
