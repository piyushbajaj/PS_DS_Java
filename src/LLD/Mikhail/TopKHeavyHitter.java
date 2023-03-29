package LLD.Mikhail;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: LLD.Mikhail
 * <p>
 * User: piyushbajaj
 * Date: 17/03/23
 * Time: 11:41 pm
 * <p>
 * ref: <a href="https://youtu.be/kx-XDoPjoHw?t=428">...</a>
 */
public class TopKHeavyHitter {
    static class HeavyHitter {
        private final int frequency;
        private final String identifier;

        HeavyHitter(int frequency, String identifier) {
            this.frequency = frequency;
            this.identifier = identifier;
        }
    }

    /**
     * Approach:
     * 1. Insert events in the frequency table along with the frequency
     * 2. Create a PQ, which stores events on the basis of minimum frequency
     * 3. Keep removing elements from heap till the size of keep is just k
     * <p>
     * TC: O(N) [HashMap] + O(M*log M) => O(N+M*logM), where N is the events size, M is the unique events in the array
     * SC: O(N)
     *
     * @param events
     * @param k
     * @return
     */
    public List<HeavyHitter> topK(String[] events, int k) {
        Map<String, Integer> frequencyTable = new HashMap<>();

        for (String event : events) {
            frequencyTable.put(event, frequencyTable.getOrDefault(event, 0) + 1);
        }

        // Priority queue stores minimum frequency
        PriorityQueue<HeavyHitter> heavyHitterPriorityQueue =
            new PriorityQueue<>(Comparator.comparingInt(e -> e.frequency));

        for (Map.Entry<String, Integer> map : frequencyTable.entrySet()) {
            // Inserting frequency and identifier in the min PQ by frequency
            heavyHitterPriorityQueue.offer(new HeavyHitter(map.getValue(), map.getKey()));

            // Keep removing elements from the heap, till heap reaches k
            if (heavyHitterPriorityQueue.size() > k) {
                heavyHitterPriorityQueue.poll();
            }
        }

        List<HeavyHitter> result = new ArrayList<>();

        while (!heavyHitterPriorityQueue.isEmpty()) {
            result.add(heavyHitterPriorityQueue.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        TopKHeavyHitter topKHeavyHitter = new TopKHeavyHitter();
        List<HeavyHitter> result = topKHeavyHitter.topK(new String[] {"A", "B", "C", "A", "A", "D", "C", "A", "B",
            "C"}, 2);

        for (HeavyHitter heavyHitter : result) {
            System.out.println(heavyHitter.identifier + " -> " + heavyHitter.frequency);
        }
    }
}
