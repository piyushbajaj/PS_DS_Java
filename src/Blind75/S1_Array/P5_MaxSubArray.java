package Blind75.S1_Array;

/**
 * Project: DS_Algo
 * Package: Blind75.S1_Array
 * <p>
 * User: piyushbajaj
 * Date: 20/11/22
 * Time: 6:26 pm
 */
public class P5_MaxSubArray {
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
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        P5_MaxSubArray p5_maxSubArray = new P5_MaxSubArray();
        System.out.println(p5_maxSubArray.maxSubArray(arr));
    }
}
