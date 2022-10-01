package StringAlgorithm;

/**
 * Created by piyush.bajaj on 18/01/17.
 * For a text T we need to find when did the pattern P occurred first.
 */


public class BruteForce {
    public int BruteAlgo(String T, int n, String P, int m){
        for(int i = 0; i <=n-m; i++){
            int j = 0;
            while (j < m && T.charAt(i+j) == P.charAt(j)){
                j++;
            }
            if(j==m)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        BruteForce BF = new BruteForce();
        int[] T = {10, 12, 14, 16, 18, 20};
        int[] P = {14, 16};

        String t1 = "Piyush";
        String p1 = "us";

        System.out.println(BF.BruteAlgo(t1, t1.length(), p1, p1.length()));

    }
}
