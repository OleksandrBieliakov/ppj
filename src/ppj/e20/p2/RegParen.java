package ppj.e20.p2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegParen {

    public static void main (String[] args) {

        String str = "Lisboa (Lisbon , Portugal), " +
                "Warszawa (Warsaw, Poland), and " +
                "Roma (Rome,Italy)";

        String pat = "\\((\\w+) *, *(\\w+)\\)";
        Matcher m = Pattern.compile(pat).matcher(str);

        while (m.find()) {
            System.out.println(m.group(2) + " -> " + m.group(1));
        }

    }

}
