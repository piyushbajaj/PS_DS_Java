package Array;

import java.util.Hashtable;

/**
 * Created by piyush.bajaj on 03/04/17.
 */
public class findingDuplicates {

    //Time Complexity: O(n*n)
    public boolean checkDuplicates(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++ ){
                if(arr[i] == arr[j])
                    return true;
            }
        }
        return false;
    }

    //After sorting the array, time complexity will be O(n*log(n))
    public boolean checkDuplicates_sort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n-1; i++){
                if(arr[i] == arr[i+1])
                    return true;
        }
        return false;
    }

    //Using Hash Table
    //Time Complexity: O(n); Space: O(n)
    public boolean checkDuplicates_hash(int[] arr){
        int n = arr.length;
        Hashtable<Integer, Integer> hash = new Hashtable<>();

        for(int i = 0; i < n; i++){
            if(hash.containsKey(arr[i])){
                hash.put(arr[i], hash.get(arr[i]) + 1);
                return true;
            }
            else {
                hash.put(arr[i], 1);
            }
        }
        return false;
    }

    /*
    We can improve the space complexity further on, but there are few points which we need to consider:
    1. The array should be applicable for write operation.
    2. This solution will work only if all the array elements are positive.
    3. If there are n elements, all the elements should be range 0 to n-1


     */

    public int checkDuplicates_optimised(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(arr[Math.abs(arr[i])] < 0)
                return Math.abs(arr[i]);
            else
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
        }
        return -1;
    }

    public static void main(String[] args) {
        findingDuplicates fd = new findingDuplicates();
        int[] arr = {5, 6, 1, 4, 3, 1};
        System.out.println("Finding duplicates in unsorted array: " + fd.checkDuplicates(arr));

        int[] sortArr = {1, 4, 6, 8, 8, 9};
        System.out.println("Finding duplicates in sorted array: " + fd.checkDuplicates_sort(sortArr));

        System.out.println("Finding duplicates in array using Hash: " + fd.checkDuplicates_hash(arr));

        int[] arr1 = {1, 3, 5, 2, 4, 2, 5};
        System.out.println("Finding duplicates in array after optimising: " + fd.checkDuplicates_optimised(arr1));
    }
}
