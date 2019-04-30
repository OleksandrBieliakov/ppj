package gui.werner.e07.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class IterFileWrapper implements Iterable<String> {

    private Path filein;
    IterFileWrapper(String filename) {
        filein = Paths.get(filename);
    }

    public Iterator<String> iterator() {
        return new MyIterator(filein);
    }

    class MyIterator implements Iterator<String> {
        private BufferedReader br;
        private String nextLine;

        MyIterator (Path filein) {
            try {
                br = Files.newBufferedReader(filein, UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {
            if(nextLine != null) return true;
            try {
                if((nextLine = br.readLine()) != null) return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public String next() throws NoSuchElementException {
            if(nextLine == null) throw new NoSuchElementException();
            String tmp = nextLine;
            nextLine = null;
            return tmp;
        }
    }
}
