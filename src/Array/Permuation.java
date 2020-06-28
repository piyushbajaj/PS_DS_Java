package Array;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by piyush.bajaj on 19/11/16.
 */
public class Permuation {
    public static void isPermutation(String str1, String str2){
        if(str1.length() != str2.length()){
            System.out.println("Both strings length are Unequal");
            return;
        }

        char[] ch = str1.toCharArray();

        int n = ch.length;
        char temp;
        for(int i = 0; i < n; i++){
            if((i != n-1-i) && i < n/2){
                temp = ch[i];
                ch[i] = ch[n-1-i];
                ch[n-1-i] = temp;
            }
            else break;
        }

        String str3 = String.valueOf(ch);
        if(str2.equals(str3)) {
            System.out.println(str1 + " is reverse of " + str2);
            return;
        }
        else {
            System.out.println(str1 + " is not a reverse of " + str2);
            return;
        }
    }

    public static String sort(String s){
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static void isPermutation_Java(String str1, String str2){
        if(str1.length() != str2.length()){
            System.out.println("Both strings length are Unequal");
            return;
        }

        if(sort(str1).equals(sort(str2))){
            System.out.println(str1 + " is anagram of " + str2);
            return;
        }
        else {
            System.out.println(str1 + " is not an anagram of " + str2);
            return;
        }

    }

    public static void isPermutation_1(String str1, String str2){
        if(str1.length() != str2.length()){
            System.out.println("Both strings length are Unequal");
            return;
        }

        int[] letters = new int[256];

        char[] s_array = str1.toCharArray();
        for(char c: s_array){
            letters[c]++;
        }

        char[] s_array1 = str2.toCharArray();
        for(char c: s_array1){
            if(--letters[c] < 0) {
                System.out.println(str1 + " is not anagram of " + str2);
                return;
            }
        }
        System.out.println(str1 + " is anagram of " + str2);
        return;
    }

    public void permutationOfString(String str){
        //char[] charArr = new char[str.length()];
        char[] charArr = str.toCharArray();
        int n = str.length();
        permutations(charArr, n);
    }

    HashSet<String> hashSet = new HashSet<>();
    public void permutations(char[] arr, int n){
        if(n==1)
        {
            hashSet.add(String.valueOf(arr));
            System.out.println(String.valueOf(arr) + " ");
            return;
        }
        for(int i = 0; i < n; i++){
                swap(arr, i, n-1);
                permutations(arr, n - 1);
                swap(arr, i, n-1);
        }
    }

    public void swap(char[] arr, int i, int j){
//        arr[i] = ((char) (arr[i] ^ arr[j]));
//        arr[j] = ((char) (arr[i] ^ arr[j]));
//        arr[i] = ((char) (arr[i] ^ arr[j]));
        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        Permuation per = new Permuation();

//        System.out.println("Input first string");
//        Scanner s1 = new Scanner(System.in);
//        String str1 = s1.nextLine();
//        System.out.println("Input second string");
//        Scanner s2 = new Scanner(System.in);
//        String str2 = s2.nextLine();
//        isPermutation(str1, str2);
        //isPermutation_Java(str1, str2);
        //isPermutation_1(str1, str2);
        System.out.println("Input string for permutations");
        Scanner s3 = new Scanner(System.in);
        String str3 = s3.nextLine();
        System.out.println("So the permutation of " + str3 + " are: ");
        per.permutationOfString(str3);
        System.out.println(per.hashSet.size());

    }
}
