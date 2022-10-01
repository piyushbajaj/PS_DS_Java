package TakeUForward.S1_LearnBasics.S1_4_BasicRecursion;

/**
 * Created by bajajp on 17 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/sum-of-first-n-natural-numbers/
 * <p>
 * Example 1:
 * Input: N=5
 * Output: 15
 * Explanation: 1+2+3+4+5=15
 * <p>
 * Example 2:
 * Input: N=6
 * Output: 21
 * Explanation: 1+2+3+4+5+6=15
 */
public class P4_SumOfN {

    /**
     * TC: O(N)
     * SC: O(N)
     * @param n
     * @return
     */
    static int sumOfFirstN(int n) {
        if (n == 0) return 0;

        return n + sumOfFirstN(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfFirstN(10));
    }
}
