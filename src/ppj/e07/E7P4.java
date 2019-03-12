package ppj.e07;

public class E7P4 {
	
	public static void main (String[] args) {
		
		int [] arr = { 4,3,4,3,6,7,4,8,2,9 };
		int [] brr = { 2,3,6,8,1,5 };
		
		ARR: for (int i = 0; i < arr.length; ++i) {
			
			for (int j = 0; j < brr.length; ++j) {
			
				if (brr[j] == arr[i]) continue ARR; 
			
			}
			
			for (int j = 0; j < i; ++j) {
			
				if (arr[j] == arr[i]) continue ARR; 
			
			} 
			
			System.out.print(arr[i] + " ");
			
		}
	
	}
	
}