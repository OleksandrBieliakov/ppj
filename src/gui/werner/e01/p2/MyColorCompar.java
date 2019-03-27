package gui.werner.e01.p2;

import java.util.Comparator;

public class MyColorCompar implements Comparator<MyColor> {

    public enum ColComponent {RED, GREEN, BLUE}

    private ColComponent colCom;

    public MyColorCompar(ColComponent colCom) {
        this.colCom = colCom;
    }

    @Override
    public int compare(MyColor mc1, MyColor mc2) {
        int red = mc1.getRed() - mc2.getRed();
        int green = mc1.getGreen() - mc2.getGreen();
        int blue = mc1.getBlue() - mc2.getBlue();

        switch (colCom) {
            case RED:
                return red;
            case GREEN:
                return green;
        }
        return blue;
    }

}
