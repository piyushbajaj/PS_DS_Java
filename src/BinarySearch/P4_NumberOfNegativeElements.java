package BinarySearch;

/**
 * Created by bajajp on 14 Sep, 2022
 */
public class P4_NumberOfNegativeElements {

    public int numberOfNegative(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] < 0 && nums[mid + 1] >= 0) {
                return mid + 1;
            } else if (nums[mid] >= 0) {
                high = mid - 1;
            } else if (nums[mid] < 0 && nums[mid + 1] < 0)
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        P4_NumberOfNegativeElements p4_numberOfNegativeElements = new P4_NumberOfNegativeElements();
        int[] nums = {-101, -99, -54, -21, -3, 6, 12, 19, 20, 74, 92};
        System.out.println(p4_numberOfNegativeElements.numberOfNegative(nums));
    }
}
