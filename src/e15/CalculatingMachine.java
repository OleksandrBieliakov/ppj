package e15;

public class CalculatingMachine {

    protected String name;

    public CalculatingMachine (String name) {
        this.name = name;
    }

    public String calculate(double x, double y) {
        return name + "(" + x + "," + y + ") -> '+':" + (x + y);
    }

    public static void printRes(CalculatingMachine[] a, double x, double y) {
        for(CalculatingMachine cm : a) {
            System.out.println(cm.calculate(x, y));
        }
    }

}
