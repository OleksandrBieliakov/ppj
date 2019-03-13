package ppj.werner.e01;

import java.util.Scanner;

public class E1P5 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		if ((a > b && b > c) || (a < b && b < c)) {
			System.out.println(b);
		} else if ((b > a && a > c) || (b < a && a < c)) {
			System.out.println(a);
		} else if ((a > c && c > b) || (a < c && c < b)) {
			System.out.println(c);
		} else {
			System.out.println("Two or more equal numbers - no middle value");
		}
		
	}
	
}
