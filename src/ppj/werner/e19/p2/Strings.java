package ppj.werner.e19.p2;

import java.io.FileInputStream;
import java.io.IOException;


public class Strings {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java Strings fileName [min ASCII string length (default 4)]\n" +
                    "Example: java Strings Hello.class 5");
            return;
        }

        String fileName = args[0];
        int n = args.length > 1 ? Integer.parseInt(args[1]) : 4;

        List list = new List();

        try {
            FileInputStream is = new FileInputStream(fileName);
            int read;
            int count = 0;
            StringBuffer sb = new StringBuffer();
            while((read = is.read()) != -1) {
                if(read > 31 && read < 127){
                    sb.append((char)read);
                    count++;
                } else {
                    if (count >= n)
                        list.add(sb.toString());
                    sb = new StringBuffer();
                    count = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.toFile(args[0].substring(0, args[0].indexOf(".")));

    }

}
