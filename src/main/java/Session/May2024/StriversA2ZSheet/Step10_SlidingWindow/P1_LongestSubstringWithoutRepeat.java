package Session.May2024.StriversA2ZSheet.Step10_SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step10_SlidingWindow
 * <p>
 * User: piyushbajaj
 * Date: 05/10/24
 * Time: 8:33 pm
 */
public class P1_LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = l + 1;
        int maxLen = -1;

        Set<Character> hashSet = new HashSet<>();
        hashSet.add(s.charAt(l));

        while (r < n) {
            if (hashSet.contains(s.charAt(r))) {
                hashSet.clear();
                l = r;
            } else {
                hashSet.add(s.charAt(r++));
                if (r - l > maxLen) {
                    maxLen = r - l;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        P1_LongestSubstringWithoutRepeat p1LongestSubstringWithoutRepeat = new P1_LongestSubstringWithoutRepeat();
        String s = "abcabcbb";
        System.out.println(p1LongestSubstringWithoutRepeat.lengthOfLongestSubstring(s));

        String s1 = "bbbb";
        System.out.println(p1LongestSubstringWithoutRepeat.lengthOfLongestSubstring(s1));

        String s2 = "pwwkew";
        System.out.println(p1LongestSubstringWithoutRepeat.lengthOfLongestSubstring(s2));
    }
}
