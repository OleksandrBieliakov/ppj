package e17;

public class Car {

    private int fuel;
    private int km;

    public Car () {
        fuel = 35;
        km = 0;
    }

    public void fill() {
        if(Math.random() <= 0.1) throw new Explosion("BOOOOM");
        fuel += Math.random()*(35-15)+ 15;
        System.out.println("After filling " + fuel);
    }

    public void drive100km() throws NotEnoughGas {
        if(fuel < 10) throw new NotEnoughGas(fuel);
        fuel -= 10;
        km += 100;
        System.out.println(km + "km driven, " + fuel + " liters left");
    }

}
