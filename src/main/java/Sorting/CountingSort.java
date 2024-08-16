package Sorting;

/**
 * Created by piyush.bajaj on 15/01/17.
 * Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
 */
public class CountingSort {
    public static void main(String[] args) {
        CountingSort QS = new CountingSort();
        int[] arr = {1, 4, 1, 2, 10, 5, 2};
        System.out.println("Original Array: ");
        QS.printArray(arr);
        System.out.println("After applying Counting Sort in an Array: ");
        QS.CountingSortAlgo(arr);
        QS.printArray(arr);
    }

    public void CountingSortAlgo(int[] arr) {

        int[] count = new int[256]; //This will keep the count of unique digits
        int[] output = new int[arr.length]; //To store output in the array

        for (int i = 0; i < arr.length; i++) {
            ++count[arr[i]];
        }

        //take the sum of counts
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        //output
        //Here we kept arr[i]]-1 because to put it from 0th Index
        for (int i = 0; i < arr.length; i++) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        //Putting back into the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }

    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
