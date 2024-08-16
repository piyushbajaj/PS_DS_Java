package Sorting.Practice_2022;

import java.util.Arrays;

public class BubbleSort extends BaseClass {

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 1, 3, 5};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // TC: Best Case -> O(N)

    /**
     * It's the simplest algorithm, it will keep swapping sequential elements till the array is completely sorted.
     * TC: O(N^2)
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int firstPtr = n - 1; firstPtr >= 0; firstPtr--) {
            for (int secondPtr = 0; secondPtr <= firstPtr - 1; secondPtr++) {
                if (arr[secondPtr] > arr[secondPtr + 1]) {
                    swap(arr, secondPtr, secondPtr + 1);
                }
            }
        }
    }

    public void bubbleSort_better(int[] arr) {
        int n = arr.length;

        for (int firstPtr = n - 1; firstPtr >= 0; firstPtr--) {
            boolean flag = true;
            for (int secondPtr = 0; secondPtr <= firstPtr - 1 && flag; secondPtr++) {
                flag = false;
                if (arr[secondPtr] > arr[secondPtr + 1]) {
                    swap(arr, secondPtr, secondPtr + 1);
                    flag = true;
                }
            }
        }
    }
}
