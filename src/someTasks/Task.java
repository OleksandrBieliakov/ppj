package someTasks;

public class Task {
	
	public static void main(String[] args) {
		
		int[][] arr = { {1,2,3}, 
						{4,5,6}, 
						{7,8,9} };
		int[][] brr = { {0,0,1}, 
						{0,1,0}, 
						{1,0,0} };

		int len = arr.length;
		int[][]crr = new int[len][arr[0].length];
		
		int sum = 0;
		
		for(int i = 0; i < len; ++i) {
			
			for(int j = 0; j < len; ++j) {
				
				System.out.print("[" + i + "," + j + "]: ");
				
				for(int x = 0; x < len; ++x) {
					
					sum += (arr[i][x]* brr[x][j]);

					if(x > 0) System.out.print(" + ");
					System.out.print(arr[i][x] + " * " + brr[x][j]);

				}
				
				crr[i][j] = sum;
				sum = 0;
				
				System.out.println(" = " + crr[i][j]);
		
			}	
			
		}
		
	}
	
}