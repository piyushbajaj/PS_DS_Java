package LinkedList;

/**
 * Created by piyush.bajaj on 22/01/18.
 */
public class ChocolateFeast_Prob {
    static int chocolateFeast(int n, int c, int m) {
        // Complete this function
        int count = 0; // Count number of Chocolates
        int val = n;
        int remain = 0;

        if (val >= 0){
            count+= val/c;
            val = val/c;
            remain = val%c;

        }

        int k = 0;
        int rem = 0;
        while (val >= m){
            k = val/m;
            rem = val%m;
            val = k + rem;
            count+=k;
        }

        //count+= val/m;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(chocolateFeast(41894, 36, 640));

        //41894 36 640
    }
}
