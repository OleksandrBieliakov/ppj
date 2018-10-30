public class E5P3 {
	
	public static void main(String[] args) {
		
			info(encode(130999, 101, 7777, 99, 7000,6));
		
	}
	
	public static long encode (int caller, int caller_zone, 
							   int callee, int callee_zone,
							   int duration, int tariff) {
		
		long res = 0;
		
		long temp = caller;
		temp <<= 47;
		res |= temp;
		
		temp = caller_zone;
		temp <<= 40;
		res |= temp;
		
		temp = callee;
		temp <<= 23;
		res |= temp;
		
		temp = callee_zone;
		temp <<= 16;
		res |= temp;
		
		temp = duration;
		temp <<= 3;
		res |= temp;
		
		res |= tariff;
		
		return res;
		
	}
	
	public static void info(long res) {
		
		long temp = res;
		temp >>>= 47;
		
		System.out.printf("%13s", "Caller: ");
		System.out.println(temp);
		
		temp = res;
		temp >>>= 40;
		temp &= 0b1111111;
		
		System.out.printf("%13s", "Caller zone: ");
		System.out.println(temp);
		
		temp = res;
		temp >>>= 23;
		temp &= 0b11111111111111111;
		
		System.out.printf("%13s", "Callee: ");
		System.out.println(temp);
		
		temp = res;
		temp >>>= 16;
		temp &= 0b1111111;
		
		System.out.printf("%13s", "Callee zone: ");
		System.out.println(temp);
		
		temp = res;
		temp >>>= 3;
		temp &= 0b1111111111111;
		
		System.out.printf("%13s", "Duration: ");
		System.out.println(temp);
		
		res &= 0b111;
		
		System.out.printf("%13s", "Tariff: ");
		System.out.println(res);
		
	}
	
}