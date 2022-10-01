package SlidingWindow;

/**
 * Created by bajajp on 26 Sep, 2022
 * Link: https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 */
public class P11_ReplaceSubstringBalancedString {
    static int balancedString(String s) {
        int l = 0, r = 0, n = s.length();
        int res = 0;

        if (n < 4 || n % 4 != 0) {
            return -1;
        }

        int balancedCount = n / 4;

        int[] count = new int[26];

        int counter = 0;
        int countQ = 'Q' - 'A';
        int countW = 'W' - 'A';
        int countE = 'E' - 'A';
        int countR = 'R' - 'A';

        // Here we store all the occurrence of characters one by one
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'A']++;
        }

        while (r < n) {
            int chStr = s.charAt(r);
            if (s.charAt(r) == 'Q') {
                while (count[countQ] > balancedCount) {
                    if (count[countW] < balancedCount) {
                        count[countW]++;
                    } else if (count[countE] < balancedCount) {
                        count[countE]++;
                    } else if (count[countR] < balancedCount)
                        count[countR]++;
                    count[countQ]--;
                    counter++;
                }
            } else if (s.charAt(r) == 'W') {
                while (count[countW] > balancedCount) {
                    if (count[countQ] < balancedCount) {
                        count[countQ]++;
                    } else if (count[countE] < balancedCount) {
                        count[countE]++;
                    } else if (count[countR] < balancedCount)
                        count[countR]++;
                    count[countW]--;
                    counter++;
                }
            } else if (chStr == 'E') {
                while (count[countE] > balancedCount) {
                    if (count[countQ] < balancedCount) {
                        count[countQ]++;
                    } else if (count[countW] < balancedCount) {
                        count[countW]++;
                    } else if (count[countR] < balancedCount)
                        count[countR]++;
                    count[countE]--;
                    counter++;
                }
            } else if (chStr == 'R') {
                while (count[countR] > balancedCount) {
                    if (count[countQ] < balancedCount) {
                        count[countQ]++;
                    } else if (count[countW] < balancedCount) {
                        count[countW]++;
                    } else if (count[countE] < balancedCount)
                        count[countE]++;
                    count[countR]--;
                    counter++;
                }
            }
            r++;
        }

        return counter;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param s
     * @return
     */
    static int balancedString1(String s) {
        int l = 0, r = 0, n = s.length();
        int res = n, k = n / 4;
        int[] count = new int[26];
        int countQ = 'Q' - 'A';
        int countW = 'W' - 'A';
        int countE = 'E' - 'A';
        int countR = 'R' - 'A';

        // Here we store all the occurrence of characters one by one
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'A']++;
        }

        while (r < n) {
            int asciiAtCh = s.charAt(r) - 'A';
            count[asciiAtCh]--;
            r++;

            while (l < n && count[countQ] <= k && count[countW] <= k && count[countE] <= k && count[countR] <= k) {
                res = Math.min(res, r - l);
                count[s.charAt(l) - 'A']++;
                l++;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(balancedString("QQQW"));
        System.out.println(balancedString1("QQQW"));
    }
}
