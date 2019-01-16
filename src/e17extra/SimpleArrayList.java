package e17extra;

import java.util.Arrays;

public class SimpleArrayList {

    private final static int INITIAL_CAPACITY = 5;
    private int cap = INITIAL_CAPACITY;
    private int size = 0;
    private int[] arr = new int[cap];


    public SimpleArrayList() {}

    public SimpleArrayList(int val) {
        size = 1;
        arr[0] = val;
    }

    public SimpleArrayList(int[] vals) {
        size = vals.length;
        if(cap < size) {
            cap = 2*size;
            arr = new int[cap];
        }
        System.arraycopy(vals, 0, arr, 0, size);
    }

    public SimpleArrayList(SimpleArrayList other) {
        size = other.size();
        if(size > cap){
            cap = 2*size;
            arr = new int[cap];
        }
        System.arraycopy(other.arr(), 0, arr, 0, size);
    }

    public int size(){return size;}
    public int[] arr() {return Arrays.copyOf(arr, size);}

    public void incrCap (int newSize) {
        int[] tmp = arr;
        cap = 2*newSize;
        arr = new int[cap];
        System.arraycopy(tmp, 0, arr, 0, size);
    }

    public void clean() {
        cap = INITIAL_CAPACITY;
        size = 0;
        arr = new int[cap];
    }

    public void trim() {
        cap = size;
        int [] tmp = arr;
        arr = new int[cap];
        System.arraycopy(tmp, 0, arr, 0, size);
    }

    public SimpleArrayList insert(int ind, int[] other) {
        if(ind > size || ind < 0)
            throw new IndexOutOfBoundsException();
        int sz = other.length;
        if((sz + size) > cap) incrCap(sz+size);
        if(ind < size)
            System.arraycopy(arr, ind, arr, ind + sz, size - sz);
        System.arraycopy(other, 0, arr, ind, sz);
        size += sz;
        return this;
    }

    public SimpleArrayList insert(int ind, int e) {
        return insert(ind, new int[] {e});
    }

    public SimpleArrayList append(int e) {
        return insert(size, new int[] {e});
    }

    public SimpleArrayList append(int[] a) {
        return insert(size, a);
    }

    public SimpleArrayList append(SimpleArrayList a) {
        return insert(size, a.arr());
    }

    public int get(int ind) {
        if (ind > size - 1)
            throw new IndexOutOfBoundsException();
        return arr[ind];
    }

    public SimpleArrayList set(int ind , int val) {
        if (ind > size - 1)
            throw new IndexOutOfBoundsException();
        arr[ind] = val;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int a : arr())
            s.append(a + " ");
        return "Cap=" + cap + ", size=" + size + ": [ " + s.toString() + "]";
    }

}
