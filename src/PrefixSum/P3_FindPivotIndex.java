package PrefixSum;

/**
 * Created by bajajp on 25 Sep, 2022
 * <p>
 * Link: https://leetcode.com/problems/find-pivot-index/
 */
public class P3_FindPivotIndex {
    /**
     * Will using prefix sum to calculate the value of the left array and to the right array
     * TC: O(N)
     * SC: O(1)
     * @param nums
     * @return
     */
    static int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum = 0;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
