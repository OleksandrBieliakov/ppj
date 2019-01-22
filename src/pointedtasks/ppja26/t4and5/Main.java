package pointedtasks.ppja26.t4and5;

import java.io.*;

public class Main {

    public static void readFile(String fileName) {
        InputStream is;
        try {
            is = new FileInputStream(fileName);
            int read;
            while ((read = is.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName, FruitsList list) {
        PrintWriter pw;
        try {
            pw = new PrintWriter(fileName);
            while (!list.empty())
                pw.println(list.pop());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static FruitsList fileToList(String fileName) {
        FruitsList list = new FruitsList();
        InputStream is;
        try {
            is = new FileInputStream(fileName);
            int read;
            StringBuffer sb = new StringBuffer();
            int seeds = 0;
            while ((read = is.read()) != -1) {
                if(read == '\n') {
                    list.push(sb.toString(), seeds);
                    sb = new StringBuffer();
                    seeds = 0;
                } else if (read >= 'A') {
                    sb.append((char)read);
                } else if (read >= '0' && read <= '9') {
                    seeds *= 10;
                    seeds += read - '0';
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main (String[] args) {

        FruitsList list = new FruitsList();
        String fileName = "fruits.txt";

        list.push("Watermellon", 153869);
        list.push("Apple", 6);

        writeFile(fileName, list);

        readFile(fileName);
        System.out.println();

        String fileName2 = "fruits2.txt";
        writeFile(fileName2, fileToList(fileName));
        readFile(fileName2);

    }

}
