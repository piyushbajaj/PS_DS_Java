package TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_1_Easy
 * <p>
 * User: piyushbajaj
 * Date: 14/10/22
 * Time: 9:08 am
 * <p>
 */
public class P10_Missing_Number_In_Array {

    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int expectedSum = n * (n + 1) / 2;

        return expectedSum - sum;
    }
}
