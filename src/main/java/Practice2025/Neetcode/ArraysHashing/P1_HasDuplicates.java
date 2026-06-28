package Practice2025.Neetcode.ArraysHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 03/04/25
 * Time: 9:59 am
 *
 * Link: <a href="https://neetcode.io/problems/duplicate-integer">...</a>
 */
public class P1_HasDuplicates {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> result = new HashSet<>();
        for (int num : nums) {
            if (result.contains(num)) {
                return true;
            }
            result.add(num);
        }
        return false;
    }
}
