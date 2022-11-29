package LC_Contest.Weekly_13thNov;

/**
 * Project: DS_Algo
 * Package: LC_Contest.Weekly_13thNov
 * <p>
 * User: piyushbajaj
 * Date: 13/11/22
 * Time: 8:47 am
 */
public class LCM_SubArray {

    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        boolean[] elementsDivisible = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (k % nums[i] == 0) {
                elementsDivisible[i] = true;
            }
        }

        int startIndex = -1, endIndex = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (elementsDivisible[i] && startIndex == -1) {
                startIndex = i;
            } else if (!elementsDivisible[i]) {
                endIndex = i;
                count += countLCM(startIndex, i, nums, k);
                startIndex = -1;
            }
            // endIndex is smaller because all elements are true
            if (i == n - 1 && startIndex != -1 && endIndex < startIndex) {
                count += countLCM(startIndex, n, nums, k);
            }
        }

        return -1;
    }

    // endIndex - exclusive, startIndex - inclusive
    public int countLCM(int startIndex, int endIndex, int[] nums, int k) {
        for (int i = startIndex; i < endIndex; i++) {

        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
