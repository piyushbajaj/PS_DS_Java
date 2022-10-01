package TakeUForward.S1_LearnBasics.S1_3_BasicMaths;

/**
 * Created by bajajp on 17 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/find-gcd-of-two-numbers/
 * <p>
 * Problem Statement: Find gcd of two numbers.
 * <p>
 * Example 1:
 * Input: num1 = 4, num2 = 8
 * Output: 4
 * Explanation: Since 4 is the greatest number which divides both num1 and num2.
 * <p>
 * Example 2:
 * Input: num1 = 3, num2 = 6
 * Output: 3
 * Explanation: Since 3 is the greatest number which divides both num1 and num2.
 */
public class P4_GCDOfTwoNumbers {

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param num1
     * @param num2
     * @return
     */
    static int gcd(int num1, int num2) {
        int small = Math.min(num1, num2);

        for (int i = small; i >= 0; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }

        return 1;
    }

    /**
     * Using Euclidean theorem
     * gcd(a,b) -> gcd(b,a%b)
     * TC: O(log(min(a,b)))
     * SC: O(1)
     *
     * @param num1
     * @param num2
     * @return
     */
    static int gcd1(int num1, int num2) {
        if (num2 == 0) return num1;

        return gcd1(num2, num1 % num2);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(gcd(3, 7));
        long endTime = System.nanoTime() - startTime;

        System.out.println(endTime);

        startTime = System.nanoTime();
        System.out.println(gcd1(3, 7));
        endTime = System.nanoTime() - startTime;

        System.out.println(endTime);
    }
}
