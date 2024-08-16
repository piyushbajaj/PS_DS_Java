package TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy;

import java.util.Arrays;

/**
 * Created by bajajp on 18 Sep, 2022
 * <p>
 * Link: <a href="https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/">...</a>
 * Link: <a href="https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">...</a>
 */
public class P2_SecondLargestSmallest {

    /**
     * TC: O(2N)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    static int[] secondLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        int n = arr.length;

        if (n == 0 || n == 1) {
            return new int[] {-1, -1};
        }

        for (int j : arr) {
            max = Math.max(j, max);
            min = Math.min(j, min);
        }

        for (int j : arr) {
            if (j != max) {
                secondMax = Math.max(j, secondMax);
            }

            if (j != min) {
                secondMin = Math.min(j, secondMin);
            }
        }

        return new int[] {secondMax, secondMin};
    }

    /**
     * Return Second Largest and Smallest Element from the list
     * TC: O(N)
     * SC: O(1)
     * Tip: Best solution, as it can be done in single pass
     *
     * @param n
     * @param arr
     * @return
     */
    public static int[] getSecondOrderElements(int n, int[] arr) {
        int small = Integer.MAX_VALUE, second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE, second_large = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } else if (arr[i] < second_small && small != second_small) {
                second_small = arr[i];
            }

            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            } else if (arr[i] > second_large && large != second_large) {
                second_large = arr[i];
            }
        }

        return new int[] {second_small, second_large};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(secondLargestElement(new int[] {1, 2, 4, 6, 7, 5})));
        System.out.println(Arrays.toString(getSecondOrderElements(6, new int[] {1, 2, 4, 6, 7, 5})));
    }
}
