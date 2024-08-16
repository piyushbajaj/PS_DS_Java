package Array;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 20/11/16.
 */
public class compressed {
    public static void compressedChar(String str) {
        char[] charArr = str.toCharArray();

        String s = "";
        char last = charArr[0];
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (charArr[i] == last) {
                count++;
            } else {
                s += last + "" + count;
                last = charArr[i];
                count = 1;
            }
        }
        s = s + last + count;
        if (s.length() < str.length()) {
            System.out.println("Compressed string is: " + s);
            return;
        } else {
            System.out.println(
                "Since the length of compressed string was no longer bigger so Original String is: " + str);
            return;
        }

        /*
        Here we are using String concatenation, which takes O(n^2) time.
        So we should instead use String Buffer which takes much less time.
         */
    }

    public static void compressBetter(String str) {
        char[] charArr = str.toCharArray();

        StringBuffer s = new StringBuffer();
        char last = charArr[0];
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (charArr[i] == last) {
                count++;
            } else {
                s.append(last);
                s.append(count);
                last = charArr[i];
                count = 1;
            }
        }
        s.append(last);
        s.append(count);
        if (s.length() < str.length()) {
            System.out.println("Compressed string is: " + s);
            return;
        } else {
            System.out.println(
                "Since the length of compressed string was no longer bigger so Original String is: " + str);
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println("Input the string: ");
        Scanner s = new Scanner(System.in);

        String str = s.nextLine();
        //compressedChar(str);
        compressBetter(str);
    }
}
