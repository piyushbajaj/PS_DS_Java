package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 26/12/22
 * Time: 11:59 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/majority-element/description/">...</a>
 */
public class P3_Majority_Element {

    public static void main(String[] args) {
        P3_Majority_Element p3_majority_element = new P3_Majority_Element();
        System.out.println(p3_majority_element.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
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

        int cnt = 0;
        int majorityElement = -1;

        for (int num : nums) {
            if (cnt == 0) {
                majorityElement = num;
            }

            if (majorityElement == num) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return majorityElement;
    }
}
