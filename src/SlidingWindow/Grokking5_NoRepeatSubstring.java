package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bajajp on 23 Sep, 2022
 * Link: https://akshay-iyangar.github.io/system-design/grokking-coding-interviews/2-patttern-sliding-window/6-No-repeat-Substring-hard/1.1-No-repeat-Substring-hard.html
 */
public class Grokking5_NoRepeatSubstring {

    /**
     * TC: O(N)
     * SC: O(K)
     * @param str
     * @return
     */
    static int findLongestNonRepeatingSubString(String str) {
        int l = 0, r = 0, n = str.length();
        int maxLen = 0;

        Set<Character> characterSet = new HashSet<>();

        while (r < n) {
            Character chStr = str.charAt(r);
            if (!characterSet.contains(chStr)) {
                characterSet.add(chStr);
                r++;
            } else {
                while (characterSet.contains(chStr)) {
                    if (characterSet.contains(str.charAt(l))) {
                        characterSet.remove(str.charAt(l));
                        l++;
                    }
                }
            }
            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findLongestNonRepeatingSubString("abbbb"));
    }
}
