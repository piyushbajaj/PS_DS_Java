package Practice2025.TakeUForward.Sorting;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: Practice2025.TakeUForward.Sorting
 * <p>
 * User: piyushbajaj
 * Date: 14/08/25
 * Time: 8:00 pm
 */
public class P1_SelectionSort {

    public int[] selectionSort(int[] nums) {
        int len = nums.length;
        boolean swapOccurred = false;
        for (int first = 0; first < len; first++) {
            int second = first + 1;
            int minIndex = first;
            while (second < len) {
                if (nums[second] < nums[minIndex]) {
                    minIndex = second;
                    swapOccurred = true;
                }
                second++;
            }
            if (swapOccurred) {
                swap(nums, first, minIndex);
            }
        }

        return nums;
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        P1_SelectionSort selectionSort = new P1_SelectionSort();
        System.out.println(Arrays.toString(selectionSort.selectionSort(new int[] {7, 4, 1, 5, 3})));
    }
}
