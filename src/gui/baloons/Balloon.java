package gui.baloons;

import java.awt.*;

class Balloon {

    private BalloonColors colorName;
    private Color color;
    private int altitude = 0;
    private int position = 0;

    Balloon(BalloonColors colorName) {
        this.colorName = colorName;
        switch (colorName) {
            case BLUE:
                color = Color.BLUE;
                break;
            case CYAN:
                color = Color.CYAN;
                break;
            case GREEN:
                color = Color.GREEN;
                break;
            case MAGENTA:
                color = Color.MAGENTA;
                break;
            case ORANGE:
                color = Color.ORANGE;
                break;
            case PINK:
                color = Color.PINK;
                break;
            case RED:
                color = Color.RED;
                break;
            case WHITE:
                color = Color.WHITE;
                break;
            case YELLOW:
                color = Color.YELLOW;
                break;
            case BLACK:
                color = Color.BLACK;
                break;
            case PURPLE:
                color = new Color(102, 0, 153);
                break;
            case RED_ORANGE:
                color = new Color(255, 102, 0);
                break;
            case DARK_RED:
                color = new Color(153, 0, 0);
                break;
            case DARK_GREEN:
                color = new Color(0, 153, 0);
                break;
            case LIGHT_BLUE:
                color = new Color(51, 153, 255);
                break;
            case LIGHT_BROWN:
                color = new Color(153, 102, 0);
                break;
        }
    }

    Color getColor() {
        return color;
    }

    int getAltitude() {
        return altitude;
    }

    int getPosition() {
        return position;
    }

    void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    void setPosition(int position) {
        this.position = position;
    }

    boolean isRed() {
        return color == Color.RED;
    }

    @Override
    public String toString() {
        return "Balloon{" +
            "color=" + colorName +
            ", altitude=" + altitude +
            ", position=" + position +
            '}';
    }
}
