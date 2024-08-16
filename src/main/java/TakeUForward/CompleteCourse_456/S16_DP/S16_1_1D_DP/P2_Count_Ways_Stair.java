package TakeUForward.CompleteCourse_456.S16_DP.S16_1_1D_DP;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP
 * <p>
 * User: piyushbajaj
 * Date: 11/11/22
 * Time: 9:47 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/climbing-stairs/description/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1">...</a>
 */
public class P2_Count_Ways_Stair {
    //Function to count number of ways to reach the nth stair.

    public static void main(String[] args) {

    }

    /**
     * Recursion
     *
     * @param n
     * @return
     */
    public int countWays_recur(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int left = countWays_recur(n - 1);
        int right = countWays_recur(n - 2);

        return left + right;
    }

    public int countWays_tab(int n) {
        int prev2 = 1;
        int prev = 1;
        int fib = prev;
        for (int i = 2; i <= n; i++) {
            fib = prev + prev2;
            prev2 = prev;
            prev = fib;
        }

        return fib;
    }
}
