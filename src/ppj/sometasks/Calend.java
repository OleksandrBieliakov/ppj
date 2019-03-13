package ppj.sometasks;

import java.util.Calendar;

public class Calend {
	
	public static void main (String[] args) {
	
	Calendar now = Calendar.getInstance();
	
	int y = now.get(Calendar.YEAR);
	int m = now.get(Calendar.MONTH);
	int d = now.get(Calendar.DATE);
	
	System.out.println(d + "." + (m + 1) + "." +y);
		
	if (m > 1 && (y%400 == 0 || (y%100 != 0 && y%4 == 0))) ++d;
	
	
	if (m == 1 || m == 5 || m == 6) ++d;
	else if (m == 2) --d;
	else if (m == 7) d += 2;
	else if (m == 8 || m == 9) d +=3;
	else if (m == 10 || m == 11) d += 4;
	
	System.out.println("Day of the year: " + (m*30 + d));
	
	}
	
}