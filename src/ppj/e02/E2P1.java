package ppj.e02;

import java.util.Scanner;

public class E2P1 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		double a = scan.nextDouble();
		String op = scan.next();
		double b = scan.nextDouble();
		
		if (op.equals("+"))
			System.out.println(a + b);
		if (op.equals("-"))
			System.out.println(a - b);
		if (op.equals("*"))
			System.out.println(a * b);
		if (op.equals("/"))
			System.out.println(b != 0 ? a / b : "Undefined");
		
	}
	
}
