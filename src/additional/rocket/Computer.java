package additional.rocket;

public class Computer {

    private int attitude;
    private int step;

    public Computer(int step) {
        attitude = 0;
        this.step = step;
    }

    public int getAttitude() {
        attitude += step;
        System.out.print(attitude + " ");
        return attitude;
    }

}
