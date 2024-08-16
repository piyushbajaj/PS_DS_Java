package TakeUForward.Blind75.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: DSAlgo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 03/04/23
 * Time: 1:16 pm
 */
public class P9_3Sum {

    /**
     * TC: O(N*N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {

                int start = i + 1;
                int end = n - 1;

                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];

                    if (sum < 0) {
                        start++;
                    } else if (sum > 0) {
                        end--;
                    } else {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                        start++;
                        end--;

                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        P9_3Sum p93Sum = new P9_3Sum();
        System.out.println(p93Sum.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
