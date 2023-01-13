package TakeUForward.S3_Arrays.S3_2_Medium;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 26/12/22
 * Time: 5:13 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/next-permutation/description/">...</a>
 */
public class P7_Next_Permutation {
    /**
     * Approach:
     * 1. Traverse from the last, and the one where a[i] < a[i+1], so index1 = i
     * 2. Traverse from the last, the one which is greater than i.e, a[index2] > a[index1], will be index2.
     * 3. Swap index1 and index2
     * 4. Reverse all the elements after index1
     * <p>
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }

        int i = n - 2;
        int index1 = -1;
        int index2 = -1;
        boolean flag = false;

        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                index1 = i;
                flag = true;
                break;
            }
            i--;
        }

        i = n - 1;
        while (flag && i > index1) {
            if (nums[i] > nums[index1]) {
                index2 = i;
                break;
            }
            i--;
        }

        if (flag) {
            swap(nums, index1, index2);
        }

        reverse(nums, index1 + 1, n - 1);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        P7_Next_Permutation p7_next_permutation = new P7_Next_Permutation();
        int[] nums = {3, 2, 1};
        p7_next_permutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
