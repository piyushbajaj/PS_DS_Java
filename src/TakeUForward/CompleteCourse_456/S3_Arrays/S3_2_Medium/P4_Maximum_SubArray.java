package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 26/12/22
 * Time: 12:48 pm
 */
public class P4_Maximum_SubArray {

    /**
     * Kadanes Algorithm
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        P4_Maximum_SubArray p4_maximum_subArray = new P4_Maximum_SubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(p4_maximum_subArray.maxSubArray(nums));
    }
}
