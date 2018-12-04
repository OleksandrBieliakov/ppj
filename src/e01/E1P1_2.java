package e01;

import javax.swing.*;

public class E1P1_2 {
	
	public static void main (String[] args) {
		
		String s = JOptionPane.showInputDialog(null, "Enter your height in meters");
		
		double h = Double.parseDouble(s);
		
		s = JOptionPane.showInputDialog(null, "Enter your weight in kilograms");
		double w = Double.parseDouble(s);
				
		JOptionPane.showMessageDialog(null, "Your BMI (body mass index) is " + (w / (h * h)));
		
		System.exit(0);

		}
	
}
