package StringAlgorithm;

/**
 * Created by piyush.bajaj on 19/01/17.
 */
public class KMPAlgo {
    public static int[] F;
    public void prefixTable(char[] pattern){

        int i = 1, j = 0;
        int m = pattern.length;
        F = new int[m];
        F[0] = 0;
        while (i<m){
            if(pattern[i] == pattern[j]){
                F[i] = j + 1;
                i++;
                j++;
            }
            else if(j>0)
                j = F[j-1];
            else {
                F[i] = 0;
                i++;
            }
        }
    }

    public int KMP(char[] text, char[] pattern){
        int i =1, j =0;
        prefixTable(pattern);
        int n = text.length;
        int m = pattern.length;
        while (i<n){
            if(text[i] == pattern[j]){
                if(j == m-1)
                    return i-j;
                else {
                    i++;
                    j++;
                }
            }
            else if(j>0)
                j = F[j-1];
            else {
                //F[i] = 0;
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMPAlgo RK = new KMPAlgo();
        String t1 = "abxabcabcaby";
        String p1 = "abcaby";

        System.out.println(RK.KMP(t1.toCharArray(), p1.toCharArray()));
    }


}
