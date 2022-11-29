package Blind75.S1_Array;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: Blind75.S1_Array
 * <p>
 * User: piyushbajaj
 * Date: 19/11/22
 * Time: 7:50 pm
 */
public class P4_ProductArray {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        P4_ProductArray p4_productArray = new P4_ProductArray();
        int[] arr = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(p4_productArray.productExceptSelf(arr)));
    }
}
