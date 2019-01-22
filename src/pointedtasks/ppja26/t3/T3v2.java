package pointedtasks.ppja26.t3;

import java.io.*;
import java.util.Scanner;

public class T3v2 {

    public static void main(String[] args) throws IOException {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("the-file-name.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer smaller than 16777216"); //16777216=2^(32-8) because of the reading loop construction
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        if (writer != null) {
            if (n == 0) {
                writer.print((char)(n & 0b1111_1111));
            } else {
                do {
                    sb.insert(0, (char)(n & 0b1111_1111));
                    n >>>= 8;
                } while (n != 0);
                writer.print(sb.toString());
            }
            writer.close();
        }

        Reader is = new FileReader("the-file-name.txt");
        sb = new StringBuilder();
        String st;
        int read;
        int m = 0;

        while ((read = is.read()) != -1) {
            sb.append((char)read);
            m |= read;
            m <<= 8;
        }
        m >>>= 8;

        st = sb.toString();
        System.out.println(st);
        System.out.println(m);

    }

}