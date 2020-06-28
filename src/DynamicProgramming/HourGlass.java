package DynamicProgramming;

/**
 * Created by piyush.bajaj on 03/05/17.
 */
public class HourGlass {
    public int cal_hourGlass(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        if(row >6 || row < 0 || col > 6 || col < 0)
            return -1;
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 1; i < row-1; i++ ){
            for(int j = 1; j < col-1; j++){
                sum+= mat[i-1][j-1] + mat[i-1][j] + mat[i-1][j+1] +
                      mat[i][j] +
                        mat[i+1][j-1] + mat[i+1][j] + mat[i+1][j+1] ;
                if(sum > max){
                    max = sum;
                }
                sum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        HourGlass HG = new HourGlass();
        int[][] mat =
                {{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
                };
        System.out.println(HG.cal_hourGlass(mat));
    }
}
