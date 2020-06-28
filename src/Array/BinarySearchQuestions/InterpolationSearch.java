package Array.BinarySearchQuestions;

/**
 * Created by piyush.bajaj on 29/05/17.
 * Few notes about interpolation:
 * 1. It is an improved variant of Binary Search.
 * 2. For this algo to work properly, the data collection should be in sorted form and equally distributed.
 * 3. Here the formula we used is:
 * y = y1 + m * (x - x1)
 * m = (y2-y1)/(x2-x1)
 * Time Complexity: O(log(logN))
 */
public class InterpolationSearch {
    public int search(int[] arr, int l, int h, int key){
        int mid = -1;
        while (l < h){
            mid = l +  ((h-l)/(arr[h]-arr[l]))*(key-arr[l]);
            if(arr[mid]==key)
                return mid;
            else if(arr[mid] < key)
                l = mid+1;
            else h = mid -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        InterpolationSearch ip = new InterpolationSearch();
        int[] arr = {1, 5, 6, 7, 9, 19, 20, 27, 56};
        System.out.println(ip.search(arr, 0, arr.length - 1, 5));
    }
}
