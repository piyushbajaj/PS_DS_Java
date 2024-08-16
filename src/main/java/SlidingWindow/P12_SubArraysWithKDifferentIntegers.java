package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 26 Sep, 2022
 */
public class P12_SubArraysWithKDifferentIntegers {
    static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinct_util(nums, k) - subarraysWithKDistinct_util(nums, k - 1);
    }

    static int subarraysWithKDistinct_util(int[] nums, int k) {
        int l = 0, r = 0;
        int n = nums.length;
        int res = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();

        while (r < n) {
            if (hashMap.getOrDefault(nums[r], 0) == 0) {
                k--;
            }

            hashMap.put(nums[r], hashMap.getOrDefault(nums[r], 0) + 1);
            r++;
            while (k < 0) {
                hashMap.put(nums[l], hashMap.getOrDefault(nums[l], 0) - 1);
                if (hashMap.getOrDefault(nums[l], 0) == 0) {
                    hashMap.remove(nums[l]);
                    k++;
                }
                l++;
            }

            res += r - l;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[] {1, 2, 1, 2, 3}, 2));
    }

}
