package TakeUForward.Blind75.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.String
 * <p>
 * User: piyushbajaj
 * Date: 27/02/23
 * Time: 9:37 am
 * <p>
 * Lc: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">...</a>
 */
public class P1_Longest_Substring_Without_Char_Replacement {

    public static void main(String[] args) {
        P1_Longest_Substring_Without_Char_Replacement p1_longest_substring_without_char_replacement =
            new P1_Longest_Substring_Without_Char_Replacement();
        System.out.println(p1_longest_substring_without_char_replacement.lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Map<Character, Integer> hashMap = new HashMap<>();
        int l = 0, r = 0;
        int maxSoFar = Integer.MIN_VALUE;

        while (r < n) {
            if (hashMap.containsKey(s.charAt(r))) {
                l = Math.max(l, hashMap.get(s.charAt(r)) + 1);
            }
            hashMap.put(s.charAt(r), r++);
            maxSoFar = Math.max(maxSoFar, r - l);
        }

        return maxSoFar;
    }
}
