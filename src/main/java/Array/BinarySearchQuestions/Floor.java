package Array.BinarySearchQuestions;

/**
 * Created by piyush.bajaj on 28/05/17.
 * <p>
 * Floor means a next smaller value
 * <p>
 * Given an array of N distinct integers,
 * find floor value of input ‘key’. Say, A = {-1, 2, 3, 5, 6, 8, 9, 10} and key = 7,
 * we should return 6 as outcome.
 */

public class Floor {

    public static void main(String[] args) {
        Floor fl = new Floor();
        int[] arr = {-1, 2, 3, 5, 6, 8, 9, 10};
        System.out.println(fl.getFloor(arr, 0, arr.length - 1, 7));
    }

    public int getFloor(int[] arr, int l, int r, int key) {
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (arr[m] > key) {
                r = m;
            } else {
                l = m;
            }
        }
        return arr[l];
    }
}
