import javax.swing.JOptionPane;

public class E4P2 {

    public static void main(String[] args) {

        String s = JOptionPane.showInputDialog(null, "Enter an integer");

        int n = Integer.parseInt(s);

		String s1 = "";
		
        for (int f = -2147483648, i = 0; i < 31; ++i, f = f >>> 1) {
            if ((n & f) != 0)
                s1 += "1, ";
			else if (s1 != "")
				s1 += "0, ";
		}
		if ((n & 1) != 0)
			s1 += "1.";
		else
			s1 += "0.";
        
            JOptionPane.showMessageDialog(null, s1);

    }

}
