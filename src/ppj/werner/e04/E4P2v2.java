package ppj.werner.e04;

import javax.swing.*;

public class E4P2v2 {

    public static void main(String[] args) {

        String s = JOptionPane.showInputDialog(null, "Enter an integer");

        int n = Integer.parseInt(s);

        String s1 = "";
        boolean first = true;
        while (n > 0 || first) {
            if (first)
                first = false;
            else
                s1 += ",";
            s1 += n & 1;
            n >>>= 1;
        }

        JOptionPane.showMessageDialog(null, s1);

    }

}
