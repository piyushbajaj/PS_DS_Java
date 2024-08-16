package Array;

/**
 * Created by piyush.bajaj on 22/07/17.
 */
public class SortedIntegerArray {
    static int find_missing_number(int arr[], int len) {
        int first, middle, last;
        first = 0;
        last = len - 1;
        middle = (first + last) / 2;

        while (first < last) {
            if ((arr[middle] - arr[first]) != (middle - first)) {
                /* there is a hole in the first half */
                if ((middle - first) == 1 && (arr[middle] - arr[first] > 1)) {
                    return (arr[middle] - 1);
                }

                last = middle;
            } else if ((arr[last] - arr[middle]) != (last - middle)) {
                /* there is a hole in the second half */
                if ((last - middle) == 1 && (arr[last] - arr[middle] > 1)) {
                    return (arr[middle] + 1);
                }

                first = middle;
            } else {
                /* there is no hole */
                return -1;
            }

            middle = (first + last) / 2;
        }

        /* there is no hole */
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6};
        System.out.println(find_missing_number(arr, arr.length));
    }
}
