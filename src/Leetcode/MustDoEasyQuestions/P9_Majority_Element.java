package Leetcode.MustDoEasyQuestions;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 11:06 pm
 * <p>
 * Pattern:
 * Array
 * Hash Table
 * Divide and Conquer
 * Sorting
 * Counting
 * <p>
 * lc: <a href="https://leetcode.com/problems/majority-element/">...</a>
 */
public class P9_Majority_Element {

    public static void main(String[] args) {
        P9_Majority_Element p9_majority_element = new P9_Majority_Element();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(p9_majority_element.majorityElement(nums));
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        int curr = nums[0];

        for (int i = 1; i < n; i++) {
            if (count == 0) {
                curr = nums[i];
            }
            if (curr == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return curr;
    }
}
