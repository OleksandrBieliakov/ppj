package gui.werner.e04.p3;

import java.util.Iterator;

public class Casino implements Iterable<Integer> {
    public Iterator<Integer> iterator() {
        return new CasinoIterator();
    }

    class CasinoIterator implements Iterator<Integer> {
        int min = 3, a, b, c;

        @Override
        public boolean hasNext() {
            return min-- > 0 || a != b || a != c || b != c;
        }

        @Override
        public Integer next() {
            a = b;
            b = c;
            return c = (int) (Math.random() * 2);
        }
    }
}
