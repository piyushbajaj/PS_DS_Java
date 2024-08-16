package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 24 Sep, 2022
 */
public class Grokking8_FindPermutation {

    /**
     * TC: O(N)
     * SC: O(K), K -> Pattern length
     *
     * @param str
     * @param pattern
     * @return
     */
    static boolean findPermutation(String str, String pattern) {
        int l = 0, r = 0, n = str.length(), m = pattern.length(), matched = 0;

        // Pattern with frequencies
        Map<Character, Integer> hashPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            hashPattern.put(pattern.charAt(i), hashPattern.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        while (r < n) {
            char strCh = str.charAt(r);
            if (hashPattern.containsKey(strCh)) {
                hashPattern.put(strCh, hashPattern.getOrDefault(strCh, 0) - 1);

                if (hashPattern.getOrDefault(strCh, 0) == 0) {
                    matched++;
                }
            }
            r++;

            if (matched == hashPattern.size()) {
                return true;
            }

            // shrink the window if its gets greater than pattern length
            if (r - l >= m) {
                strCh = str.charAt(l);
                l++;
                if (hashPattern.containsKey(strCh)) {
                    if (hashPattern.getOrDefault(strCh, 0) == 0) {
                        matched--;
                    }

                    hashPattern.put(strCh, hashPattern.getOrDefault(strCh, 0) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("abcdxabcde", "abcdeabcdx"));
        System.out.println(findPermutation("eidboaoo", "ab"));
    }
}
