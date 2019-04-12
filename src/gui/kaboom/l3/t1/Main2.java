package gui.kaboom.l3.t1;

public class Main2 {

    private static double doHardWork() {
        double dummy = 0.0;
        for (int i = 0; i < 1000; i++) {
            dummy += i;
        }
        return dummy;
    }

    public static void main(String[] args) {
        createThread("Evens", 0, 2).start();
        createThread("Odds ", 1, 2).start();
        createThread("All  ", 0, 1).start();
    }

    private static Thread createThread(String title, int from, int step) {
        return new Thread(() -> {
            long start = System.currentTimeMillis();
            long c = 0;
            double x = 0.0;
            boolean toggle = false;
            for (int i = from; i < 1_000_000 + from; i += step) {
                c++;
                toggle = !toggle;
                if (toggle)
                    x += doHardWork();
                else
                    x -= doHardWork();
            }
            System.out.println(title + " : " + c + " : " + x + " : " + (System.currentTimeMillis() - start));
        });
    }
}
