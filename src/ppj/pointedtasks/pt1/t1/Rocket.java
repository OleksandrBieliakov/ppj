package ppj.pointedtasks.pt1.t1;

import java.util.Random;

public class Rocket {

    public String name;
    public int fuelWeight;

    public Rocket (String name, int fuelWeight) {
        this.name = name;
        this.fuelWeight = fuelWeight;
    }

    public void refill() {
        Random rand = new Random();
        fuelWeight = rand.nextInt(3000);
    }

    public void launch() throws IllegalArgumentException{
        if (fuelWeight < 1000)
            throw new IllegalArgumentException("Launch canceled, fuel too low.");
    }
}
