package ppj.e08;

public class E8P2v2 {
	
	public static boolean check(int arr[][]) {
		
		boolean valid = true;
		
		if(arr.length == 0) return valid = false;
		
		for(int m = 0; m < arr.length; ++m) {
			if(arr[m].length == 0) return valid = false;
		}
		return valid;
	}

    public static int[] getArr(int arr[][]) {

        int[] brr = new int[arr.length];

        for(int j = 0; j < arr.length; ++j) {
            brr[j] = arr[j][0];
            for(int k = 1; k < arr[j].length; ++k) {
                if(arr[j][k] > brr[j]) {
                    brr[j] = arr[j][k];
                }
            }
        }
        return brr;
    }
	
    public static void main(String[] args) {

        int[][] arr = { {1,3}, {3,4,5,8}, {6,8}, {1,9,6} };
		
		if(check(arr)) {
		
			int[] brr = getArr(arr);

			for(int i = 0; i < brr.length; ++i) {
				System.out.print(brr[i] + " ");
			}
			
		} else System.out.println("Invalid values of the array." + 
								"\nThe array can`t contain any empty elements.");

    }

}