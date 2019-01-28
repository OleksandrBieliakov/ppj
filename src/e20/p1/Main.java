package e20.p1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[]args) {

        List list = new List();
        String reg = "(https://|http://|www\\.)\\w+\\.\\w+";
        Matcher m = Pattern.compile(reg).matcher("");
        String s;


        try (FileReader reader = new FileReader("data/e20p1")) {
            StringBuffer sb = new StringBuffer();
            int read;
            while((read = reader.read()) != -1) {
                if((read == ' ' || read == '\n') && sb.length() != 0){
                    s = sb.toString();
                    m.reset(s);
                    if(m.matches())
                        list.add(s);
                    sb = new StringBuffer();
                }
                else sb.append((char)read);
            }
            if(sb.length() != 0) {
                s = sb.toString();
                m.reset(s);
                if (m.matches())
                    list.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.print();

    }

}
