package Array.BinarySearchQuestions;

/**
 * Created by piyush.bajaj on 28/05/17.
 */
public class Occurences {
    public static void main(String[] args) {
        Occurences occ = new Occurences();
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 5, 5};
        int key = 2;
        int left = occ.getLeftOccur(arr, -1, arr.length - 1, key);
        int right = occ.getRightOccur(arr, 0, arr.length, key);

        System.out.println((arr[left] == key && arr[right] == key) ? (right - left + 1) : 0);


    }

    public int getLeftOccur(int[] arr, int l, int r, int key) {
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (arr[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    public int getRightOccur(int[] arr, int l, int r, int key) {
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (arr[m] > key) {
                r = m;
            } else {
                l = m;
            }
        }
        return l;
    }
}
