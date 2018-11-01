public class E6P2 {
	
	static int maxOfThree(int a, int b, int c) {
		return a < b ? (b < c ? c : b) : (a < c ? c : a);
	}
	
	static int greatestDivisor(int n) {
		if (n == 1) return 1;
		int i = n -1;
		while(n%i != 0) --i;
		return i;
	}
	
	static boolean areRelativelyPrime(int a, int b) {
		while(a != b) {
			if (a > b) a -= b;
			else b -= a;
		}
		return a == 1;		
	}
	
	static boolean isPerfect(int n){
		int sum = 0;
		for(int i = n - 1; i != 0; --i) {
			if (n%i == 0) sum += i;				
		}
		return sum == n;
	}
	
	public static void main(String[] args) {
		
		int x = 2, y = 3, z = 1;
		
		System.out.println("Max of " + x + ", " + y + ", " + z + " is " + maxOfThree(x, y, z));
		
		for(int a = 12; a < 16; ++a)
			System.out.println("Greatest divisor of " + a + " is " + greatestDivisor(a));
		
		for(int m = 11, n = 5; m >= 3; m -= 2, n += 2)
			if (areRelativelyPrime(m, n))
				System.out.println(m + " and " + n + " are relatively prime");
			
		for(int m = 2; m <= 100; ++m)
			if(isPerfect(m))
				System.out.println(m + " is perfect");
			
	}
	
}
