package PracticeSessionMay2024.TechBoost.Arrays;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost.Arrays
 * <p>
 * User: piyushbajaj
 * Date: 05/07/24
 * Time: 6:21 pm
 */
public class UnionOfArrays {


    /**
     * TC: O(N+M)
     * SC: O(N+M)
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] unionArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int k = Math.min(n, m);
        int[] arr = new int[n + m];

        int cnt1 = 0, cnt2 = 0, cnt = 0;
        while (cnt < k) {
            if (arr1[cnt1] < arr2[cnt2]) {
                arr[cnt] = arr1[cnt1];
                cnt1++;
            } else {
                arr[cnt] = arr2[cnt2];
                cnt2++;
            }
            cnt++;
        }

        while (cnt1 < n) {
            arr[cnt++] = arr1[cnt1++];
        }

        while (cnt2 < m) {
            arr[cnt++] = arr2[cnt2++];
        }

        return arr;
    }

    public static void main(String[] args) {
        UnionOfArrays unionOfArrays = new UnionOfArrays();
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 4, 5};

        System.out.println(Arrays.toString(unionOfArrays.unionArrays(arr1, arr2)));
    }
}
