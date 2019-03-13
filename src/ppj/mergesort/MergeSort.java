package ppj.mergesort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    private static int[] sortMerge(int[] a1, int[] a2) {
        int[] arr = new int [a1.length + a2.length];
        int next = 0;
        int i1 = 0;
        int i2 = 0;
        MAIN_LOOP:
        while (i1 < a1.length) {
            while (i2 < a2.length) {
                if (a2[i2] <= a1[i1]){
                    arr[next++] = a2[i2++];
                } else {
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
        /*
        for(int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();
        */
        a2 = splitMerge(a2);
        /*
        for(int i : a2) {
            System.out.print(i + " ");
        }
        System.out.println();
        */
        return sortMerge(a1, a2);
    }

    public static void main (String[] args) {

        //int[] arr = new int[]{5, 7, 1, 9, 8, 2, 4, 6, 3, 7};

        Random r = new Random();
        int[] arr = new int[100];

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = r.nextInt(101);
        }

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
