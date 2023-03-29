package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by piyush.bajaj on 17/01/17.
 */
public class sortElementsByFrequency {

    HashMap<Integer, Integer> frequencyMap = new HashMap<>();

    public static void main(String[] args) {
        sortElementsByFrequency SF = new sortElementsByFrequency();
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};

        //SF.heapSort(arr);
        //SF.printArray(arr, arr.length);

        SF.sortElementByFreq(arr, arr.length);
        //System.out.println(SF.frequencyMap);

    }

    //Sorting elements using Heap-Sort
    /*
    1. Create left & right function
    2. Create Swap function
    3. Create Heapify Function to re-arrage array
    4. Create HeapSort function
     */

    public void sortElementByFreq(int[] arr, int n) {

        int count = 0, max = 0, k = 0;


        for (int i = 0; i < n; i++) {
            if (frequencyMap.containsKey(arr[i])) {
                frequencyMap.put(arr[i], frequencyMap.get(arr[i]) + 1);
            } else {
                frequencyMap.put(arr[i], 1);
            }
        }

        while (!frequencyMap.isEmpty()) {
            for (Map.Entry<Integer, Integer> key : frequencyMap.entrySet()) {
                if (key.getValue() > max) {
                    max = key.getValue();
                    k = key.getKey();
                }
            }

            for (int i = 0; i < max; i++) {
                System.out.print(k + " ");
            }
            frequencyMap.remove(k);
            max = 0;
        }

        //return frequencyMap;

    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapify(int[] arr, int i, int n) {
        int l = left(i);
        int r = right(i);
        int large = i;

        if (l < n && arr[l] > arr[large]) {
            large = l;
        }

        if (r < n && arr[r] > arr[large]) {
            large = r;
        }

        if (large != i) {
            swap(arr, large, i);
            heapify(arr, large, n);
        }
    }

    public void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        //one by one extract an element from the heap
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
