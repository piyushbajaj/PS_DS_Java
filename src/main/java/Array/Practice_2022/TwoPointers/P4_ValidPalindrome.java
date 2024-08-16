package Array.Practice_2022.TwoPointers;

/**
 * Created by bajajp on 10 Sep, 2022
 */
public class P4_ValidPalindrome {
    public static void main(String[] args) {
        P4_ValidPalindrome p4_validPalindrome = new P4_ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(p4_validPalindrome.isPalindrome(s));
    }

    /**
     * Use filter function to consider only ascii value from 65 to 90, 97 to 122, 48 to 57
     * TC: O(N)
     * SC: O(1)
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = filterAlphaNumeric(s);

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * ASCII A to Z is 65 to 90, a to z is 97 to 122, 0 to 9 is 48 to 57
     *
     * @param s
     * @return
     */
    public String filterAlphaNumeric(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            int asciiVal = s.charAt(i);
            if (asciiVal >= 65 && asciiVal <= 90) {
                asciiVal += 32;
            }

            if ((asciiVal >= 97 && asciiVal <= 122) || (asciiVal >= 48 && asciiVal <= 57)) {
                result = result.concat(String.valueOf((char) asciiVal));
            }
        }

        return result;
    }
}
