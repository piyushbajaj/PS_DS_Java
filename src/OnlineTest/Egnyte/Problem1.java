package OnlineTest.Egnyte;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: OnlineTest.Egnyte
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 9:15 am
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int[] arr = {15, 20, 9, 11};

        int[] arr1 = {11, 20, 15};

        int[] arr2 = {0, 44, 32, 30, 42, 18, 34, 16, 35};

        int[] arr3 = {9};
        System.out.println(problem1.solution(arr));

        System.out.println(problem1.solution(arr1));

        System.out.println(problem1.solution(arr2));

        System.out.println(problem1.solution(arr3));
    }

    public int solution(int[] A) {
        int shortestBoard = 0;
        int n = A.length;
        int diff = 0, diff1 = 0;

        Arrays.sort(A);

        if (n % 2 == 0) {
            // Even Case
            for (int i = 0; i < n - 1; i = i + 2) {
                diff = Math.max(diff, A[i + 1] - A[i]);
            }
            shortestBoard = diff;
        } else {
            // Odd Case
            if (n == 1) {
                return n;
            }
            for (int i = 0; i < n - 1; i = i + 2) {
                diff = Math.max(diff, A[i + 1] - A[i]);
            }

            for (int i = 1; i < n - 1; i = i + 2) {
                diff1 = Math.max(diff1, A[i + 1] - A[i]);
            }

            shortestBoard = Math.min(diff, diff1);
        }

        return shortestBoard;
    }
}
