package DynamicProgramming;

/**
 * Created by piyush.bajaj on 13/08/17.
 */
public class longest_palindrome {
    public static void main(String[] args) {
        longest_palindrome fl = new longest_palindrome();
        String str = "BANANA";

        System.out.println(fl.find_longestPalindrome(str));
    }

    public String find_longestPalindrome(String str) {
        int n = str.length();
        boolean[][] mat = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            mat[i][i] = true;
        }

        //for double character sequence
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                mat[i][i + 1] = true;
            }
        }

        //from 3 characters to n length
        int j = 0;
        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                j = i + k - 1;
                if (str.charAt(i) == str.charAt(j) && mat[i + 1][j - 1]) {
                    mat[i][j] = true;
                    if (j - i > max) {
                        end = j;
                        start = i;
                        max = end - start;
                    }
                } else {
                    mat[i][j] = false;
                }
            }
        }
        return str.substring(start, end + 1);
    }
}
