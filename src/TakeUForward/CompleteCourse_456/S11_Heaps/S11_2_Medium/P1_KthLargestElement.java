package TakeUForward.CompleteCourse_456.S11_Heaps.S11_2_Medium;

import java.util.PriorityQueue;

/**
 * Created by bajajp on 27 Sep, 2022
 * <p>
 * Approaches for this problem:
 * 1. Sort the array, and then take kth element from the end.
 * TC: O(nLogN), SC: O(1)
 * 2. Build the max heap and get the kth largest, build the min heap and get the smallest kth element.
 * TC: O(nLogN), SC: O(1)
 * 3. Quick-Select Algorithm, TC: O(N)
 */
public class P1_KthLargestElement {

    /**
     * TC: O(nlogK)
     *
     * @param arr
     * @param k
     * @return
     */
    static int kthLargest_maxHeap(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }

        while (k > 1) {
            priorityQueue.poll();
            k--;
        }

        return priorityQueue.peek() != null ? priorityQueue.peek() : -1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int kthLargest_maxHeap_qs(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (true) {
            int largestPartition = partition(arr, left, right);

            if (largestPartition == k - 1) {
                return arr[largestPartition];
            } else if (largestPartition < k - 1) {
                left = largestPartition + 1;
            } else {
                right = largestPartition - 1;
            }
        }
    }

    /**
     * In this all the elements to the left of partition index is greater than the pivot, and to the right are smaller
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (arr[l] < pivot && arr[r] > pivot) {
                swap(arr, l, r);
                l++;
                r--;
            }

            if (arr[l] >= pivot) {
                l++;
            }

            if (arr[r] <= pivot) {
                r--;
            }
        }
        swap(arr, left, r);
        return r;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 4, 5, 3};

        int[] arr1 = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println(kthLargest_maxHeap(arr, 3));

        System.out.println(kthLargest_maxHeap_qs(arr1, 4));
    }
}
