package Leetcode.MustDoEasyQuestions;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 12:57 pm
 * <p>
 * Pattern: Array, Divide and Conquer, Dynamic Programming
 * <p>
 * lc: <a href="https://leetcode.com/problems/maximum-subarray/">...</a>
 */
public class P4_Max_SubArray {

    public static void main(String[] args) {
        P4_Max_SubArray p4_max_subArray = new P4_Max_SubArray();
        System.out.println(p4_max_subArray.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, sum);
        }

        return maxSoFar;
    }
}
