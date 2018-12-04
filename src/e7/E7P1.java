package e7;

public class E7P1 {
	
	public static void print(int[] arr) {
	for(int i = 0; i < arr.length; ++i)	
		System.out.print(arr[i] + " ");
	}
	
	public static void main(String[] args) {
		
		int[] arr = {0,1,2,3,4,5}; 
		
		print(arr);
		System.out.println();
		
		int j = 0;
		int k = arr.length - 1;
		
		while(j < arr.length && arr[j]%2 == 0) ++j;
		while(k >= 0 && arr[k]%2 != 0) --k;
		
		if(j == arr.length)
			System.out.println("All numbers are even");
		else if(k < 0)
			System.out.println("All numbers are odd");
		else {
			int t = arr[j];
			arr[j] = arr[k];
			arr[k] = t;
			print(arr);
		}
		
	}
	
}