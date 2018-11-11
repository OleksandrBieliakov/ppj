public class E8P1 {
	
	public static void index (int[][] arr) {
		
		int rowM = 0, rowMi = Integer.MIN_VALUE;
		
		for(int i = 0, rowS = 0; i < arr.length; ++i) {
			
			for(int j = 0; j < arr[i].length; ++j) {
				rowS += arr[i][j];
			}
			
			if(rowS > rowM) {
				rowM = rowS;
				rowMi = i;
			}
			
			rowS = 0;
			
		}
		
		int colM = 0, colMi = Integer.MIN_VALUE;
		
		for(int k = 0, colS = 0; k < arr[0].length; ++k) {
			
			for(int m = 0; m < arr.length; ++m) {
				colS += arr[m][k];
			}
			
			if(colS > colM) {
				colM = colS;
				colMi = k;
			}
			
			colS = 0;
			
		}
		
		System.out.println("row: " + rowMi + "\ncolumn: " + colMi);
		
	}
	
	public static void main(String[] args) {
		
		int[][] arr = { {1,3,2}, {3,4,8}, {2,6,8}, {1,8,5} };
		
		index(arr);
		
	}
	
}
