package ppj.pointedtasks.ppja26;

import java.io.*;

public class T2 {

    public static void main(String[] args) throws IOException {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("the-file-name.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (writer != null) {
            writer.println("When the dragon’s away, the mice will play");
            writer.close();
        }

        Reader is = new FileReader("the-file-name.txt");
        StringBuilder sb = new StringBuilder();
        String st;
        int read;

        while ((read = is.read()) != -1) {
            sb.append((char)read);
        }

        st = sb.toString();
        System.out.print(st);

    }

}
