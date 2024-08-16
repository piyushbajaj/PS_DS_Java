package Leetcode.MustDoEasyQuestions;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 11:27 pm
 * <p>
 * Pattern: Math
 * <p>
 * lc: <a href="https://leetcode.com/problems/factorial-trailing-zeroes/description/">...</a>
 * helpful link: <a href="https://leetcode.com/problems/factorial-trailing-zeroes/solutions/545913/factorial-trailing-zeroes/">...</a>
 */
public class P10_Factorial_Trailing_Zeroes {

    public static void main(String[] args) {
        P10_Factorial_Trailing_Zeroes p10_factorial_trailing_zeroes = new P10_Factorial_Trailing_Zeroes();
        System.out.println(p10_factorial_trailing_zeroes.trailingZeroes(13));
        System.out.println(p10_factorial_trailing_zeroes.trailingZeroes_better(13));
    }

    /**
     * Approach:
     * Number of 5's means the number of trailing zeroes, as 2 will always be higher in number.
     * So number of fives = (n/5 + n/25 + n/125 ...)
     * TC: O(logN)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public int trailingZeroes_better(int n) {
        int fives = 0;
        int power_of_five = 5;

        while (n >= power_of_five) {
            fives += n / power_of_five;
            power_of_five *= 5;
        }

        return fives;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        long k = factorial(n);
        if (k == 0) {
            return (int) k;
        }

        while (true) {
            if (k % 10 == 0) {
                count++;
                k = k / 10;
            } else {
                break;
            }
        }

        return count;
    }

    public long factorial(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }
}
