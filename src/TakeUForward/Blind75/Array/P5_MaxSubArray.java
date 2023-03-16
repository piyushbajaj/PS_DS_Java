package TakeUForward.Blind75.Array;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 06/03/23
 * Time: 12:08 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/maximum-subarray/">...</a>
 */
public class P5_MaxSubArray {
    /**
     * TC: O(N)
     * SC: O(1)
     * Using Kaden's Algo
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = nums[0], maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[] {5, 4, -1, 7, 8}));
        System.out.println(maxSubArray(new int[] {-1}));
    }
}
