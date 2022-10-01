package SlidingWindow;

/**
 * Created by bajajp on 26 Sep, 2022
 * Link: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 */
public class P9_NumberOfSubstringsContainingAllThreeChars {

    /**
     * Using the technique of Sliding Window
     * TC: O(n)
     * SC: O(1)
     *
     * @param s
     * @return
     */
    static int numberOfSubstrings(String s) {
        int l = 0, r = 0, n = s.length(), res = 0;
        int[] count = new int[3];

        while (r < n) {
            count[s.charAt(r) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(l) - 'a']--;
                l++;
            }
            r++;

            res += l;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
    }
}
