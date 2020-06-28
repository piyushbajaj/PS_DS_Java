package DynamicProgramming;

/**
 * Created by piyush.bajaj on 12/08/17.
 */
public class minCoins {
    public int minCoins_Change(int[] arr, int sum){


        int rowLength = arr.length+1;
        int colLength = sum+1;
        int min = Integer.MAX_VALUE;

        int[][] mat = new int[rowLength][colLength];

        for(int i = 0; i < rowLength; i++){
            for (int j = 0; j < colLength; j++){
                if(i == 0 || j == 0)
                    mat[i][j] = 0;
                else {
                    if(j-arr[i-1] < 0)
                        mat[i][j] = mat[i-1][j];
                    else if(j-arr[i-1] == 0){
                        mat[i][j] = 1;
                    }
                    else {
                        if(mat[i-1][j-arr[i-1]] != 0)
                            mat[i][j] = mat[i-1][j-arr[i-1]] + 1;
                        else
                            mat[i][j] = 0;
                    }
                }
                if(j == sum && min > mat[i][j] && mat[i][j] != 0)
                    min = mat[i][j];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        minCoins mc = new minCoins();
        int[] arr = {2, 5, 3};
        int sum = 2;
        int value = mc.minCoins_Change(arr, sum);

        if(value == Integer.MAX_VALUE)
            System.out.println("Invalid Sum, there is no coin to add up!!!");
        else {
            System.out.println("Number of coins to get sum is: " + value);

        }

    }
}
