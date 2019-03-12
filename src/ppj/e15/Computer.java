package ppj.e15;

public class Computer extends Calculator{

    public Computer(String name) {
        super(name);
    }

    @Override
    public String calculate(double x, double y) {
        return super.calculate(x, y) + "; '*':" + (x * y) + "; '/':" + (x / y);
    }

}
