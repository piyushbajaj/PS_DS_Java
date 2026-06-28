package Practice2025.Neetcode.ArraysHashing;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 03/04/25
 * Time: 10:24 am
 * <p>
 * Link: <a href="https://neetcode.io/problems/is-anagram">...</a>
 */
public class P2_Anagram {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
