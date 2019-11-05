package daftacademy;

public class Main {
    public static void main(String[] args) {

        Ship ship = Parser.parseShip("15: Ning-Po (Feedermax)");
        //Container container = Parser.parseContainer("BE-BR-61613986/3551/B1@oqk.bf/39927");

        System.out.println(ship);
        //System.out.println(container);

    }
}
