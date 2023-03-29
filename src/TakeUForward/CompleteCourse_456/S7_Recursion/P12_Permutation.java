package TakeUForward.CompleteCourse_456.S7_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 18/10/22
 * Time: 12:52 pm
 * <p>
 * Leetcode Link: https://leetcode.com/problems/permutations/
 * Take U Link: https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12&ab_channel
 * =takeUforward
 */
public class P12_Permutation {

    /**
     * Let's optimize the above approach
     *
     * @param args
     */

    public static void main(String[] args) {
        P12_Permutation p12_permutation = new P12_Permutation();
        int[] arr = {1, 2, 3};
        System.out.println(p12_permutation.permute(arr));
    }

    /**
     * TC: O(N!) * N
     * SC: O(N) + O(N)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        permute(nums, result, new ArrayList<>(), new boolean[nums.length]);

        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> subResult,
                         boolean[] isOccurred) {
        if (subResult.size() == nums.length) {
            result.add(new ArrayList<>(subResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isOccurred[i]) {
                subResult.add(nums[i]);
                isOccurred[i] = true;

                permute(nums, result, subResult, isOccurred);
                subResult.remove(subResult.size() - 1);
                isOccurred[i] = false;
            }
        }
    }

    public List<List<Integer>> permute_imp(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        permute_util_imp(nums, result, new ArrayList<>(), new boolean[nums.length]);

        return result;
    }

    public void swap(List<Integer> arrayList, int a, int b) {
        int temp = arrayList.get(a);
        arrayList.set(a, arrayList.get(b));
        arrayList.set(b, temp);
    }

    private void permute_util_imp(int[] nums, List<List<Integer>> result, List<Integer> subResult,
                                  boolean[] isOccurred) {
        if (subResult.size() == nums.length) {
            result.add(new ArrayList<>(subResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isOccurred[i]) {
                subResult.add(nums[i]);
                isOccurred[i] = true;

                permute(nums, result, subResult, isOccurred);
                subResult.remove(subResult.size() - 1);
                isOccurred[i] = false;
            }
        }
    }
}
