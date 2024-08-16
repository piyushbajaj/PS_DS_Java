package PracticeSessionMay2024.Blind75.Day1_Array;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.Blind75.Day1_Array
 * <p>
 * User: piyushbajaj
 * Date: 12/08/24
 * Time: 8:41 am
 */
public class P4_ProductOfArray {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * Link: https://leetcode.com/problems/product-of-array-except-self/
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
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
        P4_ProductOfArray productOfArray = new P4_ProductOfArray();
        System.out.println(Arrays.toString(productOfArray.productExceptSelf(new int[] {1, 2, 3, 4})));
    }
}
