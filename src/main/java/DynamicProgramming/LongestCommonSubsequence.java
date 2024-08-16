package DynamicProgramming;

/**
 * Created by piyush.bajaj on 26/01/17.
 */
public class LongestCommonSubsequence {
    public int lcs(char[] c1, char[] c2){
        int n1 = c1.length;
        int n2 = c2.length;
        int m = 0;
        int j = 0;

        if(n1 > n2) {
            m = n1;
            j = n2;
        }
        else {
            m = n2;
            j = n1;
        }

        char[] temp = new char[m];
        int k = 0;

        for(int i = 0; i < m; i++){
            if(i < n1 && i < n2){
                if(c1[i] == c2[i])
                    temp[k++] = c1[i];
                else if(c1[i+1] == c2[i])
                    temp[k++] = c1[i+1];
                else if(c1[i] == c2[i+1])
                    temp[k++] = c1[i];
            }
        }
        return -1;
    }

    public int lcs_better(char[] c1, char[] c2){
        int n1 = c1.length;
        int n2 = c2.length;
        int l =0;

        //lcs_util(c1, c2, n1-1, n2-1, l);

        return -1;

    }

    public int lcs_util(char[] c1, char[] c2, int n1, int n2){
        if(c1[n1] == c2[n2]) {
           return lcs_util(c1, c2, n1 - 1, n2 - 1);
        }
        return -1;
    }

    public int lcs_CMS(char[] c1, char[] c2){
        int n1 = c1.length;
        int n2 = c2.length;
        int result = 0;

        int[][] mat = new int[n2+1][n1+1];

        for(int i = 0; i <= n2; i++){
            for(int j = 0; j <= n1; j++){
                if(i==0 || j==0)
                    mat[i][j] = 0;
                else if(c1[j-1] == c2[i-1]){
                    mat[i][j] = mat[i-1][j-1] + 1;
                }
                else {
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }
        result = mat[n2][n1];
        char[] output = new char[result];
        int cnt = result-1;

        for(int i = n2-1; i >= 0; i--){
            for(int j =n1-1; j >= 0; j--){
                if( c1[j] == c2[i] ) {
                    output[cnt--] = c2[i];
                    break;
                }
            }
        }

        for(char c: output)
            System.out.print(c);

        System.out.println();
        return result;
    }

    //Using DP
    public int lcs_common(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] mat = new int[n1][n2];

//        int max = 0;
//        String str = "";

        for(int i = 0; i < n1; i++){
            if(s1.charAt(i) == s2.charAt(0))
                mat[i][0] = 1;
            else {
                if(i == 0)
                    mat[i][0] = 0;
                else
                    mat[i][0] = mat[i-1][0];
            }
        }

        for(int i = 0; i < n2; i++){
            if(s1.charAt(0) == s2.charAt(i))
                mat[0][i] = 1;
            else {
                if(i == 0)
                    mat[0][i] = 0;
                else
                    mat[0][i] = mat[0][i-1];
            }
        }




        for(int i = 1; i < n1; i++){
            for(int j = 1; j < n2; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    mat[i][j] = Math.max(Math.max(mat[i-1][j-1], mat[i-1][j]), mat[i][j-1]) + 1;
                }
                else {
                    mat[i][j] = Math.max(Math.max(mat[i-1][j-1], mat[i-1][j]), mat[i][j-1]);
                }
            }
        }
        return mat[n1-1][n2-1];
    }


    public static void main(String[] args) {
        LongestCommonSubsequence LC = new LongestCommonSubsequence();
//        String s1 = "ABCDGH";
//        String s2 = "AEDFHR";

        String s1 = "ACBEA";
        String s2 = "ADCA";

        //LC.lcs(s1.toCharArray(), s2.toCharArray());
//        String s1 = "ABCDAF";
//        String s2 = "ACBCF";

        //By Tushar Video
        System.out.println(LC.lcs_CMS(s1.toCharArray(), s2.toCharArray()));

//        System.out.println(LC.lcs_common(s1, s2));
    }
}
