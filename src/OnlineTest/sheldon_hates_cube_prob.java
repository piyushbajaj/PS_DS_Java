package OnlineTest;

import java.util.HashSet;

/**
 * Created by piyush.bajaj on 20/05/18.
 */
public class sheldon_hates_cube_prob {
        public static int solve(int[] A) {
            int count = 0;
            int n = A.length;
            int prod = 0;
            HashSet<Integer> hashSet = new HashSet<>();

            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    prod = A[i]*A[j];
                    if(isCube(prod)) {
                        //count++;
                        hashSet.add(A[i]);
                        //hashSet.add(A[j]);
                        if(A[i] == A[j])
                            count++;
                        System.out.println(A[i] + " " + A[j]);
                    }
                }
            }


            return n - hashSet.size() - count;
        }

        public static boolean isCube(int num){
            if(num == 1)
                return true;

            if(num < 8)
                return false;
            else{
                for(int i = 2; i <= num/3; i++){
                    if(i*i*i == num)
                        return true;
                }
            }
            return false;
        }

    public static void main(String[] args) {
        //int[] A = {2, 1, 7, 2, 6, 10, 5, 20, 1, 10, 12, 18, 18, 12, 2, 16, 10, 8};
        //int[] A = {17, 4, 19, 6, 7, 12, 2, 16, 20, 9, 5};
        int[] A = {15, 8, 15, 5, 4, 11, 8};
        System.out.println(A.length);
        System.out.println(solve(A));
    }


}
