package DynamicProgramming;

/**
 * Created by piyush.bajaj on 13/08/17.
 */
public class minCostPath {

    public int min_Cost(int[][] mat, int m, int n){
        if(m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if(m == 0 && n == 0)
            return mat[m][n];

        else {
            return mat[m][n]
                    + Math.min(Math.min(min_Cost(mat, m - 1, n - 1),
                    min_Cost(mat, m - 1, n)),
                    min_Cost(mat, m, n - 1));
        }
    }

    //Using DP
    //Minimum cost to reach destination, when using moves: Right, Bottom & Bottom-Right
    public int min_Cost_DP(int[][] mat, int m, int n){
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[][] cost_mat = new int[rowLen][colLen];

        cost_mat[0][0] = mat[0][0];

        for(int i = 1; i < rowLen; i++){
            cost_mat[i][0] = mat[i][0] + cost_mat[i-1][0];
        }

        for(int j = 1; j < colLen; j++){
            cost_mat[0][j] = mat[0][j] + cost_mat[0][j-1];
        }

        for(int i = 1; i < rowLen; i++ ){
            for(int j = 1; j < colLen; j++){
                cost_mat[i][j] = mat[i][j] + Math.min(Math.min(cost_mat[i-1][j], cost_mat[i][j-1]),cost_mat[i-1][j-1] );
            }
        }

        return cost_mat[m][n];

    }

    //Minimum cost to reach destination, when using moves: Right & Bottom

    public int min_cost_DP_RB(int[][] mat, int m, int n){

        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[][] cost_mat = new int[rowLen][colLen];

        cost_mat[0][0] = mat[0][0];

        for(int i = 1; i < rowLen; i++){
            cost_mat[i][0] = mat[i][0] + cost_mat[i-1][0];
        }

        for(int j = 1; j < colLen; j++){
            cost_mat[0][j] = mat[0][j] + cost_mat[0][j-1];
        }

        for(int i = 1; i < rowLen; i++ ){
            for(int j = 1; j < colLen; j++){
                cost_mat[i][j] = mat[i][j] + Math.min(cost_mat[i-1][j], cost_mat[i][j-1]);
            }
        }

        return cost_mat[m][n];

    }

    public static void main(String[] args) {
        minCostPath mc = new minCostPath();
        int[][] mat = { { 3, 2, 8 }, { 1, 9, 7 }, { 0, 5, 2 }, {6, 4, 3} };

        int[][] mat1 = { { 1 , 3, 5, 8 }, { 4, 2, 1, 7 }, {4 , 3, 2, 3}};
        System.out.println("Minimum cost: " + mc.min_Cost(mat, 3, 2));

        System.out.println("Minimum cost using DP (Right, Bottom & Diagonal Moves): " + mc.min_Cost_DP(mat, 3, 2));

        System.out.println("Minimum cost using DP (Right and Bottom Moves): " + mc.min_cost_DP_RB(mat1, 2, 3));
    }
}
