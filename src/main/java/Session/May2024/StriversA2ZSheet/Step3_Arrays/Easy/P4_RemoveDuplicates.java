package Session.May2024.StriversA2ZSheet.Step3_Arrays.Easy;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays
 * <p>
 * User: piyushbajaj
 * Date: 17/07/24
 * Time: 10:01 am
 */
public class P4_RemoveDuplicates {

    /**
     * 2-Pointer Approach
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0, j = i + 1;

        while (j < n) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3};
        System.out.println(removeDuplicates(arr));
    }
}
