package Practice2025.Neetcode.ArraysHashing.Heap.MaxHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing.Heap.MaxHeap
 * <p>
 * User: piyushbajaj
 * Date: 09/06/25
 * Time: 1:03 pm
 */
public class PQWithComparator {

    PriorityQueue<Person> priorityQueue;

    PQWithComparator() {
        // Sorting by Age in Reverse Order
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> -a.age));

        // Sorting by Age
        // priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.age));
    }

    void add(String name, int age) {
        priorityQueue.add(new Person(name, age));
    }

    void printQueue() {
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    public static void main(String[] args) {
        PQWithComparator pqWithComparator = new PQWithComparator();
        pqWithComparator.add("Alice", 30);
        pqWithComparator.add("Bob", 25);
        pqWithComparator.add("Charlie", 35);

        pqWithComparator.printQueue();
    }
}
