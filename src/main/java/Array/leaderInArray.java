package Array;

/**
 * Created by piyush.bajaj on 17/01/17.
 */
public class leaderInArray {
    public static void main(String[] args) {
        leaderInArray LI = new leaderInArray();
        int[] arr = {16, 17, 4, 3, 5, 2};


        LI.findLeaders(arr);

    }

    public void findLeaders(int[] arr) {
        int n = arr.length;
        int[] out = new int[n];

        int j = 0;
        out[j++] = arr[n - 1];
        int max = arr[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            if ((arr[i] > arr[i - 1]) && (arr[i] > max)) {
                out[j++] = arr[i];
                max = arr[i];
            }
        }

        printArray(out, j);
    }

    public void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
