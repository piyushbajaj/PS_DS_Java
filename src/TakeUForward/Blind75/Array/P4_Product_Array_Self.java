package TakeUForward.Blind75.Array;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 06/03/23
 * Time: 11:52 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/product-of-array-except-self/">...</a>
 */
public class P4_Product_Array_Self {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];
        // initialize
        left[0] = 1;
        right[n - 1] = 1;

        // start multiplying from the 0th index and store in the 1st index
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // start multiplying from the nth index and store in the 1st index
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
    }
}
