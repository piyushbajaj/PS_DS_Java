package TakeUForward.S11_Heaps.S11_1_Learning;

import java.util.Vector;

/**
 * Created by bajajp on 27 Sep, 2022
 */
public class BaseHeap_PQ {
    public Vector<Integer> A;
    public Integer maxCapacity;

    public BaseHeap_PQ() {
        A = new Vector<>();
    }

    public BaseHeap_PQ(int capacity) {
        A = new Vector<>(capacity);
        maxCapacity = capacity;
    }

    public int parent(int i) {
        if (i == 0) {
            return 0;
        }

        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public void swap(int a, int b) {
        int temp = A.get(a);
        A.set(a, A.get(b));
        A.set(b, temp);
    }

    public void swap_custom(Vector<Integer> vector, int a, int b) {
        int temp = vector.get(a);
        vector.set(a, vector.get(b));
        vector.set(b, temp);
    }

    public int size() {
        return A.size();
    }

    public boolean isEmpty() {
        return A.size() == 0;
    }

    public Boolean contains(Integer i) {
        return A.contains(i);
    }

    public Integer[] toArray() {
        return A.toArray(new Integer[size()]);
    }
}
