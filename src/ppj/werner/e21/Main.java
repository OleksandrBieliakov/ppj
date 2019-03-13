package ppj.werner.e21;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void countPrint(String reg, String text) {
        Pattern pat = Pattern.compile(reg);

        Matcher m = pat.matcher(text);

        int count = 0;
        while(m.find()) {
            count++;
        }

        System.out.print(count + " ");
    }

    public static String makeReg(int n, int k) {
        StringBuilder sb = new StringBuilder("\\b\\w{,}\\b");

        sb.insert(6, k);
        sb.insert(5, n);

        return sb.toString();
    }

    public static String makeReg(int n) {
        StringBuilder sb = new StringBuilder("\\b\\w{,}\\b");

        sb.insert(5, n);

        return sb.toString();
    }

    public static void main (String[] args) {

        String text = "";

        try {
            FileReader fr = new FileReader("data/task21.txt");
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = fr.read()) != -1) {
                sb.append((char)i);
            }
            text = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(text + "\n");

        ////////////////////////////////////////////////

        Scanner scan = new Scanner(System.in);
        String limSt = scan.nextLine();

        String[] limStArr = limSt.split("\\s+");
        int len = limStArr.length;
        int[] lim = new int[len];

        for(int i = 0; i < len; ++i) {
            lim[i] = limStArr[i].charAt(0) - '0'; //ASCI trick
        }

        ////////////////////////////////////////////////

        String reg = makeReg(1, lim[0]);
        countPrint(reg, text);

        for(int i = 1; i < len; ++i ) {
            reg = makeReg(lim[i-1]+1, lim[i]);
            countPrint(reg, text);
        }

        reg = makeReg(lim[len-1]+1);
        countPrint(reg, text);

    }

}
