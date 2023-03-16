package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 26/12/22
 * Time: 1:50 pm
 *
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0">...</a>
 */
public class P5_Print_SubArray_Maximum {
    public long pairWithMaxSum(long arr[], long N) {

        long maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < N - 1; i++) {
            maxSoFar = Math.max(arr[i] + arr[i + 1], maxSoFar);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        P5_Print_SubArray_Maximum p5_print_subArray_maximum = new P5_Print_SubArray_Maximum();
        System.out.println(p5_print_subArray_maximum.pairWithMaxSum(new long[] {4, 3, 1, 5, 6}, 5));
    }
}
