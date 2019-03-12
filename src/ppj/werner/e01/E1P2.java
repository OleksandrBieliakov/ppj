package ppj.werner.e01;

import java.util.Scanner;

public class E1P2 {
	
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter three natural numbers.");
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		if (a == b && b != c) {
			System.out.println("OK");
		} else if (a == c && b != c) {
			System.out.println("OK");
		} else if (b == c && b != a) {
			System.out.println("OK");
		} else {
			System.out.println("NOT OK");
		}
	}
	
}
