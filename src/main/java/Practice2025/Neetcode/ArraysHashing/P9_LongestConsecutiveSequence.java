package Practice2025.Neetcode.ArraysHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 26/04/25
 * Time: 7:39 pm
 */
public class P9_LongestConsecutiveSequence {

    /**
     * Approach 1:
     * 1. Store all elements in the HashSet
     * 2. Loop through all the elements one by one
     * 2.1. Check if the hash contains previous element, if yes then continue the loop
     * 2.2. If it doesn't contain previous element, then this is the start of the sequence, counter = 1, and loop
     * through the sequence until it keep discovering counter + 1.
     * 2.3. At the end keep getting the maxCount it has discovered
     * 3. Return the maxCount
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        Set<Integer> numbersHashSet = new HashSet<>();
        for (int num : nums) {
            numbersHashSet.add(num);
        }

        int maxCount = 0;

        for (int num : numbersHashSet) {
            if (numbersHashSet.contains(num - 1)) {
                continue;
            }

            int count = 1;
            while (numbersHashSet.contains(num + count)) {
                count++;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int maxCount = 0;

        for (int num : hashSet) {
            if (!hashSet.contains(num - 1)) {
                int count = 1;
                while (hashSet.contains(num + count)) {
                    count++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        P9_LongestConsecutiveSequence longestConsecutiveSequence = new P9_LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutiveSequence.longestConsecutive1(new int[] {100, 4, 200, 1, 3, 2}));
    }
}
