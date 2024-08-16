package TakeUForward.Blind75.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 06/03/23
 * Time: 11:42 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/contains-duplicate/">...</a>
 */
public class P3_Contains_Duplicate {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1, 2, 3, 1}));
    }
}
