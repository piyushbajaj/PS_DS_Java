package OnlineTest.microsoft_online_test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by bajajp on 20 Sep, 2022
 */
public class P1 {

    // Function to find the minimum count of
    // characters required to be deleted to make
    // frequencies of all characters unique
    static int minCntCharDeletionsfrequency(int[] A) {

        int n = A.length;
        // Stores frequency of each distinct integer of integer
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Store frequency of each distinct character such that the largest frequency is present at the top
        PriorityQueue<Integer> priorityQueue_frequency = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        // Stores minimum count of characters required to be deleted to make frequency of each character unique
        int minCount = 0;

        // Traverse the String
        for (int i = 0; i < n; i++) {
            // Update frequency of str[i]
            hashMap.put(A[i], hashMap.getOrDefault(A[i], 0) + 1);
        }

        // Traverse the map
        for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
            // Insert current frequency into pq
            priorityQueue_frequency.add(it.getValue());
        }

        // Traverse the priority_queue
        while (!priorityQueue_frequency.isEmpty()) {
            // Stores topmost element of pq
            int frequency = priorityQueue_frequency.peek();

            // Pop the topmost element
            priorityQueue_frequency.remove();

            // If pq is empty
            if (priorityQueue_frequency.isEmpty()) {

                // Return cntChar
                return minCount;
            }

            // If frequent and topmost
            // element of pq are equal
            if (frequency == priorityQueue_frequency.peek()) {
                // If frequency of the topmost
                // element is greater than 1
                if (frequency > 1) {
                    // Insert the decremented
                    // value of frequent
                    priorityQueue_frequency.add(frequency - 1);
                }

                // Update cntChar
                minCount++;
            }
        }

        return minCount;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 3, 2, 5, 2, 3, 2};

        System.out.print(minCntCharDeletionsfrequency(arr));
    }


}
