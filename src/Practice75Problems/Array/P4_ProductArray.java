package Practice75Problems.Array;

import java.util.Arrays;

/**
 * Created by bajajp on 23 Jun, 2022
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 */
public class P4_ProductArray {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];

        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            left[i] = left[i] * right;
            right = nums[i] * right;
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
