package TakeUForward.CompleteCourse_456.S1_LearnBasics.S1_3_BasicMaths;

/**
 * Created by bajajp on 17 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/c-programs/reverse-a-number-in-c/
 * <p>
 * Problem Statement: Given a number N reverse the number and print it.
 * <p>
 * Example 1:
 * Input: N = 123
 * Output: 321
 * Explanation: The reverse of 123 is 321
 * <p>
 * Example 2:
 * Input: N = 234
 * Output: 432
 * Explanation: The reverse of 234 is 432
 */
public class P2_ReverseANumber {

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    static int reverseNumber(int n) {
        int num = 0;

        while (n != 0) {
            int rem = n % 10;
            n = n / 10;

            num = num * 10 + rem;
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println(reverseNumber(123456));
    }
}
