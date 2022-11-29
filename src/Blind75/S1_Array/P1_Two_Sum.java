package Blind75.S1_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: DS_Algo
 * Package: Blind75.S1_Array
 * <p>
 * User: piyushbajaj
 * Date: 19/11/22
 * Time: 5:19 pm
 */
public class P1_Two_Sum {
    /**
     * TC: O (Nlogn)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // Store Diff and Index
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (hashMap.containsKey(diff)) {
                return new int[] {hashMap.get(diff), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
