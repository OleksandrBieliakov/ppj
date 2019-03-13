package ppj.werner.e03;

import java.util.Scanner;

public class E3P3 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter two natural numbers larger than 1 for width and height of a rectangle:");
		
		System.out.print("w = ");	
		int w = scan.nextInt();
		
		while (w <= 1) {
			
			System.out.println(
			"w = " + w + " is not a natural number larger than 1. Please enter another number:");
			System.out.print("w = ");
			w = scan.nextInt();
			
		} 
		
		System.out.print("h = ");
		int h = scan.nextInt();
		
		while (h <= 1) {
			
			System.out.println(
			"h = " + h + " is not a natural number larger than 1. Please enter another number:");
			System.out.print("h = ");
			h = scan.nextInt();
			
		} 
		
		scan.close();
		System.out.println();
				
		for (int i = 0; i < w; ++i)
				System.out.print("*");
			
		System.out.println();	
			
		for (int len = h - 2; len > 0; len--) {
			
			System.out.print("*");
			
			for (int i = w - 2; i > 0; --i)
				System.out.print(" ");
						
			System.out.print("*");
			
			System.out.println();	
		}	
			
		for (int i = 0; i < w; ++i)
				System.out.print("*");
		
		System.out.println();
		
	}
	
}