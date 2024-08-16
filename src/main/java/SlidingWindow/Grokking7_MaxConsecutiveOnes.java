package SlidingWindow;

/**
 * Created by bajajp on 24 Sep, 2022
 */
public class Grokking7_MaxConsecutiveOnes {
    static int maxConsecutiveOnes(int[] arr, int k) {
        int l = 0, r = 0, n = arr.length;
        int maxLen = 0;
        int countZeroes = 0;

        if (n > 100000 || n <= 0) {
            return -1;
        }

        if (k > n || k < 0) {
            return -1;
        }

        while (r < n) {
            if (arr[r] == 0) {
                countZeroes++;
            }
            r++;

            if (countZeroes == k) {
                maxLen = Math.max(maxLen, r - l);
            } else if (countZeroes > k) {
                while (countZeroes > k) {
                    if (arr[l] == 0) {
                        countZeroes--;
                    }
                    l++;
                }
            }

            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
