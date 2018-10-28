import javax.swing.JOptionPane;

public class E4P4 {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, 
		"20 Questions game!\nThink of a number from 1 to million.");

		int n = 500000, k = 250000, i = 0;
		
        String st = "";
        
        while (true) {
		
		st = JOptionPane.showInputDialog(null, 
		"Is this " + n + "?\nAnswer \"s\" if " + n + " is smaller than the chosen number;" + 
		"\n\"b\" if " + n + " is bigger;\n\"y\" if " + n + " is your number."
		);
		
		++i;
		
		if ("y".equals(st))
			break;
		if ("s".equals(st))
			n += k;
		else if ("b".equals(st))
			n -= k;
			
		k = k / 2 + k % 2;
		
		}
		
		JOptionPane.showMessageDialog(null, 
		"Your number is " + n + "!\nNumber of trials: " + i);

    }
	
}

