package ppj.e04;

import java.util.Scanner;

public class E4P3v2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int max = 0, maxN = 0;

        int n = read(scan);
        while (n != 0) {
            int sum = 0, newN = n;

            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }

            if (sum > max) {
                max = sum;
                maxN = newN;
            }

            n = read(scan);
        }

        System.out.print("Max sum of digits was " + max + " for " + maxN);

    }

    private static int read(Scanner scan) {
        System.out.print("enter a natural number (0 if done): ");
        return scan.nextInt();
    }

}