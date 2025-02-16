package Session.May2024.TechBoost;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost
 * <p>
 * User: piyushbajaj
 * Date: 29/05/24
 * Time: 6:58 pm
 */
public class P2_Factorial {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param n
     * @return
     */
    public int fact_recursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * fact_recursive(n - 1);
    }


    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public int fact_iterative(int n) {
        int fact = 1;
        if (n == 0 || n == 1) {
            return fact;
        }

        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }


    public static void main(String[] args) {
        P2_Factorial p2Factorial = new P2_Factorial();
        int n = 5;
        System.out.println("Factorial Recursive for " + n + " " + p2Factorial.fact_recursive(n));
        System.out.println("Factorial Iterative for " + n + " " + p2Factorial.fact_iterative(n));
    }
}
