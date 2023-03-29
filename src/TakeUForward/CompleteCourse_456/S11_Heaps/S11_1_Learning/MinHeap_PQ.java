package TakeUForward.CompleteCourse_456.S11_Heaps.S11_1_Learning;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by bajajp on 27 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
 * <p>
 * https://www.techiedelight.com/introduction-priority-queues-using-binary-heaps/
 * https://www.techiedelight.com/min-heap-max-heap-implementation-in-java/
 * <p>
 * Operations:
 * - Parent Node, Left Child Node, and Right Child Node
 * - Push Element -> O(logN)
 * - Remove Element -> O(logN)
 * - Peek -> O(1)
 */
public class MinHeap_PQ extends BaseHeap_PQ {

    public MinHeap_PQ() {
        super();
    }

    public MinHeap_PQ(int capacity) {
        super(capacity);
    }

    public static void main(String[] args) throws Exception {
        MinHeap_PQ minHeap_pq = new MinHeap_PQ(10);

        // insert three integers
        minHeap_pq.push(3);
        minHeap_pq.push(2);
        minHeap_pq.push(15);

        // print priority queue size
        System.out.println("Priority queue size is " + minHeap_pq.size());

        // search 2 in priority queue
        Integer searchKey = 2;

        if (minHeap_pq.contains(searchKey)) {
            System.out.println("Priority queue contains " + searchKey + "\n");
        }

        // empty queue
        minHeap_pq.clear();

        if (minHeap_pq.isEmpty()) {
            System.out.println("The queue is empty");
        }

//        System.out.println("\nCalling remove operation on an empty heap");
//        System.out.println("The element with the highest priority is " + minHeap_pq.poll());

//        System.out.println("\nCalling peek operation on an empty heap");
//        System.out.println("The element with the highest priority is " + minHeap_pq.peek() +
//                System.lineSeparator());

        // again insert three integers
        minHeap_pq.push(5);
        minHeap_pq.push(4);
        minHeap_pq.push(45);

        // construct an array containing all elements present in the queue
        Integer[] I = minHeap_pq.toArray();
        System.out.println("Printing array: " + Arrays.toString(I));

        System.out.println("\nThe element with the highest priority is " + minHeap_pq.poll());
        System.out.println("The element with the highest priority is " + minHeap_pq.peek());
    }

    /**
     * Once we insert new element in the end, then we do heapify all the elements upwards the array
     *
     * @param i
     */
    private void heapify_up(int i) {
        if (i > 0 && A.get(i) < A.get(parent(i))) {
            swap(i, parent(i));
            heapify_up(parent(i));
        }
    }

    /**
     * Once we remove element from the bottom, it replaces with top element, then we do heapify all the elements
     * downwards the array from the topmost element
     *
     * @param i
     */
    private void heapify_down(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < size() && A.get(left) < A.get(smallest)) {
            smallest = left;
        }

        if (right < size() && A.get(right) < A.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify_down(smallest);
        }
    }

    public void heapify_down_custom(Vector<Integer> vecA, int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        int n = vecA.size();

        if (left < n && vecA.get(left) < vecA.get(smallest)) {
            smallest = left;
        }

        if (right < n && vecA.get(right) < vecA.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify_down(smallest);
        }
    }

    /**
     * TC: O(logN)
     *
     * @param val
     * @throws Exception
     */
    public void push(int val) throws Exception {
        if (isEmpty()) {
            A.addElement(val);
            return;
        }

        if (size() > maxCapacity) {
            throw new Exception("Maximum capacity is reached");
        }

        A.addElement(val);
        int index = A.size() - 1;
        heapify_up(index);
    }

    /**
     * Idea here is the swap first and last element, and then remove last element, and heapify from first element
     * TC: O(logN)
     */
    public Integer poll() throws Exception {
        if (isEmpty()) {
            throw new Exception("Heap is already empty");
        }

        //Top element to be removed
        int topElement = A.firstElement();

        // Swap first and last element
        swap(0, size() - 1);

        A.remove(size() - 1);

        heapify_down(0);

        return topElement;
    }

    public Integer peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Heap is already empty");
        }

        return A.firstElement();
    }

    public void clear() throws Exception {
        System.out.println("Emptying queue");
        while (!A.isEmpty()) {
            System.out.print(poll() + " ");
        }
        System.out.println();
    }

}
