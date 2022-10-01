package TakeUForward.S1_LearnBasics.S1_3_BasicMaths;

/**
 * Created by bajajp on 17 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/count-digits-in-a-number/
 * <p>
 * Problem Statement: Given an integer N , write program to count number of digits in N.
 * <p>
 * Example 1:
 * Input: N = 12345
 * Output: 5
 * Explanation: N has 5 digits
 * <p>
 * Example 2:
 * Input: N = 8394
 * Output: 4
 * Explanation: N has 4 digits
 */
public class P1_CountDigitsInANumber {
    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    static int count_digits(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    /**
     * Using String.valueOf() function
     * TC: O(1)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    static int count_digits1(int n) {
        String str = String.valueOf(n);
        return str.length();
    }

    /**
     * Using log10 for this log10(1234) -> 4.01, so if we take the floor for this, then we get the desired result
     * TC: O(1)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    static int count_digits2(int n) {
        return (int) Math.floor(Math.log10(n)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(count_digits(1234567));
        System.out.println(count_digits1(1234567));
        System.out.println(count_digits2(1234567));
    }
}
