package TakeUForward.Blind75.Array;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 06/03/23
 * Time: 1:51 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/maximum-product-subarray/">...</a>
 */
public class P6_MaxProdArray {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];

        int res = maxProduct;

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(maxProduct * nums[i], minProduct * nums[i]));
            minProduct = Math.min(nums[i], Math.min(maxProduct * nums[i], minProduct * nums[i]));

            maxProduct = tempMax;

            res = Math.max(res, maxProduct);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
    }
}
