package ppj.pointedtasks.ppja26.t1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

        try {
            InputStream is = new FileInputStream("data/text");
            MyScanner ist = new MyScanner(is);

            System.out.println("word: " + ist.readWord());
            System.out.println("line: " + ist.readLine());
            System.out.println("integer: " + ist.readInteger());
            System.out.println("positive integer: " + ist.readPositiveInteger());
            System.out.println("positive integer: " + ist.readPositiveInteger());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
