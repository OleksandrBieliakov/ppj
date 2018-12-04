package e01;

import java.util.Scanner;

public class E1P6_2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a, b, c for ax^2 + bx + c = 0");

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        //just for pretty output
        System.out.println();

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("x = any number");
                } else {
                    System.out.println("No solution");
                }
            } else {
                System.out.println("x = " + 1d * -c / b);
            }
        } else {
            int d = b * b - 4 * a * c;
            if (d < 0) {
                System.out.println("No real solutions");
            } else {
                double s = Math.sqrt(d);
                double x1 = (-b - s) / (2 * a);
                double x2 = (-b + s) / (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }
}

