package pointedtasks.t29;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T1 {

    public static void main(String[] args) {

        String reg = "(\\d+)-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01]))";
        String text = "2019-01-31";
        Matcher m = Pattern.compile(reg).matcher(text);
        System.out.println(text + ": " + m.matches());
        text = "2019-12-01";
        m.reset(text);
        System.out.println(text + ": " + m.matches());

    }

}
