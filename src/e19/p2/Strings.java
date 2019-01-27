package e19.p2;

import java.io.FileInputStream;
import java.io.IOException;


public class Strings {

    public static void main(String[] args) {

        int n = 4;
        List list = new List();

        try {
            FileInputStream is = new FileInputStream("data/Hello.class");
            int read;
            int count = 0;
            StringBuffer sb = new StringBuffer();
            while((read = is.read()) != -1) {
                if(read > 31 && read < 127){
                    sb.append((char)read);
                    count++;
                } else if(count >= n){
                    list.add(sb.toString());
                    sb = new StringBuffer();
                    count = 0;
                } else {
                    sb = new StringBuffer();
                    count = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.show();

    }

}
