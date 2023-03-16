package TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy;

import java.util.Arrays;

/**
 * Created by bajajp on 18 Sep, 2022
 */
public class P2_SecondLargestElement {

    /**
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
            return new int[]{-1, -1};
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

        return new int[]{secondMax, secondMin};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(secondLargestElement(new int[]{1, 2, 4, 6, 7, 5})));
    }
}
