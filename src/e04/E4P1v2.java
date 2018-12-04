package e04;

import javax.swing.*;

public class E4P1v2 {

    public static void main(String[] args) {

        String s = JOptionPane.showInputDialog(null, "Enter an integer");

        int n = Integer.parseInt(s);

        int[] a = new int[n / 2];

        int len = 0;

        for (int k = 2; k <= n / 2; ++k)
            if (n % k == 0)
                a[len++] = k;


        if (len == 0)
            JOptionPane.showMessageDialog(null, "The number " + n + " is prime");
        else {

            String s2 = "Nontrivial division of " + n + ":";

            for (int i = 0; i < len; ++i)
                s2 += " " + a[i];

            JOptionPane.showMessageDialog(null, s2);

        }

    }

}
