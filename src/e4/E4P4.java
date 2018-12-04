package e4;

import javax.swing.JOptionPane;

public class E4P4 {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, 
		"20 Questions game!\nThink of a number from 1 to million.");

		int min = 0, max = 1000000, i = 0, n = 0, k = 0;
		
        String st = "";
        
        while (true) {
			
			k = (max - min)/2;
			n = min + k;
			
			st = JOptionPane.showInputDialog(null, 
			"Is this " + n + "?\nAnswer \"s\" if " + n + " is smaller than the chosen number;" + 
			"\n\"b\" if " + n + " is bigger;\n\"y\" if " + n + " is your number."
			);
		
			++i;
		
			if ("y".equals(st))
				break;
			if ("s".equals(st)) {
				min += k;
			} else if ("b".equals(st)) {
				max -= k;
			}
		}
		
		JOptionPane.showMessageDialog(null, 
		"Your number is " + n + "!\nNumber of trials: " + i);

    }
	
}

