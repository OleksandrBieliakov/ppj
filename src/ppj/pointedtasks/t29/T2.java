package ppj.pointedtasks.t29;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T2 {
    public static void main(String[]args) {

        // The program validates e-mails

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        String reg = "\\w+@\\w+(\\.\\w+)+";

        Matcher m = Pattern.compile(reg).matcher(s);

        System.out.println(s + ": " + m.matches());

    }
}
