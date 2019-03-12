package ppj.e03;

import java.util.Scanner;

public class E3P2 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please ender a natural odd number:");
		
		int n = scan.nextInt();
		
		while (n <= 0 || n % 2 == 0) {
			
			System.out.println(
			"n = " + n + " is not an odd natural number. Please enter another number:");
			n = scan.nextInt();
			
		} 
		
		scan.close();
		
		System.out.println();
		
		for (int len = n, sp = 0; len > 0; len -= 2, ++sp) {
			
			for (int i = 0; i < sp; ++i)
				System.out.print(" ");
			
			for (int i = 0; i < len; ++i)
				System.out.print("*");
			
			System.out.println();	
			
		}
		
	}
	
} 
