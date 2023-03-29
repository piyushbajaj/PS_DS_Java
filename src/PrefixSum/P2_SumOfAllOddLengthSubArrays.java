package PrefixSum;

/**
 * Created by bajajp on 25 Sep, 2022
 */
public class P2_SumOfAllOddLengthSubArrays {

    static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int oddSubArray = 0;

        for (int i = 0; i < n; i++) {
            int start = n - i;
            int end = i + 1;

            oddSubArray += ((start * end) + 1) / 2 * arr[i];
        }

        return oddSubArray;
    }

    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[] {1, 4, 2, 5, 3}));
    }
}
