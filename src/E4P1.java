import javax.swing.JOptionPane;

public class E4P1 {
	
	public static void main (String[] args) {
		
		String s = JOptionPane.showInputDialog(null,"Enter an integer");
		
		int n = Integer.parseInt(s);
		
		int [] a;
		
		for (int i = 0, k = 2; k < n && n%k == 0; ++k)
			a[i++] = k;
			
		if (a.length == 0)
			JOptionPane.showMessageDialog(null, "The number is prime");
		else {
		
		String s2 = "";
		
		for (i = 0; i < a.length; ++i)
			s2 += a[i];
				
		JOptionPane.showMessageDialog(null, s2);
		
		}
		
	}
	
}
