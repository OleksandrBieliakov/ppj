package e01;

import java.util.Scanner;

public class E1P3 {
	
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nPlease enter three integers a b c.\n");
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		System.out.println("\na = " + a + "\nb = " + b + "\nc = " + c);
		
		int largest;
		int middle;
		int smallest;
		
		if (a > b) {
			largest = a;
			middle = b;
		} else if ( a == b){
			largest = a;
			middle = b;
		} else {
			largest = b;
			middle = a;
		}
		
		if (c > largest) {
			smallest = middle;
			middle = largest;
			largest = c;
		} else if (largest > c && c > middle) {
			smallest = middle;
			middle = c;
		} else {
			smallest = c;
		}
		
		a = smallest;
		b = middle;
		c = largest;
		
		System.out.println("\na = " + a + "\nb = " + b + "\nc = " + c);
	}
	
}
