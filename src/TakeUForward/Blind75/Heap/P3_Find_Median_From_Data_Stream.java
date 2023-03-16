package TakeUForward.Blind75.Heap;

import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Heap
 * <p>
 * User: piyushbajaj
 * Date: 23/02/23
 * Time: 11:23 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/find-median-from-data-stream/">...</a>
 */
public class P3_Find_Median_From_Data_Stream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /**
     * Approach:
     * 1. Keep storing all the lower numbers in the MaxHeap, like if the current number is smaller than the maxHeap
     * peek element, then add to the maxHeap
     * 2. Keep storing all the higher numbers in the MinHeap, like if the current number is higher than minHeap peek
     * element, then add to the minHeap
     * 3. Keep balancing the PQ in such a way that MaxHeap Size > MinHeap Size + 1, if not satisfied, then remove the
     * element from MaxHeap to the MinHeap. While if the MaxHeap Size < MinHeap, then remove the element from MinHeap
     * to the MaxHeap.
     * 4. If the MinHeap Size == MaxHeap Size, then medium is the average of both the peeks, or else MaxHeap Peek
     * <p>
     * TC: Adding: O(logN)
     * SC: O(N)
     */
    public P3_Find_Median_From_Data_Stream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Adjust the elements, such that max heap will never contain 1 more element than min heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        P3_Find_Median_From_Data_Stream p3_find_median_from_data_stream = new P3_Find_Median_From_Data_Stream();
        p3_find_median_from_data_stream.addNum(1);
        p3_find_median_from_data_stream.addNum(2);
        p3_find_median_from_data_stream.addNum(3);
        System.out.println(p3_find_median_from_data_stream.findMedian());
    }

}
