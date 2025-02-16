package Session.May2024.StriversA2ZSheet.Step3_Arrays.Easy;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Easy
 * <p>
 * User: piyushbajaj
 * Date: 18/07/24
 * Time: 7:07 pm
 */
public class P9_LongestSubArrayWithSum {

    public int lenOfLongSubArr(int[] A, int N, int K) {
        int i = 0, j = i + 1;
        int sum = A[i];
        int lenMax = 0;

        while (j < N) {
            while (sum > K && i < j) {
                sum -= A[i];
                i++;
            }

            if (sum == K) {
                lenMax = Math.max(j - i, lenMax);
                i = j - 1;
                sum = A[i];
            } else {
                sum += A[j];
                j++;
            }

        }

        return lenMax;
    }

    public static void main(String[] args) {
        P9_LongestSubArrayWithSum p9LongestSubArrayWithSum = new P9_LongestSubArrayWithSum();
        int[] arr = {2, 3, 5};
        System.out.println(p9LongestSubArrayWithSum.lenOfLongSubArr(arr, arr.length, 5));

        int[] nums = {10, 5, 2, 7, 1, 9};
        System.out.println(p9LongestSubArrayWithSum.lenOfLongSubArr(nums, nums.length, 15));
    }
}
