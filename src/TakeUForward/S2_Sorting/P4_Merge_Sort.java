package TakeUForward.S2_Sorting;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S1_Sorting
 * <p>
 * User: piyushbajaj
 * Date: 13/10/22
 * Time: 9:07 am
 * <p>
 */
public class P4_Merge_Sort {

    /**
     * TC: O(N * log N)
     * SC: O(N)
     *
     * @param arr
     * @param start
     * @param end
     */
    public void merge_sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid + 1, end);
            merge_sort_util(arr, start, mid, end);
        }
    }

    public void merge_sort_util(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        // Push all the left side elements in the array
        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }

        // Push all the right side elements in the array
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // keep pushing the element left over

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        P4_Merge_Sort p4_merge_sort = new P4_Merge_Sort();
        int[] arr = {3, 2, 8, 5, 1, 4, 23};
        p4_merge_sort.merge_sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
