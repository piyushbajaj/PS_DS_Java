package TakeUForward.CompleteCourse_456.S11_Heaps.S11_2_Medium;

import TakeUForward.CompleteCourse_456.S11_Heaps.S11_1_Learning.MinHeap_PQ;

import java.util.PriorityQueue;

/**
 * Created by bajajp on 27 Sep, 2022
 */
public class P2_KthSmallestElement {
    public int kthSmallest_minHeap(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            priorityQueue.add(arr[i]);
        }

        while (k > 1) {
            priorityQueue.poll();
            k--;
        }

        return priorityQueue.peek();
    }

    public int kthSmallest_minHeap_using_inhouse(int[] arr, int k) throws Exception {
        MinHeap_PQ minHeap_pq = new MinHeap_PQ(10);

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            minHeap_pq.push(arr[i]);
        }

        while (k > 1) {
            minHeap_pq.poll();
            k--;
        }

        return minHeap_pq.peek();
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int kthSmallest_minHeap_qs(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (true) {
            int smallestPartition = partition(arr, left, right);

            if (smallestPartition == k - 1) {
                return arr[smallestPartition];
            } else if (smallestPartition < k - 1) {
                left = smallestPartition + 1;
            } else {
                right = smallestPartition - 1;
            }
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }


    public static void main(String[] args) throws Exception {
        P2_KthSmallestElement p2_kthSmallestElement = new P2_KthSmallestElement();

        int[] arr = {1, 2, 6, 4, 5, 3};

        System.out.println(p2_kthSmallestElement.kthSmallest_minHeap(arr, 3));

        System.out.println(p2_kthSmallestElement.kthSmallest_minHeap_using_inhouse(arr, 3));

        System.out.println(p2_kthSmallestElement.kthSmallest_minHeap_qs(arr, 3));
    }
}
