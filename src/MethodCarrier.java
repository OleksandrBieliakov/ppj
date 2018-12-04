public class MethodCarrier {
	
	public static void main (String[] args) {
	
		draw(5);
	
	}
	
	public static void draw(int edge) {
		
		for(int i = edge; i > edge/2; --i) {
			
			for(int j = edge; j > edge/2; --j) {
				System.out.print(((edge - i) + (edge -j)) + " ");
			}
			for(int j = edge/2; j < edge; ++j) {
				System.out.print(((edge - i) + (edge -j)) + " ");
			}
			System.out.println();
		
		}
		
		for(int i = edge/2; i < edge; ++i) {
			
			for(int j = edge; j > edge/2; --j) {
				System.out.print(((edge - i) + (edge -j)) + " ");
			}
			for(int j = edge/2; j < edge; ++j) {
				System.out.print(((edge - i) + (edge -j)) + " ");
			}
			System.out.println();
			
		}
		
	}
	
}