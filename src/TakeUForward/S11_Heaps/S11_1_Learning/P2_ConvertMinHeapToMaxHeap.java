package TakeUForward.S11_Heaps.S11_1_Learning;

import java.util.Vector;

/**
 * Created by bajajp on 27 Sep, 2022
 */
public class P2_ConvertMinHeapToMaxHeap extends MaxHeap_PQ {

    public P2_ConvertMinHeapToMaxHeap(int capacity) {
        super(capacity);
    }

    /**
     * TC: O(N)
     *
     * @param vector
     */
    public void buildMaxHeap(Vector<Integer> vector) {
        int n = vector.size();

        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify_down_custom(vector, i, n);
        }
    }

    public static void main(String[] args) {
        P2_ConvertMinHeapToMaxHeap p2_convertMinHeapToMaxHeap = new P2_ConvertMinHeapToMaxHeap(10);
        Vector<Integer> vectorA = new Vector<>();
        vectorA.add(1);
        vectorA.add(3);
        vectorA.add(4);
        vectorA.add(6);
        vectorA.add(10);
        vectorA.add(8);
        vectorA.add(5);

        System.out.println(vectorA);

        p2_convertMinHeapToMaxHeap.buildMaxHeap(vectorA);

        System.out.println(vectorA);

    }
}
