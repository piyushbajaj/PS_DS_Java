package Practice2025.Neetcode.TwoPointers;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.TwoPointers
 * <p>
 * User: piyushbajaj
 * Date: 06/06/25
 * Time: 7:39 pm
 */
public class P1_ValidPalindrome {

    /**
     * Approach 1:
     * 1. Clean the string, and keep only Alphanumeric characters
     * 2. Check the palindrome using 2 pointer approach.
     * 3. Two pointers from both ends, till they are equal, when they are not return false.
     * TC: O(N)
     * SC: O(1)
     *
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {
        StringBuilder cleanString = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                cleanString.append(ch);
            }
        }

        return isPalindrome_util(cleanString.toString().toLowerCase());
    }

    private boolean isPalindrome_util(String cleanString) {
        int start = 0;
        int end = cleanString.length() - 1;

        while (start < end) {
            if (cleanString.charAt(start) == cleanString.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }


    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (Character ch : s.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append(Character.toLowerCase(ch));
            }
        }

        int start = 0;
        int end = sb.length() - 1;

        while (start < end) {
            if (sb.charAt(start) == sb.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P1_ValidPalindrome validPalindrome = new P1_ValidPalindrome();
        validPalindrome.isPalindrome("A man, a plan, a canal: Panama");
    }
}
