import java.util.Scanner;

public class E5P1 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please endter two integers a and b from the interval [-5;5] and a < b ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println("Please endter two integers c and d from the interval [-5;5] and c < d");
		int c = scan.nextInt();
		int d = scan.nextInt();
		
		for (int n = -5; n <= 5; ++n) {
			boolean ab = (a <= n && n <= b);
			boolean cd = (c <= n && n <= d);
			boolean inSum = (ab || cd);
			boolean inIntersect = (ab && cd);
			boolean inSymDiff = (ab ^ cd);
			
			System.out.printf("%11s", n + ": inSum? ");
			System.out.printf("%5s", inSum);
			System.out.printf("%14s", " inIntersect? ");
			System.out.printf("%5s", inIntersect);
			System.out.printf("%12s", " inSymDiff? ");
			System.out.printf("%5s", inSymDiff);
			System.out.println();
			
		}
		
	}
	
}