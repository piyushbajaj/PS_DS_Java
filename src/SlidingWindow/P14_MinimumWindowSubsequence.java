package SlidingWindow;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bajajp on 26 Sep, 2022
 */
public class P14_MinimumWindowSubsequence {
    static String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int l = 0, r = 0;

        // To store dictionary in the way of insertion
        Map<Character, Integer> dict_map = new LinkedHashMap<>();

        Map<Character, Integer> hash_map = new LinkedHashMap<>();

        for (int i = 0; i < m; i++) {
            dict_map.put(s2.charAt(i), dict_map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int[] answer = {-1, 0, 0};

        int formed = 0;
        int required = dict_map.size();

        while (r < n) {
            Character chAtS1 = s1.charAt(r);
            hash_map.put(chAtS1, hash_map.getOrDefault(chAtS1, 0) + 1);

            if (dict_map.containsKey(chAtS1) && hash_map.getOrDefault(chAtS1, 0)
                    .equals(dict_map.getOrDefault(chAtS1, 0))) {
                formed++;
            }


            while (l <= r && formed == required) {
                chAtS1 = s1.charAt(l);
                if (answer[0] == -1 || r - l < answer[0]) {
                    answer[0] = r - l;
                    answer[1] = l;
                    answer[2] = r;
                }

                hash_map.put(chAtS1, hash_map.getOrDefault(chAtS1, 0) - 1);

                if (dict_map.containsKey(chAtS1) && hash_map.get(chAtS1) < dict_map.get(chAtS1)) {
                    formed = 0;
                    l = r + 1;
                } else {
                    l++;
                }
            }
            r++;

        }
        return answer[0] == -1 ? "" : s1.substring(answer[1], answer[2] + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("abcdebdde", "bde"));
        System.out.println(minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u"));
        System.out.println(minWindow("cnhczmccqouqadqtmjjzl", "dq"));

        System.out.println(Math.floor(1.9));
    }
}
