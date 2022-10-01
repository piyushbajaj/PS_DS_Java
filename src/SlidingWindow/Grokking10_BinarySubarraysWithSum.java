package SlidingWindow;

/**
 * Created by bajajp on 24 Sep, 2022
 */
public class Grokking10_BinarySubarraysWithSum {
    static int numSubarraysWithSum(int[] nums, int goal) {
        int l = 0, r = 0, n = nums.length, noOfSubArrays = 0;
        int sum = 0;

        while (r < n) {
            sum += nums[r];


            if (sum > goal) {
                sum -= nums[l];
                l++;
            }

            if (sum == goal) {
                noOfSubArrays++;
            }
            r++;
        }

        return noOfSubArrays;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}
