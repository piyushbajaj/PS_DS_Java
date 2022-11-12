package TakeUForward.S4_Binary_Search.S4_1_Learning;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S4_Binary_Search.S4_1_Learning
 * <p>
 * User: piyushbajaj
 * Date: 14/10/22
 * Time: 1:09 pm
 * <p>
 */
public class P4_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        int ceil = -1;
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid == end && nums[mid] < target) {
                return mid + 1;
            }

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                ceil = mid;
                end = mid - 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        P4_Search_Insert_Position p4_search_insert_position = new P4_Search_Insert_Position();
        System.out.println(p4_search_insert_position.searchInsert(nums, 7));
    }
}
