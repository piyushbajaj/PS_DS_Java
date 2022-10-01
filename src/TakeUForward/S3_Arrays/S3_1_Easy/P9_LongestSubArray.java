package TakeUForward.S3_Arrays.S3_1_Easy;

/**
 * Created by bajajp on 18 Sep, 2022
 */
public class P9_LongestSubArray {
    static int longestSubArray(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0;
        int count = 0;
        int maxSoFar = 0;

        while (i < n) {
            if (arr[i] <= k) {
                if (sum == 0) {
                    sum += arr[i];
                    if (sum == k) {
                        count = 1;
                        maxSoFar = Math.max(maxSoFar, count);
                    }
                    j++;
                }
                if (i != j) {
                    if (sum + arr[j] <= k) {
                        sum += arr[j];

                        if (sum == k) {
                            count = j - i;
                            maxSoFar = Math.max(maxSoFar, count);
                        }
                    } else {
                        i++;
                        j++;
                    }
                }
            } else {
                i++;
                j++;
            }
        }

        return -1;
    }

    static int longestSubArray1(int[] arr, int k) {
        int l = 0, r = 0, n = arr.length;
        int sum = 0, longestSubArray = 0, count = 0;

        while (r < n) {
            if (sum == k) {
                count++;
            }

            sum += arr[r];
            r++;

            if (sum == k) {
                count++;
            } else if (sum > k) {
                sum -= arr[l];
                l++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestSubArray1(new int[]{1, 1, 1}, 2));
        System.out.println(longestSubArray1(new int[]{1, 2, 3}, 3));
        System.out.println(longestSubArray1(new int[]{1, 2, 1, 2, 1}, 3));

    }
}
