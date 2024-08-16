package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 21 Sep, 2022
 */
public class P8_ReplaceSubstringForBalanceString_RL {

    static int balancedString(String s) {
        int n = s.length();
        int res = 0;

        if (n % 4 != 0) {
            return -1;
        }

        int lenOfEachElement = n / 4;
        Map<Character, Integer> countHash = new HashMap<>();

        countHash.put('Q', 0);
        countHash.put('W', 0);
        countHash.put('E', 0);
        countHash.put('R', 0);


        for (int i = 0; i < n; i++) {
            countHash.put(s.charAt(i), countHash.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> map : countHash.entrySet()) {
            res += Math.abs(map.getValue() - lenOfEachElement);
        }

        return res;
    }

    static int balancedString1(String s) {
        int[] count = new int[128];
        int n = s.length(), res = n, i = 0, k = n / 4;
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j)];
        }
        for (int j = 0; j < n; ++j) {
            --count[s.charAt(j)];
            while (i < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
                res = Math.min(res, j - i + 1);
                ++count[s.charAt(i++)];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(balancedString("WQWRQQQW"));
        System.out.println(balancedString1("WQWRQQQW"));
    }
}
