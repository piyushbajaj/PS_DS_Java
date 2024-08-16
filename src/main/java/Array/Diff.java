package Array;

/**
 * Created by piyush.bajaj on 16/11/17.
 */
public class Diff {
    public static char findTheDifference(String s, String t) {
        int len = s.length();
        char[] ch = new char[1];

        for (int i = 0; i < len; i++) {
            ch[0] = ((char) (ch[0] ^ s.charAt(i) ^ t.charAt(i)));
        }

        ch[0] = ((char) (t.charAt(t.length() - 1) ^ ch[0]));

        return ch[0];

    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abc", "abdc"));
    }
}
