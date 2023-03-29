package DynamicProgramming;

/**
 * Created by piyush.bajaj on 12/08/17.
 * Algorithm:
 * 1. Wherever, the characters are same diagonally will make it TRUE.
 * 2. Second, will loop for two consecutive elements if its same, then will make it TRUE.
 * 3. Third, will loop for 3 or more elements, then will check if the first and last characters are matching, if matching
 * then will check rest characters are palindrome or not. If it is then will mark them as TRUE
 * 4. Now we have build DP graph, its turn to make it a cut array, to identify cuts.
 */
public class Palindrome_Min_Cut {

    public static void main(String[] args) {
        Palindrome_Min_Cut pm = new Palindrome_Min_Cut();
        String str = "BANANA";
        System.out.println(pm.min_cut(str));
    }

    public int min_cut(String str) {
        int len = str.length();
        boolean[][] mat = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            mat[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                mat[i][i + 1] = true;
            }
        }

        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len - k + 1; i++) {
                int j = k + i - 1;
                if ((str.charAt(i) == str.charAt(j)) && mat[i + 1][j - 1]) {
                    mat[i][j] = true;
                }
            }
        }

        int[] cut = new int[len];

        for (int i = 0; i < len; i++) {
            int temp = Integer.MAX_VALUE;
            if (mat[0][i]) {
                cut[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (mat[j + 1][i] && temp > cut[j] + 1) {
                        temp = cut[j] + 1;
                    }
                }
                cut[i] = temp;
            }
        }
        return cut[len - 1];
    }


}
