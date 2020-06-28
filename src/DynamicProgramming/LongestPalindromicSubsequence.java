package DynamicProgramming;

/**
 * Created by piyush.bajaj on 14/08/17.
 */
public class LongestPalindromicSubsequence {

    public int longest_seq(String str){
        int n = str.length();
        int[][] mat = new int[n][n];

        for(int i = 0; i < n; i++){
            mat[i][i] = 1;
        }

        for(int i = 0; i < n-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                mat[i][i+1] = 2;
            }
            else {
                mat[i][i+1] = Math.max(mat[i][i], mat[i+1][i+1]);
            }
        }


        int j = 0, max = Integer.MIN_VALUE;
        for(int k = 3; k <= n; k++){
            for(int i = 0; i < n - k + 1; i++){
                j = i + k -1;
                if(str.charAt(i) == str.charAt(j)){
                    mat[i][j] = mat[i+1][j-1] + 2;
                }
                else {
                    mat[i][j] = Math.max(mat[i][j-1], mat[i+1][j]);
                }

                if(mat[i][j] > max){
                    max = mat[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence ls = new LongestPalindromicSubsequence();
        String str = "LPASPAL";
        System.out.println(ls.longest_seq(str));
    }
}
