package TakeUForward.CompleteCourse_456.S2_Sorting;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S1_Sorting
 * <p>
 * User: piyushbajaj
 * Date: 12/10/22
 * Time: 9:43 am
 * <p>
 */
public class Utility {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
