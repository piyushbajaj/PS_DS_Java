package TechBoost_Old.DP_Prob;

/**
 * Created by piyush.bajaj on 27/03/18.
 */
public class LongestIncreasingSubstring_Prob {
    static int[] cnt;
    static int[] path;
    public static int LongestIncreasingSubstring(int[] arr){
        int LLIS = 1;
        int n = arr.length;
        cnt = new int[n];
        path = new int[n];

        int max = 0;
        int prev = -1;
        cnt[0] = 1;
        for(int i = 1; i < n; i++){

            for(int j = 0; j < i; j++){
                if(arr[j] >= arr[i])
                    continue;

                if(max < cnt[j]){
                    max = cnt[j];
                    prev = j;
                }
            }

            cnt[i] = max + 1;
            path[i] = prev;

            if(LLIS < cnt[i])
                LLIS = cnt[i];
        }
        return LLIS;
    }

    public static void printValue(int[] arr){
        int n = arr.length;
        int max = -1;
        int i = 0;
        for(i = 0; i < n; i++){
            if(max < path[i]){
                max = path[i];
                System.out.print(arr[max] + " ");
            }
        }
        System.out.print(arr[i-1] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.print(LongestIncreasingSubstring(arr));
        System.out.println();
        printValue(arr);
    }
}
