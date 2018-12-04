package e1;

import java.util.Scanner;

public class E1P3_2 {
	
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nPlease enter three integers a b c.\n");
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();

		System.out.println("\na = " + a + "\nb = " + b + "\nc = " + c);

		int t;

		if (a > b) {
			t = a;
			a = b;
			b = t;
		}
		if (b > c) {
			t = b;
			b = c;
			c = t;
		}
		if (a > b) {
			t = a;
			a = b;
			b = t;
		}

		System.out.println("\na = " + a + "\nb = " + b + "\nc = " + c);
	}
	
}
