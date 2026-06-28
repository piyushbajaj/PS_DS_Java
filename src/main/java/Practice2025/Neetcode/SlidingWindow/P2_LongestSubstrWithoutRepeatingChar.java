package Practice2025.Neetcode.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.SlidingWindow
 * <p>
 * User: piyushbajaj
 * Date: 19/06/25
 * Time: 5:56 pm
 */
public class P2_LongestSubstrWithoutRepeatingChar {

    /**
     * Approach 1: Storing characters in hashSet
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            while (characterSet.contains(s.charAt(right))) {
                characterSet.remove(s.charAt(left));
                left++;
            }
            characterSet.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        P2_LongestSubstrWithoutRepeatingChar longestSubstrWithoutRepeatingChar =
            new P2_LongestSubstrWithoutRepeatingChar();
        String str = "pwwkew";
        System.out.println(longestSubstrWithoutRepeatingChar.lengthOfLongestSubstring(str));
    }
}
