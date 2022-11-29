package Blind75.S1_Array;

/**
 * Project: DS_Algo
 * Package: Blind75.S1_Array
 * <p>
 * User: piyushbajaj
 * Date: 20/11/22
 * Time: 6:34 pm
 */
public class P6_MaxProdSubArray {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax * nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        P6_MaxProdSubArray p6_maxProdSubArray = new P6_MaxProdSubArray();
        int[] nums = {-2, 0, -1};
        System.out.println(p6_maxProdSubArray.maxProduct(nums));
    }
}
