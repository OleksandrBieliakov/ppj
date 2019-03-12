package ppj.e13;

import java.util.Arrays;

public class StringCmp {

    public static boolean isLess(String s1, String s2) {
        if(s1.length() < s2.length()) return true;
        if(s1.length() == s2.length() && s1.compareTo(s2) < 0) return true;
        return false;
    }

    public static String[] sortSel(String[] arr) {
        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = i+1; j < arr.length; ++j) {
                if(!isLess(arr[i], arr[j])) {
                    String t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    return arr;
    }

    public static void main (String[] args) {
        String[] arr = {"Kate", "Bea", "Mary", "Bea", "Zoe"};
        System.out.println(Arrays.toString(arr));
        sortSel(arr);
        System.out.println(Arrays.toString(arr));
    }

}
