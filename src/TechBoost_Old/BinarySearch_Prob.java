package TechBoost_Old;

/**
 * Created by piyush.bajaj on 22/03/18.
 */
public class BinarySearch_Prob {

    public int binarySearch_iterative(int[] A, int x){
        int start = 0;
        int end = A.length-1;

        while (start <= end){
            int mid = (start + end)/2;

            if(A[mid] == x)
                return mid;
            else if(A[mid] > x)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }

    public int binarySearch_recursive(int[] A , int x){
        int start = 0;
        int end = A.length-1;

        return binarySearch_recursive_util(A, start, end, x);
    }

    public int binarySearch_recursive_util(int[] A, int start, int end, int x){
        int mid = (start + end)/2;

        if(start <= end){
            if(A[mid] == x) return mid;
            else if(A[mid] > x)
                return binarySearch_recursive_util(A, start, mid -1, x);
            else
                return binarySearch_recursive_util(A, mid + 1, end, x );
        }
        else
            return -1;

    }

    public static void main(String[] args) {
        BinarySearch_Prob bp = new BinarySearch_Prob();
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(bp.binarySearch_iterative(A, 10));

        System.out.println(bp.binarySearch_recursive(A, 5));
    }
}
