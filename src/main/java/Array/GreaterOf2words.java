package Array;

/**
 * Created by piyush.bajaj on 21/11/17.
 */
public class GreaterOf2words {
    public static int compareStrings(String s1, String s2) {
        int comparison = 0;
        int c1, c2;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            c1 = (int) s1.toLowerCase().charAt(i);   // See note 1
            c2 = (int) s2.toLowerCase().charAt(i);   // See note 1
            comparison = c1 - c2;   // See note 2

            if (comparison != 0)     // See note 3
            {
                return comparison;
            }
        }
        if (s1.length() > s2.length())    // See note 4
        {
            return 1;
        } else if (s1.length() < s2.length()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(compareStrings("created", "completed"));
    }
}
