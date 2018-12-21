package mergesort;

import java.util.Arrays;

public class MergeSort {

    private static int[] sortMerge(int[] a1, int[] a2) {
        int[] arr = new int [a1.length + a2.length];
        int next = 0;
        int i1 = 0;
        int i2 = 0;
        MAIN_LOOP:
        while (i1 < a1.length) {
            for (int i = i2; i < a2.length; ++i){
                if (a2[i] < a1[i1]){
                    arr[next++] = a2[i];
                    ++i2;
                } else if (a2[i] > a1[i1]) {
                    arr[next++] = a1[i1++];
                    continue MAIN_LOOP;
                }
            }
            arr[next++] = a1[i1++];
        }
        if (i1 < a1.length){
            for (int i = i1; i < a1.length; ++i) {
                arr[next++] = a1[i];
            }
        } else if (i2 < a2.length){
            for (int i = i2; i < a2.length; ++i) {
                arr[next++] = a2[i];
            }
        }
        return arr;
    }

    private static int[] splitMerge (int[] arr) {
        int l = arr.length;
        if(l < 2) return arr;
        int[] a1 = Arrays.copyOfRange(arr, 0, l/2);
        int[] a2 = Arrays.copyOfRange(arr, l/2, l);
        a1 = splitMerge(a1);
        for(int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();
        a2 = splitMerge(a2);
        for(int i : a2) {
            System.out.print(i + " ");
        }
        System.out.println();
        return sortMerge(a1, a2);
    }

    public static void main (String[] args) {
        int[] arr = {2,5,6,3,8,9,6,1,0,5};
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] brr = splitMerge(arr);
        for(int i : brr) {
            System.out.print(i + " ");
        }
    }

}
