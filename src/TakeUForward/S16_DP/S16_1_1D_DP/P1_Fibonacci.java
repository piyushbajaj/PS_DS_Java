package TakeUForward.S16_DP.S16_1_1D_DP;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP
 * <p>
 * User: piyushbajaj
 * Date: 10/11/22
 * Time: 1:16 pm
 */
public class P1_Fibonacci {

    /**
     * Approach: Memoization (extension of recursion)
     * TC: O(N)
     * SC: O(N) + O(N)
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        return fibonacci(n, dp);
    }

    public int fibonacci(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
    }

    /**
     * Approach: Tabulation
     * TC: O(N)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public int fibonacci_tab(int n) {
        int prev2 = 0;
        int prev = 1;

        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = prev + prev2;
            prev2 = prev;
            prev = fib;
        }

        return fib;
    }

    public static void main(String[] args) {
        P1_Fibonacci fibonacci = new P1_Fibonacci();

        System.out.println(fibonacci.fibonacci(11));

        System.out.println(fibonacci.fibonacci_tab(4));
    }
}
