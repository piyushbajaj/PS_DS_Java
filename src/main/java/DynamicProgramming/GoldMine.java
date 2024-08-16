package DynamicProgramming;

/**
 * Created by piyush.bajaj on 15/08/17.
 * Algorithm:
 * 1. Create a gold_mat with the same size as original matrix, then initialize with 0.
 * 2. Then first loop will be from last column to first column, while the second loop will be from 1st row to last row.
 * 3. Keep calculating three variables: right -> (if the column is already at last, then we cannot calculate this value,
 * hence will put 0, or if not the last column then will keep gold_mat[i][j+1])
 * 4. In the same way, will keep logic for right_up and right_down.
 * 5. Finally, will take Max of those 3 variables above, and then add to mat[i][j]
 */
public class GoldMine {
    public static void main(String[] args) {
        GoldMine gm = new GoldMine();
//        int[][] arr = {{1, 3, 3},
//                {2, 1, 4},
//                {0, 6, 4}};

//        int[][] arr = { {1, 3, 1, 5},
//                {2, 2, 4, 1},
//                {5, 0, 2, 3},
//                {0, 6, 1, 2}};


        int[][] arr = {{10, 33, 13, 15},
            {22, 21, 04, 1},
            {5, 0, 2, 3},
            {0, 6, 14, 2}};
        System.out.println(gm.max_golmine(arr));
    }

    public int max_golmine(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;

        int max = Integer.MIN_VALUE;

        int[][] gold_mat = new int[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                gold_mat[i][j] = 0;
            }
        }

        for (int j = colLen - 1; j >= 0; j--) {
            for (int i = 0; i < rowLen; i++) {
                int right = (j == colLen - 1) ? 0 : gold_mat[i][j + 1];

                int right_up = (j == colLen - 1 || i == 0) ? 0 : gold_mat[i - 1][j + 1];

                int right_down = (j == colLen - 1 || i == rowLen - 1) ? 0 : gold_mat[i + 1][j + 1];

                gold_mat[i][j] = mat[i][j] + Math.max(Math.max(right, right_down), right_up);
            }
        }

        for (int i = 0; i < rowLen; i++) {
            if (gold_mat[i][0] > max) {
                max = gold_mat[i][0];
            }
        }

        return max;
    }
}
