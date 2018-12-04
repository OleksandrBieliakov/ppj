package e2;

import java.util.Scanner;

public class E2P2_2 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		int l, s;
		
		if (a <= b) {
			l = b;
			s = a;
		} else {
			l = a;
			s = b;
		}
		
		if (l < c) {
			l = c;
		} else if (s > c) {
			s = c;
		}
		
		if (l < d) {
			l = d;
		} else if (s > d) {
			s = d;
		}
		
		System.out.println();
		System.out.println(l - s);
		
	}
	
} 
