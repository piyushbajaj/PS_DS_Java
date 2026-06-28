package Neetcode150.ArraysNHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: Neetcode150.ArraysNHashing
 * <p>
 * User: piyushbajaj
 * Date: 26/05/26
 * Time: 9:15 am
 */
public class P1_ContainsDuplicate {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public boolean hasDuplicate(int[] nums) {
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
        P1_ContainsDuplicate containsDuplicate = new P1_ContainsDuplicate();
        System.out.println(containsDuplicate.hasDuplicate(new int[] {1, 2, 3, 3}));
        System.out.println(containsDuplicate.hasDuplicate(new int[] {1, 2, 3, 4}));
    }
}
