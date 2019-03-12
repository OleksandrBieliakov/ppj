package ppj.e04;

import javax.swing.*;

public class E4P1 {
	
	public static void main (String[] args) {
		
		String s = JOptionPane.showInputDialog(null,"Enter an integer");
		
		int n = Integer.parseInt(s);
		
		int [] a = new int [n/2];
		
		int greatestI = -1;
		
		for (int i = 0, k = 2; k <= n/2; ++k) {
			if (n%k == 0) {
				greatestI = i;
				a[i++] = k;
			}
		}	
		if (greatestI == -1)
			JOptionPane.showMessageDialog(null, "The number is prime");
		else {
		
		String s2 = "";
		
		for (int i = 0; i <= greatestI; ++i)
			s2 += a[i] + " ";
				
		JOptionPane.showMessageDialog(null, "Nontrivial divisors of " + n + ": " + s2);
		
		}
		
	}
	
}
