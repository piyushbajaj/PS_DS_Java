package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bajajp on 24 Sep, 2022
 */
public class Grokking9_LongestSubstringWithoutAnyRepeatingChar {

    /**
     * TC: O(N)
     * SC: O(K)
     *
     * @param str
     * @return
     */
    static int longestSubstringWithoutAnyRepeatingCharacter(String str) {
        int l = 0, r = 0, n = str.length();
        int maxLen = 0;

        Set<Character> hashSet = new HashSet<>();

        while (r < n) {
            char ch = str.charAt(r);
            if (hashSet.contains(ch)) {
                while (hashSet.contains(ch)) {
                    char ch_l = str.charAt(l);
                    hashSet.remove(ch_l);
                    l++;
                }
            }
            hashSet.add(ch);
            r++;

            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutAnyRepeatingCharacter("pwwkew"));
    }
}
