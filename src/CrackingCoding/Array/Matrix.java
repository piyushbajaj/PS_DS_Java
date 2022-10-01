package CrackingCoding.Array;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 20/11/16.
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] ma = new int[4][4];
        //rotate(matrix_fill(ma), 4);
        setZero(matrix_fill(ma));
    }

    public static void setZero(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];


        for(int i =0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                if((matrix[i][j])==0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for(int i =0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                if((row[i] || column[j] )){
                    matrix[i][j]=0;
                }
            }
        }

        System.out.println("After setting rows and column to 0 where it encountered: ");
        for(int r = 0; r< matrix.length; r++){
            for(int col = 0 ;col< matrix[r].length; col++){
                System.out.print(matrix[r][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrix_fill(int[][] arr){
        Scanner in = new Scanner(System.in);
        for(int row = 0; row< arr.length; row++){
            for(int col = 0 ;col< arr[row].length; col++){
                System.out.println("enter the elements for the Matrix");
                arr[row][col] = in.nextInt();
            } System.out.println();
        }

        for(int row = 0; row< arr.length; row++){
            for(int col = 0 ;col< arr[row].length; col++){
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
        return arr;
    }

    //matrix happens with [row] * [column]
    public static void rotate(int[][] matrix, int n){
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n-1-layer;

            for(int i = first; i < last; i++){
                int offset = i - first;
                int temp, top, left, right, bottom;

//                top = matrix[i][first];
//                left = matrix[last-offset][first];
//                bottom = matrix[last-offset][last];
//                right = matrix[first][last];
//
//                temp = top;
//                top = left;
//                left = right;
//                right = bottom;
//                bottom = temp;

                temp = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = temp;

            }
        }
        System.out.println("After converting 90 degree our matrix: ");
        for(int row = 0; row< matrix.length; row++){
            for(int col = 0 ;col< matrix[row].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
