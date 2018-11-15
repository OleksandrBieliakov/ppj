import java.util.Random;

public class T6v2 {
	
	public static void main(String[] args) {
		
		int[][] arr = new int[8][8];
		
		Random r = new Random();
		
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
		System.out.println();
		
		
		int[] brr = new int[10];
		
		for(int j = 0; j < arr.length; ++j) {
			++brr[arr[j][j]];
			++brr[arr[j][arr.length - 1 - j]];
		}
		
		for(int n = 0; n < brr.length; ++n) {
			if(brr[n] >= 3)
				System.out.print(n + " ");
		}
		
	}
	
}