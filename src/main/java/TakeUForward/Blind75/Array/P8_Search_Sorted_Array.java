package TakeUForward.Blind75.Array;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 07/03/23
 * Time: 7:42 am
 */
public class P8_Search_Sorted_Array {

    public static void main(String[] args) {
        P8_Search_Sorted_Array p8_search_sorted_array = new P8_Search_Sorted_Array();
        System.out.println(p8_search_sorted_array.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 4));
    }

    /**
     * Approach:
     * 1. Initiate the pointer start to 0, and the pointer end to n - 1.
     * 2. Perform standard binary search. While start <= end:
     * 2.1. Take an index in the middle mid as a pivot.
     * 2.2. If nums[mid] == target, the job is done, return mid.
     * 2.3. Now there could be two situations:
     * 2.3.1. Pivot element is larger than the first element in the array, i.e. the subarray from the first element to
     * the pivot is non-rotated. If the target is located in non-rotated subarray, then go left: end = mid - 1, else
     * go right: start = mid + 1
     * 2.3.2. Pivot element is larger than the first element in the array, i.e. the subarray from the first element to
     * the pivot is non-rotated. If the target is located in non-rotated subarray, then go left: end = mid - 1, else
     * go right: start = mid + 1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[low]) {
                // First search in the sorted sub array from low...mid
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // First search in the sorted sub array from mid...high
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
