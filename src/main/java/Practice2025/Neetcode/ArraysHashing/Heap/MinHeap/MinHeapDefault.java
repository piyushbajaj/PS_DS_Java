package Practice2025.Neetcode.ArraysHashing.Heap.MinHeap;

import java.util.PriorityQueue;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing.Heap
 * <p>
 * User: piyushbajaj
 * Date: 09/06/25
 * Time: 12:13 pm
 */
public class MinHeapDefault {

    PriorityQueue<Integer> priorityQueue;

    MinHeapDefault() {
        priorityQueue = new PriorityQueue<>();
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

    void printHeapSort() {
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
    }


    public static void main(String[] args) {
        MinHeapDefault minHeapDefault = new MinHeapDefault();
        minHeapDefault.add(10);
        minHeapDefault.add(5);
        minHeapDefault.add(20);
        minHeapDefault.add(15);

        System.out.println(minHeapDefault.peek());
        System.out.println(minHeapDefault.remove());
        System.out.println(minHeapDefault.peek());

        minHeapDefault.printHeapSort();
    }
}
