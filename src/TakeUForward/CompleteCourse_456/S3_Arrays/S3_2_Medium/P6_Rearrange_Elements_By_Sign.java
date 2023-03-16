package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 26/12/22
 * Time: 2:50 pm
 */
public class P6_Rearrange_Elements_By_Sign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int i = 0;
        while (i < n - 1) {
            if (nums[i] > 0 && nums[i + 1] < 0) {
                i = i + 2;
                continue;
            } else {
                swap(nums, i, i + 1);
            }


        }

        return null;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }
}
