package DynamicProgramming;

/**
 * Created by piyush.bajaj on 30/04/17.
 */
public class    knapsack_problem {

    public void knapsack(int[] weight, int[] benefit, int maxWt){
        int n = weight.length;
        int sum_benef = 0;
        int sum_wt = 0;
        int max = 0;
        for(int j = 0; j < n; j++) {
            for (int i = j; i < n; i++) {
                sum_wt += weight[i];
                if (sum_wt <= maxWt) {
                    sum_benef += benefit[i];
                }
                else
                    break;
            }
            if (sum_benef > max) {
                max = sum_benef;
                sum_benef = 0;
                sum_wt = 0;
            }

        }
        System.out.print(max);
    }

    public static void main(String[] args) {
        knapsack_problem kp = new knapsack_problem();
//        int[] weight = {2, 2, 4, 5};
//        int[] benefit = {3, 7, 2, 9};
//        int max_weight = 10;
        //kp.knapsack(weight, benefit, max_weight);
        //int[] weight = {1, 3, 4, 5};
        int[] weight = {20, 19};
        //int[] benefit = {1, 4, 5, 7};
        int[] benefit = {24, 20};
        int max_weight = 50;
        System.out.println(kp.knapsack_prac(weight, benefit, max_weight));
        //System.out.println(kp.knapSack_g4g(max_weight, weight, benefit, weight.length ));
    }

    public int knapSack_g4g(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];



    }

    public int knapsack_prac(int[] wt, int[] val, int weight){
        int row_len = wt.length;
        int[][] mat = new int[row_len][weight+1];

        for(int i = 0; i < row_len; i++){
            for(int j = 0; j <= weight; j++){
                if(j==0)
                    mat[i][j] = 0;
                else if(j < wt[i]){
                    if( i == 0){
                        mat[i][j] = mat[i][j-1];
                    }
                    else
                        mat[i][j] = mat[i-1][j];
                }else {
                    if( i == 0){
                        mat[i][j] = val[i];
                    }
                    else
                        mat[i][j] = Math.max((val[i] + mat[i-1][j-wt[i]]), mat[i-1][j]);
                }

            }
        }

        int result = mat[row_len-1][weight];

        int j = weight;
        for(int i = row_len -1; i >= 0; i--) {
                if (i==0 && j==0)
                    break;
                else if( i!=0 && (mat[i][j] == mat[i-1][j]))
                    continue;
                else {
                    System.out.println("Index: " + i + ", Weight: " + wt[i] + " , Benefit: " + val[i]);
                    j = j - wt[i];
                }
        }


        return result;




    }



}
