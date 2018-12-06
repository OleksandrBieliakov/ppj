import java.util.Scanner;

public class MethodCarrier {

	public static void innerLoops(int i, int edge) {
		int n = 0;
		for (int j = 0; j < edge/2; ++j) {
			System.out.print(n + " ");
			if (n < i) ++n;
		}
		if (edge%2 != 0) {
			System.out.print(n + " ");
		}
		for (int j = edge/2; j > 0; --j) {
			if(n >= j) --n;
			System.out.print(n + " ");
		}
	}

	
	public static void draw(int edge) {
		for (int i = 0; i < edge/2; ++i) {
			innerLoops(i, edge);
			System.out.println();
		}
		if (edge%2 != 0) {
			innerLoops(edge/2, edge);
			System.out.println();
		}
		for (int i = edge/2; i > 0; --i) {
			innerLoops(i - 1, edge);
			System.out.println();
		}
	}

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int edge = scan.nextInt();
		draw(edge);
	}

}