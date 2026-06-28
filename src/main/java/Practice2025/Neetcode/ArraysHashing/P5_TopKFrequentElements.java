package Practice2025.Neetcode.ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 03/04/25
 * Time: 7:52 pm
 * <p>
 * Approach 1:
 * 1. Using int[] of 2000 integers
 * 2. TC: O(4000), SC: O(2000)
 * <p>
 * Approach 2: Using Treemap, storing elements and their frequency
 * TC: O(NlogN)
 * SC: O(N)
 * <p>
 * Approach 3: Using HashMap and Array: Bucket Sort Algo
 * 1. Create HashMap<Integer Element, Frequency> and store all elements
 * 2. Create List Array to store frequency and elements mapped to each frequency
 * 3. Then iterate through hashMap and store all elements per frequency in Integer Array
 * 4. When iterating array from last, return k elements
 * <p>
 * TC: O(N)
 * SC: O(N)
 */
public class P5_TopKFrequentElements {

    /**
     * Approach 1: Using Sorting HashMap Values
     * <p>
     * 1. Create HashMap to store elements and their frequency
     * 2. Insert all elements one by one into this hashMap
     * 3. Create an empty List with Integer arrayElements int[]
     * 4. Add Frequency, Element into arrayElements
     * 5. Sort arrayElements on the basis of frequency in descending order
     * 6. Create output result set of k size, and then loop through each element
     * <p>
     * TC: O(NLogN)
     * SC: O(2N + K)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<int[]> arrayElements = new ArrayList<>();

        for (Map.Entry<Integer, Integer> map : frequencyMap.entrySet()) {
            arrayElements.add(new int[] {map.getValue(), map.getKey()});
        }

        arrayElements.sort((a, b) -> b[0] - a[0]);

        int[] result = new int[k];

        for (int index = 0; index < k; index++) {
            result[index] = arrayElements.get(index)[1];
        }

        return result;
    }

    /**
     * Approach 2: Using MinHeap
     * <p>
     * 1. Create HashMap to store elements and their frequency
     * 2. Insert all elements one by one into this hashMap
     * 3. Create MinHeap PQ on the basis of frequency and insert all the elements.
     * 3.1. As soon as it reaches size > k, then start polling as we only need to care about higher frequencies
     * 4. Iterate through all the elements, and insert the element into the result array
     * <p>
     * TC: O(N) + O(NLogK) + O(k) ~ O(NlogK)
     * SC: O(N) + O(N) + O(k) ~ O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // PQ as MinHeap
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (Map.Entry<Integer, Integer> map : frequencyMap.entrySet()) {
            priorityQueue.add(new int[] {map.getValue(), map.getKey()});

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];

        for (int index = 0; index < k; index++) {
            result[index] = priorityQueue.remove()[1];
        }

        return result;
    }


    /**
     * Approach 3: Bucket Sort
     * <p>
     * 1. Create HashMap to store elements and their frequency
     * 2. Insert all elements one by one into this hashMap
     * 3. Create Frequency array of List with size n+1
     * 4. Initialize with empty list for each element in frequency array
     * 5. Iterate through each element in hashMap, and insert into frequency array, getting frequency count and adding elements to that.
     * 6. Get the top 2 most frequent items going from back
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] frequencyCounter = new ArrayList[nums.length + 1];

        for (int i = 0; i < frequencyCounter.length; i++) {
            frequencyCounter[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> map : frequencyMap.entrySet()) {
            frequencyCounter[map.getValue()].add(map.getKey());
        }

        int[] result = new int[k];
        int cnt = 0;
        for (int index = frequencyCounter.length - 1; index > 0 && cnt < k; index--) {
            if (!frequencyCounter[index].isEmpty()) {
                for (int num : frequencyCounter[index]) {
                    result[cnt++] = num;
                    if (cnt == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMapElements = new HashMap<>();
        List<Integer>[] frequency = new List[nums.length + 1];
        int[] result = new int[k];

        for (int num : nums) {
            hashMapElements.put(num, hashMapElements.getOrDefault(num, 0) + 1);
        }

        for (int index = 0; index <= nums.length; index++) {
            frequency[index] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> map : hashMapElements.entrySet()) {
            frequency[map.getValue()].add(map.getKey());
        }

        int index = 0;
        for (int i = frequency.length - 1; i > 0 && index < k; i--) {
            for (int num : frequency[i]) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P5_TopKFrequentElements topKFrequentElements = new P5_TopKFrequentElements();
        int[] nums = {2, 2, 2, 2, 3, 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent1(nums, 2)));
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent2(nums, 2)));
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent3(nums, 2)));

        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 2)));
    }
}
