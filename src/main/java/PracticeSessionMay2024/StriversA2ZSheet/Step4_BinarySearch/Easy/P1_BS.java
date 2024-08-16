package PracticeSessionMay2024.StriversA2ZSheet.Step4_BinarySearch.Easy;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step4_BinarySearch.Easy
 * <p>
 * User: piyushbajaj
 * Date: 20/07/24
 * Time: 11:25 am
 */
public class P1_BS {


    /**
     * TC: O(logN)
     * SC: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        P1_BS p1BS = new P1_BS();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(p1BS.search(nums, 9));
    }
}
