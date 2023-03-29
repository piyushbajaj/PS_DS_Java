package SlidingWindow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bajajp on 19 Sep, 2022
 * <p>
 * Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * <p>
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k
 * distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 */
public class P2_LongestSubstringWithKDistinctChar {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param s
     * @param k
     * @return
     */
    static int longestSubstringWithKDistinct(String s, int k) {
        int l = 0, r = 0;
        int n = s.length();
        int maxSoFar = 0;
        Map<Character, Integer> hashMap = new HashMap<>();

        if (k == 0) {
            return 0;
        }

        while (r < n) {
            if (hashMap.containsKey(s.charAt(r))) {
                hashMap.put(s.charAt(r), hashMap.get(s.charAt(r)) + 1);
                r++;
            } else {
                if (hashMap.size() < k) {
                    hashMap.put(s.charAt(r++), 1);
                } else {
                    if (hashMap.get(s.charAt(l)) > 1) {
                        hashMap.put(s.charAt(l), hashMap.get(s.charAt(l)) - 1);
                    } else {
                        hashMap.remove(s.charAt(l));
                        hashMap.put(s.charAt(r++), 1);
                    }
                    l++;
                }
            }
            maxSoFar = Math.max(maxSoFar, r - l);
        }
        return maxSoFar;
    }

    /**
     * With LinkedHashMap, here we store in Map -> Character and its Index
     * TC: O(N)
     * SC: O(N)
     *
     * @param s
     * @param k
     * @return
     */
    static int longestSubstringWithKDistinct1(String s, int k) {
        int l = 0, r = 0;
        int maxSoFar = 0;
        int n = s.length();
        Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();

        while (r < n) {
            Character charAt_r = s.charAt(r);
            if (linkedHashMap.containsKey(charAt_r)) {
                linkedHashMap.remove(charAt_r);
            } else if (linkedHashMap.size() >= k) {
                Map.Entry<Character, Integer> leftMost = linkedHashMap.entrySet().iterator().next();
                linkedHashMap.remove(leftMost.getKey());
                l = leftMost.getValue() + 1;
            }
            linkedHashMap.put(charAt_r, r++);
            maxSoFar = Math.max(maxSoFar, r - l);
        }

        return maxSoFar;
    }


    public static void main(String[] args) {
        System.out.println(longestSubstringWithKDistinct("a", 0));
    }
}
