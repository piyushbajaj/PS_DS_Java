package TechBoost_Old.DP_Prob;

/**
 * Created by piyush.bajaj on 19/04/18.
 * Time Complexity: O(N*N)
 */
public class LongestCommonSubsequence_Prob {
    public static void main(String[] args) {
        String s1 = "abcdaf";
        String s2 = "acbcf";

        calculate(s1, s2);
    }

    public static void calculate(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] mat = new int[n + 1][m + 1];
        int i = 0, j = 0;
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                }
            }
        }


        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }

        System.out.println(mat[n][m]);

        System.out.println(print_lcs(mat, n, m, s1, s2));

    }

    public static String print_lcs(int[][] mat, int n, int m, String s1, String s2) {
        StringBuilder str = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (mat[i][j] == mat[i - 1][j]) {
                i--;
            } else if (mat[i][j] == mat[i][j - 1]) {
                j--;
            } else {
                str.append(s1.charAt(i - 1));
                i--;
                j--;
            }

        }
        return str.toString();
    }
}
