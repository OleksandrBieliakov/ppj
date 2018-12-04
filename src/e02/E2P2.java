package e02;

import java.util.Scanner;

public class E2P2 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		int t;
		
		if (a < b) {
			t = a;
			a = b;
			b = t;
		}
		if (b < c) {
			t = b;
			b = c;
			c = t;
		}
		if (c < d) {
			t = c;
			c = d;
			d = t;
		}
		
		if (a < b) {
			t = a;
			a = b;
			b = t;
		}
		if (b < c) {
			t = b;
			b = c;
			c = t;
		}
		
		if (a < b) {
			t = a;
			a = b;
			b = t;
		}
		
		System.out.println();
		System.out.println(a - d);
	
	}
	
} 
