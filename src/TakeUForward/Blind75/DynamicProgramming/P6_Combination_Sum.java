package TakeUForward.Blind75.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.DynamicProgramming
 * <p>
 * User: piyushbajaj
 * Date: 01/02/23
 * Time: 11:02 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/combination-sum/description/">...</a>
 */
public class P6_Combination_Sum {

    public static void main(String[] args) {
        P6_Combination_Sum p6_combination_sum = new P6_Combination_Sum();
        System.out.println(p6_combination_sum.combinationSum_recur(new int[] {2, 3, 6, 7}, 7));
    }

    /**
     * This is a recursive problem, where we either pick an element or don't pick
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum_recur(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        combinationSum_recur_util(result, new ArrayList<>(), 0, target, candidates);

        return result;
    }

    public void combinationSum_recur_util(List<List<Integer>> result, List<Integer> subResult, int index,
                                          int target, int[] candidates) {

        // Base Condition
        if (index == candidates.length) {
            if (target == 0) {
                // if target is 0, then add this subResult to result
                result.add(new ArrayList<>(subResult));
            }
            return;
        }

        // pick an element
        if (target >= candidates[index]) {
            // Adding an element
            subResult.add(candidates[index]);
            combinationSum_recur_util(result, subResult, index, target - candidates[index], candidates);
            // remove last element
            subResult.remove(subResult.size() - 1);
        }

        // don't pick element
        combinationSum_recur_util(result, subResult, index + 1, target, candidates);
    }
}
