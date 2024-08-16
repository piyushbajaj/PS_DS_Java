package PracticeSessionMay2024.TwoPointer;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TwoPointer
 * <p>
 * User: piyushbajaj
 * Date: 28/06/24
 * Time: 8:10 pm
 */

import java.util.Arrays;

/**
 * Question: Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
 * sorted in non-decreasing order.
 * Link: <a href="https://leetcode.com/problems/squares-of-a-sorted-array/description/?envType=problem-list-v2&envId=eso8g3p2">...</a>
 */
public class P1_SquaresOfSortedArray {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int front = 0;
        int rear = n - 1;
        int rearIndex = rear;
        while (front <= rear && rearIndex >= 0) {
            int frontVal = nums[front] * nums[front];
            int rearVal = nums[rear] * nums[rear];
            if (frontVal < rearVal) {
                result[rearIndex] = rearVal;
                rear--;
            } else {
                result[rearIndex] = frontVal;
                front++;
            }
            rearIndex--;
        }

        return result;
    }

    public int[] sortedSquaresSpaceOpt(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int front = 0;
        int rear = n - 1;

        while (front <= rear) {
            if (nums[front] > nums[rear]) {
                swap(nums, rear, front);
            }
            rear--;
        }
        return nums;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        P1_SquaresOfSortedArray p1SquaresOfSortedArray = new P1_SquaresOfSortedArray();
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(p1SquaresOfSortedArray.sortedSquares(arr)));
        p1SquaresOfSortedArray.sortedSquaresSpaceOpt(arr);
        System.out.println(Arrays.toString(arr));
    }
}
