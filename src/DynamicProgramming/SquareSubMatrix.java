package DynamicProgramming;

/**
 * Created by piyush.bajaj on 13/08/17.
 */
public class SquareSubMatrix {

    public int max_Square_SubMatrix(int[][] mat){
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[][] table = new int[rowLen][colLen];

        table[0][0] = mat[0][0];

        int max = -1;

        for(int i = 1; i < rowLen; i++){
            table[i][0] = mat[i][0];
        }

        for(int j = 1; j < colLen; j++){
            table[0][j] = mat[0][j];
        }

        for(int i = 1; i < rowLen; i++){
            for(int j = 1; j < colLen; j++){
                if(mat[i][j] == 0)
                    table[i][j] = 0;
                else
                    table[i][j] = Math.min(Math.min(table[i-1][j], table[i][j-1]),table[i-1][j-1] ) + 1;

                if(table[i][j] > max)
                    max = table[i][j];
            }
        }
        return max;


    }

    public static void main(String[] args) {
        SquareSubMatrix sb = new SquareSubMatrix();
        int[][] mat = { { 1, 1, 0, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 1 }
        };
        System.out.println(sb.max_Square_SubMatrix(mat));
    }
}
