package CrackingCoding.Array;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 19/11/16.
 */
public class Permuation {
    public static void isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("Both strings length are Unequal");
            return;
        }

        char[] ch = str1.toCharArray();

        int n = ch.length;
        char temp;
        for (int i = 0; i < n; i++) {
            if ((i != n - 1 - i) && i < n / 2) {
                temp = ch[i];
                ch[i] = ch[n - 1 - i];
                ch[n - 1 - i] = temp;
            } else {
                break;
            }
        }

        String str3 = String.valueOf(ch);
        if (str2.equals(str3)) {
            System.out.println(str1 + " is anagram of " + str2);
            return;
        } else {
            System.out.println(str1 + " is not an anagram of " + str2);
            return;
        }
    }

    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static void isPermutation_Java(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("Both strings length are Unequal");
            return;
        }

        if (sort(str1).equals(sort(str2))) {
            System.out.println(str1 + " is anagram of " + str2);
            return;
        } else {
            System.out.println(str1 + " is not an anagram of " + str2);
            return;
        }

    }

    public static void isPermutation_1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("Both strings length are Unequal");
            return;
        }

        int[] letters = new int[256];

        char[] s_array = str1.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }

        char[] s_array1 = str2.toCharArray();
        for (char c : s_array1) {
            if (--letters[c] < 0) {
                System.out.println(str1 + " is not anagram of " + str2);
                return;
            }
        }
        System.out.println(str1 + " is anagram of " + str2);
        return;
    }

    public static void main(String[] args) {
        System.out.println("Input first string");
        Scanner s1 = new Scanner(System.in);
        String str1 = s1.nextLine();
        System.out.println("Input second string");
        Scanner s2 = new Scanner(System.in);
        String str2 = s1.nextLine();
        //isPermutation(str1, str2);
        //isPermutation_Java(str1, str2);
        isPermutation_1(str1, str2);
    }
}
