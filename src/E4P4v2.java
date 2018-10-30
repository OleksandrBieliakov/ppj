import javax.swing.*;

public class E4P4v2 {

    public static void main(String[] args) {

        int i = 0, min = 0, max = 1000001, n;


        JOptionPane.showMessageDialog(null,
                "20 Questions game!\nThink of a number from 1 to 1000000");

        while (true) {
            n = (max + min) / 2;

            String st = JOptionPane.showInputDialog(null,
                    "Is this " + n + "?\nAnswer \"s\" if " + n + " is smaller than the chosen number;" +
                            "\n\"b\" if " + n + " is bigger;\n\"y\" if " + n + " is your number."
            );
			
            ++i;

            if ("y".equals(st))
                break;
            if ("s".equals(st))
                min = n;
            else if ("b".equals(st))
                max = n;
        }

        JOptionPane.showMessageDialog(null,
                "Your number is " + n + "!\nNumber of trials: " + i);

    }

}

