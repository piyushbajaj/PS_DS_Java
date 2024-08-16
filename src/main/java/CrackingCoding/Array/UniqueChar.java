package CrackingCoding.Array;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyush.bajaj on 18/11/16.
 */
public class UniqueChar {

    //this takes O(n*n)
    public static boolean isUnique(char[] ch) {
        int n = ch.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ch[i] == ch[j]) {
                    System.out.println("Input string is not unique");
                    return false;
                }
            }
        }
        System.out.println("Input string is unique");
        return true;
    }

    public static boolean isUnique_SortedArray(char[] ch) {
        int n = ch.length;
        for (int i = 0; i < n - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                System.out.println("Input string is not unique");
                return false;
            }
        }
        System.out.println("Input string is unique");
        return true;
    }

    //for time O(nlogn), first we need to sort array using merge sort then we can directly use function isUnique_SortedArray

    public static void mergeSort(char[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void merge(char[] a, int l, int m, int r) {
        int N1 = m - l + 1;
        int N2 = r - m;

        char[] L = new char[N1];
        char[] R = new char[N2];

        for (int i = 0; i < N1; i++) {
            L[i] = a[l + i];
        }

        for (int i = 0; i < N2; i++) {
            R[i] = a[m + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < N1 && j < N2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                k++;
                i++;
            } else {
                a[k] = R[j];
                k++;
                j++;
            }
        }

        while (i < N1) {
            a[k] = L[i];
            k++;
            i++;
        }

        while (j < N2) {
            a[k] = R[j];
            k++;
            j++;
        }
    }


    //this is with complexity O(n)
    public static boolean isUnique_hash(char[] ch) {
        HashMap<Character, Boolean> h = new HashMap<>();
        for (char c : ch) {
            if (h.containsKey(c)) {
                System.out.println("Input string is not unique");
                return false;
            } else {
                h.put(c, true);
            }
        }
        System.out.println("Input string is unique");
        return true;
    }

    //Cracking the code interview

    public static boolean isUniqueChar2(String str) {
        if (str.length() > 256) {
            System.out.println("String is not unique");
            return false;
        }

        boolean[] bl = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (bl[val]) {
                System.out.println("String is not unique");
                return false;
            }
            bl[val] = true;
        }
        System.out.println("String is unique");
        return false;
    }

    public static boolean isUniqueChars(String str) {
        if (str.length() > 256) {
            System.out.println("String is not unique");
            return false;
        }

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';

            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("Input the string: ");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char[] charArray = str.toCharArray();
        //isUnique(charArray);
        //isUnique_SortedArray(charArray);
        //isUnique_hash(charArray);
        //System.out.println(str);

        isUniqueChars(str);
        //isUniqueChar2(str);
        int n = charArray.length;

        int l = 0;
        mergeSort(charArray, l, n - 1);
//        for(int i = 0; i < n; i++){
//            System.out.println(charArray[i]);
//        }

        isUnique_SortedArray(charArray);
    }

}
