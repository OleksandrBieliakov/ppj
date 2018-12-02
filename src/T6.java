import java.util.Random;

public class T6 {
	
	public static void print(int prr[]) {
		for(int n = 0; n < prr.length; ++n) {
			if(prr[n] >= 3)
				System.out.print(n + " ");
		}
	}
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int[][] arr = new int[8][8];
		
		for(int i = 0; i < arr.length; ++i) {
			for(int f = 0; f < arr[i].length; ++f) {
				arr[i][f] = r.nextInt(10);
			}
		}
		
		for(int x = 0; x < arr.length; ++x) {
			for(int y = 0; y < arr[x].length; ++y) {
				System.out.print(arr[x][y] + " ");
			}
			System.out.println();
		}
				
		int[] brr = new int[10], crr = new int[10];
		
		for(int j = 0; j < arr.length; ++j) {
			++brr[arr[j][j]];
			++crr[arr[j][arr.length - 1 - j]];
		}
	
		System.out.println();
		print(brr);
		System.out.println();
		print(crr);
		
	}
	
}