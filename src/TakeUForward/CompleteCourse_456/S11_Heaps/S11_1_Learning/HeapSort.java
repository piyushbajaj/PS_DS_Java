package TakeUForward.CompleteCourse_456.S11_Heaps.S11_1_Learning;

import java.util.Vector;

/**
 * Created by bajajp on 27 Sep, 2022
 */
public class HeapSort extends MaxHeap_PQ {
    public HeapSort(int capacity) {
        super(capacity);
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort(10);
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(9);
        vector.add(4);
        vector.add(11);
        vector.add(15);
        vector.add(2);

        System.out.println("Before heapsort: " + vector);
        heapSort.heapSort_algo(vector);

        System.out.println("After heapsort: " + vector);
    }

    /**
     * Use Max- heap for Heap Sort because:
     * 1. In the first step, it will arrange the element as per the max heap
     * 2. In the second step, it will keep moving larger element in the end, and will reduce the ith index
     * <p>
     * TC: O(nlogN)
     * SC: O(nlogN)
     *
     * @param vecA
     */
    public void heapSort_algo(Vector<Integer> vecA) {
        int n = vecA.size();

        // First heapify this to max heap, which means largest element will be on top
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify_down_custom(vecA, i, n);
        }

        // Now swap the largest element to the end and keep reducing the iteration

        for (int i = n - 1; i >= 0; i--) {
            swap_custom(vecA, i, 0);
            heapify_down_custom(vecA, 0, i);
        }
    }
}
