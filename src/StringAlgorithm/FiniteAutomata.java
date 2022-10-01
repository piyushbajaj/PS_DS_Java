package StringAlgorithm;

/**
 * Created by piyush.bajaj on 22/01/17.
 * There are 3 functions which drives this:
 * 1. search: Prints all occurrences of pat in txt
 * 2. computeTF: This function builds the TF table which represents Finite Automata for a given pattern
 * 3. getNextState:
 * Time Complexity: O(m*(m-1))
 */
public class FiniteAutomata {
    private final int  No_Of_Chars = 256;

    public int getNextState(char[] pat, int M, int state, int x){

        // If the character c is same as next character in pattern,
        // then simply increment state
        if(state < M && x == pat[state])
            return state+1;

        int i, ns;
        for(ns = state; ns > 0; ns--){
            if(pat[ns-1] == x){
                for( i = 0; i < ns-1; i++){
                    if(pat[i] != pat[state - (ns-1) + i])
                        break;
                }
                if(i == ns-1)
                    return ns;
            }
        }





















//        if(state < M && x == pat[state])
//            return state+1;
//
//        // ns finally contains the longest prefix which is also suffix
//        // in "pat[0..state-1]c"
//
//        // Start from the largest possible value and stop when you find
//        // a prefix which is also suffix
//        int ns, i;
//
//        for (ns = state; ns > 0; ns--)
//        {
//            if(pat[ns-1] == x)
//            {
//                for(i = 0; i < ns-1; i++)
//                {
//                    if (pat[i] != pat[state-ns+1+i])
//                        break;
//                }
//                if (i == ns-1)
//                    return ns;
//            }
//        }
//
        return 0;
    }

    public void computeTF(char[] pat, int M, int TF[][]){
        for(int state = 0; state <= M; state++)
            for(int x = 0; x < No_Of_Chars; x++)
                TF[state][x] = getNextState(pat, M, state, x);


//        int state, x;
//        for (state = 0; state <= M; ++state)
//            for (x = 0; x < No_Of_Chars; ++x)
//                TF[state][x] = getNextState(pat, M, state, x);
    }

    public void search(char[] pat, char[] text){

        int M = pat.length;
        int N = text.length;

        int[][] TF = new int[M+1][No_Of_Chars];

        computeTF(pat, M, TF);

        //Now print the value
        //Process text over FA
        int i, state = 0;

        for(i = 0; i < N; i++){
            state = TF[state][text[i]];
            if(state == M)
                System.out.println("Found the pattern at: " + (i - M +1));
        }
















//        int M = pat.length;
//        int N = text.length;
//
//        int[][] TF = new int[M+1][No_Of_Chars];
//
//        computeTF(pat, M, TF);
//
//        // Process txt over FA.
//        int i, state=0;
//        for (i = 0; i < N; i++) {
//            state = TF[state][text[i]];
//            if (state == M)
//            {
//                System.out.println("Pattern found at index: " + (i - M + 1));
//            }
//        }
    }

    public static void main(String[] args) {
        FiniteAutomata FA = new FiniteAutomata();
        String text = "ACACAGA";
        String pat = "A";

        FA.search(pat.toCharArray(), text.toCharArray());
    }

}
