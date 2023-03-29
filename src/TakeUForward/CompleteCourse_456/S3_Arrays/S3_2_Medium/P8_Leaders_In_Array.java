package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

import java.util.ArrayList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 26/12/22
 * Time: 6:48 pm
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1">...</a>
 */
public class P8_Leaders_In_Array {
    public static void main(String[] args) {
        P8_Leaders_In_Array p8_leaders_in_array = new P8_Leaders_In_Array();
        System.out.println(p8_leaders_in_array.leaders(new int[] {16, 17, 4, 3, 5, 2}, 6));
    }

    public ArrayList<Integer> leaders(int[] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = arr[n - 1];
        result.add(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                result.add(max);
            }
        }
        reverse(result);
        return result;
    }

    public void reverse(ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;

        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }
}
