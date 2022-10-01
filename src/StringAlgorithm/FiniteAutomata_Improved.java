package StringAlgorithm;

/**
 * Created by piyush.bajaj on 22/01/17.
 * We use LPS(longest prefix suffix) here. We use previously filled rows to fill a new row
 *

 1) Fill the first row. All entries in first row are always 0 except the entry for pat[0] character. For pat[0] character,
 we always need to go to state 1.
 2) Initialize lps as 0. lps for the first index is always 0.
 3) Do following for rows at index i = 1 to M. (M is the length of the pattern)
 …..a) Copy the entries from the row at index equal to lps.
 …..b) Update the entry for pat[i] character to i+1.
 …..c) Update lps “lps = TF[lps][pat[i]]” where TF is the 2D array which is being constructed.

 Time Complexity: O(N + M* No_Of_Chars(256 ))

 */
public class FiniteAutomata_Improved {

    private final int  No_Of_Chars = 256;

    public void computeTF(char[] pat, int M, int[][] TF){
        int lps = 0;
        int x;

        for(x = 0; x < No_Of_Chars; x++){
            TF[0][x] = 0;
        }
        TF[0][pat[0]] = 1;

        for(int i = 1; i < M; i++){

            for(x=0; x < No_Of_Chars; x++){
                TF[i][x] = TF[lps][x];
            }

            TF[i][pat[i]] = i+1;

            if(i < M)
                lps = TF[lps][pat[i]];
        }

    }

    public void search(char[] pat, char[] text){
        int M = pat.length;
        int N = text.length;

        int[][] TF = new int[M+1][No_Of_Chars];

        computeTF(pat, M, TF);

        int i, state = 0;

        for(i = 0; i < N; i++){
            state = TF[state][text[i]];
            if(state == M)
                System.out.println("Found the pattern at: " + (i - M +1));
        }

    }

    public static void main(String[] args) {
        FiniteAutomata_Improved FA = new FiniteAutomata_Improved();
        String text = "ACACAGA";
        String pat = "A";

        FA.search(pat.toCharArray(), text.toCharArray());
    }
}
