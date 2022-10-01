package DynamicProgramming;

/**
 * Created by piyush.bajaj on 12/08/17.
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert
 Remove
 Replace
 All of the above operations are of equal cost.
 Input:   str1 = "geek", str2 = "gesek"
 Output:  1
 We can convert str1 into str2 by inserting a 's'.

 Input:   str1 = "cat", str2 = "cut"
 Output:  1
 We can convert str1 into str2 by replacing 'a' with 'u'.

 Input:   str1 = "sunday", str2 = "saturday"
 Output:  3
 Last three and first characters are same.  We basically
 need to convert "un" to "atur".  This can be done using
 below three operations.
 Replace 'n' with 'r', insert t, insert a
 */
public class Edit_Distance {

    public int get_min_distance(String source, String destination){
        int rowLen = source.length() + 1;
        int colLen = destination.length() + 1;

        int[][] mat = new int[rowLen][colLen];

        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(i == 0 || j == 0) {
                    if (i == 0 && j == 0)
                        mat[i][j] = 0;
                    else {
                        if (i == 0)
                            mat[i][j] = j;
                        if (j == 0)
                            mat[i][j] = i;
                    }
                }
                else {
                    if(source.charAt(i-1) == destination.charAt(j-1)){
                        mat[i][j] = mat[i-1][j-1];
                    }
                    else {
                        mat[i][j] = Math.min(Math.min(mat[i-1][j-1], mat[i-1][j]), mat[i][j-1]) + 1;
                    }
                }

            }
        }
        return mat[rowLen-1][colLen-1];
    }

    public static void main(String[] args) {
        Edit_Distance ed = new Edit_Distance();
        //String source = "CART";
        String source = "INTENTION";

        //String destination = "MARCH";
        String destination = "EXECUTION";
        System.out.println(ed.get_min_distance(source, destination));
    }

}
