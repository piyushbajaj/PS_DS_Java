package TakeUForward.Blind75.Interval;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Interval
 * <p>
 * User: piyushbajaj
 * Date: 21/02/23
 * Time: 8:44 pm
 * lc: <a href="https://leetcode.com/problems/find-all-duplicates-in-an-array/">...</a>
 */
public class P4_Find_All_Duplicates {
    public static void main(String[] args) {
        P4_Find_All_Duplicates p4_find_all_duplicates = new P4_Find_All_Duplicates();
        System.out.println(p4_find_all_duplicates.findDuplicates_better(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.contains(num)) {
                hashSet.add(num);
            } else {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    /**
     * Using counting sort algo
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates_better(int[] nums) {
        int n = nums.length;
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return duplicates;
    }
}
