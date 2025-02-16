package Session.May2024.Blind75.Day1_Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.Blind75.Day1_Array
 * <p>
 * User: piyushbajaj
 * Date: 12/08/24
 * Time: 8:37 am
 */
public class P3_ContainsDuplicate {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for (Integer num : nums) {
            if (hashSet.contains(num)) {
                return true;
            }

            hashSet.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        P3_ContainsDuplicate containsDuplicate = new P3_ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[] {1, 2, 3, 1}));
    }
}
