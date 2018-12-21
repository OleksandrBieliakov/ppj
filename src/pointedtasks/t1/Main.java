package pointedtasks.t1;

public class Main {

    public static void main (String[] args) {

        Rocket rocket = new Rocket("R1", 4000);

        try {
            rocket.launch();
        } catch (IllegalArgumentException ex) {
            System.out.print(ex);
        }

        rocket.refill();

        try {
            rocket.launch();
        } catch (IllegalArgumentException ex) {
            System.out.print(ex);
        }

    }

}
