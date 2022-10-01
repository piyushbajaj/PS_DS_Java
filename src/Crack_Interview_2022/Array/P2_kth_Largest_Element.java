package Crack_Interview_2022.Array;

import Crack_Interview_2022.Sorting.P1_HeapSort;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created by bajajp on 04 Aug, 2022
 */
public class P2_kth_Largest_Element extends P1_HeapSort {

    public static int kthLargestElement(int[] arr, int k) {
        List<Integer> input = Arrays.stream(arr).boxed().collect(Collectors.toList());

        if (input.size() < k) {
            System.exit(-1);
        }

        // b - a shows that this is Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        // TC: O(n)
        pq.addAll(input);

        // TC: O(k*log(N))
        while (k > 1) {
            k--;
            pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kthLargestElement(arr, 3));
    }
}
