package e3;

import java.util.Scanner;

public class E3P1_1 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter integer numbers. Enter 0 to stop.");

		int cur;
		int countcur = 0;
		
		int last = 0; 
		
		int rec = 0;
		int countrec = 0;
		
		do {
			
			cur = scan.nextInt();
			
			if (cur == last) {
				countcur++; 
			} else {
				countcur = 1;
				last = cur;
			}

			if (countcur > countrec) {
				countrec = countcur;
				rec = last;
			}

		} while (cur != 0);
		
		System.out.println("Longest sequence: " + countrec + " times " + rec);
		
	}
	
} 
