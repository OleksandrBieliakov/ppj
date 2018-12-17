// Java Program to illustrate reading from Text File
// using Scanner Class
package readfile;

import java.io.File;
import java.util.Scanner;

public class Readfile1 {

        public static void main (String[] args) throws Exception {

            // pass the path to the file as a parameter
            File file = new File("C:\\Projects\\Hello.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        }

}
