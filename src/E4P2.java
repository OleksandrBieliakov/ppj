import javax.swing.JOptionPane;

public class E4P2 {

    public static void main(String[] args) {

        String s = JOptionPane.showInputDialog(null, "Enter an integer");

        int n = Integer.parseInt(s);

		String s1 = "";
		
        for (int i = 0; i < 31; ++i, n = n >>> 1) {
            if (n == 1){
				s1 += "1.";
				break;
			} else if (n == 0) {
				s1 += "0.";
				break;
			} else {
			if ((n & 1) != 0)
                s1 += "1, ";
			else
				s1 += "0, ";
			}
		}
        
            JOptionPane.showMessageDialog(null, s1);

    }

}
