import java.util.Scanner;

public class E4P3 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = 1;
		int max = 0;
		int maxN = 0;
		
		while (n !=0) {
			System.out.print("enter a natural number (0 if done): ");
			n = scan.nextInt();
			System.out.println();
		
			int sum = 0;
			int newN = n;
			
		
			while (n >= 10) {
				sum += n % 10;
				n /= 10;
			}
			
			sum += n;
			
			if (sum > max) {
				max = sum;
				maxN = newN;
			}
			
		}
		
		System.out.print("Max sum of digits was " + max + " for " + maxN);
		
	}
	
}