package ppj.e01;

import java.util.Scanner;

public class E1P6 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a, b, c for ax\u00B2 + bx + c = 0");
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		if (a == 0) {
			if (b == 0) {
				if (c == 0) 
					System.out.println("x = any number");
				else
					System.out.println("No solution");
			} else 
				System.out.println("x = " + (double)-c/b); 
		} else {
			if ((b*b - 4*a*c) < 0)
				System.out.println("No real solutions");
			else
				System.out.println(
				"x1 = " + (double)(-b - Math.sqrt(b*b - 4*a*c))/(2*a)
				+ "\nx2 = " + (double)((-b + Math.sqrt(b*b - 4*a*c))/(2*a))
				);
			
		}
		
	}
	
} 
