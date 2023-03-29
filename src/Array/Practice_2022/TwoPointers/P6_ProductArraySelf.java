package Array.Practice_2022.TwoPointers;

import java.util.Arrays;

/**
 * Created by bajajp on 10 Sep, 2022
 */
public class P6_ProductArraySelf {
    public static void main(String[] args) {
        P6_ProductArraySelf p6_productArraySelf = new P6_ProductArraySelf();
        int[] arr = {4, 5, 1, 8, 2, 10, 6};
        System.out.println(Arrays.toString(p6_productArraySelf.productExceptSelf(arr)));
    }

    /**
     * Left Array -> Contain all the number multiplied by
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            left[i] = left[i] * right;
            right = nums[i] * right;
        }

        return left;
    }
}
