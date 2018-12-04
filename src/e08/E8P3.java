package e08;

public class E8P3 {
	
	public static int[] getArr(int arr[][]) {
		int[] brr = {0,0};
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[i].length; ++j) {
				if(arr[i][j]%2 == 0) ++brr[0];
				else ++brr[1];
			}
		}
		return brr;		
	}
	
	public static void main(String[] args) {
		
		int[][] arr = { {1,2,3,4,5}, {1,9}, {3,1,8} };
		
		int[] brr = getArr(arr);
		
		System.out.println("Even: " + brr[0] + "; odd: " + brr[1]);
		
	}
	
}