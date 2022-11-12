package TakeUForward.S4_Binary_Search.S4_1_Learning;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S4_Binary_Search.S4_1_Learning
 * <p>
 * User: piyushbajaj
 * Date: 14/10/22
 * Time: 11:15 am
 * <p>
 */
public class P1_Find_X_Sorted_Array {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        // keeping <= to cover the case of single value also.
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P1_Find_X_Sorted_Array p1_find_x_sorted_array = new P1_Find_X_Sorted_Array();
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.out.println(p1_find_x_sorted_array.search(arr, 9));
    }
}
