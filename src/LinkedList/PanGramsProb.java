package LinkedList;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 07/01/18.
 */
public class PanGramsProb {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        pangram(str);
    }

    public static void pangram(String s) {
        int[] strArr = new int[26];

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }

            strArr[Integer.valueOf(s.charAt(i)) - 97]++;
        }

        for (int i = 0; i < strArr.length; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }

            if (strArr[i] == 0) {
                System.out.println("not pangram");
                return;
            }
        }

        System.out.println("pangram");
        return;

    }
}
