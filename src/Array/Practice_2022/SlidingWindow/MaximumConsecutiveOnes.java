package Array.Practice_2022.SlidingWindow;

/**
 * Created by bajajp on 23 May, 2022
 */
public class MaximumConsecutiveOnes {
    public int getMaxConsecutiveOnes(int[] arr, int k) {
        int n = arr.length;
        int consecutiveZeros = 0;
        int i = 0;
        int maxCount = 0;
        while (consecutiveZeros <= k && i < n) {
            if (arr[i] == 0) {
                consecutiveZeros++;
            }
            i++;
        }

        maxCount = i;

        for (int j = i; j < n; j++) {
            if (arr[j] == 0) {
                consecutiveZeros++;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

    }
}
