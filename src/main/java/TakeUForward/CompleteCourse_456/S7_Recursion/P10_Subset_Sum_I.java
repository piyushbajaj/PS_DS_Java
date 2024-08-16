package TakeUForward.CompleteCourse_456.S7_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 17/10/22
 * Time: 5:59 pm
 * <p>
 */
public class P10_Subset_Sum_I {

    public static void main(String[] args) {
        P10_Subset_Sum_I p10_subset_sum_i = new P10_Subset_Sum_I();
        System.out.println(p10_subset_sum_i.subsetSums(new ArrayList<>(Arrays.asList(3, 1, 2)), 3));
    }

    /**
     * TC: O(2^N) + Sorting: O(2^N*log(2^N))
     * SC: O(2^N)
     *
     * @param arr
     * @param N
     * @return
     */
    public ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        subsetSums_util(result, arr, 0, 0);
        Collections.sort(result);

        return result;
    }

    public void subsetSums_util(ArrayList<Integer> res, ArrayList<Integer> arr,
                                int index, int sum) {
        if (index == arr.size()) {
            res.add(sum);
            return;
        }

        subsetSums_util(res, arr, index + 1, sum + arr.get(index));
        subsetSums_util(res, arr, index + 1, sum);
    }
}
