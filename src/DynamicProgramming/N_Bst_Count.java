package DynamicProgramming;

/**
 * Created by piyush.bajaj on 09/08/17.
 */
public class N_Bst_Count {

   //static int i = 0, j =0, count = 0;


    public static int n_bst(int[] arr, int n){
        if(n <0)
            return 0;
        else if(n == 0 || n ==1){
            return 1;
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == -1){
                arr[i] = n_bst(arr, i);
            }
            if(arr[n-i-1] == -1){
                arr[n-i-1] = n_bst(arr, n-i-1);
            }
            count+= arr[i] * arr[n-i-1];
        }


        return count;
    }

    public static int bst_util(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = -1;
        return n_bst(arr, n);


    }

    public static void main(String[] args) {
        N_Bst_Count NB = new N_Bst_Count();
        System.out.println(NB.bst_util(3));
        //System.out.println(count);
    }
}
