public class Task {
	
	public static void main(String[] args) {
		
		int[][] arr = { {1,2,3}, 
						{4,5,6}, 
						{7,8,9} };
		int[][] brr = { {0,0,1}, 
						{0,1,0}, 
						{1,0,0} };
		
		int[][]crr = new int[arr.length][arr[0].length];
		
		int sum = 0;
		
		for(int i = 0; i < arr.length; ++i) {
			
			for(int j = 0; j < arr.length; ++j) {
				
				System.out.print("[" + i + "," + j + "]: ");
				
				for(int x = 0; x < arr.length; ++x) {
					
					sum += (arr[i][x]* brr[x][j]);
					
					System.out.print(arr[i][x] + " * " + brr[x][j]);
					if(x < 2) System.out.print(" + ");
					
				}
				
				crr[i][j] = sum;
				sum = 0;
				
				System.out.println(" = " + crr[i][j]);
		
			}	
			
		}
		
	}
	
}