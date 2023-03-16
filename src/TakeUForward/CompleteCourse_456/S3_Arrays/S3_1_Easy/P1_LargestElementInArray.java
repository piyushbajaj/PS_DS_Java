package TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy;

/**
 * Created by bajajp on 18 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/
 * <p>
 * Problem Statement: Given an array, we have to find the largest element in the array.
 * <p>
 * Example 1:
 * Input: arr[] = {2,5,1,3,0};
 * Output: 5
 * Explanation: 5 is the largest element in the array.
 * <p>
 * Example2:
 * Input: arr[] = {8,10,5,7,9};
 * Output: 10
 * Explanation: 10 is the largest element in the array.
 */
public class P1_LargestElementInArray {

    /**
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @return
     */
    static int maxElement(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int j : arr) {
            max = Math.max(j, max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxElement(new int[]{2, 5, 1, 3, 0}));
    }
}
