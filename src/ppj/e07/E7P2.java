package ppj.e07;

public class E7P2 {
	
	public static void main(String[] args) {
		
		int[] arr = {1,5,8,2,6};
		
		int max = arr[0];
		for(int i = 1; i < arr.length; ++i) {
			if(arr[i] > max) max = arr[i];
		}
		
		for(int j = max; j > 0; --j) {
			for(int k = 0; k < arr.length; ++k) {
				System.out.print(arr[k] >= j ? "*" : " ");
			}
			System.out.println();
		}
		
	}
	
}