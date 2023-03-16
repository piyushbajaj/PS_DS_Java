package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 18 Sep, 2022
 * <p>
 * Link: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">...</a>
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */
public class P1_LongestSubstringWithoutRepeatingChar {

    /**
     * Using Sliding Window technique
     *
     * @param s
     * @return
     */
    static int longestSubstringWithoutRepeating(String s) {
        int l = 0, r = 0;
        int maxSoFar = 0;
        int n = s.length();
        Map<Character, Integer> charHashMap = new HashMap<>();

        while (r < n) {
            if (charHashMap.containsKey(s.charAt(r))) {
                l = Math.max(l, charHashMap.get(s.charAt(r)) + 1);
            }
            charHashMap.put(s.charAt(r), r++);
            maxSoFar = Math.max(maxSoFar, r - l);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeating("tmmzuxt"));
    }
}
