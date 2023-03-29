package Array;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 19/11/16.
 */
public class ReplaceString {
    public static String replaceStr(String str) {
        char[] charArr = str.toCharArray();
        int count = 0;
        for (char c : charArr) {
            if (c == ' ') {
                count++;
            }
        }
        if (count == 0) {
            //System.out.println("String doesnt have any extra space");
            return "String doesnt have any extra space";
        }
        int n = str.length() + count * 2;
        char[] charArr1 = new char[n];
//        for(int i = 0; i < charArr.length; i++){
//            charArr1[i] = charArr[i];
//        }
        //char[] charArray_new = new char[n];
        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] == ' ') {
                charArr1[n - 1] = '0';
                charArr1[n - 2] = '2';
                charArr1[n - 3] = '%';
                n = n - 3;
            } else {
                charArr1[n - 1] = charArr[i];
                n = n - 1;
            }
        }
        return String.valueOf(charArr1);

    }

    public static void main(String[] args) {
        System.out.println("Input the string with white spaces");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        //replaceStr(str);
        System.out.println("String with white spaces: " + replaceStr(str));
    }
}
