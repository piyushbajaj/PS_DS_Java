package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 19 Sep, 2022
 */
public class P3_MinimumWindowSubstring {
    /**
     * TC: O(M+N)
     * SC: O(M+N)
     *
     * @param s
     * @param t
     * @return
     */
    static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int l = 0, r = 0;

        if (m < n) return "";

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Window Length, left ptr, right ptr
        int[] res = {-1, 0, 0};

        // Character with Frequency
        Map<Character, Integer> dict_map_t = new HashMap<>();

        // Character with Frequency
        Map<Character, Integer> map_s = new HashMap<>();

        for (int i = 0; i < n; i++) {
            dict_map_t.put(t.charAt(i), dict_map_t.getOrDefault(t.charAt(i), 0) + 1);
        }

        int formed = 0;
        int required = dict_map_t.size();

        while (r < m) {
            Character charAt_s = s.charAt(r);
            // Pushing all element as r is going towards right
            map_s.put(charAt_s, map_s.getOrDefault(charAt_s, 0) + 1);

            if (dict_map_t.containsKey(charAt_s) && dict_map_t.get(charAt_s).equals(map_s.get(charAt_s))) {
                formed++;
            }

            // updating result and then increasing the left pointer also
            while (l <= r && formed == required) {
                charAt_s = s.charAt(l);
                if (res[0] == -1 || r - l + 1 < res[0]) {
                    res[0] = r - l + 1;
                    res[1] = l;
                    res[2] = r;
                }

                map_s.put(charAt_s, map_s.get(charAt_s) - 1);

                if (dict_map_t.containsKey(charAt_s) && map_s.get(charAt_s) < dict_map_t.get(charAt_s)) {
                    formed--;
                }

                l++;
            }
            r++;
        }
        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }

    public static void main(String[] args) {
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("aa", "aa"));
    }
}
