package DynamicProgramming;

/**
 * Created by piyush.bajaj on 30/07/17.
 */
public class maxSubArraySum {
    public static void main(String[] args) {
        maxSubArraySum ma = new maxSubArraySum();
        int[] arr = {2, -9, 5, 1, -4, 6, 0, -7, 8};
        int len = arr.length;

        System.out.println(ma.maxSum(arr, len));
    }

    public int maxSum(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > sum || (arr[i] + sum) >= 0) {
                sum += arr[i];
            } else if (arr[i] + sum < 0) {
                sum = 0;
            }
        }
        return sum;
    }
}
