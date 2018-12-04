package e7;

public class E7P4v2 {
	
	public static void main(String[] args) {
	
		int[] arr = {4,3,4,3,6,7,4,8,2,9};
		int[] brr = {2,3,6,8,1,5};
		
		int max = arr[0];

		for(int i = 1; i < arr.length; ++i) {
			if(arr[i] > max) max = arr[i];
		}
		
		boolean[] srr = new boolean[max + 1];
		
		for(int j = 0; j < arr.length; ++j) {
			srr[arr[j]] = true;
		}
		
		for(int k = 0; k < brr.length; ++k) {
			if(brr[k] <= max) srr[brr[k]] = false;
		}
		
		for(int l = 0; l < srr.length; ++l)	{
			if(srr[l]) System.out.print(l + " ");
		}
		
	}
	
}