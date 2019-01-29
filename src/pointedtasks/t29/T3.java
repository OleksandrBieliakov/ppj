package pointedtasks.t29;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T3 {

    public static void main(String[]args) {

        //The program reads the file "serverLog" and prints IPv4s found in the file

        String s = "";

        try {
            FileReader fr = new FileReader("data/serverLog");
            int read;
            StringBuffer sb = new StringBuffer();
            while ((read = fr.read()) != -1) {
                sb.append((char)read);
            }
            s = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String reg = "(((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))+\\.){3}((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))+";

        Matcher m = Pattern.compile(reg).matcher(s);

        int count = 1;
        while (m.find()) {
        System.out.println(count++ + ": " + m.group());
        }

    }
}
