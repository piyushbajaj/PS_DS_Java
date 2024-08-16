package PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Easy;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Easy
 * <p>
 * User: piyushbajaj
 * Date: 17/07/24
 * Time: 6:35 pm
 */
public class P6_MoveAllZeroesEnd {

    /**
     * Two Pointer Approach
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int i, j;
        for (i = 0; i < n; i++) {
            if (nums[i] == 0) {
                break;
            }
        }

        j = i + 1;
        if (j >= n) {
            return;
        }

        while (j < n) {
            if (nums[i] == 0 && nums[j] != 0) {
                swap(nums, i, j);
            } else if (nums[i] == 0 && nums[j] == 0) {
                j++;
            } else {
                i++;
                j++;
            }
        }
    }

    /**
     * Another way using 2 Pointer
     *
     * @param nums
     */
    public void moveZeroes_anotherWay(int[] nums) {
        int n = nums.length;

        int i, j;
        for (i = 0; i < n; i++) {
            if (nums[i] == 0) {
                break;
            }
        }

        j = i + 1;
        if (j >= n) {
            return;
        }

        while (j < n) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        P6_MoveAllZeroesEnd p6MoveAllZeroesEnd = new P6_MoveAllZeroesEnd();
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        p6MoveAllZeroesEnd.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        p6MoveAllZeroesEnd.moveZeroes_anotherWay(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
