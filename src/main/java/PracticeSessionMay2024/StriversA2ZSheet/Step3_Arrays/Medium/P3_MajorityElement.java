package PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Medium;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Medium
 * <p>
 * User: piyushbajaj
 * Date: 08/08/24
 * Time: 10:25 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/majority-element/">...</a>
 */
public class P3_MajorityElement {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;

        for (int num : nums) {
            if (count == 0) {
                count = 1;
                element = num;
            } else if (element == num) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (element == num) {
                count++;
            }
        }

        return (count >= n / 2) ? element : -1;
    }

    public static void main(String[] args) {
        P3_MajorityElement p3MajorityElement = new P3_MajorityElement();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(p3MajorityElement.majorityElement(nums));
    }
}
