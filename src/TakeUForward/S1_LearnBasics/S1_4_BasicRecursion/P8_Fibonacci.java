package TakeUForward.S1_LearnBasics.S1_4_BasicRecursion;

import java.util.Arrays;

/**
 * Created by bajajp on 17 Sep, 2022
 */
public class P8_Fibonacci {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param n
     * @return
     */
    static int[] fibonacci(int n) {
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    static int[] fibonacci1(int n) {
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param n
     */
    static void fibonacci2(int n) {
        int secondLast = 0, last = 1;

        if (n == 0) {
            System.out.print(n + " ");
        } else {
            System.out.print(secondLast + " " + last + " ");
        }

        for (int i = 2; i <= n; i++) {
            int curr = secondLast + last;
            secondLast = last;
            last = curr;
            System.out.print(curr + " ");
        }
    }

    /**
     * TC: O(2^n)
     * SC: O(n)
     * @param n
     * @return
     */
    static int fibonacci_recur(int n) {
        if (n == 0 || n == 1) return n;

        return fibonacci_recur(n - 1) + fibonacci_recur(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fibonacci(5)));
        fibonacci2(5);
        System.out.println("Fibonacci in Recursive: " + fibonacci_recur(5));
    }
}
