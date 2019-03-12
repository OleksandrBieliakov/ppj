package ppj.e01;

import javax.swing.*;
import java.util.Scanner;

public class E1P1 {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your height in meters and weight in kilograms.");
		
		double height = scan.nextDouble();
		double weight = scan.nextDouble();
		
		JOptionPane.showMessageDialog(null, "Your BMI (body mass index) is " + (weight / (height * height)));
		
	}
	
}
