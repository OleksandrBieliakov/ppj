package mergesort;

import java.util.Random;

public class MergeSortingFather {

    /**
     * Sort by merge sorting algorithm.
     *
     * @param arr random array of int elements, possibly duplicated
     * @return sorted array
     */
    public static int[] sort(int[] arr) {
        int arrLen = arr.length;
        //if the length of array 3 or more then split it into 2 (possibly not equal) parts,
        //sort each part and merge them
        if (arrLen > 2) {
            int aLen = arrLen / 2;
            int bLen = arrLen - aLen;
            int[] a = new int[aLen];
            int[] b = new int[bLen];
            for (int i = 0; i < aLen; i++) {
                a[i] = arr[i];
            }
            for (int i = 0; i < bLen; i++) {
                b[i] = arr[aLen + i];
            }
            //recursive call
            return merge(sort(a), sort(b));
        } else {
            //the real sorting happens in this point only
            //check and swap elements if there are 2 elements.
            //return as is if there is only one element in array
            if (arrLen == 2) {
                if (arr[1] < arr[0]) {
                    int t = arr[1];
                    arr[1] = arr[0];
                    arr[0] = t;
                }
            }
            return arr;
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int al = a.length;
        int bl = b.length;
        int[] c = new int[al + bl];
        int i = 0, j = 0, k = 0;
        //take the smallest element from the head of "left" or "right" SORTED array
        while (i < al && j < bl)
            c[k++] = a[i] <= b[j] ? a[i++] : b[j++];
        //attach the rest of elements if any remains in "right" OR "left" array
        while (i < al)
            c[k++] = a[i++];
        while (j < bl)
            c[k++] = b[j++];
        return c;
    }

    public static void main(String[] args) {

        //int[] arr = new int[]{5, 7, 1, 9, 8, 2, 4, 6, 3, 7};

        Random r = new Random();
        int[] arr = new int[100];

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = r.nextInt(101);
        }

        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        int[] brr = sort(arr);

        for (int i : brr)
            System.out.print(i + " ");

    }

}