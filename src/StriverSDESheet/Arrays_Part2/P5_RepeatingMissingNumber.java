package StriverSDESheet.Arrays_Part2;

/**
 * Created by bajajp on 14 Aug, 2022
 */
public class P5_RepeatingMissingNumber {

    public static int[] repeating_missing_number(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        fast = arr[0];

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        int n = arr.length;
        int sum = n * (n + 1) / 2;

        int arrSum = 0;
        for (int j : arr) {
            arrSum += j;
        }

        int diff = sum - arrSum;

        return new int[]{slow, slow + diff};
    }

    public static void main(String[] args) {

    }
}
