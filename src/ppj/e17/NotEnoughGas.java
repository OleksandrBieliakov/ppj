package ppj.e17;

public class NotEnoughGas extends Exception {

    NotEnoughGas() {
        super();
    }

    NotEnoughGas(int fuel) {
        super("Only " + fuel + " liters. Must fill the tank");
    }

}
