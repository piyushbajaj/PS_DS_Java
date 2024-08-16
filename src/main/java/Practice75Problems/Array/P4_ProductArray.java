package Practice75Problems.Array;

import java.util.Arrays;

/**
 * Created by bajajp on 23 Jun, 2022
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 */
public class P4_ProductArray {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = nums[i] * right;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
    }
}
