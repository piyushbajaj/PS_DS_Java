package Blind75.S1_Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DS_Algo
 * Package: Blind75.S1_Array
 * <p>
 * User: piyushbajaj
 * Date: 19/11/22
 * Time: 7:47 pm
 */
public class P3_Duplicate {
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
        P3_Duplicate p3_duplicate = new P3_Duplicate();
        int[] nums = {1, 2, 3, 1};

        System.out.println(p3_duplicate.containsDuplicate(nums));
    }
}
