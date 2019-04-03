package gui.werner.e04;

public class Pereson {
    private String name;
    private int yearOfBirth;

    public Pereson(String n, int y) {
        name = n;
        yearOfBirth = y;
    }

    @Override
    public String toString() {
        return name + "(" + yearOfBirth + ")";
    }
}
