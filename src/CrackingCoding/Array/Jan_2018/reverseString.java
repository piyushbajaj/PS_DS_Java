package CrackingCoding.Array.Jan_2018;

/**
 * Created by piyush.bajaj on 25/01/18.
 */
public class reverseString {
    public static void main(String[] args) {
        String str = "piyush bajaj";
        reverse(str);
    }

    public static void reverse(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder(str);
        char temp = ' ';
        for (int i = 0; i < len; i++) {
            temp = str.charAt(i);
            sb.setCharAt(i, str.charAt(len - i - 1));
            sb.setCharAt(len - i - 1, temp);
        }

        System.out.println(sb.toString());
    }
}
