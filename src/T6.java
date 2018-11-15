import java.util.Random;

public class T6 {
	
	public static void print(int prr[]) {
		for(int n = 0; n < prr.length; ++n) {
			if(prr[n] >= 3)
				System.out.print(n + " ");
		}
	}
	
	public static void main(String[] args) {
		
		int[][] arr = new int[8][8];
		
		Random r = new Random();
		
		for(int i = 0; i < arr.length; ++i) {
			for(int f = 0; f < arr[i].length; ++f) {
				arr[i][f] = r.nextInt(10);
			}
		}
		
		int[] brr = new int[10];
		
		for(int j = 0; j < arr.length; ++j) {
			++brr[arr[j][j]];
		}
		
		int[] crr = new int[10];
		
		for(int k = 0; k < arr.length; ++k) {
			++crr[arr[k][arr.length - 1 - k]];
		}

		for(int x = 0; x < arr.length; ++x) {
			for(int y = 0; y < arr[x].length; ++y) {
				System.out.print(arr[x][y] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		print(brr);
		System.out.println();
		print(crr);
		
	}
	
}