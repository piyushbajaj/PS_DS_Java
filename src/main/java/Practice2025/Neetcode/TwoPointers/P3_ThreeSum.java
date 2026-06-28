package Practice2025.Neetcode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.TwoPointers
 * <p>
 * User: piyushbajaj
 * Date: 14/06/25
 * Time: 11:51 am
 */
public class P3_ThreeSum {

    /**
     * Approach:
     * 1. Sort the numbers
     * 2. Outer loop from start to end, one by one
     * 2.1. If start element is greater than 0, then return
     * 2.2. If the current element and previous element is equal, increment the pointer
     * 2.3. Inner loop from index+1 to end
     * 2.3.1. If sum < 0, increment start pointer.
     * 2.3.2. If sum > 0, decrement end pointer.
     * 2.3.3. Add the sub-result to the result array, increment start ptr, decrement end ptr.
     * 2.3.4. If nums[start] == nums[start-1], increment start pointer
     * <p>
     * TC: O(NlogN) + O(N^2)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int index = 0; index < len; index++) {
            if (nums[index] > 0) {
                break;
            }

            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }

            int start = index + 1;
            int end = len - 1;
            while (start < end) {
                List<Integer> subResult = new ArrayList<>();
                int sum = nums[index] + nums[start] + nums[end];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    subResult.add(nums[index]);
                    subResult.add(nums[start]);
                    subResult.add(nums[end]);
                    start++;
                    end--;

                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }

                    result.add(subResult);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P3_ThreeSum threeSum = new P3_ThreeSum();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum(arr));
    }
}
