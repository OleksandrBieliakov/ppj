public class E6P1 {
	
	public static boolean hasTwoRoots(double a, double b, double c) {
		return a != 0 && (b*b - 4*a*c) > 0 ? true : false;		
	}
	
	public static boolean monot(double a, double b, double c) {
		return a > b && b > c ? true : false;
	}
	
	public static double maxEI(double a, double b, double c) {
		double max = a;
		if (a < b) max = b;
		if (max < c) max = c;
		return max;
	}
	
	public static int numPos(double a, double b, double c) {
		int num = 0;
		if (a > 0) ++num;
		if (b > 0) ++num;
		if (c > 0) ++num;
		return num;
	}
	
	private static void print (double a, double b, double c, String s) {
		System.out.print("(a, b, c) = (" + a + ", " + b + ", " + c + "): " + s + " ");		
	}
	
	
	public static void main (String [] args) {
		
		double a = 2, b = 3, c = 1;
		print(a, b, c, "hasTwoRoots?");
		System.out.println(hasTwoRoots(a, b, c));
		
		a = 0; b = 2; c = 1;
		print(a, b, c, "hasTwoRoots?");
		System.out.println(hasTwoRoots(a, b, c));
		
		a = 2; b = 1; c = -1;
		print(a, b, c, "monot?");
		System.out.println(monot(a, b, c));
		
		a = 2; b = 1; c = 2;
		print(a, b, c, "monot?");
		System.out.println(monot(a, b, c));
		
		a = 2; b = 1; c = 2;
		print(a, b, c, "maxEI");
		System.out.println(maxEI(a, b, c));
		
		a = 2; b = 2; c = 4;
		print(a, b, c, "maxEI");
		System.out.println(maxEI(a, b, c));
		
		a = -2; b = 1; c = -3;
		print(a, b, c, "numPos");
		System.out.println(numPos(a, b, c));
		
		a = -2; b = 1; c = 3;
		print(a, b, c, "numPos");
		System.out.println(numPos(a, b, c));
		
	}
	
}
