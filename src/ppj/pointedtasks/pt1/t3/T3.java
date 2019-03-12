package ppj.pointedtasks.pt1.t3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class T3 {

    private static void print (int[] arr) throws ArrayIndexOutOfBoundsException {
        for(int i = 0; i < arr.length + 1; ++i) {
            System.out.print(arr[i]);
        }
    }

    private static void readfile() throws FileNotFoundException {
        File file = new File("C:\\Projects\\null.txt");
        if(file == null)
            throw new FileNotFoundException();
        Scanner sc = new Scanner(file);
        String s = sc.nextLine();
        System.out.println(s);
    }

    private static void unit (String unit) throws Exception {
        if(!unit.equals("Kilo"))
            throw new Exception("wrong unit");
    }

    public static void main (String[] args) {

        int[] arr = {1,2,3};

        try {
            print(arr);
            readfile();
            unit("Pound");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Array ind out of bounds");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (Exception ex){
            System.out.println("ex");
        }

    }
}
