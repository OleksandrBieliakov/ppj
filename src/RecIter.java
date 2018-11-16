public class RecIter {
	
	public static int fiboR(int n) {
		int fn = 0;
		if(0 <= n && n < 2) return n;
		else fn = fiboR(n-1) + fiboR(n - 2); 
		return fn;
	}
	
	public static int fiboI(int n) {
		int fn = 0;
		int fn1 = 1;
		int fn2 = 0;
		if(0 <= n && n < 2) return n;
		else 
			for(int i = 2; i <= n; ++i) {
				fn = fn1 + fn2;
				fn2 = fn1;
				fn1 = fn;
			}
		return fn;
	}
	
	public static int factR(int n) {
		int fac = 0;
		if(n == 0) return 1;
		else fac = n * factR(n-1);
		return fac;
	}
	
	public static int factI(int n) {
		int fac = 0;
		int fac1 = 1;
		if(n == 0) return 1;
		else
			for(int i = 1; i <= n; ++i) {
				fac = i * fac1;
				fac1 = fac;
			}
		return fac;	
	}
	
	public static int gcdR(int a, int b) {
		if(a > b) a -= b;
		else if(b > a) b -= a;
		if(a != b) return gcdR(a, b);
		return a;
	}

	public static int gcdI(int a, int b) {
		while(a != b) {
			if(a > b) a -= b;
			else b -= a;
		}
		return a;
	}
		
	public static int maxElem(int[] arr, int from, int to) {
		if(from == to - 1) return arr[from];
		else {
        if(Math.max(arr[from], arr[to - 1]) == arr[from])
			return maxElem(arr, from, --to);
		else
			return maxElem(arr, ++from, to);
		}
	}
	
	public static void reverse(int[] arr, int from, int to) {
		if(from < to - 1) {
			int t = arr[from];
			arr[from] = arr[to - 1];
			arr[to - 1] = t;
			reverse(arr, ++from, --to);
		}
	}
	
	public static boolean isPalindrom(String s) {
		if(s.length() > 1) {
			if(s.charAt(0) == s.charAt(s.length() - 1)) {
				isPalindrom(s.substring(1, s.length() - 1));
			} else return false;
		}
		return true;
	}
		
}