package Matrix;

/**
 * Created by piyush.bajaj on 19/02/17.
 */
public class word2DArray {
    public boolean isWordFound(char[][] mat, char[] pat, int patLen, int nrow, int ncol){

        return false;
    }


//    public static void searchGrid(char[][] grid, String word) {
//
//        for (int i = 0; i < grid.length; ++i) {
//            for (int j = 0; j < grid[0].length; ++j) {
//                         if (searchGridUtil(grid, word, i, j, 5, 5))
//                            System.out.println("Pattern found at " + i + ", " + j);
//                }
//        }
//    }
//
//
//    public static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1 };
//    public static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1 };
//
//    public static boolean searchGridUtil(char[][] grid, String word, int row, int col, int R, int C) {
//        if (grid[row][col] != word.charAt(0))
//            return false;
//
//        int len = word.length();
//
//        for (int dir = 0; dir < 8; dir++)
//        {
//            // Initialize starting point for current direction
//            int k, rd = row + x[dir], cd = col + y[dir];
//
//            // First character is already checked, match remaining
//            // characters
//            for (k = 1; k < len; k++)
//            {
//                // If out of bound break
//                if (rd >= R || rd < 0 || cd >= C || cd < 0)
//                    break;
//
//                // If not matched,  break
//                if (grid[rd][cd] != word.charAt(k))
//                    break;
//
//                //  Moving in particular direction
//                rd += x[dir];
//                cd += y[dir];
//            }
//
//            // If all character matched, then value of must
//            // be equal to length of word
//            if (k == len)
//                return true;
//        }
//        return false;
//    }

    boolean pattern_match(char[][] mat, int m, int n, char[] pat)
    {
        boolean[][] visited = new boolean[m][n];
        boolean found=false;
        int i, j;
        for(i=0; i<m; i++) {
            //visited = new boolean[n];
            for(j=0; j<n; j++)
                visited[i][j]=false;
        }

        for(i=0; i<m; i++){
            for(j=0; j<n; j++) {
                if(find_pattern(mat, i, j, m, n, pat, 0, visited)==true) {
                    found = true;
                    break;
                }
            }
        if(found) break;
    }

    return found;
}

    boolean find_pattern(char[][] mat, int i, int j, int m, int n, char[] pat, int pos, boolean[][] visited)
    {
        int[] delta_i = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] delta_j={1, 0, -1, -1, -1, 0, 1, 1};
        int dir;
        int k = pos;
        //char *p=pattern;
        //if(*p == '\0') return true;
        if(k== pat.length-1)
            return true;
        //for (int k = 1; k < pat.length; k++) {

            if (i < 0 || i > m - 1 || j < 0 || j > n - 1)
                return false;
            if (mat[i][j] != pat[k] || visited[i][j] == true)
                return false;

            visited[i][j] = true;
            for (dir = 0; dir < 8; dir++){
                if (find_pattern(mat, i + delta_i[dir], j + delta_j[dir], m, n, pat, pos + 1, visited) == true)
                    return true;
            }
        //}
        return (visited[i][j]=false);
    }



    public static void main(String[] args) {
        word2DArray wa = new word2DArray();
        int nrow = 5;
        int ncol = 5;
        //char[][] matrix = new char[nrow][ncol];
        char[][] matrix = {
                {'A', 'C', 'P', 'R', 'C'},
                {'X', 'S', 'O', 'P', 'C'},
                {'V', 'O', 'V', 'N', 'I'},
                {'W', 'G', 'F', 'M', 'N'},
                {'Q', 'A', 'T', 'I', 'T'}};
        int len = matrix.length;
        int l1 = matrix[0].length;
        //wa.isWordFound();

        //searchGrid(matrix, "MICROSOFT");
        String str = "MITAQ";

        System.out.println(wa.pattern_match(matrix, 5, 5, str.toCharArray()));
    }
}
