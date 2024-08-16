package TwoPointers;

import java.util.Arrays;

/**
 * Created by bajajp on 24 Sep, 2022
 */
public class Grokking1_PairWithTargetSum {
    static int[] search(int[] arr, int targetSum) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int sum = arr[l] + arr[r];

            if (sum == targetSum) {
                return new int[] {l, r};
            } else if (sum < targetSum) {
                l++;
            } else {
                r--;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 11};
        System.out.println(Arrays.toString(search(arr, 11)));
    }
}
