package StriverSDESheet.Arrays_Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bajajp on 13 Aug, 2022
 */
public class P2_MergeOverlappingSubIntervals {

    /**
     * TC: O(N + NlogN)
     * SC: O(N)
     *
     * @param intervals
     * @return
     */
    public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        List<List<Integer>> result = new ArrayList<>();
        int n = intervals.size();

        //Sort the intervals -> n logN
        intervals.sort((a, b) -> a.get(0) - b.get(0));

        for (int i = 0; i < n; i++) {
            int resSize = result.size();
            // If result is empty or result's last index is smaller than interval's first index value, then do this
            if (result.isEmpty() || result.get(resSize - 1).get(1) < intervals.get(i).get(0)) {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(intervals.get(i).get(0));
                subResult.add(intervals.get(i).get(1));

                result.add(subResult);
            } else {
                // here we merge the intervals if result's last index value is smaller than intervals last index value

                result.get(resSize - 1).set(1, Math.max(result.get(resSize - 1).get(1), intervals.get(i).get(1)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> intervals = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(2, 6),
            Arrays.asList(8, 10),
            Arrays.asList(15, 18));

        System.out.println(mergeIntervals(intervals));
    }
}
