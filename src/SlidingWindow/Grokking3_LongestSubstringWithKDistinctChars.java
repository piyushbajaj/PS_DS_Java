package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 23 Sep, 2022
 */
public class Grokking3_LongestSubstringWithKDistinctChars {

    /**
     * TC: O(N)
     * SC: O(N)
     * @param str
     * @param k
     * @return
     */
    static int findLength(String str, int k) {
        int l = 0, r = 0, n = str.length();
        int maxLen = 0;

        // Storing Characters with Frequencies
        Map<Character, Integer> hashMap = new HashMap<>();

        while (r < n) {
            if (hashMap.size() <= k) {
                hashMap.put(str.charAt(r), hashMap.getOrDefault(str.charAt(r), 0) + 1);
                r++;
                if (hashMap.size() == k) {
                    maxLen = Math.max(maxLen, r - l);
                }
            }

            while (hashMap.size() > k) {
                hashMap.put(str.charAt(l), hashMap.getOrDefault(str.charAt(l), 0) - 1);
                if (hashMap.getOrDefault(str.charAt(l), 0) == 0) {
                    hashMap.remove(str.charAt(l));
                }
                l++;
            }
        }

        // for cases when K is greater than N
        return maxLen == 0 ? Math.max(maxLen, r - l) : maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findLength("a", 2));
    }
}
