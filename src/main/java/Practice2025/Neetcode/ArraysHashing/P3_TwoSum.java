package Practice2025.Neetcode.ArraysHashing;

import java.util.HashMap;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 03/04/25
 * Time: 10:32 am
 */
public class P3_TwoSum {

    /**
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
                return new int[] {hashMap.get(diff), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[] {};
    }

    public int[] twoSum_better(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hashMap.containsValue(diff)) {
                return new int[] {hashMap.get(diff), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[] {};
    }
}
