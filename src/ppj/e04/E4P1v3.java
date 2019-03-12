package ppj.e04;

import javax.swing.*;

public class E4P1v3 {

    public static void main(String[] args) {

        String s = JOptionPane.showInputDialog(null, "Enter an integer");

        int n = Integer.parseInt(s);

		String s1 = "";
		
        for (int k = 2; k <= n / 2; ++k)
            if (n % k == 0)
                s1 += " " + k;

        if (s1 == "")
            JOptionPane.showMessageDialog(null, "The number " + n + " is prime");
        else 
            JOptionPane.showMessageDialog(null, "Nontrivial divisors of " + n + ":" + s1);

    }

}
