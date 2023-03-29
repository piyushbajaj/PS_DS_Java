package TechBoost_Old;

/**
 * Created by piyush.bajaj on 01/04/18.
 */
public class knights_prob {
    static int N = 8;

    public static void knight_sol() {
        int[][] mat = new int[8][8];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = -1;
            }
        }

        int[] rowArr = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] colArr = {1, 2, 2, 1, -1, -2, -2, -1};
        mat[0][0] = 0;
        if (knight_sol_util(N, 0, 0, rowArr, colArr, 1, mat)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Knights cannot cover all points in the Chess Board");
        }
    }

    public static boolean isValid(int[][] mat, int i, int j, int n) {
        return (i >= 0 && i < n && j >= 0 && j < n && mat[i][j] == -1);
//            return true;
//        }
//        else
//            return false;
    }

    public static boolean knight_sol_util(int n, int row, int col, int[] rowArr, int[] colArr,
                                          int count, int[][] mat) {
        int k, rowMove, colMove;
        if (count == N * N) {
            //mat[row][col] = n*n-1;
            return true;
        }

        for (k = 0; k < N; k++) {
            rowMove = row + rowArr[k];
            colMove = col + colArr[k];
            if (isValid(mat, rowMove, colMove, n)) {
                mat[rowMove][colMove] = count;
                if (knight_sol_util(n, rowMove, colMove, rowArr, colArr, count + 1, mat)) {
                    return true;
                } else {
                    mat[rowMove][colMove] = -1;
                    //  return false;
                }
            }

        }

        return false;

    }

    public static void main(String[] args) {
        knight_sol();
    }
}
