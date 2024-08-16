package Practice75Problems;

/**
 * Created by bajajp on 18 Jun, 2022
 */
public class P4_ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = filterAlphaNumeric(s);

        int start = 0, end = s.length() - 1;

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

    private String filterAlphaNumeric(String s) {
        int n = s.length();
        String output = "";

        for (int i = 0; i < n; i++) {
            int asciiValue = s.charAt(i);
            if ((asciiValue >= 65 && asciiValue <= 90)) {
                asciiValue += 32;
            }
            if ((asciiValue >= 97 && asciiValue <= 122) || (asciiValue >= 48 && asciiValue <= 57)) {
                output = output.concat(String.valueOf((char) (asciiValue)));
            }
        }
        return output;
    }

    public static void main(String[] args) {
        P4_ValidPalindrome validPalindrome = new P4_ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
