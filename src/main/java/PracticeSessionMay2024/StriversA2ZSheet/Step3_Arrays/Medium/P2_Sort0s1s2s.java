package PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Medium;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Medium
 * <p>
 * User: piyushbajaj
 * Date: 08/08/24
 * Time: 6:45 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/sort-colors/">...</a>
 */
public class P2_Sort0s1s2s {

    /**
     * Dutch National Flag Algorithm
     * <p>
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        P2_Sort0s1s2s p2Sort0s1s2s = new P2_Sort0s1s2s();
        int[] arr = {2, 0, 2, 1, 1, 0};
        p2Sort0s1s2s.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
