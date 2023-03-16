package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 26/12/22
 * Time: 8:33 pm
 */
public class P9_Longest_Consecutive_Sequence {

    /**
     * TC: O(N)
     * SC: O(1)
     * assuming hashset takes O(1) to search
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> hashSet = new HashSet<>();

        if (n == 0) {
            return 0;
        }

        for (int num : nums) {
            hashSet.add(num);
        }
        int maxCount = 0;
        for (int num : nums) {
            if (!hashSet.contains(num - 1)) {
                int curr = num;
                int count = 0;
                while (hashSet.contains(curr)) {
                    count++;
                    curr++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        P9_Longest_Consecutive_Sequence p9_longest_consecutive_sequence = new P9_Longest_Consecutive_Sequence();
        System.out.println(
            p9_longest_consecutive_sequence.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }
}
