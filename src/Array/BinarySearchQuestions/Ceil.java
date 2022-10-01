package Array.BinarySearchQuestions;

/**
 * Created by piyush.bajaj on 28/05/17.
 * Ceil means a next bigger value
 */
public class Ceil {
    public int getCeil(int[] arr, int l, int r, int key) {
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (arr[m] > key)
                r = m;
            else
                l = m;
        }
        return arr[r];
    }

    public static void main(String[] args) {
        Ceil cl = new Ceil();
//        int[] arr = {-1, 2, 3, 5, 6, 8, 9, 10};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(cl.getCeil(arr, 0, arr.length - 1, -1));
    }
}
