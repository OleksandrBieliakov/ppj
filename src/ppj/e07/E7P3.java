package ppj.e07;

public class E7P3 {
	
	public static void print(int[] arr) {
	for(int i = 0; i < arr.length; ++i)	
		System.out.print(arr[i] + " ");
	}
	
	public static void main (String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		print(arr);
		System.out.println();
		
		int t = arr[0];

		for(int i = 1; i < arr.length; ++i) {
			arr[i-1] = arr[i];
		}
		
		arr[arr.length-1] = t;
		
		print(arr);
		
	}
	
}
