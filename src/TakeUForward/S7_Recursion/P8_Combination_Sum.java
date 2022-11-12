package TakeUForward.S7_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 16/10/22
 * Time: 1:55 pm
 * <p>
 */
public class P8_Combination_Sum {

    /**
     * Approach
     * <p>
     * TC: O(2^target * k), k -> combinations which get added
     * SC: O
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();

        combinationSum_util(result, subResult, 0, candidates, target);

        return result;
    }

    public void combinationSum_util(List<List<Integer>> result, List<Integer> subResult, int index,
                                    int[] candidates, int target) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(subResult));
            }
            return;
        }

        // Pick an element
        if (candidates[index] <= target) {
            subResult.add(candidates[index]);
            combinationSum_util(result, subResult, index, candidates, target - candidates[index]);
            // Not pick an element
            subResult.remove(subResult.size() - 1);
        }
        combinationSum_util(result, subResult, index + 1, candidates, target);

    }

    public static void main(String[] args) {
        P8_Combination_Sum p8_combination_sum = new P8_Combination_Sum();
        int[] arr = {2, 3, 6, 7};
        System.out.println(p8_combination_sum.combinationSum(arr, 7));
    }
}
