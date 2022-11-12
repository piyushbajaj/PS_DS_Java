package TakeUForward.S4_Binary_Search.S4_1_Learning;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S4_Binary_Search.S4_1_Learning
 * <p>
 * User: piyushbajaj
 * Date: 11/11/22
 * Time: 8:10 pm
 * <p>
 * Link: <a href="https://practice.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1">...</a>
 */
public class P5_Input_Array_Sorted {
    public boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P5_Input_Array_Sorted p5_input_array_sorted = new P5_Input_Array_Sorted();

        int[] arr = {10, 20, 30, 40, 50};

        System.out.println(p5_input_array_sorted.arraySortedOrNot(arr, arr.length));
    }
}
