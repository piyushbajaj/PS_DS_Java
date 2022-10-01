package Array;

/**
 * Created by piyush.bajaj on 01/12/16.
 */
public class LargestSumContiguousSubarray {
    public static int LargestSumContiguous(int[] arr){
        int max_so_far=0;
        int max_ending_here =0;

        for(int a: arr){
            max_ending_here = max_ending_here + a;
            if(max_ending_here < 0)
                max_ending_here = 0;
            else if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(LargestSumContiguous(arr));
        //LargestSumContiguous(arr);
    }

}
