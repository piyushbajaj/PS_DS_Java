package Session.Blind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: Session.Blind75
 * <p>
 * User: piyushbajaj
 * Date: 23/03/25
 * Time: 1:32 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/contains-duplicate/">...</a>
 */
public class P1_ContainsDuplicate {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> hashSet = new HashSet<>();

        for (int val : nums) {
            if (hashSet.contains(val)) {
                return true;
            } else {
                hashSet.add(val);
            }
        }

        return false;

    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    public static void main(String[] args) {

    }
}
