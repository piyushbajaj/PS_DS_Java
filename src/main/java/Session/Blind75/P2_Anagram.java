package Session.Blind75;

import java.util.HashMap;

/**
 * Project: DSAlgo
 * Package: Session.Blind75
 * <p>
 * User: piyushbajaj
 * Date: 23/03/25
 * Time: 1:45 pm
 */
public class P2_Anagram {

    /**
     * Approach 1:
     * 1. Store first string in the hashMap along-with frequency
     * 2. Keep removing the elements from the hashMap as we go each element in the second string
     * <p>
     * TC: O(2N)
     * SC: O(26)
     * <p>
     * Approach 2:
     * Frequency Counter
     * 1. Create counter array of 26 length, as it can only contain lower case characters
     * 2. Increment counter of alphabet for 1st string and decrement counter from another string
     * <p>
     * TC: O(N)
     * SC: O(26)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (Character ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            } else {
                return false;
            }
        }

        return map.size() == 0;
    }

    public boolean isAnagram1(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m) {
            return false;
        }

        int[] counter = new int[26];

        for (int i = 0; i < n; i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        P2_Anagram p2Anagram = new P2_Anagram();
        System.out.println(p2Anagram.isAnagram("anagram", "nataram"));

    }
}
