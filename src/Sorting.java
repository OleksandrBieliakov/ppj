import java.util.Random;

public class Sorting {
	
	// compares and iterchages each element of an array
	public static int[] sortArr(int[] arr) {
		for(int i = 0; i < arr.length-1; ++i) {
			for(int j = i+1; j < arr.length; ++j) {
				if(arr[i] > arr[j]) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
					return sortArr(arr);
				}
			}
		}
		return arr;
	}
	
	// compares and interchanges each element of two arrays
	public static int[] twoArrs(int[] arr1, int[] arr2) {
		arr1 = sortArr(arr1);
		arr2 = sortArr(arr2);
		for(int i = 0; i < arr1.length; ++i) {
			for(int j = 0; j < arr2.length; ++j) {
				if(arr1[i] > arr2[j]) {
					int t = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = t;
					return twoArrs(arr1, arr2);
				} 
			}
		}
		
		// merges two arrays
		int[] brr = new int[arr1.length + arr2.length];
		for(int n = 0; n < arr1.length; ++n) {
			brr[n] = arr1[n];
		}
		for(int m = 0; m < arr2.length; ++m) {
			brr[m + arr1.length] = arr2[m];
		}
		return brr;
	}
	
	// glues sorted halves back
	public static int[][] stitchArr(int[][] arr, int count) {
		if(count < 1) return arr;
		int[][] brr = new int[arr.length/2][];
		for(int i = 0; i < brr.length; ++i) {
			brr[i] = twoArrs(arr[i*2], arr[i*2+1]);
		}
		return stitchArr(brr, --count);
	}
	
	// divedes an array into halves and halves into halves
	public static int[][] tearArr(int[][] arr, int count) {
		if(count < 1) return arr;
		int[][] brr = new int[arr.length*2][];
		for(int i = 0; i < arr.length; ++i) {
			brr[i*2] = new int[arr[i].length/2];
			brr[i*2+1] = new int[arr[i].length/2 + arr[i].length%2];
			for(int j = 0; j < arr[i].length/2; ++j) {
				brr[i*2][j] = arr[i][j];
			}
			for(int k = arr[i].length/2; k < arr[i].length; ++k) {
				brr[i*2+1][k - arr[i].length/2] = arr[i][k];
			}
		}
		return tearArr(brr, --count);
	}
	
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int[] arr = new int[100];
		
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = r.nextInt(101);
		}
			
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
		
		// counts how many time an array can be divided by 2
		int count = 0;
		int div = arr.length;
		while(div > 1) {
			div >>>= 1;
			++count;
		}
		System.out.println(count);
		
		// turning arr into a twodimentional array
		int[][] arr1 = new int [1][arr.length];
		for(int i = 0; i < arr.length; ++i) {
			arr1[0][i] = arr[i];
		}
		
		int[][] brr = stitchArr(tearArr(arr1, count), count);
		
		int[] brr1 = brr[0];
		
		for(int i : brr1)
			System.out.print(i + " ");
	
	}
	
}