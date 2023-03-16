package Array;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyush.bajaj on 19/11/16.
 */
public class ReverseString {
    public char[] reverseArr(char[] ch) {
        int n = ch.length;
        //char c = 'A' ^ 'B';
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
        return ch;
    }

    public char[] reverseArr(char[] ch, int j, int n) {
        //int n = ch.length;
        //char c = 'A' ^ 'B';
        char temp;
        for (int i = j; i < n; i++) {
            if ((i != n - 1 - i) && i < n / 2) {
                temp = ch[i];
                ch[i] = ch[n - 1 - i];
                ch[n - 1 - i] = temp;
            } else {
                break;
            }
        }
        return ch;
    }

    //without using temp variable
    public static void reverseArr_XOR(char[] ch) {
        int n = ch.length;
        for (int i = 0; i < n; i++) {
            if ((i != n - 1 - i) && i < n / 2) {
                ch[i] = ((char) (ch[i] ^ ch[n - 1 - i]));
                ch[n - 1 - i] = ((char) (ch[i] ^ ch[n - 1 - i]));
                ch[i] = ((char) (ch[i] ^ ch[n - 1 - i]));
            } else {
                break;
            }
        }
    }

    //reverse words in sentence

    public void reverseSentence(String arr, int n) {
        //char c = 'A' ^ 'B';


        HashMap<String, Boolean> hash = new HashMap<>();
        //hash.put
        StringBuilder sb = new StringBuilder();
        arr = String.valueOf(reverseArr(arr.toCharArray()));
        //.toString();
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (arr.charAt(i) == ' ') {
                sb.append(String.valueOf(reverseArr(arr.substring(start, i).toCharArray())) + " ");
                start = i + 1;
            } else if (i == n - 1) {
                sb.append(String.valueOf(reverseArr(arr.substring(start, i + 1).toCharArray())) + " ");
            }

        }
        System.out.println(sb);
    }

    public static String reverseString(String str) {
        int len = str.length();

        StringBuffer dest = new StringBuffer(len);

        for (int i = len - 1; i >= 0; i--) {
            dest.append(str.charAt(i));
        }
        return dest.toString();
    }

    public static void main(String[] args) {
        ReverseString RA = new ReverseString();

//        System.out.println("Input the string to be reversed: ");
//        Scanner s = new Scanner(System.in);
//        String str = s.nextLine();
//        char[] charArr = str.toCharArray();
//        //RA.reverseArr(charArr);
//        reverseArr_XOR(charArr);
//        String st = String.valueOf(charArr);
//        System.out.println(st);
//
//        System.out.println("Using StringBuffer: ");
//        System.out.println(reverseString(str));

        System.out.println("Input the sentence to be reversed: ");
        Scanner s1 = new Scanner(System.in);
        String str1 = s1.nextLine();
        char[] charArr1 = str1.toCharArray();
        int n = charArr1.length;
        RA.reverseSentence(str1, n);
        //reverseString(str1);
    }
}
