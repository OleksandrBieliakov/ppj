package e03;

import java.util.Scanner;

public class E3P4 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		if (a == 0){
			if (b == 0)
			System.out.println("Undefined");
			else
			System.out.println(b);
		
			return;
		}
		if (b == 0){
			if (a == 0)
			System.out.println("Undefined");
			else
			System.out.println(a);
		
			return;
		}
		
		a = Math.abs(a);
		b = Math.abs(b);
		
		while (a != b) {
			
			if (a > b) 
				a -= b;
			else 
				b -= a;
		}
		
		System.out.println(a);
		
	}
	
}