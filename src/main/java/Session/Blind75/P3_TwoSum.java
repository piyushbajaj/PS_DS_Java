package Session.Blind75;

import java.util.HashMap;

/**
 * Project: DSAlgo
 * Package: Session.Blind75
 * <p>
 * User: piyushbajaj
 * Date: 23/03/25
 * Time: 6:15 pm
 */
public class P3_TwoSum {


    /**
     * Approach: Using HashMap
     * 1. Check if target - nums[i] is in the hashMap, if yes then return indices
     * 2. If not then insert  -> nums[i], i
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hashMap.containsKey(diff)) {
                return new int[] {i, hashMap.get(diff)};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {

    }
}
