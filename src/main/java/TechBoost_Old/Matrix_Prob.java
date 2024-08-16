package TechBoost_Old;

/**
 * Created by piyush.bajaj on 26/03/18.
 */
public class Matrix_Prob {
    public static void search(int[][] mat, int key) {
        int row = mat.length;
        int col = mat[0].length;

        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                if (mat[j][i] > key) {
                    break;
                } else if (mat[j][i] < key) {
                    continue;
                } else {
                    System.out.println("Key is found at col: " + i + " and row: " + j);
                    return;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{2, 5, 6, 20},
            {3, 9, 12, 25},
            {4, 20, 24, 26},
            {8, 28, 30, 35}};

        search(mat, 24);
    }


}
