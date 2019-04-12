package gui.kaboom.l3.t1;

public class Main2 {

    private static double doHardWork() {
        return 1235.0;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            long start = System.currentTimeMillis();
            long c = 0;
            double x = 0.0;
            boolean toggle = false;
            for (int i = 0; i < 100_000_000; ++i) {
                c++;
                toggle = !toggle;
                if (toggle)
                    x += doHardWork();
                else
                    x -= doHardWork();
            }
            System.out.println("\nLoop: " + c + " : " + x + " : " + (System.currentTimeMillis() - start));
        }).start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            long c = 0;
            double x = 0.0;
            boolean toggle = false;
            for (int i = 0; i < 100_000_000; i += 2) {
                c++;
                toggle = !toggle;
                if (toggle)
                    x += doHardWork();
                else
                    x -= doHardWork();
            }
            System.out.println("\nEvens: " + c + " : " + x + " : " + (System.currentTimeMillis() - start));
        }).start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            long c = 0;
            double x = 0.0;
            boolean toggle = false;
            for (int i = 1; i <= 100_000_000; i += 2) {
                c++;
                toggle = !toggle;
                if (toggle)
                    x += doHardWork();
                else
                    x -= doHardWork();
            }
            System.out.println("\nOdds: " + c + " : " + x + " : " + (System.currentTimeMillis() - start));
        }).start();


    }
}
