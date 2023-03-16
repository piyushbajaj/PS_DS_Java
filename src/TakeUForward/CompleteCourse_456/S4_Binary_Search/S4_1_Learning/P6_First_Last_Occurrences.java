package TakeUForward.CompleteCourse_456.S4_Binary_Search.S4_1_Learning;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S4_Binary_Search.S4_1_Learning
 * <p>
 * User: piyushbajaj
 * Date: 11/11/22
 * Time: 8:40 pm
 */
public class P6_First_Last_Occurrences {
    public ArrayList<Long> find(long[] arr, int n, int x) {
        int low = 0, high = n - 1;
        long first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                first = Math.min(first, mid);
                last = Math.max(last, mid);
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new ArrayList<>(Arrays.asList(first, last));
    }

    public static void main(String[] args) {
        long[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};

        P6_First_Last_Occurrences p6_first_last_occurrences = new P6_First_Last_Occurrences();
        System.out.println(p6_first_last_occurrences.find(arr, arr.length, 5));
    }
}
