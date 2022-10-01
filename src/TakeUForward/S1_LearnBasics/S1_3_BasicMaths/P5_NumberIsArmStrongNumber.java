package TakeUForward.S1_LearnBasics.S1_3_BasicMaths;

/**
 * Created by bajajp on 17 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/maths/check-if-a-number-is-armstrong-number-or-not/
 * <p>
 * Problem Statement: Given a number, check if it is Armstrong Number or Not.
 * <p>
 * Example 1:
 * Input:153
 * Output: Yes, it is an Armstrong Number
 * Explanation: 1^3 + 5^3 + 3^3 = 153
 * <p>
 * Input:170
 * Output: No, it is not an Armstrong Number
 * Explanation: 1^3 + 7^3 + 0^3 != 170
 * <p>
 * Armstrong Numbers are the numbers having the sum of digits raised to power no. of digits is equal to a given number.
 * Examples- 0, 1, 153, 370, 371, 407, and 1634 are some Armstrong Numbers.
 */
public class P5_NumberIsArmStrongNumber {

    /**
     * 1. First Count the digits
     * 2. Then one by one add to the num
     * TC: O(N)
     * SC: O(1)
     * @param n
     * @return
     */
    static boolean isArmStrong(int n) {
        int originalNum = n;
        int num = 0;
        int digit = countDigits(n);
        while (n != 0) {
            int rem = n % 10;
            n = n / 10;
            num += Math.pow(rem, digit);
        }

        return originalNum == num;
    }

    static int countDigits(int n) {
        return (int) Math.floor(Math.log10(n)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(isArmStrong(153));
    }
}
