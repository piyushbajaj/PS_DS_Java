package Array;

/**
 * Created by piyush.bajaj on 17/01/17.
 */
public class maximumSumNoAdjacent {
    public int maximumSum(int[] arr){
        int n = arr.length;

        int incl=arr[0], excl =0, excl_new;

        //sum = arr[0]
        for(int i = 1; i < n; i++){
            excl_new = (incl > excl)? incl:excl;

            incl = arr[i] + excl;

            excl = excl_new;

        }
        return (incl > excl)? incl: excl;
    }

    public static void main(String[] args) {
        maximumSumNoAdjacent MS = new maximumSumNoAdjacent();
        int[] arr = {5, 5, 10, 100, 10, 5};

        System.out.println(MS.maximumSum(arr));



    }
}
