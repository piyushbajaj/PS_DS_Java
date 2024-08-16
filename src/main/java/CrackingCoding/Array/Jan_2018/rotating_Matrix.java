package CrackingCoding.Array.Jan_2018;

/**
 * Created by piyush.bajaj on 25/01/18.
 */
public class rotating_Matrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}};

        rotate(mat);
    }

    public static void rotate(int[][] mat) {
        int n = mat[0].length;
        for (int i = 0; i < n / 2; i++) { // Here i refers to LAYER
            int first = i;
            int last = n - 1 - i;

            for (int j = first; j < last; j++) {
                int offset = j - first;

                //top
                int top = mat[first][j];

                //Left to Top
                mat[first][j] = mat[last - offset][first];

                //Bottom to Left
                mat[last - offset][first] = mat[last][last - offset];

                //Right to Bottom
                mat[last][last - offset] = mat[j][last];

                mat[j][last] = top;
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
