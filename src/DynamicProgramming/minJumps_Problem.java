package DynamicProgramming;

/**
 * Created by piyush.bajaj on 27/08/17.
 */
public class minJumps_Problem {
    public static int minJumps(int[] arr){
        int n = arr.length;
        int[] T = new int[n];
        int[] R = new int[n];

        for(int i = 0; i < n; i++){
            T[i] = Integer.MAX_VALUE-1;
        }

        T[0] = 0;

        for(int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if( j + arr[j] >= i) {
                    if(T[j] + 1 < T[i]) {
                        T[i] = T[j] + 1;
                        R[i] = j;
                    }
                }
            }
        }
        return T[n-1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println(minJumps(arr));
    }
}
