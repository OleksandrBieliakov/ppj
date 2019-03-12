package ppj.e05;

import java.util.Scanner;

public class E5P2 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter an int");
		int n = scan.nextInt();
		scan.close();
		
		
		boolean is7thBitSet = false;
		is7thBitSet = (n & 64) != 0;
		System.out.println("Is 7th bit set? " + is7thBitSet);
		
		
		int numberOf1s = 0;
		for (int i = 0, m = n; i < 32; ++i) {
			if ((m & 1) != 0)
				++numberOf1s;
			m >>>= 1;
		}
		System.out.println("No. of 1s is " + numberOf1s);
		
		
		if (n == 0) 
			System.out.println("No bits set for n = 0");
		else {
			int mostSignificant = 31;
			for (int m = n; (m & -2147483648) == 0; --mostSignificant) {
				m <<= 1;
			}
			System.out.println("Most significant bit set: " + mostSignificant);
		}
		
		
		int swapped = 0;
		int m1 = n & 0b1111111100000000;
		int m0 = n & 0b11111111;
		m1 >>>= 8;
		m0 <<= 8;
		swapped = n & 0b11111111111111110000000000000000 | m1 | m0;
		System.out.println("With 2 least significant bytes swapped: " + swapped);
	
	}
	
}