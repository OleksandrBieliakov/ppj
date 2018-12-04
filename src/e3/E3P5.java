package e3;

import java.util.Scanner;

public class E3P5 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for (int y = 1; y <= n; y++) {
			
			for (int x = 1; x <= n; x++) {
				
				System.out.printf("%4d", y*x);
				
			}  
			
			System.out.println();
			
		}
		
	}
	
}
