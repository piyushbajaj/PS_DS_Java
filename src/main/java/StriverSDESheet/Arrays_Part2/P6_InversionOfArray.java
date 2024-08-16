package StriverSDESheet.Arrays_Part2;

/**
 * Created by bajajp on 03 Sep, 2022
 */
public class P6_InversionOfArray {
    /**
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    public static int countInversions(int[] arr) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    /**
     * Optimal Approach merge sort technique
     *
     * @param arr
     * @param l
     * @param r
     */
    public static int mergeSortPrac(int[] arr, int l, int r) {
        int cnt = 0;
        if (l < r) {
            int m = (l + r) / 2;
            cnt += mergeSortPrac(arr, l, m);
            cnt += mergeSortPrac(arr, m + 1, r);
            cnt += mergePrac(arr, l, m, r);
        }
        return cnt;
    }

    public static int mergePrac(int[] arr, int l, int mid, int r) {
        int cnt = 0;
        int N1 = mid - l + 1;
        int N2 = r - mid;

        int[] L = new int[N1];
        int[] R = new int[N2];

        for (int i = 0; i < N1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < N2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < N1 && j < N2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                k++;
            } else {
                arr[k] = R[j];
                j++;
                k++;
                cnt += (mid - i);
            }
        }

        while (i < N1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < N2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};
        System.out.println(countInversions(arr));
        System.out.println(mergeSortPrac(arr, 0, arr.length - 1));
        System.out.println(3 / 2);
    }
}
