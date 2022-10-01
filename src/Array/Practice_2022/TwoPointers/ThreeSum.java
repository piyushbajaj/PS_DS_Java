package Array.Practice_2022.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bajajp on 14 Jun, 2022
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int ptr = 0; ptr < nums.length && nums[ptr] <= 0; ptr++) {
            if (ptr == 0 || nums[ptr] != nums[ptr - 1]) {
                int l = ptr + 1, n = nums.length, r = n - 1, sum = 0;
                while (l < r) {
                    sum = nums[ptr] + nums[l] + nums[r];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[ptr], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                    } else if (sum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(null + "abc");
    }
}
