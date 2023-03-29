package StriverSDESheet.Arrays_Part4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 10 Sep, 2022
 */
public class P1_2Sum_Problem {
    public static void main(String[] args) {
        P1_2Sum_Problem p1_2Sum_problem = new P1_2Sum_Problem();
        System.out.println(Arrays.toString(p1_2Sum_problem.pairWithGivenSum(
            new int[] {2, 7, 11, 15}, 9)));

        System.out.println(Arrays.toString(p1_2Sum_problem.pairWithGivenSum_better(
            new int[] {2, 7, 11, 15}, 9)));

        System.out.println(Arrays.toString(p1_2Sum_problem.pairWithGivenSum_best(
            new int[] {2, 7, 11, 15}, 9)));
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] pairWithGivenSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[] {i, result.get(target - nums[i])};
            } else {
                result.put(nums[i], i);
            }
        }

        return null;
    }

    /**
     * TC: O(N^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] pairWithGivenSum_better(int[] nums, int target) {
        int i = 0, j = i + 1, n = nums.length;
        while (j < n) {
            if (nums[i] == target - nums[j]) {
                return new int[] {i, j};
            }
            j++;
            if (j == n) {
                i++;
                j = i + 1;
            }
        }
        return null;
    }

    public int[] pairWithGivenSum_best(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int diff = target - nums[j];
            if (nums[i] == diff) {
                return new int[] {i, j};
            } else if (nums[i] < diff) {
                i++;
            } else {
                j--;
            }
        }

        return new int[] {0, 0};
    }
}
