package TakeUForward.CompleteCourse_456.S1_LearnBasics.S1_3_BasicMaths;

/**
 * Created by bajajp on 17 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/print-all-divisors-of-a-given-number/
 * <p>
 * Problem Statement: Given a number, print all the divisors of the number.
 * A divisor is a number that gives remainder as zero when divided.
 * <p>
 * Example 1:
 * Input: n = 36
 * Output: 1 2 3 4 6 9 12 18 36
 * Explanation: All the divisors of 36 are printed.
 * <p>
 * Example 2:
 * Input: n = 97
 * Output: 1 97
 * Explanation: Since 97 is a prime number, only 1 and 97 are printed.
 */
public class P6_PrintAllDivisors {

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param n
     */
    static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        printDivisors(36);
    }
}
