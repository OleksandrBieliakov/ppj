package e19.p2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Strings2 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java Strings fileName [min ASCII string length (default 4)]\n" +
                    "Example: java Strings Hello.class 5");
            return;
        }

        String fileName = args[0];
        int n = args.length > 1 ? Integer.parseInt(args[1]) : 4;

        //using of Set guaranties no duplicates
        Set<String> strings =  new HashSet<>();

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
                        strings.add(sb.toString());
                    sb = new StringBuffer();
                    count = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //make the list from set
        ArrayList<String> list = new ArrayList<>(strings);
        //sort the list, optionally case insensitive (consider to introduce the command line parameter)
        list.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(String.join("\n", list));
    }

}
