package TakeUForward.Blind75.Array;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 06/03/23
 * Time: 7:12 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">...</a>
 */
public class P7_Find_Min_Sorted_Array {

    /**
     * Use Customized Binary Search over here
     * TC: O(logN)
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        // base condition
        if (nums[low] < nums[high]) {
            return nums[low];
        }


        while (low < high) {
            int mid = (low + high) / 2;

            if (mid - 1 >= low && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (mid + 1 <= high && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid] < nums[low]) {
                high = mid - 1;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        P7_Find_Min_Sorted_Array p7_find_min_sorted_array = new P7_Find_Min_Sorted_Array();
        System.out.println(p7_find_min_sorted_array.findMin(new int[] {3, 4, 5, 1, 2}));
        System.out.println(p7_find_min_sorted_array.findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
        System.out.println(p7_find_min_sorted_array.findMin(new int[] {11, 13, 15, 17}));
    }
}
