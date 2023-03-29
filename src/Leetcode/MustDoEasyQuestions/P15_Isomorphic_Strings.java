package Leetcode.MustDoEasyQuestions;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 02/01/23
 * Time: 5:49 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/isomorphic-strings/description/">...</a>
 * solution link: <a href="https://leetcode.com/problems/isomorphic-strings/solutions/1261227/isomorphic-strings/">...</a>
 * <p>
 * pattern: hash table
 */
public class P15_Isomorphic_Strings {

    public static void main(String[] args) {
        P15_Isomorphic_Strings p15_isomorphic_strings = new P15_Isomorphic_Strings();
        System.out.println(p15_isomorphic_strings.isIsomorphic("egg", "add"));
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int[] int_s = new int[256];
        int[] int_t = new int[256];

        if (s.length() != t.length()) {
            return false;
        }

        // initialize with -1
        for (int i = 0; i < 256; i++) {
            int_s[i] = -1;
            int_t[i] = -1;
        }

        int len_s = s.length();
        int len_t = t.length();

        for (int i = 0; i < len_s; i++) {
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);

            if (int_s[ch_s] == -1 && int_t[ch_t] == -1) {
                int_s[ch_s] = ch_t;
                int_t[ch_t] = ch_s;
            } else if (!(int_s[ch_s] == ch_t && int_t[ch_t] == ch_s)) {
                return false;
            }
        }

        return true;
    }
}
