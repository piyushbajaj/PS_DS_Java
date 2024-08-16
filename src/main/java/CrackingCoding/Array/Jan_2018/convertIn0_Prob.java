package CrackingCoding.Array.Jan_2018;

/**
 * Created by piyush.bajaj on 26/01/18.
 */
public class convertIn0_Prob {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
            {5, 0, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}};

        convertRowCol(mat);
    }

    public static void convertRowCol(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    mat[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
