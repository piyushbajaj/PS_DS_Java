package TakeUForward.CompleteCourse_456.S1_LearnBasics.S1_3_BasicMaths;

/**
 * Created by bajajp on 17 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/check-if-a-number-is-prime-or-not/
 * <p>
 * Problem Statement: Given a number, check whether it is prime or not. A prime number is a natural number
 * that is only divisible by 1 and by itself.
 * <p>
 * Examples 2 3 5 7 11 13 17 19 …
 */
public class P7_PrimeNumber {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    static boolean isPrime(int n) {
        if (n <= 0) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * We can also check if the number is prime or not by going till square root of n
     * TC: O(SquareRoot of N)
     * SC: O(1)
     *
     * @param N
     * @return
     */
    public static boolean isPrime1(int N) {

        for (int i = 2; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPrime(10));

        System.out.println(isPrime1(8));
    }
}
