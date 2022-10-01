package Array.Practice_2022.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 14 Jun, 2022
 */
public class TwoSum {
    // Wrong
    public static int[] twoSum_tried(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (r > l) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{0, 0};
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[]{
                        map.get(comp), i
                };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum_tried(new int[]{2, 7, 11, 15}, 9)));
    }
}
