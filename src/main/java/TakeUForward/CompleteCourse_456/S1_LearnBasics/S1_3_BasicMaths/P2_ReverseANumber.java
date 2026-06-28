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

    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = x * (-1);
        }

        int len = (int) Math.floor(Math.log10(x));
        int tmp = x;
        int reverse = 0;
        int cnt = len;
        while (tmp != 0) {
            int mod = tmp % 10;
            tmp = tmp / 10;
            reverse += mod * Math.pow(10, cnt--);
        }

        return negative ? reverse * -1 : reverse;
    }


    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public int reverseNumber(int n) {
        int num = 0;

        while (n != 0) {
            int rem = n % 10;
            n = n / 10;

            num = num * 10 + rem;
        }
        return num;
    }


    public static void main(String[] args) {
        P2_ReverseANumber reverseANumber = new P2_ReverseANumber();

        System.out.println(reverseANumber.reverseNumber(123456));
        System.out.println(reverseANumber.reverse(123456));
    }
}
