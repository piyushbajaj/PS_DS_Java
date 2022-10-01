package TakeUForward.S1_LearnBasics.S1_4_BasicRecursion;

/**
 * Created by bajajp on 17 Sep, 2022
 */
public class P7_StringIsPalindrome {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    static boolean isPalindrome(String str) {
        int low = 0, high = str.length() - 1;

        while (low <= high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * @param str
     * @return
     */
    static boolean isPalindrome_recur(String str) {
        return isPalindrome_recur_util(str, 0, str.length() - 1);
    }

    static boolean isPalindrome_recur_util(String str, int low, int high) {
        if (low <= high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            isPalindrome_recur_util(str, low + 1, high - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ABCDCBD"));
        System.out.println(isPalindrome_recur("ABCDCBA"));
    }
}
