public class E5P3 {
	
	public static void main(String[] args) {
		
			info(encode(130999, 101, 7777, 99, 7000,6));
		
	}
	
	public static long encode (int caller, int caller_zone, 
							   int callee, int callee_zone,
							   int duration, int tariff) {
		
		return    (long) tariff << 61
				| (long) duration << 48
				| (long) callee_zone << 41
				| (long) callee << 24
				| (long) caller_zone << 17
				| (long) caller;
				
	}
	
	public static void info(long res) {
		
		long caller = res & 0b11111111111111111;
		long caller_zone = res >> 17 & 0b1111111;
		long callee = res >> 24 & 0b11111111111111111;
		long callee_zone = res >> 41 & 0b1111111;
		long duration = res >> 48 & 0b1111111111111;
		long tariff = res >> 61 & 0b111;
		
		print("Caller:", caller);
		print("Caller zone:", caller_zone);
        print("Callee:", callee);
        print("Callee zone:", callee_zone);
        print("Duration:", duration);
        print("Tariff:", tariff);
		
	}
	
	public static void print (String name, long value) {
		
		System.out.printf("%-12s %7d\n", name, value);
		
	}
	
}