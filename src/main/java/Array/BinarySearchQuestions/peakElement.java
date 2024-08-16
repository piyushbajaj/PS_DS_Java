package Array.BinarySearchQuestions;

/**
 * Created by piyush.bajaj on 31/05/17.
 */
public class peakElement {
    public static void main(String[] args) {
        peakElement pe = new peakElement();
        int[] arr = {10, 20, 15, 2, 23, 90, 67};
        System.out.println(pe.getPeak(arr, 0, arr.length - 1));
    }

    public int getPeak(int[] arr, int l, int r) {

        //for(int i = 1; i < r; i++){
        //int i = l;
        int mid = (l + r) / 2;

        //if(l < r) {
        if (mid == 0 || (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])) {
            return mid;
        } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
            return getPeak(arr, l, mid - 1);
        } else if (mid > 0 && arr[mid] < arr[mid + 1]) {
            if (mid + 1 == r) {
                return r;
            }
            return getPeak(arr, mid + 1, r);
        }

        // }
        //}
        if (r == arr.length - 1 || r == 0) {
            return r;
        }
        return -1;
    }
}
