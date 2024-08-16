package Leetcode.MustDoEasyQuestions;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 02/01/23
 * Time: 12:32 pm
 * <p>
 * <p>
 * lc: <a href="https://leetcode.com/problems/count-primes/">...</a>
 * <p>
 * Discussion lc: <a href="https://leetcode.com/problems/count-primes/solutions/473021/Time-Complexity-O">...</a>
 * (log(log(n))-Explained/
 * <p>
 * better tc: <a href="https://leetcode.com/problems/count-primes/solutions/1157321/count-primes/">...</a>
 */
public class P14_Count_Primes {

    public static void main(String[] args) {
        P14_Count_Primes p14_count_primes = new P14_Count_Primes();
        System.out.println(p14_count_primes.countPrimes(10));
    }

    /**
     * TC: O(N*log(logN))
     * SC: O(N)
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
            for (int j = 2; i * j < n; j++) {
                notPrime[j * i] = true;
            }
        }

        return count;
    }
}
