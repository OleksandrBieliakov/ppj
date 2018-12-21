package pointedtasks.t2;

import java.io.File;
import java.util.Scanner;

public class Read {

    public static void main (String[] args) throws Exception {

        File file = new File("C:\\Projects\\t3.txt");
        Scanner sc = new Scanner(file);

        String s = sc.nextLine();

        System.out.println(s);
    }

}
