package ppj.pointedtasks.ppja26.t1;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.Integer.parseInt;

public class MyScanner {

    private InputStream is;

    public MyScanner(InputStream is) {
        this.is = is;
    }

    public String readWord() throws IOException {
        int read;
        StringBuilder sb = new StringBuilder();
        while((read = is.read()) != -1) {
            if(read == 32 || read == '\n') return sb.toString();
            sb.append((char)read);
        }
        return sb.toString();
    }

    public String readLine() throws IOException{
        int read;
        StringBuilder sb = new StringBuilder();
        while((read = is.read()) != -1) {
            if(read == '\n') return sb.toString();
            sb.append((char)read);
        }
        return sb.toString();
    }

    public int readInteger() throws IOException {
        int i;
        try {
            return parseInt(readWord());
        }
        catch (NumberFormatException e) {
            i = readInteger();
        }
        return i;
    }

    public int readPositiveInteger() throws IOException {
        int integer = parseInt(this.readWord());
        if(integer < 1) throw new IOException(integer + " is not a positive number");
        return integer;
    }

}
