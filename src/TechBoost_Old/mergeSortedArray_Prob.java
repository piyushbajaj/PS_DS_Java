package TechBoost_Old;

/**
 * Created by piyush.bajaj on 04/04/18.
 */
public class mergeSortedArray_Prob {
    public static void main(String[] args) {
        int[] b= {2, 4, 6, 8};
        int[] a = {1, 4, 10, 11, 15, 20, -1, -1, -1, -1};
        mergeSortedArray(a, b);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }


    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[]  mergeSortedArray(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i;

        for (i = 0; i < n; i++) {
            if (a[i] == -1)
                break;
        }

        int p = n - 1;
        int k = m - 1;
        int j = i-1;
        while (p >= 0 && j >= 0 && k>=0) {
            if (a[j] > b[k]) {
                a[p] = a[j];
                p--;
                j--;

            } else {
                a[p] = b[k];
                p--;
                k--;
            }

        }
        return a;
    }
}
