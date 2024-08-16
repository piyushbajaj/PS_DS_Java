package StriverSDESheet.Arrays_Part2;

/**
 * Created by bajajp on 14 Aug, 2022
 */
public class P4_DuplicateNumberInArray {

    /**
     * TC: O(N)
     *
     * @param nums
     * @return
     */
    public static int duplicateInArray(int[] nums) {
//        int slow = arr[0];
//        int fast = arr[arr[slow]];
//
//        while (slow != fast) {
//            slow = arr[slow];
//            fast = arr[arr[fast]];
//        }
//
//        fast = arr[0];
//
//        while (slow != fast) {
//            slow = arr[slow];
//            fast = arr[fast];
//        }
//
//        return slow;

        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 3};
        System.out.println(duplicateInArray(arr));
    }
}
