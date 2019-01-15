// Java Program to illustrate reading from
// FileReader using FileReader
package readfile;

import java.io.FileReader;

public class Readfile2 {

    public static void main(String[] args) throws Exception {
        // pass the path to the file as a parameter
        FileReader fr = new FileReader("data/text.txt");

        int i;
        while ((i=fr.read()) != -1)
            System.out.print((char)i);

    }

}
