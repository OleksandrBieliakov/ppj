import java.util.Random;

public class Sorting2 {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int[] arr = new int[100];
			
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = r.nextInt(101);
		}
				
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	
	}
	
}
