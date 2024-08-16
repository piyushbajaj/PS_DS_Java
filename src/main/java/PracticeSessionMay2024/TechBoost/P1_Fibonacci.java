package PracticeSessionMay2024.TechBoost;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost
 * <p>
 * User: piyushbajaj
 * Date: 25/05/24
 * Time: 7:27 pm
 */
public class P1_Fibonacci {

    /**
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param n
     * @return
     */
    public int fibRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }


    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public int fibIterative(int n) {
        int temp1 = 0;
        int temp2 = 1;

        if (n == 0) {
            return temp1;
        }

        if (n == 1) {
            return temp2;
        }

        for (int i = 2; i <= n; i++) {
            int temp3 = temp1 + temp2;
            temp1 = temp2;
            temp2 = temp3;
        }

        return temp2;
    }

    public static void main(String[] args) {
        P1_Fibonacci p1Fibonacci = new P1_Fibonacci();
        System.out.println(p1Fibonacci.fibRecursive(5));
        System.out.println(p1Fibonacci.fibIterative(5));
    }

}
