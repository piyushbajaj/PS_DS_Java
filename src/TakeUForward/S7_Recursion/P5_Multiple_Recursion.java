package TakeUForward.S7_Recursion;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 14/10/22
 * Time: 11:07 pm
 * <p>
 */
public class P5_Multiple_Recursion {
    // Recursive Fibonacci

    /**
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param n
     * @return
     */
    public int fib_recur(int n) {
        if (n <= 1) {
            return n;
        }

        return fib_recur(n - 1) + fib_recur(n - 2);
    }

    public static void main(String[] args) {
        P5_Multiple_Recursion p5_multiple_recursion = new P5_Multiple_Recursion();
        System.out.println(p5_multiple_recursion.fib_recur(5));
    }
}
