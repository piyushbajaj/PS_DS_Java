package CompanyWise.Foray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 06/03/23
 * Time: 11:29 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/two-sum/">...</a>
 */
public class P1_Two_Sum {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
    }
}
