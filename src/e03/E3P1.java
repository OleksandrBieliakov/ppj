package e03;

import java.util.Scanner;

public class E3P1 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter integer numbers. Enter 0 to stop.");
		
		int cur = scan.nextInt();
		
		if (cur == 0) return;
		
		else {
			
			int countcur = 0;
			int last = 0; 
			int rec = 0;
			int countrec = 0;
						
			while (cur != 0) {
				
				if (cur == last) {
					countcur++;
				} else {
					last = cur;
					countcur = 1;
				}
				
				if (countcur > countrec) {
						countrec = countcur;
						rec = cur;				
				}
				
				cur = scan.nextInt();
				
			}
			
			System.out.println("Longest sequence: " + countrec + " times " + rec);
		
		}
		
	}
	
} 
