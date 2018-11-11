public class E8P2 {
	
	public static int[] getArr(int arr[][]) {
		
		int[] brr = new int[arr.length];
		
		for(int j = 0, max = 0b11111111111111111111111111111111; j < arr.length; ++j) {
			for(int k = 0; k < arr[j].length; ++k) {
				if(arr[j][k] > max) {
					max = arr[j][k];
				}				
			}
			brr[j] = max;
			max = 0b11111111111111111111111111111111;
		}
		
		return brr;
		
	}
	
	public static void main(String[] args) {
		
		int[][] arr = { {1,3}, {3,4,5,8}, {6,8}, {1,9,6} };
		
		int[] brr = getArr(arr);
		
		for(int i = 0; i < brr.length; ++i) {	
			System.out.print(brr[i] + " ");
		}
		
	}
	
}