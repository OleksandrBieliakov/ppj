package gui.werner.e04.p2;

import java.util.Iterator;

public class Hailstone implements Iterable<Integer> {
    private int a;

    public Hailstone(int a) {
        this.a = a;
    }

    public Iterator<Integer> iterator() {
        return new HailstoneIterator(a);
    }

    class HailstoneIterator implements Iterator<Integer> {
        private int a;

        HailstoneIterator(int a) {
            this.a = a;
        }

        @Override
        public boolean hasNext() {
            System.out.print(a + " ");
            return a > 1;
        }

        @Override
        public Integer next() {
            if (a % 2 == 0) return a /= 2;
            return a = a * 3 + 1;
        }
    }

}
