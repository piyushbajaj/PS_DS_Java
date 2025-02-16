package Session.May2024.Blind75.Day1_Array;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.Blind75.Day1_Array
 * <p>
 * User: piyushbajaj
 * Date: 12/08/24
 * Time: 10:06 am
 */
public class P6_MaxProductSubArray {

    /**
     * TC: O(N)
     * SC: (1)
     *
     * @param nums
     * @return
     */
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
        P6_MaxProductSubArray maxProductSubArray = new P6_MaxProductSubArray();
        System.out.println(maxProductSubArray.maxProduct(new int[] {2, 3, -2, 4}));
    }
}
