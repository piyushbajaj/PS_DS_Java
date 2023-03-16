package TakeUForward.CompleteCourse_456.S7_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 16/10/22
 * Time: 3:10 pm
 * <p>
 */
public class P9_Combination_II {

    /**
     * Approach:
     * <p>
     * TC: O(NlogN + O(K) * O(2^N)
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSum2_util(result, subResult, 0, candidates, target);

        return result;
    }

    public void combinationSum2_util(List<List<Integer>> result, List<Integer> subResult, int index,
                                     int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(subResult));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] <= target) {
                subResult.add(candidates[i]);
                combinationSum2_util(result, subResult, i + 1, candidates, target - candidates[i]);
                subResult.remove(subResult.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        P9_Combination_II p9_combination_ii = new P9_Combination_II();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(p9_combination_ii.combinationSum2(arr, 8));
    }
}
