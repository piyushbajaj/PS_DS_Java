package TakeUForward.Blind75.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Heap
 * <p>
 * User: piyushbajaj
 * Date: 25/01/23
 * Time: 11:39 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/top-k-frequent-elements/">...</a>
 */
public class P2_Top_K_Frequent_Elements {
    static class Frequency implements Comparable<Frequency> {
        int element;
        int count;

        Frequency(int element, int count) {
            this.element = element;
            this.count = count;
        }

        @Override
        public int compareTo(Frequency o) {
            return o.count > this.count ? 1 : -1;
        }
    }

    /**
     * TC: O(NlogN)
     * SC: O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Frequency> priorityQueue = new PriorityQueue<>();
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (int num : hashMap.keySet()) {
            priorityQueue.add(new Frequency(num, hashMap.get(num)));
        }

        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            result.add(priorityQueue.poll().element);
        }

        return result.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        P2_Top_K_Frequent_Elements p2_top_k_frequent_elements = new P2_Top_K_Frequent_Elements();
        System.out.println(Arrays.toString(p2_top_k_frequent_elements.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2)));
    }
}
