package DynamicProgramming;

/**
 * Created by piyush.bajaj on 27/08/17.
 * Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts,
 * where freq[i] is the number of searches to keys[i].
 * Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
 *
 * Example 1
 Input:  keys[] = {10, 12}, freq[] = {34, 50}
 There can be following two possible BSTs
 10                       12
 \                     /
 12                 10
 I                     II
 Frequency of searches of 10 and 12 are 34 and 50 respectively.
 The cost of tree I is 34*1 + 50*2 = 134
 The cost of tree II is 50*1 + 34*2 = 118
 */
public class optimal_bst_problem {
    public int optimal_bst(int[] arr, int[] freq){
        int n = arr.length;
        int[][] mat = new int[n][n];


        for(int i = 0; i < n; i++){
           mat[i][i] = freq[i];
        }

        for(int l = 2; l <= n; l++){
            for(int i = 0; i < n-l+1; i++){
                int j = i+l-1;
                //mat[i][j] = freq[i] + freq[j];
                //int q = 0;
                mat[i][j] = Integer.MAX_VALUE;
                int sum_freq = get_freq(freq, i, j);
                for(int k = i; k <= j; k++){
                   int q = sum_freq + ((k > i)? mat[i][k-1]:0) + ((k<j)? mat[k+1][j]: 0);
                    if(q < mat[i][j]){
                        mat[i][j] = q;
                    }

                }

            }
        }
        return mat[0][n-1];

    }

    public int get_freq(int[] freq, int i,int j){
        int sum = 0;

        for(int k = i; k <= j; k++){
            sum+= freq[k];
        }

        return sum;
    }

    public static void main(String[] args) {
        optimal_bst_problem op= new optimal_bst_problem();
        int[] arr = {10, 12, 16, 21};
        int[] frq = {4, 2, 6, 3};
        System.out.println(op.optimal_bst(arr, frq));
    }

}
