package TakeUForward.CompleteCourse_456.S16_DP.S16_8_MCM_DP;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_8_MCM_DP
 * <p>
 * User: piyushbajaj
 * Date: 06/01/23
 * Time: 1:45 pm
 */
public class P4_Evaluate_Boolean_Expression_To_True_follow {
    /**
     * Recursion
     * TC: Exponential
     * SC:
     *
     * @param N
     * @param S
     * @return
     */
    public int countWays_recur(int N, String S) {
        return countWays_recur_util(0, N - 1, true, S);
    }

    public int countWays_recur_util(int i, int j, boolean isTrue, String S) {
        // base condition
        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (isTrue) {
                if (S.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (S.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        int ways = 0;

        for (int index = i + 1; index <= j - 1; index++) {
            int LT = countWays_recur_util(i, index - 1, true, S);
            int LF = countWays_recur_util(i, index - 1, false, S);
            int RT = countWays_recur_util(index + 1, j, true, S);
            int RF = countWays_recur_util(index + 1, j, false, S);

            if (S.charAt(index) == '&') {
                if (isTrue) {
                    ways += LT * RT;
                } else {
                    ways += LT * RF + LF * RT + LF * RF;
                }
            } else if (S.charAt(index) == '|') {
                if (isTrue) {
                    ways += LT * RT + LT * RF + LF * RT;
                } else {
                    ways += LF * RF;
                }
            } else if (S.charAt(index) == '^') {
                if (isTrue) {
                    ways += LT * RF + LF * RT;
                } else {
                    ways += LT * RT + LF * RF;
                }
            }
        }
        return ways;
    }

    public int countWays_mem(int N, String S) {
        int[][][] dp = new int[N][N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }

            }
        }

        return countWays_mem_util(dp, 0, N - 1, 1, S);
    }

    int mod = 1000000007;

    public int countWays_mem_util(int[][][] dp, int i, int j, int isTrue, String S) {
        // base condition
        if (i > j) {
            return 0;
        }

        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        if (i == j) {
            if (isTrue == 1) {
                if (S.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (S.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        int ways = 0;

        for (int index = i + 1; index <= j - 1; index = index + 2) {
            int LT = countWays_mem_util(dp, i, index - 1, 1, S);
            int LF = countWays_mem_util(dp, i, index - 1, 0, S);
            int RT = countWays_mem_util(dp, index + 1, j, 1, S);
            int RF = countWays_mem_util(dp, index + 1, j, 0, S);

            if (S.charAt(index) == '&') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RT) % mod) % mod;
                } else {
                    ways = (ways + (LT * RF) % mod + (LF * RT) % mod + (LF * RF) % mod) % mod;
                }
            } else if (S.charAt(index) == '|') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RT) % mod + (LT * RF) % mod + (LF * RT) % mod) % mod;
                } else {
                    ways = (ways + (LF * RF) % mod) % mod;
                }
            } else if (S.charAt(index) == '^') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RF) % mod + (LF * RT) % mod) % mod;
                } else {
                    ways = (ways + (LT * RT) % mod + (LF * RF) % mod) % mod;
                }
            }
        }
        return dp[i][j][isTrue] = ways % mod;
    }

    public static void main(String[] args) {
        P4_Evaluate_Boolean_Expression_To_True_follow p4_evaluate_boolean_expression_to_true =
            new P4_Evaluate_Boolean_Expression_To_True_follow();
        System.out.println(p4_evaluate_boolean_expression_to_true.countWays_recur(7, "T|T&F^T"));

        System.out.println(p4_evaluate_boolean_expression_to_true.countWays_mem(7, "T|T&F^T"));

        System.out.println(
            p4_evaluate_boolean_expression_to_true.countWays_mem(35, "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F"));
    }
}
