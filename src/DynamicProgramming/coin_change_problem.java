package DynamicProgramming;

/**
 * Created by piyush.bajaj on 18/08/17.
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
 * valued coins, how many ways can we make the change? The order of coins doesn't matter.

 For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 So the output should be 5.
 */
public class coin_change_problem {
    public int no_of_Ways(int[] coins, int sum){
        int n = coins.length;
        int[][] mat = new int[n][sum+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j <sum+1; j++){
                if(j == 0)
                    mat[i][j] = 1;

                else {
                    if(i == 0){
                        if(j%coins[i] == 0)
                            mat[i][j] = 1;
                        else
                            mat[i][j] = 0;
                    }
                    else {
                        if(j - coins[i] < 0)
                            mat[i][j] = mat[i-1][j];
                        else {
                            mat[i][j] = mat[i-1][j] + mat[i][j-coins[i]];
                        }
                    }
                }
            }
        }
        return mat[n-1][sum];
    }

    public static void main(String[] args) {
        coin_change_problem cn = new coin_change_problem();
        int[] arr = {2, 5, 3, 6};
        int sum = 10;
        //System.out.println(cn.no_of_Ways(arr, sum));
        System.out.println(check_coin_change(sum, arr));
    }

    public static int check_coin_change(int n, int[] coins){
        int rowLen = coins.length;
        int colLen = n+1;
        int[][] mat = new int[rowLen][colLen];

        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j <= n; j++ ){
                if(j == 0)
                    mat[i][j] = 0;
                else if(i==0){
                    if(j-coins[i] >= 0 && j%coins[i] == 0)
                        mat[i][j] = 1;
                    else
                        mat[i][j] = 0;
                }
                else{
                    if(j-coins[i] < 0)
                        mat[i][j] = mat[i-1][j];
                    else{
                        if(j%coins[i] == 0)
                            mat[i][j] = Math.max((mat[i-1][j]), mat[i][j-coins[i]]) + 1;
                        else{
                            //mat[i][j] = Math.max(mat[i-1][j], mat[i-1][j-1]) + mat[i][j-coins[i]];
                            mat[i][j] = mat[i-1][j] + mat[i][j-coins[i]];
                        }
                    }
                }
            }
        }
        return mat[rowLen-1][n];
    }

}
