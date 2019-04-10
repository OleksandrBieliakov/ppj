package gui.werner.e04.p2;

public class Main {
    public static void main(String... args) {
        int ini = 10, count = 0, maxel = 1;
        Hailstone hailstone = new Hailstone(ini);
        for (int h : hailstone) {
            if (h > maxel) maxel = h;
            ++count;
        }
        System.out.println("\n" + ini + " " + count + " " + maxel);
    }
}
