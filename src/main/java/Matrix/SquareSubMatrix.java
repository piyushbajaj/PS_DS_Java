package Matrix;

/**
 * Created by piyush.bajaj on 11/03/17.
 */
public class SquareSubMatrix {

    public static int minFunc(int a, int b, int c) {
        return Math.min(Math.min(a, b), Math.min(a, c));
    }

    public static void checkSubMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] table = new int[row][col];

        System.out.println(table[0][0] + " " + table[1][0]);

        //int count = 1;
        int max = 0;
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = mat[i][j];
                } else if (mat[i][j] == 0) {
                    table[i][j] = 0;
                } else {
                    table[i][j] = minFunc(table[i - 1][j], table[i][j - 1], table[i - 1][j - 1]) + 1;

                    if (table[i][j] > max) {
                        max = table[i][j];
                    }
                }
            }
        }
        printMat(table);

        System.out.println("Maximum value is: " + max);
    }

    public static void printMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 1, 1},
            {0, 0, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1, 1}};

        printMat(mat);

        System.out.println("Calculated table values: ");

        checkSubMatrix(mat);
    }

}
