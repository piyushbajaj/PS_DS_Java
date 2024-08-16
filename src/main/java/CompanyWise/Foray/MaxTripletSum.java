package CompanyWise.Foray;

/**
 * Project: DS_Algo
 * Package: CompanyWise.Foray
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 7:08 pm
 * <p>
 * link: <a href="https://www.geeksforgeeks.org/maximum-triplet-sum-array/">...</a>
 */
public class MaxTripletSum {
    static int maxTripletSum(int arr[], int n) {
        // Initialize Maximum, second maximum and third
        // maximum element
        int maxA = -100000000, maxB = -100000000;
        int maxC = -100000000;

        for (int i = 0; i < n; i++) {

            // Update Maximum, second maximum
            // and third maximum element
            if (arr[i] > maxA) {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            }

            // Update second maximum and third maximum
            // element
            else if (arr[i] > maxB) {
                maxC = maxB;
                maxB = arr[i];
            }

            // Update third maximum element
            else if (arr[i] > maxC) {
                maxC = arr[i];
            }
        }

        return (maxA + maxB + maxC);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 8, 6, 4, 2};
        int n = arr.length;
        System.out.println(maxTripletSum(arr, n));
    }
}
