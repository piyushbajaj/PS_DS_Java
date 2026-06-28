package Practice2025.Neetcode.ArraysHashing.Heap.MinHeap;

import java.util.PriorityQueue;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing.Heap
 * <p>
 * User: piyushbajaj
 * Date: 09/06/25
 * Time: 12:41 pm
 */
public class PriorityQueueWithObjects {

    public static void main(String[] args) {
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Person("Alice", 30));
        priorityQueue.add(new Person("Bob", 25));
        priorityQueue.add(new Person("Charlie", 35));

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}

