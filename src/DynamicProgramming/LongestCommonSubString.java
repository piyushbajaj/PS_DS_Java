package DynamicProgramming;

/**
 * Created by piyush.bajaj on 13/08/17.
 */
public class LongestCommonSubString {
    public String lcs_common(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] mat = new int[n1][n2];

        int max = Integer.MIN_VALUE;
        String str = "";

        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i == 0 || j == 0)
                        mat[i][j] = 1;
                    else {
                        mat[i][j] = Math.max(Math.max(mat[i-1][j-1], mat[i-1][j]), mat[i][j-1]) + 1;
                    }

                    if(mat[i][j] > max) {
                        max = mat[i][j];

                        if(i == 0)
                            str = s1.substring(i, j + 1);
                        else
                            str = s1.substring(i-1, j + 1);
                    }
                }
                else {
                    mat[i][j] = 0;
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        LongestCommonSubString LC = new LongestCommonSubString();
        String s2 = "ABCDGH";
        String s1 = "AEDFHR";
        //LC.lcs(s1.toCharArray(), s2.toCharArray());
//        String s1 = "ABCDAF";
//        String s2 = "ACBCF";

        //By Tushar Video
        //System.out.println(LC.lcs_CMS(s1.toCharArray(), s2.toCharArray()));

        System.out.println(LC.lcs_common(s1, s2));
    }
}
