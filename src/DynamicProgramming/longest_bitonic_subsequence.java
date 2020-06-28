package DynamicProgramming;

/**
 * Created by piyush.bajaj on 15/08/17.
 * Algorithm:
 * 1. Create LIS[] array for longest increasing sub-sequence integers only.
 * 2. Create LDS[] array for longest decreasing sub-sequence integers only.
 * 3. Make Bitonic[] array for: LIS[] + LDS[] -1
 */
public class longest_bitonic_subsequence {
    public int[] LIS_fun(int[] arr){
        int n = arr.length;
        int[] lis = new int[n];

        for(int i = 0; i < n; i++)
            lis[i] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = -1;
        for(int k = 0; k < lis.length; k++){
            if(lis[k] > max)
                max = lis[k];
        }

        return lis;
    }

    public int[] LDS_fun(int[] arr){
        int n = arr.length;
        int[] lds = new int[n];

        for(int i = 0; i < n; i++)
            lds[i] = 1;

        for(int i = n-2; i >= 0; i--){
            for(int j = n-1; j >= i ; j--){
                if(arr[i] > arr[j] && lds[i] < lds[j] + 1){
                    lds[i] = lds[j] + 1;
                }
            }
        }



        return lds;
    }

    public int bitonic_fun(int[] arr){
        int[] lis = LIS_fun(arr);
        int[] lds = LDS_fun(arr);



        int n = arr.length;

        int[] bitonic = new int[n];

        for(int i = 0; i < n; i++){
            bitonic[i] = lis[i] + lds[i] -1;
        }

        int max = -1;
        for(int k = 0; k < n; k++){
            if(bitonic[k] > max)
                max = bitonic[k];
        }
        return max;
    }

    public static void main(String[] args) {
        longest_bitonic_subsequence ls = new longest_bitonic_subsequence();
        //int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};

        System.out.println(ls.bitonic_fun(arr));
    }

}
