package additional.rocket;

public class Main {

    public static void main(String[] args) {

        Rocket rocket = new Rocket();

        try {
            rocket.start();
        } catch (ComputerErrorException ex) {
            System.out.println("Attitude 10000 is reached according to one of the computers -\nattitudes calculated by Computer 1 and 2 are not equal.");
        }

    }

}
