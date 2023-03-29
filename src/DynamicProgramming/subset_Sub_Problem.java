package DynamicProgramming;

/**
 * Created by piyush.bajaj on 10/08/17.
 * Algorithm:
 * 1. For j = 0, make it true means 0 can be achieve from any of the weights.
 * 2. For i = 0, make it false means apart from 0 any weight cannot be achieved just by 0.
 * 3. Iterate two loops, first from i = 0 to row-length, second from 0 to key.
 * 4. if(j-wt[i-1] > 0) then mat[i-1][j] OR mat[i-1][j-wt[i-1]
 * 5. else mat[i-1][j]
 */
public class subset_Sub_Problem {

    public static void main(String[] args) {
        subset_Sub_Problem sp = new subset_Sub_Problem();
        int[] arr = {1, 3, 9, 2};
        int key = 5;

        int n = arr.length - 1;
        sp.check_sum(arr, key);
    }

    //Using knapsack logic
    public boolean check_sum(int[] wt, int key) {

        int row_len = wt.length;
        boolean[][] mat = new boolean[row_len + 1][key + 1];

        for (int i = 0; i <= row_len; i++) {
            for (int j = 0; j <= key; j++) {
                if (j == 0) {
                    mat[i][j] = true;
                    continue;
                }
                if (i == 0 && j != 0) {
                    mat[i][j] = false;
                    continue;
                }
                if (j - wt[i - 1] >= 0) {
                    mat[i][j] = (mat[i - 1][j] || mat[i - 1][j - wt[i - 1]]);
                } else {
                    mat[i][j] = mat[i - 1][j];
                }
            }
        }

        return mat[row_len][key];

    }
}
