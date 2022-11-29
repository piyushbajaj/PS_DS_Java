package TakeUForward.S16_DP.S16_2_2D_3D_Grids;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP
 * <p>
 * User: piyushbajaj
 * Date: 12/11/22
 * Time: 5:47 pm
 *
 * Link codingNinja: <a href="https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003">...</a>
 */
public class P7_Ninja_Training {

    /**
     * Recursion
     * TC: O(2^n)
     * SC: Stack space
     *
     * @param n
     * @param points
     * @return
     */
    public int ninjaTraining(int n, int points[][]) {
        return getPoint(n - 1, 3, points);
    }

    public int getPoint(int day, int last, int points[][]) {
        int maxi = 0;
        if (day == 0) {
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + getPoint(day - 1, task, points);
                maxi = Math.max(maxi, point);
            }
        }
        return maxi;
    }

    /**
     * Memoization
     * TC: O(N*4)*3
     * SC: O(N) {Recursion} + O(N*4)
     *
     * @param n
     * @param points
     * @return
     */
    public int ninjaTraining_mem(int n, int points[][]) {
        int[][] dp = new int[n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }

        return getPoint_mem(n - 1, 3, points, dp);
    }

    public int getPoint_mem(int day, int last, int[][] points, int[][] dp) {
        int maxi = 0;
        if (day == 0) {
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + getPoint_mem(day - 1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        dp[day][last] = maxi;
        return maxi;
    }

    /**
     * Tabulation, with removing recursion stack space
     * TC: O(N*4*3)
     * SC: O(N*4)
     *
     * @param n
     * @param points
     * @return
     */
    public int ninjaTraining_tab(int n, int points[][]) {
        int[][] dp = new int[n][4];

        // base case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[n - 1][3];

    }

    /**
     * Tabulation with better space: BEST
     * TC: O(N*4*3)
     * SC: O(4)
     *
     * @param n
     * @param points
     * @return
     */
    public int ninjaTraining_tab_improve_space(int n, int points[][]) {
        int[] prev = new int[4];

        // base case
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);


        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + prev[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }

            prev = temp;
        }

        return prev[3];

    }

    public static void main(String[] args) {
        P7_Ninja_Training p7_ninja_training = new P7_Ninja_Training();
        int[][] points = new int[][] {{1, 2, 5},
            {3, 1, 1},
            {3, 3, 3}};
        System.out.println(p7_ninja_training.ninjaTraining(points.length, points));

        System.out.println(p7_ninja_training.ninjaTraining_mem(points.length, points));

        System.out.println(p7_ninja_training.ninjaTraining_tab(points.length, points));

        System.out.println(p7_ninja_training.ninjaTraining_tab_improve_space(points.length, points));
    }

}
