package LinkedList;

import java.util.TreeSet;

/**
 * Created by piyush.bajaj on 04/03/18.
 */
public class mansaAndStone_Prob {

    static int[] stones(int n, int a, int b) {

        if(n < 1 || n > 1000 || a < 1 || a > 1000 || b < 1 || b > 1000 )
            return null;

        TreeSet<Integer> hashSet = new TreeSet<>();
        for(int i = 0; i < n; i++){
            int val = i*a + (n-1-i)*b;
            hashSet.add(val);
        }

        int size = hashSet.size();
        int[] result = new int[size];

        int i = 0;
        for(int val: hashSet){
            result[i++] = val;
        }

            return result;
        // Complete this function
    }

    public static void main(String[] args) {
        int[] result = stones(4, 10, 100);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }


    }
}
