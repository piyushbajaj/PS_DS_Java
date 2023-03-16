package TakeUForward.Blind75.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.String
 * <p>
 * User: piyushbajaj
 * Date: 27/02/23
 * Time: 10:03 am
 */
public class P2_Longest_Repeating_Char_Replacement {

    /**
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int n = s.length();
        int l = 0, r = 0;

        hashMap.put(s.charAt(r), r++);
        int maxSoFar = 0;
        while (r < n) {
            if (!hashMap.containsKey(s.charAt(r))) {
                if (k > 0) {
                    k--;
                } else if (k == 0) {
                    l = Math.max(l, hashMap.get(s.charAt(l))) + 1;
                    k++;
                }
            }
            hashMap.put(s.charAt(r), r++);
            maxSoFar = Math.max(maxSoFar, r - l);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        P2_Longest_Repeating_Char_Replacement p2_longest_repeating_char_replacement =
            new P2_Longest_Repeating_Char_Replacement();
        System.out.println(p2_longest_repeating_char_replacement.characterReplacement("AABABBA", 1));
    }
}
