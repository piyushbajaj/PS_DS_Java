package Array;

/**
 * Created by piyush.bajaj on 01/12/16.
 */
public class missingNumber {
    public static int missingNum(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n+1)/2;
        for(int a: arr){
            sum = sum - a;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        //System.out.println(missingNum(arr));
        //missingNum(arr);

        int[] arr1 = {9,7,8,5,4,6,2,3,1};
        int[] arr2 = {2,4,3,9,1,8,5,6};

        missingElement(arr1, arr2);

        missingElementUsingXOR(arr1, arr2);

    }

    /*
    Given two integer arrays where second array is duplicate of first array with just 1 element missing. Find the element.
    Example:

    Input:
    Array1 - 9 7 8 5 4 6 2 3 1
    Array2 - 2 4 3 9 1 8 5 6

    Output:
    7
     */

    public static void missingElement(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] temp = new int[10];

        for(int i = 0; i < n1; i++){
            temp[arr1[i]]++;
        }

        for(int i = 0; i < n2; i++){
            temp[arr2[i]]--;
        }

        for(int i = 0; i < n1; i++){
            if(temp[i] > 0){
                System.out.println(i);
                break;
            }
        }
    }



    //Using XOR Approach
    public static void missingElementUsingXOR(int[] arr1, int[] arr2){
        int res = 0;
        int N1 = arr1.length;
        int N2 = arr2.length;

        for(int i = 0; i < N1; i++){
            res = res ^ arr1[i];
        }

        for(int i = 0; i < N2; i++){
            res = res ^ arr2[i];
        }

        System.out.println(res);

    }


}
