package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 23 Sep, 2022
 * <p>
 * Link: https://akshay-iyangar.github.io/system-design/grokking-coding-interviews/2-patttern-sliding-window/7-Longest-Substring-with-Same-Letters-after-Replacement-hard/1.1-Longest-Substring-with-Letters-after-Replacement-hard.html
 */
public class Grokking6_LongestSubstringWithSameLetters {

    static int longestSubstringWithSameLetters(String s, int k) {
        int l = 0, r = 0, n = s.length();
        int maxLen = 0;

        // Letters with frequencies
        Map<Character, Integer> hashMap = new HashMap<>();

        int maxRepeatingLetters = 0;

        while (r < n) {
            Character chatAt_S = s.charAt(r);
            hashMap.put(chatAt_S, hashMap.getOrDefault(chatAt_S, 0) + 1);
            r++;
            maxRepeatingLetters = Math.max(maxRepeatingLetters, hashMap.getOrDefault(chatAt_S, 0));

            if (r - l - maxRepeatingLetters > k) {
                chatAt_S = s.charAt(l);
                hashMap.put(chatAt_S, hashMap.getOrDefault(chatAt_S, 0) - 1);
                if (hashMap.getOrDefault(chatAt_S, 0) == 0) {
                    hashMap.remove(chatAt_S);
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithSameLetters("aabccbb", 2));
        System.out.println(longestSubstringWithSameLetters("abbcb", 1));
        System.out.println(longestSubstringWithSameLetters("abccde", 1));
    }
}
