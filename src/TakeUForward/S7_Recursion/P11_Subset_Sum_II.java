package TakeUForward.S7_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 17/10/22
 * Time: 7:28 pm
 * <p>
 */
public class P11_Subset_Sum_II {

    /**
     * TC: O(2^N) * O(2^N * log (2^N))
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        subsetsWithDup_util(result, new ArrayList<>(), nums, 0);

        return new ArrayList<>(result);
    }

    public void subsetsWithDup_util(Set<List<Integer>> result, List<Integer> subResult, int[] nums,
                                    int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subResult));
            return;
        }

        subResult.add(nums[index]);
        subsetsWithDup_util(result, subResult, nums, index + 1);
        subResult.remove(subResult.size() - 1);
        subsetsWithDup_util(result, subResult, nums, index + 1);
    }

    /**
     * TC: O(2^N)*O(N) + O(NlogN)
     * SC: O(2^N) * O(K)
     * Auxillary Space: O(N)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup_imp(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        subsetsWithDup_imp_util(result, new ArrayList<>(), nums, 0);

        return result;
    }

    public void subsetsWithDup_imp_util(List<List<Integer>> result, List<Integer> subResult, int[] nums,
                                        int index) {

        result.add(new ArrayList<>(subResult));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            subResult.add(nums[i]);
            subsetsWithDup_imp_util(result, subResult, nums, i + 1);
            subResult.remove(subResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        P11_Subset_Sum_II p11_subset_sum_ii = new P11_Subset_Sum_II();
        int[] arr = {4, 4, 4, 1, 4};
        System.out.println(p11_subset_sum_ii.subsetsWithDup(arr));
        System.out.println(p11_subset_sum_ii.subsetsWithDup_imp(arr));
    }
}
