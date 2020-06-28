package Matrix;

/**
 * Created by piyush.bajaj on 12/03/17.
 */
public class convertToDiagonalMatrix {

    public static void printMat(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void diagonalMatrix(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;

        int newRow = row + col -1;
        int newcol = row;

        //int[][] table = new int[newRow][newcol];

        int i=0, j=0;
        for(int k = 0; k < row; k++){
            i = k;
            j = 0;
            for (i = k; i >= 0 && j < col; i--){
                System.out.print(mat[i][j] + " ");
                j++;
            }
            System.out.println();
        }

        //j = 1;
        for(int m = 1; m < col; m++){
            i = row-1;
            for(j = m; j < col && i >=0; j++){
                System.out.print(mat[i][j] + " ");
                i--;
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}};

        printMat(mat);

        System.out.println();

        diagonalMatrix(mat);

    }
}
