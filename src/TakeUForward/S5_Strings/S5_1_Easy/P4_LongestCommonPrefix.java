package TakeUForward.S5_Strings.S5_1_Easy;

/**
 * Created by bajajp on 28 Sep, 2022
 */
public class P4_LongestCommonPrefix {
    static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int minCol = 0;
        String str = "";
        for (int i = 0; i < n; i++) {
            minCol = Math.min(minCol, strs[i].length());
        }

        int j = 0;
        for (j = 0; j < minCol; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
                    continue;
                }
                if (i == n - 1) {

                }
            }
        }

        return "";
    }

    public static void main(String[] args) {

    }
}
