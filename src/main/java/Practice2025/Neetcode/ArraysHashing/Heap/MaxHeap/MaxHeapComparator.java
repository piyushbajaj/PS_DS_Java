package Practice2025.Neetcode.ArraysHashing.Heap.MaxHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing.Heap
 * <p>
 * User: piyushbajaj
 * Date: 09/06/25
 * Time: 12:30 pm
 */
public class MaxHeapComparator {

    PriorityQueue<Integer> priorityQueue;

    MaxHeapComparator() {
        priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    }

    void add(int val) {
        priorityQueue.add(val);
    }

    Integer remove() {
        return priorityQueue.poll();
    }

    Integer peek() {
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        MaxHeapComparator maxHeapComparator = new MaxHeapComparator();
        maxHeapComparator.add(10);
        maxHeapComparator.add(5);
        maxHeapComparator.add(20);
        maxHeapComparator.add(15);

        System.out.println(maxHeapComparator.peek());
        System.out.println(maxHeapComparator.remove());
        System.out.println(maxHeapComparator.peek());
    }
}
