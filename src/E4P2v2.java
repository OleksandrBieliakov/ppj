import javax.swing.*;

public class E4P2v2 {

    public static void main(String[] args) {

        String s = JOptionPane.showInputDialog(null, "Enter an integer");

        int n = Integer.parseInt(s);

        String s1 = "";

        for (int i = 0; n > 0; ++i, n = n >>> 1) {
            if (i > 0)
                s1 += ",";
            s1 += n & 1;
        }

        JOptionPane.showMessageDialog(null, s1);

    }

}
