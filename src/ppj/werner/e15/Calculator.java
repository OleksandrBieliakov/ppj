package ppj.werner.e15;

public class Calculator extends CalculatingMachine {

    public Calculator(String name) {
        super(name);
    }

    @Override
    public String calculate(double x, double y) {
        return super.calculate(x, y) + "; '-':" + (x - y);
    }

}
