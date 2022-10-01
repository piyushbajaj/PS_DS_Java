package TakeUForward.S1_LearnBasics.S1_3_BasicMaths;

/**
 * Created by bajajp on 17 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/check-if-a-number-is-palindrome-or-not/
 * <p>
 * Problem Statement:  Given a number check if it is a palindrome.
 * <p>
 * Example 1:
 * Input: N = 123
 * Output: Not Palindrome Number
 * Explanation: 123 read backwards is 321.Since these are two different numbers 123 is not a palindrome.
 * <p>
 * Example 2:
 * Input: N =  121
 * Output: Palindrome Number
 * Explanation: 121 read backwards as 121.Since these are two same numbers 121 is a palindrome.
 */
public class P3_CheckPalindrome {

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    static boolean isPalindrome(int n) {
        int reverseNum = reverse(n);

        return reverseNum == n;
    }

    static int reverse(int n) {
        int num = 0;

        while (n != 0) {
            int rem = n % 10;
            n = n / 10;

            num = num * 10 + rem;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
